package org.example.bibliotecaspring.controllers;

import jakarta.validation.Valid;
import org.example.bibliotecaspring.models.Prestamo;
import org.example.bibliotecaspring.repositories.PrestamoRepository;
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
@RequestMapping("/prestamos")
@CacheConfig(cacheNames = {"prestamos"})
public class PrestamoController {

    PrestamoRepository prestamoRepository;

    public PrestamoController() {}

    @Autowired
    public PrestamoController(PrestamoRepository prestamoRepository) {
        this.prestamoRepository = prestamoRepository;
    }

    @GetMapping
    public ResponseEntity<List<Prestamo>> getEjemplares() {
        return ResponseEntity.ok(prestamoRepository.findAll());
    }

    @GetMapping("/{id}")
    @Cacheable
    public ResponseEntity<Prestamo> getEjemplar(@PathVariable Integer id) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Prestamo prestamo = prestamoRepository.findById(id).orElseThrow();
        return ResponseEntity.ok(prestamo);
    }

    @PostMapping
    public ResponseEntity<Prestamo> addLibro(@Valid @RequestBody Prestamo prestamo) {
        return ResponseEntity.ok(prestamoRepository.save(prestamo));
    }

    @PutMapping
    public ResponseEntity<Prestamo> updateLibro(@Valid @RequestBody Prestamo prestamo) {
        return ResponseEntity.ok(prestamoRepository.save(prestamo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLibro(@PathVariable Integer id) {
        prestamoRepository.deleteById(id);
        return ResponseEntity.ok("Préstamo con ID " + id + " borrado.");
    }

}
