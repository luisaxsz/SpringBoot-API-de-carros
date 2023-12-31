package com.example.demo.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class LoginForm {
	// Post - Mais recomendado
	@GetMapping("/login")
	public String login(@RequestParam("login") String login, @RequestParam("senha") String senha) {
		return " login:  " + login + "  senha: " + senha;
	}

	@GetMapping("/login2/login/{login}/senha/{senha}")
	public String login2(@PathVariable("login") String login, @PathVariable("senha") String senha) {
		return " login:  " + login + "  senha: " + senha;
	}

	@GetMapping("/Carros/{id}")
	public String getCarroById(@PathVariable("id") Long id) {
		return "Id: " + id;
	}
	

	@PostMapping("/loginPost")
	public String loginPost(@RequestParam("login") String login, @RequestParam("senha") String senha) {
		return " login:  " + login + "  senha: " + senha;
	}

	@PutMapping()
	public String put() {
		return "PUT SpringBoot";
	}

	@DeleteMapping()
	public String delete() {
		return "Delete SpringBoot";
	}
}
