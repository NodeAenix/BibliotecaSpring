package org.example.bibliotecaspring.repositories;

import org.example.bibliotecaspring.models.Libro;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LibroRepository extends JpaRepository<Libro, String> {

}
