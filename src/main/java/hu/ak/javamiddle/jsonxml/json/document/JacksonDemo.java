package hu.ak.javamiddle.jsonxml.json.document;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;

public class JacksonDemo {

    public static void main(String[] args) throws IOException {
        Book book1 = new Book();
        book1.setAuthor("Joshue Bloch");
        book1.setTitle("null");
        book1.setId(202302L);
        book1.setBook(book1);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        StringWriter sw = new StringWriter();

        objectMapper.writeValue(sw, book1);

//        System.out.println(sw);
//
//        objectMapper.writeValue(System.out, new HashMap<>() {
//            {
//                for (Book book : Arrays.asList(book1)) {
//                    put("title", book.getTitle());
//                }
//            }
//        });

        Book book = objectMapper.readValue(sw.toString(), Book.class);
        System.out.println(book);

//        objectMapper.readTree()
    }

}
