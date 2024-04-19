package codoacodo.bookapi.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Book {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String author;
    private String genre;
    private String yearOfPublication;
    private Double price;

    @ManyToOne
    //atributo con el que se van a relacionar
    @JoinColumn(name = "editorial_id")
    private Editorial editorial;


    public Book(String title, String author, String genre, String yearOfPublication, Double price) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.yearOfPublication = yearOfPublication;
        this.price = price;
    }
}
