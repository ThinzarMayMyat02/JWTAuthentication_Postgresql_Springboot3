package com.sample.spring_security.book;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/test/")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/Books")
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/Books/{id}")
    public ResponseEntity<Optional<Book>> findById(@PathVariable int id) {
        return ResponseEntity.ok(bookService.findBookById(id));
    }

    @ResponseStatus(HttpStatus.CREATED) // 201
    @PostMapping("/Books")
    public ResponseEntity<Book> saveBook(@RequestBody Book book){
       return ResponseEntity.ok(bookService.saveBook(book));
    }

    @PutMapping("/Books/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book book){
        Book updated = bookService.updateBook(id,book);
        return ResponseEntity.ok(updated);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)  //204
    @DeleteMapping("/Books/{id}")
    public void deleteById(int id){
        bookService.deleteBookById(id);
    }

    @GetMapping("/Books/find/author/{author}")
    public ResponseEntity<List<Book>> findByAuthor(@PathVariable String author){
        return ResponseEntity.ok(bookService.findByAuthor(author));
    }

    @GetMapping("/Books/find/title/{title}")
    public  ResponseEntity<List<Book>> findByTitle(@PathVariable String title){
        return ResponseEntity.ok(bookService.findByTitle(title));
    }
}
