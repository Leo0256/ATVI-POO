package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import modelo.CPF;
import modelo.Cliente;
import modelo.Empresa;
import modelo.Produto;
import modelo.RG;
import modelo.Servico;
import modelo.Telefone;

public class DadosTeste {
	private List<Produto> produtos;
	private List<Servico> servicos;
	private List<Cliente> clientes;
	
	public DadosTeste(Empresa emp) {
		this.produtos = emp.getProdutos();
		this.servicos = emp.getServicos();
		this.clientes = emp.getClientes();
		
		setProdutos();
		setServicos();
		setClientes();
	}
	
	private void setClientes() {
		List<RG> rgs1 = new ArrayList<RG>();
		rgs1.add(new RG(LocalDate.now(), "1234567890"));
		rgs1.add(new RG(LocalDate.now(), "0987654321"));
		
		List<RG> rgs2 = new ArrayList<RG>();
		rgs2.add(new RG(LocalDate.now(), "4242424242"));
		
		List<Telefone> tels1 = new ArrayList<Telefone>();
		tels1.add(new Telefone("12","1234-5678"));
		
		List<Telefone> tels2 = new ArrayList<Telefone>();
		tels2.add(new Telefone("90","9090-9090"));
		tels2.add(new Telefone("88","8888-8888"));
		
		Cliente cli1 = new Cliente(
				"Robson Oliveira",
				"Rob",
				"M",
				new CPF(LocalDate.now(), "123.456.789/00"),
				rgs1,
				tels1
				);
		cli1.addProdutoConsumido(produtos.get(0));
		cli1.addProdutoConsumido(produtos.get(0));
		cli1.addServicoConsumido(servicos.get(0));
		
		Cliente cli2 = new Cliente(
				"Miriam dos Santos",
				"Miriam",
				"F",
				new CPF(LocalDate.now(), "987.654.321/00"),
				rgs2,
				tels2);
		cli2.addProdutoConsumido(produtos.get(0));
		cli2.addProdutoConsumido(produtos.get(1));
		cli2.addServicoConsumido(servicos.get(1));
		
		clientes.add(cli1);
		clientes.add(cli2);
	}
	
	private void setProdutos() {
		produtos.add(new Produto(
				"A001",
				"Shampoo Top de Linha",
				20.00));
		
		produtos.add(new Produto(
				"A002",
				"Sabonete Líquido em Barra",
				5.50));
	}
	
	private void setServicos() {
		servicos.add(new Servico(
				"B100",
				"Corte de Cabelo Poligonal",
				24.00));
		
		servicos.add(new Servico(
				"B200",
				"Tortura para a Remoção de Cravos",
				15.50));
	}
}
