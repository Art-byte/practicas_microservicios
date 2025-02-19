package com.art_byte.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BooksController {

    @Autowired
    private BooksService booksService;

    @GetMapping("/all")
    public ResponseEntity<List<Books>> getAllBooks(){
        return new ResponseEntity<>(booksService.getAllBooks(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Books> getBookById(@PathVariable int id){
        return new ResponseEntity<>(booksService.getBookById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createBook(@RequestBody Books book){
        return new ResponseEntity<>(booksService.createNewBook(book), HttpStatus.CREATED);
    }
}
