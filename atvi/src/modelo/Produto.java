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
	
	public Produto() {}
	
	public String getId() {
		return id;
	}
	
	@Override
	public boolean equals(Object obj) {
		Produto produto = (Produto) obj;
		return id.equals(produto.getId());
	}
}