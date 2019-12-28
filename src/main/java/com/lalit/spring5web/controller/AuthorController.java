package com.lalit.spring5web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lalit.spring5web.repositories.AuthorRepository;

@Controller
public class AuthorController {

	private AuthorRepository authorRepository;

	public AuthorController(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}
	
	@RequestMapping("/authors")
	public String getAuthors(Model model) {

		model.addAttribute("authors", authorRepository.findAll());
		return "authors";
	}

	@RequestMapping("/home")
	public String getHome(Model model) {

		model.addAttribute("authors", authorRepository.findAll());
		return "home";
	}
}
