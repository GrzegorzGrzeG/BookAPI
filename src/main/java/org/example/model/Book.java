package org.example.model;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "books")
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String isbn;
    public String title;
    public String author;
    public String publisher;
    public String category;


}
