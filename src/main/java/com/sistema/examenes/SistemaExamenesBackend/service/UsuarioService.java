package com.sistema.examenes.SistemaExamenesBackend.service;

import com.sistema.examenes.SistemaExamenesBackend.model.Usuario;
import com.sistema.examenes.SistemaExamenesBackend.model.UsuarioRol;

import java.util.Set;

public interface UsuarioService {

    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception;
}
