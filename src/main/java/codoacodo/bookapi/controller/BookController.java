package codoacodo.bookapi.controller;

import codoacodo.bookapi.models.Book;
import codoacodo.bookapi.models.BookDto;
import codoacodo.bookapi.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookService bookService;


    //CRUD
    @CrossOrigin
    @GetMapping("")
    public List<BookDto> getAllBooks(){
        return bookService.getAllBooks();
    }
//    @PostMapping("/add")
//    public void createBook(@RequestBody Book book){
//        bookService.createBook(book);
//    }
    @PostMapping("/add")
    public Optional<Book> createBook(@RequestBody Book book, @RequestParam Long editorialId){
        return bookService.createBook(book,editorialId);
    }

    @GetMapping("/{id}")
    public Book findBookById(@PathVariable Long id){
        return  bookService.findBookById(id);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.deleteBookById(id);
    }
    @PutMapping("/update")
    public Book updateBook(@RequestBody Book book){
        return bookService.updateBook(book);
    }
    //Por título
    @GetMapping("/title")
    public List<Book> getBookByTitle(@RequestParam String title){
        return bookService.getBookByTitle(title);
    }

    //Por Ofertas
    @GetMapping("/books-offers")
    public List<Book> getOffers(@RequestParam Integer offerPrice){
        return bookService.getOffers(offerPrice);
    }



}
