package com.student.ust.controller;

import com.student.ust.entity.Book;
import com.student.ust.entity.Student;
import com.student.ust.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * The type Book controller.
 */
@Slf4j

@RestController
public class BookController {
    /**
     * The Book service.
     */
    @Autowired
    BookService bookService;

    /**
     * Add.
     *
     * @param book the book
     */
    @PostMapping("/book")
    public void add (@RequestBody Book book){
        bookService.saveBook(book);
    }

    /**
     * Get response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @GetMapping("/book/{id}")
    public ResponseEntity<Book> get(@PathVariable  Integer id) {

        log.debug("Get-invoked");

        try {
            Book book = bookService.getBookById(id);
            return new ResponseEntity<Book>(book, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);

        }
    }

    /**
     * Get 2 response entity.
     *
     * @return the response entity
     */
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

    /**
     * Update.
     *
     * @param book the book
     */
    @PutMapping("/book")
    public void update(@RequestBody Book book){
        Book updatedBook = bookService.updateBook(book);

    }

    /**
     * Delete.
     *
     * @param id the id
     */
    @DeleteMapping("/book/{id}")
    public void delete(@PathVariable  Integer id)
    {
        bookService.removeById(id);
    }
}
