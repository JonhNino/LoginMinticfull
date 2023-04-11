package com.loginminticfull.app.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.loginminticfull.app.entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	@Query("SELECT usuario From Usuario usuario WHERE usuario.username")
	Usuario getUsuarioByUsername(@Param("username")String username);
}
