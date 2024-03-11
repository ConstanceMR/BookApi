package codoacodo.bookapi.controller;

import codoacodo.bookapi.models.Book;
import codoacodo.bookapi.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }
    @PostMapping("/agregar")
    public void createBook(@RequestBody Book book){
        bookService.createBook(book);
    }
    @GetMapping("/{id}")
    public Book findBookById(@PathVariable Long id){
        return  bookService.findBookById(id);
    }
    @DeleteMapping("/eliminar/{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.deleteBookById(id);
    }
    @PutMapping("/actualizar")
    public Book updateBook(@RequestBody Book book){
        return bookService.updateBook(book);
    }


}
