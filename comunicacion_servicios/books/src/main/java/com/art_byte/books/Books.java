package com.art_byte.books;

import lombok.*;

import java.util.Date;

public class Books {
    private Integer id;
    private String name;
    private String author;
    private Date releaseDate;

    public Books(){}

    public Books(Integer id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.releaseDate = new Date();
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}
