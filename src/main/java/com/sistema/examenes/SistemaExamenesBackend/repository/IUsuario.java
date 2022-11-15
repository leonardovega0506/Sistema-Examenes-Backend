package com.sistema.examenes.SistemaExamenesBackend.repository;

import com.sistema.examenes.SistemaExamenesBackend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuario extends JpaRepository<Usuario,Long> {

    public Usuario findByUsername(String username);
}
