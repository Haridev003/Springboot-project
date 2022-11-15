package com.student.ust.service;

import com.student.ust.entity.Book;
import com.student.ust.respository.BookRespositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * The type Book service.
 */
@Service
public class BookService {
    /**
     * The Book respositry.
     */
    @Autowired
    BookRespositry bookRespositry;

    /**
     * Save book.
     *
     * @param book the book
     */
    public  void saveBook(Book book) {
        book.setCreatedDate(LocalDateTime.now());
        book.setModifiedDate(LocalDateTime.now());
        bookRespositry.save(book);
    }

    /**
     * Gets book by id.
     *
     * @param id the id
     * @return the book by id
     */
    public Book getBookById(Integer id) {
        return bookRespositry.findById(id).orElse(null);
    }

    /**
     * Gets student all.
     *
     * @return the student all
     */
    public List<Book> getStudentAll() {
        return bookRespositry.findAll();
    }

    /**
     * Update book book.
     *
     * @param book the book
     * @return the book
     */
    public Book updateBook(Book book) {
        Book updateBook = bookRespositry.findById(book.getBookId()).orElseThrow(()->
                new NoSuchElementException());
        updateBook.setBookName(book.getBookName());
        updateBook.setAuthorName(book.getAuthorName());
        updateBook.setIsbNo(book.getIsbNo());
        updateBook.setModifiedDate(LocalDateTime.now());
       // updateBook.setRollNo(student.getRollNo());
        bookRespositry.save(updateBook);
        return updateBook;
    }

    /**
     * Remove by id.
     *
     * @param id the id
     */
    public void removeById(Integer id) {
        bookRespositry.deleteById(id);
    }
}
