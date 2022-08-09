package com.aulas.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aulas.entidades.Comida;
import com.aulas.repository.ComidaRepository;

@Controller
@RequestMapping("/")
public class ComidaController {
	
	
	@Autowired
	private ComidaRepository comidaRepository;

	@GetMapping
	public String index() {
		return "index";
	}
	
	@GetMapping("/cadastro")
	public String formCadastro() {
		return "cadastro";
	}
	
	@GetMapping("/consulta")
	public String consulta(Model model) {
		Iterable<Comida> comidas = comidaRepository.findAll();
		model.addAttribute("comidas", comidas);
		return "consulta";
	}
	
	@GetMapping("/consulta/{idcomida}")
		public String formEditar(@PathVariable("idcomida") int id, Model model){
			Comida comida = comidaRepository.findById(id).get();
			model.addAttribute("comida", comida);
			return "edicao";
	}
	
	@PostMapping("/cadastro")
	public String salvar(Comida comida) {
		comidaRepository.save(comida);
		return "redirect:/consulta";
	}
	
	@GetMapping("/delete/{idcomida}")
	public String delete(@PathVariable("idcomida") int id) {
		comidaRepository.deleteById(id);
		return "redirect:/consulta";
	}
	
}
