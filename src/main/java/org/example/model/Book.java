package org.example.model;

import lombok.*;

import java.util.Objects;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Book {
    public Long id;
    public String isbn;
    public String title;
    public String author;
    public String publisher;
    public String category;


}
