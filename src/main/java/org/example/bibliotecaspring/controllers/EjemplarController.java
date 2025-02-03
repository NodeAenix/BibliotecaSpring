package org.example.bibliotecaspring.controllers;

import jakarta.validation.Valid;
import org.example.bibliotecaspring.models.Ejemplar;
import org.example.bibliotecaspring.repositories.EjemplarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
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
@RequestMapping("/ejemplares")
@CacheConfig(cacheNames = {"ejemplares"})
public class EjemplarController {

    EjemplarRepository ejemplarRepository;

    public EjemplarController() {}

    @Autowired
    public EjemplarController(EjemplarRepository ejemplarRepository) {
        this.ejemplarRepository = ejemplarRepository;
    }

    @GetMapping
    public ResponseEntity<List<Ejemplar>> getEjemplares() {
        return ResponseEntity.ok(ejemplarRepository.findAll());
    }

    @GetMapping("/{id}")
    @Cacheable
    public ResponseEntity<Ejemplar> getEjemplar(@PathVariable Integer id) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Ejemplar ejemplar = ejemplarRepository.findById(id).orElseThrow();
        return ResponseEntity.ok(ejemplar);
    }

    @PostMapping
    public ResponseEntity<Ejemplar> addLibro(@Valid @RequestBody Ejemplar ejemplar) {
        return ResponseEntity.ok(ejemplarRepository.save(ejemplar));
    }

    @PutMapping
    public ResponseEntity<Ejemplar> updateLibro(@Valid @RequestBody Ejemplar ejemplar) {
        return ResponseEntity.ok(ejemplarRepository.save(ejemplar));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLibro(@PathVariable Integer id) {
        ejemplarRepository.deleteById(id);
        return ResponseEntity.ok("Ejemplar con ID " + id + " borrado.");
    }

}
