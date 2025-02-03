package org.example.bibliotecaspring.repositories;

import org.example.bibliotecaspring.models.Ejemplar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EjemplarRepository extends JpaRepository<Ejemplar, Integer> {

}
