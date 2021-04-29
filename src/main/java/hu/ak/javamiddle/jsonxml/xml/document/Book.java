package hu.ak.javamiddle.jsonxml.xml.document;

import jakarta.xml.bind.annotation.*;
import lombok.Data;

@Data
@XmlType(name = "book")
public class Book {

    @XmlAttribute
    private long id;

    @XmlElement
    private String author;

    @XmlElement
    private String title;

}
