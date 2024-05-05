package com.driver;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    List<Book> bookList;
    static int id = 0;
    public BookRepository(){
        bookList = new ArrayList<>();
    }

    public Book save(Book book){
        id++;
        book.setId(id);
        bookList.add(book);
        return book;
    }


    public Book findBookById(int id){

        for(Book b : bookList){
            if(b.getId() == id){
                return b;
            }
        }
        return null;
    }

    public List<Book> findAll(){
        return bookList;
    }

    public void deleteBookById(int id){
        for(Book b : bookList){
            if(b.getId() == id){
                bookList.remove(b);
            }
        }
    }

    public void deleteAll(){
        bookList.clear();
    }

    public List<Book> findBooksByAuthor(String author){
        List<Book> books = new ArrayList<>();
        for(Book book : bookList){
            if(book.getAuthor().equals(author)){
                books.add(book);
            }
        }
        return books;
    }

    public List<Book> findBooksByGenre(String genre){
        List<Book> books= new ArrayList<>();
        for(Book book : bookList){
            if(book.getGenre().equals(genre)){
                books.add(book);
            }
        }
        return books;
    }
}
