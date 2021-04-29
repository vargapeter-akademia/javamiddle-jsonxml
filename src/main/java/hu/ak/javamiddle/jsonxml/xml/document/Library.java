package hu.ak.javamiddle.jsonxml.xml.document;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

import java.util.List;

@Data
@XmlRootElement(name = "library")
public class Library {

    @XmlElement
    private String name;

    @XmlElement(name = "book")
    private List<Book> books;

}
