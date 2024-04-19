package codoacodo.bookapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookDto {

    private Long id;
    private String title;
    private String author;
    private String genre;
    private String yearOfPublication;
    private Double convertedPrice;




}
