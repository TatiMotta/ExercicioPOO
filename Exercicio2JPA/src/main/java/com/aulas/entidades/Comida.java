package com.aulas.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Comida {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 50, nullable = false)
	private String culinaria;
	@Column(length = 20)
	private String nome;
	@Column(length = 50, nullable = false, unique = true)
	private double preco;
	
	
	
	public Comida() {
	}
	public Comida(String culinaria, String nome, double preco) {
		this.culinaria = culinaria;
		this.nome = nome;
		this.preco = preco;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
}
