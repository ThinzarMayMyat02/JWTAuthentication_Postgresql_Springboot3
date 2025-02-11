package com.sample.spring_security.book;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public Optional<Book> findBookById(int id) {
        return bookRepository.findById(id);
    }

    public void deleteBookById(int id) {
        bookRepository.deleteById(id);
    }

    public List<Book> findByTitle(String title){
        return bookRepository.findByTitle(title);
    }

    public List<Book> findByAuthor(String author){
        return bookRepository.findByAuthor(author);
    }

    public Book updateBook(int id, Book book) {
        Book b = findBookById(id).orElseThrow(()->new RuntimeException("Book not found to update"));
        b.setTitle(book.getTitle());
        b.setAuthor(book.getAuthor());
        b.setPrice(book.getPrice());
        b.setPublishDate(book.getPublishDate());
        return bookRepository.save(b);
    }
}
