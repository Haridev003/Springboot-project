package com.student.ust.controller;

import com.student.ust.entity.Book;
import com.student.ust.entity.Student;
import com.student.ust.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/book")
    public void add (@RequestBody Book book){
        bookService.saveBook(book);
    }
    @GetMapping("/book/{id}")
    public ResponseEntity<Book> get(@PathVariable  Integer id) {
        try {
            Book book = bookService.getBookById(id);
            return new ResponseEntity<Book>(book, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);

        }
    }
    @GetMapping("/book")
    public ResponseEntity<List<Book>> get2( ){
        try {
            List <Book> bookList = bookService.getStudentAll();
            return new ResponseEntity<List<Book>>(bookList, HttpStatus.OK);
        }
        catch (NoSuchElementException e){
            return new ResponseEntity<List<Book>>(HttpStatus.NOT_FOUND);

        }


    }
    @PutMapping("/book")
    public void update(@RequestBody Book book){
        Book updatedBook = bookService.updateBook(book);

    }
    @DeleteMapping("/book/{id}")
    public void delete(@PathVariable  Integer id)
    {
        bookService.removeById(id);
    }
}
