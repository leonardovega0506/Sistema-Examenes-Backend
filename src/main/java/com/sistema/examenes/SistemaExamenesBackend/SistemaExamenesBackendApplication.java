package com.sistema.examenes.SistemaExamenesBackend;

import com.sistema.examenes.SistemaExamenesBackend.model.Rol;
import com.sistema.examenes.SistemaExamenesBackend.model.Usuario;
import com.sistema.examenes.SistemaExamenesBackend.model.UsuarioRol;
import com.sistema.examenes.SistemaExamenesBackend.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@SpringBootApplication
public class SistemaExamenesBackendApplication implements CommandLineRunner {

	@Autowired
	private UsuarioService usuarioService;

	public static void main(String[] args) {
		SpringApplication.run(SistemaExamenesBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Usuario usuario = new Usuario();

		usuario.setNombre("Leo");
		usuario.setApellido("Vega");
		usuario.setUsername("leo");
		usuario.setPassword("12345");
		usuario.setTelefono("5627696094");
		usuario.setPerfil("foto.png");


		Rol rol = new Rol();
		rol.setRolId(1L);
		rol.setNombre("ADMIN");

		Set<UsuarioRol> usuarioRoles = new HashSet<>();
		UsuarioRol usuarioRol = new UsuarioRol();
		usuarioRol.setRol(rol);
		usuarioRol.setUsuario(usuario);
		usuarioRoles.add(usuarioRol);

		Usuario usuarioGuardo = usuarioService.guardarUsuario(usuario,usuarioRoles);

		log.debug(usuarioGuardo.getUsername());
	}
}
