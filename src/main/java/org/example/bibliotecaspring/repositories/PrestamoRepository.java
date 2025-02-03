package org.example.bibliotecaspring.repositories;

import org.example.bibliotecaspring.models.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {

}
