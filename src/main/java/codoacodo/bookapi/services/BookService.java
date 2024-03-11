package codoacodo.bookapi.services;


import codoacodo.bookapi.models.Book;
import codoacodo.bookapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BookService {
    public Book updateBook;
    @Autowired
    BookRepository bookRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
    public void createBook(Book book){
        bookRepository.save(book);

    }
    public Book updateBook(Book book){
        bookRepository.save(book);
        return bookRepository.findById(book.getId()).orElse(null);
    }
    public Book findBookById(long id) {
        return bookRepository.findById(id).orElse(null);
    }
    public void deleteBookById(long id){
        bookRepository.deleteById(id);
    }
}
