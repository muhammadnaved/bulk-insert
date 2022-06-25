package com.khan.bulk.controller;

import com.khan.bulk.entity.Book;
import com.khan.bulk.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/bulk-insert")
    @Transactional
    public ResponseEntity<?> insertBulkRecords(){
        bookRepository.deleteAll();
        //System.out.println(0/0);
        List<Book> bookList = new ArrayList<>();
        for(int i=0; i<500; i++){
            Book book = new Book();
            book.setName("book-"+i);
            book.setDesc("test");
            bookList.add(book);
        }
        bookRepository.saveAll(bookList);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Inserted Successfully");
    }

}
