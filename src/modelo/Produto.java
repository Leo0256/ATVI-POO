package modelo;

public class Produto {
	private String id;
	public String nome;
	public double valor;
	
	public Produto(String id, String nome, double valor) {
		this.id = id;
		this.nome = nome;
		this.valor = valor;
	}
	
	public String getId() {
		return id;
	}
}