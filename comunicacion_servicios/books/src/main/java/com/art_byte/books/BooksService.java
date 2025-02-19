package com.art_byte.books;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BooksService {

    private final List<Books> listBook = new ArrayList<>();

    public BooksService(){
        listBook.add(new Books(1, "DUNE", "HERMES"));
        listBook.add(new Books(2, "TLOR", "TOLKIEN"));
        listBook.add(new Books(3, "NARNIA", "LEWIS"));
        listBook.add(new Books(4, "MAN AFTER MAN", "DIXON"));
        listBook.add(  new Books(5, "ALIEN", "GIGER"));
    }

    public List<Books> getAllBooks(){
        return listBook;
    }

    public Books getBookById(Integer id){
        Books booksObj = new Books();
        for(Books book : listBook){
            if(book.getId().equals(id)){
                booksObj = book;
                break;
            }
        }
        return booksObj;
    }

    public String createNewBook(Books books){
        listBook.add(books);
        return "Libro creado correctamente";
    }
}
