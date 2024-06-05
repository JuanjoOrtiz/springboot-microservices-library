package com.project.microservice.books.controller;


import com.project.microservice.books.dtos.BookDTO;
import com.project.microservice.books.service.BookService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {


    private final BookService bookService;


    @GetMapping("/books")
    public ResponseEntity<Page<BookDTO>> findAllBooks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "50") int size) {

        Page<BookDTO> books = bookService.findAll(PageRequest.of(page, size));
        return ResponseEntity.ok().body(books);
    }

    @GetMapping("/book/{id}")
    public Optional<ResponseEntity<BookDTO>> findById(@PathVariable Long id) {
        Optional<BookDTO> book = bookService.findById(id);
        return book.map(bookDTO -> new ResponseEntity<>(bookDTO, HttpStatus.OK));
    }

    @PostMapping("/book")
    public ResponseEntity<BookDTO> save(@Valid @RequestBody BookDTO bookDTO) {
        BookDTO savedBookDTO = bookService.save(bookDTO);
        return ResponseEntity.ok().body(savedBookDTO);
    }

    @PutMapping("/book/{id}")
    public ResponseEntity<BookDTO> update(@PathVariable("id") Long id, @Valid @RequestBody BookDTO bookDTO) {
            bookDTO = bookService.update(id, bookDTO);
            return ResponseEntity.ok().body(bookDTO);
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
