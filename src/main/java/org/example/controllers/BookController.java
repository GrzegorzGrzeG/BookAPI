package org.example.controllers;

import org.example.service.MockBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import org.example.model.Book;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@Deprecated
@RestController
@RequestMapping("/deprecated/books")
public class BookController {

    private MockBookService mockBookService;

    @Autowired
    public BookController(MockBookService mockBookService) {
        this.mockBookService = mockBookService;
    }

    @RequestMapping("/helloBook")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }


    @GetMapping("")
    public List<Book> books() {
        return mockBookService.getBooks();
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable Long id) {
        return mockBookService.get(id).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "book not found");
        });
    }

    @PutMapping()
    public void put(@RequestBody Book book) {
        mockBookService.update(book);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        mockBookService.delete(id);
    }

}

