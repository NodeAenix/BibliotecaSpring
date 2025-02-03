package org.example.bibliotecaspring.repositories;

import org.example.bibliotecaspring.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
