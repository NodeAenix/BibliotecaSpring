package org.example.bibliotecaspring.controllers;

import org.example.bibliotecaspring.models.Libro;
import org.example.bibliotecaspring.repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {

    LibroRepository libroRepository;

    public LibroController() {}

    @Autowired
    public LibroController(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @GetMapping
    public ResponseEntity<List<Libro>> getLibros() {
        return ResponseEntity.ok(libroRepository.findAll());
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<Libro> getLibro(@PathVariable String isbn) {
        Libro libro = libroRepository.findById(isbn).orElseThrow();
        return ResponseEntity.ok(libro);
    }

    @PostMapping
    public ResponseEntity<Libro> addLibro(@RequestBody Libro libro) {
        return ResponseEntity.ok(libroRepository.save(libro));
    }

    @PutMapping
    public ResponseEntity<Libro> updateLibro(@RequestBody Libro libro) {
        return ResponseEntity.ok(libroRepository.save(libro));
    }

    @DeleteMapping("/{isbn}")
    public ResponseEntity<String> deleteLibro(@PathVariable String isbn) {
        libroRepository.deleteById(isbn);
        return ResponseEntity.ok("Libro con ISBN " + isbn + " borrado.");
    }

}
