package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**gestaoFesta
 * UsuarioController.java
 * @author jaime
 * Em 11-05-2020 **/

@Controller
public class UsuarioController {
	/*
	 * Form Login
	 * Url: localhost:8080
	 * File: logar.html
	 */
	@GetMapping("/")
	public String formlogin(Model model) {
		return "logar";
	}
}
