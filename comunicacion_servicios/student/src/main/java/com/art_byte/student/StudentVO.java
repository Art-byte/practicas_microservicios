package com.art_byte.student;

import com.art_byte.student.integration.Books;

import java.util.List;

public class StudentVO {

    private Integer id;
    private String name;
    private String lastName;
    private List<Books> books;

    public StudentVO(){}

    public StudentVO(Integer id, String name, String lastName, List<Books> books) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.books = books;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }
}
