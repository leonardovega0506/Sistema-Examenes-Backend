package com.sistema.examenes.SistemaExamenesBackend.service.impl;

import com.sistema.examenes.SistemaExamenesBackend.model.Usuario;
import com.sistema.examenes.SistemaExamenesBackend.model.UsuarioRol;
import com.sistema.examenes.SistemaExamenesBackend.repository.IRol;
import com.sistema.examenes.SistemaExamenesBackend.repository.IUsuario;
import com.sistema.examenes.SistemaExamenesBackend.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Slf4j
@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private IUsuario iUsuario;

    @Autowired
    private IRol iRol;


    @Override
    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception {
        Usuario usuarioLocal = iUsuario.findByUsername(usuario.getUsername());

        if(usuarioLocal !=null){
            log.info("EL USUARIO YA EXISTE");
            throw new Exception("EL USUARIO YA ESTA PRESENTE");
        }else{
            for(UsuarioRol usuarioRol:usuarioRoles){
                iRol.save(usuarioRol.getRol());
            }
            usuario.getUsuarioRoles().addAll(usuarioRoles);
            usuarioLocal = iUsuario.save(usuario);
        }
        return usuarioLocal;
    }

    @Override
    public Usuario obtenerUsuario(String username) {
        return iUsuario.findByUsername(username);
    }

    @Override
    public void eliminarUsuario(Long usuarioId) {
        iUsuario.deleteById(usuarioId);
    }
}
