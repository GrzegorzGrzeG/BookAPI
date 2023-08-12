package org.example.service;


import org.example.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Deprecated
@Service
public class MockBookService implements BookService {
    private List<Book> books;
    public MockBookService() {
        books = new ArrayList<>();
        books.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce	Eckel", "Helion", "programming"));
        books.add(new Book(2L, "9788324627738", "Rusz	glowa	Java.", "Sierra	Kathy,	Bates	Bert", "Helion",
                "programming"));
        books.add(new Book(3L, "9780130819338", "Java	2.	Podstawy", "Cay	Horstmann,	Gary	Cornell", "Helion",
                "programming"));
    }


    @Override
    public List<Book> getBooks() {
        return books;
    }

    public Optional<Book> get(Long id) {
        return books.stream().filter(book -> book.getId().equals(id)).findFirst();
    }

    @Override
    public void add(Book book) {
        books.add(book);
    }

    @Override
    public void delete(Long id) {
        if(get(id).isPresent()) {
            books.remove(this.get(id).get());
        }
    }

    @Override
    public void update(Book book) {
        if(get(book.getId()).isPresent()) {
            int indexOf = books.indexOf(get(book.getId()).get());
            books.set(indexOf,book);
        }
    }
}
