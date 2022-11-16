package com.sistema.examenes.SistemaExamenesBackend.controller;

import com.sistema.examenes.SistemaExamenesBackend.model.Rol;
import com.sistema.examenes.SistemaExamenesBackend.model.Usuario;
import com.sistema.examenes.SistemaExamenesBackend.model.UsuarioRol;
import com.sistema.examenes.SistemaExamenesBackend.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService sUsuario;

    @PostMapping("/")
    public Usuario guardarUsuario(@RequestBody Usuario usuario) throws Exception{
        Set<UsuarioRol> roles = new HashSet<>();

        Rol rol = new Rol();
        rol.setRolId(2L);

        rol.setNombre(("NORMAL"));

        UsuarioRol usuarioRol = new UsuarioRol();
        usuarioRol.setUsuario(usuario);
        usuarioRol.setRol(rol);

        return sUsuario.guardarUsuario(usuario,roles);
    }

    @GetMapping("{username}")
    public Usuario obtenerUsuario(@PathVariable("username") String username){
        return sUsuario.obtenerUsuario(username);
    }

    @DeleteMapping("/{usuarioId}")
    public void eliminarUsuario(@PathVariable("usuarioId") Long usuarioId){
        sUsuario.eliminarUsuario(usuarioId);
    }
}
