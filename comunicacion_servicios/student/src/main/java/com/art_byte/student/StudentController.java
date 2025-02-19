package com.art_byte.student;

import com.art_byte.student.integration.Books;
import com.art_byte.student.integration.BooksRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private BooksRestClient booksRestClient;

    @Autowired
    private StudentService studentService;

    @GetMapping("/books")
    public ResponseEntity<List<Books>> getAllBooks() {
        return booksRestClient.getAllBooks();
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Books> getBook(@PathVariable int id){
        return booksRestClient.getBookById(id);
    }

    @PostMapping("/book/create")
    public ResponseEntity<Books> createBooks(@RequestBody Books books){
        return booksRestClient.createBook(books);
    }

    @GetMapping
    public ResponseEntity<List<StudentVO>> getAllStudents() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @GetMapping("/{studentId}/add/{bookId}")
    public ResponseEntity<String> addBookToStudent(@PathVariable Integer studentId, @PathVariable Integer bookId){
        studentService.addBookToStudent(studentId, bookId);
        return new ResponseEntity<>("Libro agregado a estudiante", HttpStatus.OK);
    }

}
