package expoo.entidades;

public class Comida {
	private int id;
	private String culinaria;
	private String nome;
	private double preco;
	
	public String toString() {
		return "Comida [id=" + id + ", culinaria=" + culinaria + ", nome=" + nome + ", preco=" + preco + "]";
	}

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
