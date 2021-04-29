package hu.ak.javamiddle.jsonxml.json.document;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

// org.json, GSon, Jackson
@Data
@JsonAutoDetect(getterVisibility = NONE, fieldVisibility = ANY)
public class Book {

    private long id;

    private String author;

    private String title;

    @JsonIgnore // @XmlTransient
    private Book book;

}

