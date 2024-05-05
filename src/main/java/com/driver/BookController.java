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

    @GetMapping("/books/get-book-by-id/{id}")
    public ResponseEntity<Book> findBookById(@PathVariable("id") String id){
        Book findBook = bookService.findBookById(id);
        return new ResponseEntity<>(findBook,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/books/delete-book-by-id/{id}")
    public ResponseEntity<String> deleteBookById (@PathVariable("id") String bookId){
        bookService.deleteBookById(bookId);
        return new ResponseEntity<>("success", HttpStatus.ACCEPTED);
    }

    @GetMapping("/books/get-all-books")
    public ResponseEntity<List<Book>> findAllBooks(){
        List<Book> bookList = bookService.findAllBooks();
        return new ResponseEntity<>(bookList, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/books/delete-all-books")
    public ResponseEntity<String> deleteAllBooks(){
        bookService.deleteAllBooks();
        return new ResponseEntity<>("success",HttpStatus.ACCEPTED);
    }
    @GetMapping("/books/get-books-by-author")
    public ResponseEntity<List<Book>> getAllBooksByAuthor(@RequestParam("author") String author){
        List<Book> bookList = bookService.findBooksByAuthor(author);
        return new ResponseEntity<>(bookList, HttpStatus.ACCEPTED);
    }
    @GetMapping("/books/get-books-by-genre")
    public ResponseEntity<List<Book>> getAllBooksByGenre(@RequestParam("genre") String genre){
        List<Book> bookList = bookService.findBooksByGenre(genre);
        return new ResponseEntity<>(bookList, HttpStatus.ACCEPTED);

    }
}
