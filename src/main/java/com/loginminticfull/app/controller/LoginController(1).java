package com.loginminticfull.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.loginminticfull.app.entity.Usuario;
import com.loginminticfull.app.repository.UsuarioRepository;

@Controller
public class LoginController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/login")
	public String llamarlogin(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "login";
	}
	
	@GetMapping("/register")
	public String llamarregistro(Model model)
	{
		model.addAttribute("usuario", new Usuario());
		return "register";
	}
	
	@GetMapping("/")
	public String llamarindex()
	{
		return"index";
	}
	
	@PostMapping("/register")
	public String formularioregistro(@ModelAttribute("usuario") Usuario usuario)
	{
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		usuario.setPassword(encoder.encode(usuario.getPassword()));
		usuarioRepository.save(usuario);
		return "redirect:/login";
	}

}
