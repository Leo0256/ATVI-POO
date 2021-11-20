package modelo;

public class Servico {
	private String id;
	public String nome;
	public double valor;
	
	public Servico(String id, String nome, double valor) {
		this.id = id;
		this.nome = nome;
		this.valor = valor;
	}
	
	public Servico() {}
	
	public String getId() {
		return id;
	}
	
	@Override
	public boolean equals(Object obj) {
		Servico servico = (Servico) obj;
		return id.equals(servico.getId());
	}
	
	public boolean equals(String id) {
		return this.id.equals(id);
	}
}