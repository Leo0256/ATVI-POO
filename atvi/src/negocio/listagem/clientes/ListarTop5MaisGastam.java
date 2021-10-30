package negocio.listagem.clientes;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import modelo.Cliente;
import modelo.Produto;
import modelo.Servico;
import negocio.listagem.Listagem;
import negocio.listagem.Sortable;

public class ListarTop5MaisGastam extends Listagem implements Sortable {
	private List<Cliente> clientes;
	
	public ListarTop5MaisGastam(List<Cliente> clientes) {
		this.clientes = clientes;
		sort();
	}

	@Override
	public void listar() {
		System.out.println("Lista dos top 5 clientes que mais gastam:");
		double total = 0;
		int flag = 1;
		for (Cliente cliente : clientes) {
			System.out.println("\n" + flag + "º:\n");
			
			System.out.println("Nome: " + cliente.nome);
			System.out.println("CPF: " + cliente.getCpf().getValor());
			
			total = getValorTotalProdutos(cliente) + 
					getValorTotalServicos(cliente);
			System.out.println("Total gasto: R$" + total);
			
			System.out.println("--------------------------------------");
			
			if(flag++ > 5) break;
		}
	}
	
	private double getValorTotalProdutos(Cliente cliente) {
		double total = 0;
		for(Produto produto : cliente.getProdutosConsumidos())
			total += produto.valor;
		return total;
	}
	
	private double getValorTotalServicos(Cliente cliente) {
		double total = 0;
		for(Servico servico : cliente.getServicosConsumidos())
			total += servico.valor;
		return total;
	}
	
	@Override
	public void sort() {
		Collections.sort(clientes, new Comparator<Cliente>() {
			@Override
			public int compare(Cliente cli1, Cliente cli2) {
				
				double totalCli1 = 
						getValorTotalProdutos(cli1) +
						getValorTotalServicos(cli1);
				
				double totalCli2 = 
						getValorTotalProdutos(cli2) +
						getValorTotalServicos(cli2);
				
				return (int) Math.round(totalCli2 - totalCli1);
			}
		});
	}
}
