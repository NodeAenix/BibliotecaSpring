package org.example.bibliotecaspring.controllers;

import jakarta.validation.Valid;
import org.example.bibliotecaspring.models.Usuario;
import org.example.bibliotecaspring.repositories.UsuarioRepository;
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
@RequestMapping("/usuarios")
@CacheConfig(cacheNames = {"usuarios"})
public class UsuarioController {

    UsuarioRepository usuarioRepository;

    public UsuarioController() {}

    @Autowired
    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> getEjemplares() {
        return ResponseEntity.ok(usuarioRepository.findAll());
    }

    @GetMapping("/{id}")
    @Cacheable
    public ResponseEntity<Usuario> getEjemplar(@PathVariable Integer id) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Usuario usuario = usuarioRepository.findById(id).orElseThrow();
        return ResponseEntity.ok(usuario);
    }

    @PostMapping
    public ResponseEntity<Usuario> addLibro(@Valid @RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioRepository.save(usuario));
    }

    @PutMapping
    public ResponseEntity<Usuario> updateLibro(@Valid @RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioRepository.save(usuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLibro(@PathVariable Integer id) {
        usuarioRepository.deleteById(id);
        return ResponseEntity.ok("Préstamo con ID " + id + " borrado.");
    }

}
