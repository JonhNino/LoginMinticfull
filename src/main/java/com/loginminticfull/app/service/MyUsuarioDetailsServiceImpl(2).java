package com.loginminticfull.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.loginminticfull.app.entity.Usuario;
import com.loginminticfull.app.repository.UsuarioRepository;

public class MyUsuarioDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		Usuario usuario = repository.getUsuarioByUsername(username);
		if (usuario==null) {
			throw new UsernameNotFoundException("No existe el usuario con username: " + username);
		}
		return new MyUsuarioDetailsService(usuario, repository);	
		}
		
	
}
