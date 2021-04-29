package hu.ak.javamiddle.jsonxml;

import hu.ak.javamiddle.jsonxml.xml.document.Book;
import hu.ak.javamiddle.jsonxml.xml.document.Library;
import jakarta.xml.bind.*;

import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Main {

    // Bájt sorozat
    //  - Serializable (Java Object Serialization)
    //  - External Data Representaion (XDR)
    //  - ...

    // Dokumentum / Document
    //  - Javascript Object Notation (JSON)
    //  - Extensible Markup Language (XML)
    //  - (HTML, Document Object Model - DOM)
    //  - SGML (Standard Generalized Markup Language)

    public static void main(String[] args) throws JAXBException, IOException {
        Book book1 = new Book();
        book1.setAuthor("Joshue Bloch");
        book1.setTitle("Effective Java");
        book1.setId(202302L);

        Book book2 = new Book();
        book2.setAuthor("Corets, Eva");
        book2.setTitle("Oberon's Legacy");
        book2.setId(21302L);

        Library library = new Library();
        library.setName("Library 1");
        library.setBooks(Arrays.asList(book1, book2));

        JAXBContext jaxbContext = JAXBContext.newInstance(Library.class);

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        StringWriter sw = new StringWriter();

        marshaller.marshal(library, sw);

        String xml = sw.toString();

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        StringReader sr = new StringReader(xml);
        Library library2 = (Library) unmarshaller.unmarshal(sr);

        System.out.println(library2);

        jaxbContext.generateSchema(new SchemaOutputResolver() {

            @Override
            public Result createOutput(String namespaceUri, String suggestedFileName) throws IOException {
                Path path = Paths.get(suggestedFileName);
                StreamResult result = new StreamResult(Files.newOutputStream(path));
                result.setSystemId(suggestedFileName);
                return result;
            }

        });

        // Marshal / unmarshal - objektum állapotának a serializálása / deszerializálása

    }

}
