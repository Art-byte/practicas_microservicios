package com.art_byte.student.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BooksRestClient {

    @Autowired
    RestTemplate restTemplate;

    private final String BASE_URL = "http://localhost:9090/api/books/";


    public ResponseEntity<List<Books>> getAllBooks() {
        return restTemplate.exchange(
                BASE_URL + "all",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Books>>() {}
        );
    }

    public ResponseEntity<Books> getBookById(Integer id){
        return restTemplate.getForEntity(BASE_URL + id, Books.class);
    }

    public ResponseEntity<Books> createBook(Books books){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Books> requestEntity = new HttpEntity<>(books, headers);
        return restTemplate.exchange(BASE_URL, HttpMethod.POST, requestEntity, Books.class);
    }
}
