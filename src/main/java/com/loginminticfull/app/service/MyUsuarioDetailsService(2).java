package com.loginminticfull.app.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.loginminticfull.app.entity.Usuario;
import com.loginminticfull.app.repository.UsuarioRepository;

public class MyUsuarioDetailsService implements UserDetails{
	
	private final Usuario usuario;
	private final UsuarioRepository repository;
	
	

	public MyUsuarioDetailsService(Usuario usuario, UsuarioRepository repository) {
		
		this.usuario = usuario;
		this.repository = repository;
	}

     public Usuario getUsuario()
     {
    	 return usuario;
     }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public String getPassword() {
		
		return usuario.getPassword();
	}



	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return usuario.getUsername();
	}

    

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	
		

}
