package negocio.listagem.clientes;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import modelo.Cliente;
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
			
			total = cliente.getValorTotalProdutos() + 
				 cliente.getValorTotalServicos();
			System.out.println("Total gasto: R$" + total);
			
			System.out.println("--------------------------------------");
			
			if(flag++ > 5) break;
		}
	}
	
	@Override
	public void sort() {
		Collections.sort(clientes, new Comparator<Cliente>() {
			@Override
			public int compare(Cliente cli1, Cliente cli2) {
				
				double totalCli1 = 
						cli1.getValorTotalProdutos() +
						cli1.getValorTotalServicos();
				
				double totalCli2 = 
						cli2.getValorTotalProdutos() +
						cli2.getValorTotalServicos();
				
				return (int) Math.round(totalCli2 - totalCli1);
			}
		});
	}
}
