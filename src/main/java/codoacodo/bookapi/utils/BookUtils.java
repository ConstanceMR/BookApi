package codoacodo.bookapi.utils;

import codoacodo.bookapi.models.Book;
import codoacodo.bookapi.models.BookDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookUtils {

    public List<Book> detectOffers(List<Book> books, double offerPrice) {
        return books.stream()
                .filter(book -> book.getPrice() < offerPrice)
                .collect(Collectors.toList());
    }

//    public List<BookDto> bookMapperList(List<Book> bookList, double dolarPrice) {
//        List<BookDto> bookDtoList = new ArrayList<>();
//        for (Book book:bookList){
//            bookDtoList.add(new BookDto(book.getId(), book.getTitle(), book.getAuthor(), book.getGenre(), book.getYearOfPublication(), book.getPrice()* dolarPrice));
//        }
//       return bookDtoList;
//    }
        public List<BookDto> bookMapperList(List<Book> bookList, double dolarPrice) {
            return bookList.stream()
                    .map(book-> new BookDto(book.getId(), book.getTitle(), book.getAuthor(), book.getGenre(), book.getYearOfPublication(), book.getPrice() * dolarPrice))
                    .collect(Collectors.toList());

        }


}


