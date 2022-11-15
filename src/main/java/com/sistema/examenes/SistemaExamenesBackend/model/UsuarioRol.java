package com.sistema.examenes.SistemaExamenesBackend.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class UsuarioRol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuarioRolId;

    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario usuario;

    @ManyToOne
    private Rol rol;
}
