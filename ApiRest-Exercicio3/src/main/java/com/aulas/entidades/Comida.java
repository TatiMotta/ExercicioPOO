package com.aulas.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Comida {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String culinaria;
	private String nome;
	private Float preco;
		
	public Comida() {
	}
	
	public Comida(String culinaria, String nome, Float preco) {
		this.culinaria = culinaria;
		this.nome = nome;
		this.preco = preco;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCulinaria() {
		return culinaria;
	}
	public void setCulinaria(String culinaria) {
		this.culinaria = culinaria;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Float getPreco() {
		return preco;
	}
	public void setPreco(Float preco) {
		this.preco = preco;
	}
	
	
}
