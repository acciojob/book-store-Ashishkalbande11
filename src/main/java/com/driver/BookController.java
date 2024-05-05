package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {
    @Autowired
    BookService bookService;

    // One example controller, make the rest by yourself
    @PostMapping("/create-book")
    public ResponseEntity<Book> createBook(@RequestBody Book book){
        Book newbook = bookService.createBook(book);
        return new ResponseEntity<>(newbook, HttpStatus.CREATED);
    }

    @GetMapping("/get-book-by-id/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable String id){
        Book findBook = bookService.findBookById(id);
        return new ResponseEntity<>(findBook, HttpStatus.OK);
    }

    @GetMapping("/get-all-books")
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> bookList = bookService.findAllBooks();
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }
    @GetMapping("/get-books-by-author")
    public ResponseEntity<List<Book>> getBooksByAuthor(@RequestParam String author){
        List<Book> bookList = bookService.findBooksByAuthor(author);
        return new ResponseEntity<>(bookList,HttpStatus.OK);
    }
    @GetMapping("/get-book-by-genre")
    public ResponseEntity<List<Book>> getBookByGenre(@RequestParam String genre ){
        List<Book> bookList = bookService.findBooksByGenre(genre);
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }
    @DeleteMapping("/delete-book-by-id/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable String id){
        bookService.deleteBookById(id);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
    @DeleteMapping("/delete-all-books")
    public ResponseEntity<String> deleteAllBooks(){
        bookService.deleteAllBooks();
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
