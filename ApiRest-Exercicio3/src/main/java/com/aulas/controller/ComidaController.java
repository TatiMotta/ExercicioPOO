package com.aulas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aulas.entidades.Comida;
import com.aulas.repository.ComidaRepository;

@RestController
@RequestMapping("/comida")
public class ComidaController {
	
	@Autowired
	private ComidaRepository comidaRepository;
	
	@GetMapping
	public List<Comida> buscarTodos(){
		return comidaRepository.findAll();
	}	
	
	@GetMapping("/{id}")
	public ResponseEntity<Comida> buscarPorId(@PathVariable Long id){
		Optional<Comida> comida = comidaRepository.findById(id);
		return comida.isPresent() ? ResponseEntity.ok(comida.get()) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Comida> adicionar(@RequestBody Comida comida){
		Comida comidaSalva = comidaRepository.save(comida);
		return ResponseEntity.status(HttpStatus.CREATED).body(comidaSalva);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Comida> atualizar(@PathVariable Long id, @RequestBody Comida comida){
		Optional<Comida> buscarComida = comidaRepository.findById(id);
		if(buscarComida.isPresent()) {
			comida.setId(id);
			comidaRepository.save(comida);
			return ResponseEntity.ok(comida);		
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Comida> deletarComida(@PathVariable Long id){
		Optional<Comida> buscarComida = comidaRepository.findById(id);
		if(buscarComida.isPresent()) {
			comidaRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
}
