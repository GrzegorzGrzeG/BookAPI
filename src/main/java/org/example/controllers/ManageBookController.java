package org.example.controllers;

import org.example.exception.NotFoundException;
import org.example.model.Book;
import org.example.service.BookService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import javax.validation.Valid;
import java.util.List;

@Service
@RequestMapping("/books")
public class ManageBookController {
    private final BookService bookService;

    public ManageBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all")
    public String showAll(Model model) {
        List<Book> bookList = bookService.getBooks();
        model.addAttribute("books", bookList);
        return "/books/all";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable Long id, Model model) {
        Book book = bookService.get(id).orElseThrow(() -> new NotFoundException("Book not found. Check info and try again"));
        model.addAttribute("book", book);
        return "/books/book";
    }

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("book", new Book());
        return "/books/add-book-form";
    }

    @PostMapping("/add")
    public String processForm(Book book) {
        bookService.add(book);
        return "redirect:/books/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id) {
        bookService.delete(id);
        return "redirect:/books/all";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("book", bookService.get(id));
        return "/books/edit";
    }

    @PostMapping("/edit/{id}")
    public String editProcessForm(@Valid Book book, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "/books/edit";
        }
        bookService.add(book);
        return "redirect:/books/all";
    }

}
