package codoacodo.bookapi.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private String titulo;
    private String autor;
    private String genero;
    private String anio;
    private Double precio;

    public Book(String titulo, String autor, String genero, String anio, Double precio) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.anio= this.anio;
        this.precio = precio;
    }
}
