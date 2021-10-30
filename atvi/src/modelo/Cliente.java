package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
	public String nome;
	public String nomeSocial;
	public String genero;
	private CPF cpf;
	private List<RG> rgs;
	private LocalDate dataCadastro;
	private List<Telefone> telefones;
	private List<Produto> produtosConsumidos;
	private List<Servico> servicosConsumidos;
	
	public Cliente(String nome, String nomeSocial, String genero, CPF cpf, 
			List<RG> rgs, List<Telefone> tels) {
		this.nome = nome;
		this.nomeSocial = nomeSocial;
		this.genero = genero;
		this.cpf = cpf;
		this.rgs = rgs;
		this.dataCadastro = LocalDate.now();
		this.telefones = tels;
		this.produtosConsumidos = new ArrayList<Produto>();
		this.servicosConsumidos = new ArrayList<Servico>();
	}
	public CPF getCpf() {
		return cpf;
	}
	public List<RG> getRgs() {
		return rgs;
	}
	public LocalDate getDataCadastro() {
		return dataCadastro;
	}
	public List<Telefone> getTelefones() {
		return telefones;
	}
	
	public List<Produto> getProdutosConsumidos() {
		return produtosConsumidos;
	}
	
	public void addProdutoConsumido(Produto produto) {
		produtosConsumidos.add(produto);
	}
	
	public List<Servico> getServicosConsumidos() {
		return servicosConsumidos;
	}
	
	public void addServicoConsumido(Servico servico) {
		servicosConsumidos.add(servico);
	}
}