package com.student.ust.service;

import com.student.ust.entity.Book;
import com.student.ust.entity.Student;
import com.student.ust.respository.BookRespositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class BookService {
    @Autowired
    BookRespositry bookRespositry;
    public  void saveBook(Book book) {
        bookRespositry.save(book);
    }

    public Book getBookById(Integer id) {
        return bookRespositry.findById(id).orElse(null);
    }

    public List<Book> getStudentAll() {
        return bookRespositry.findAll();
    }

    public Book updateBook(Book book) {
        Book updateBook = bookRespositry.findById(book.getBookId()).orElseThrow(()->
                new NoSuchElementException());
        updateBook.setBookName(book.getBookName());
        updateBook.setAuthorName(book.getAuthorName());
        updateBook.setIsbNo(book.getIsbNo());
       // updateBook.setRollNo(student.getRollNo());
        bookRespositry.save(updateBook);
        return updateBook;
    }

    public void removeById(Integer id) {
        bookRespositry.deleteById(id);
    }
}
