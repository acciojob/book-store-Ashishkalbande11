package com.driver;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    HashMap<Integer, Book> bookRepo = new HashMap<>();
    int bookId = 2;
    public BookRepository(){
        save(new Book(1,"Yoga", "Genre1", "Author2"));
        save(new Book(2, "Physics", "Genre1","Author1"));

    }

    public Book save(Book book){
        book.setId(bookId++);
        bookRepo.put(book.getId(),book);
        return book;
    }


    public Book findBookById(int id){

        return bookRepo.get(id);
    }

    public List<Book> findAll(){
        return new ArrayList<>(bookRepo.values());
    }

    public void deleteBookById(int id){

        bookRepo.remove(id);
    }

    public void deleteAll(){
        bookRepo.clear();
    }

    public List<Book> findBooksByAuthor(String author){
        List<Book> bookList = new ArrayList<>();
        for(Book book : bookRepo.values()){
            if(author.equals(book.getAuthor())){
                bookList.add(book);
            }
        }
        return bookList;
    }

    public List<Book> findBooksByGenre(String genre){
        List<Book> bookList = new ArrayList<>();
        for(Book book : bookRepo.values()){
            if(genre.equals(book.getGenre())){
                bookList.add(book);
            }
        }
        return bookList;
    }
}
