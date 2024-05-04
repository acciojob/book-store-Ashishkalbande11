package com.driver;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    HashMap<Integer, Book> bookRepo = new HashMap<>();

    public BookRepository(){
    }

    public Book save(Book book){
        int bookId = bookRepo.size()+1;
        book.setId(bookId);
        bookRepo.put(bookId,book);
        return book;
    }


    public Book findBookById(int id){

        return bookRepo.get(id);
    }

    public List<Book> findAll(){
        List<Book> bookList = new ArrayList<>();

        for(Integer book : bookRepo.keySet()){
            bookList.add(bookRepo.get(book));
        }
        return bookList;
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
            if(Objects.equals(author,book.getAuthor())){
                bookList.add(book);
            }
        }
        return bookList;
    }

    public List<Book> findBooksByGenre(String genre){
        List<Book> bookList = new ArrayList<>();
        for(Book book : bookRepo.values()){
            if(Objects.equals(genre,book.getGenre())){
                bookList.add(book);
            }
        }
        return bookList;
    }
}
