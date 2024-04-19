package codoacodo.bookapi.services;


import codoacodo.bookapi.configuration.BookConfiguration;
import codoacodo.bookapi.models.Book;
import codoacodo.bookapi.models.BookDto;
import codoacodo.bookapi.repository.BookRepository;
import codoacodo.bookapi.repository.EditorialRepository;
import codoacodo.bookapi.utils.BookUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    public Book updateBook;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    BookConfiguration bookConfiguration;
    @Autowired
    BookUtils bookUtils;
    @Autowired
    EditorialRepository editorialRepository;



//    public List<BookDto> getAllBooks(){
//        List<BookList> bookList = bookRepository.findAll();
//        List<BookDtoList> bookDtoList = bookList.stream()
//                .map(book->bookUtils.bookMapper(book, getDolarPrice()))
//                .collect(Collectors.toList());
//        return bookDtoList;
//    }
//CRUD
    public List<BookDto> getAllBooks(){
        List<Book> bookList = bookRepository.findAll();
            return bookUtils.bookMapperList(bookList, getDolarPrice());
    }

    public Optional<Book> createBook (Book book, Long editorialId) {
        book.setEditorial(editorialRepository.findById(editorialId).orElse(null));
         return  Optional.of(bookRepository.save(book));
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

    //Por título
    public List<Book> getBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    //Precio de dolar
    private double getDolarPrice() {
        return bookConfiguration.fetchDolar().getPromedio();
    }

    //Ofertas
    public List<Book> getOffers(Integer offerPrice) {
        List<Book> books = bookRepository.findAll();
        return bookUtils.detectOffers(books, offerPrice);
    }

}
