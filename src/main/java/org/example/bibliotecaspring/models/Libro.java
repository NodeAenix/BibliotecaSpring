package org.example.bibliotecaspring.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "libro")
public class Libro {
    @Id
    @Column(name = "isbn", nullable = false, length = 20)
    @NotNull
    @NotBlank(message = "Debe especificar un ISBN-13.")
    @Pattern(regexp = "^(\\d{3})-\\d-(\\d{3})-(\\d{5})-\\d$",
             message = "Compruebe el formato del ISBN-13: XXX-X-XXX-XXXXX-X")
    private String isbn;

    @Column(name = "titulo", nullable = false, length = 200)
    @NotNull
    @NotBlank(message = "Debe especificar un título.")
    @Pattern(regexp = "^[\\w\\sÀ-ÿ]{1,200}$", message = "Error de formato.")
    private String titulo;

    @Column(name = "autor", nullable = false, length = 100)
    @NotNull
    @NotBlank(message = "Debe especificar un autor.")
    @Pattern(regexp = "^[a-zA-Z_\\sÀ-ÿ]{1,100}$", message = "Error de formato.")
    private String autor;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

}
