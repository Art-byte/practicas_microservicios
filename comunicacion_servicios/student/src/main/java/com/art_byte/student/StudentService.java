package com.art_byte.student;

import com.art_byte.student.integration.Books;
import com.art_byte.student.integration.BooksRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentService {
    @Autowired
    private BooksRestClient booksRestClient;
    Map<Integer, Books> booksMap = new LinkedHashMap<>();

    private List<Student> studentList = new ArrayList<>();

    public StudentService(){
        studentList.add(new Student(1, "Arturo", "Pedraza", null));
        studentList.add(new Student(2, "Valeria", "Linares", null));
    }

    public List<StudentVO> getAllStudents(){
        return parseList(studentList);
    }

    public void addBookToStudent(int id, int idBook) {
        Student student = studentList.stream()
                .filter(stu -> stu.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (student == null) {
            throw new IllegalArgumentException("El estudiante con ID " + id + " no existe.");
        }
        // Si student.getBooks() es null, se asigna una lista vacía
        List<Integer> newList = new ArrayList<>(student.getBooks() != null ? student.getBooks() : new ArrayList<>());
        newList.add(idBook);
        student.setBooks(newList);
    }

    
    private List<StudentVO> parseList(List<Student> students) {
        // Obtenemos todos los libros
        ResponseEntity<List<Books>> respBooks = booksRestClient.getAllBooks();
        List<Books> listBooks = respBooks.getBody() != null ? respBooks.getBody() : new ArrayList<>(); // Lista vacía si es null
        generateMap(listBooks);

        List<StudentVO> studentVOList = new ArrayList<>();
        for (Student item : students) {
            // Asegurarse de que la lista de libros del estudiante no sea null
            List<Books> booksList = new ArrayList<>();
            if (item.getBooks() != null) {
                for (Integer item1 : item.getBooks()) {
                    Books book = booksMap.get(item1);
                    if (book != null) { // Solo agregamos si el libro existe
                        booksList.add(book);
                    }
                }
            }
            studentVOList.add(buildStudentVoObj(item, booksList));
        }
        return studentVOList;
    }


    private StudentVO buildStudentVoObj(Student student, List<Books> booksList){
        StudentVO studentVO = new StudentVO();
        studentVO.setId(student.getId());
        studentVO.setName(student.getName());
        studentVO.setLastName(student.getLastName());
        studentVO.setBooks(booksList);
        return studentVO;
    }

    private void generateMap(List<Books> listBooks){
        for(Books item:  listBooks){
            booksMap.put(item.getId(), item);
        }
    }

}
