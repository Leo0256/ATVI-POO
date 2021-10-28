package negocio.listagem.clientes;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import modelo.Cliente;
import negocio.listagem.Listagem;
import negocio.listagem.Sortable;

public class ListarTop10Consomem extends Listagem implements Sortable {
	private List<Cliente> clientes;
	private boolean ordem;
	
	public ListarTop10Consomem(List<Cliente> clientes, boolean ordernarAsc) {
		this.clientes = clientes;
		ordem = ordernarAsc;
		sort();
	}
	
	@Override
	public void listar() {
		System.out.print("Lista dos top 10 clientes que ");
		if(ordem) 
			System.out.println("mais consomem:");
		
		else System.out.println("menos consomem:");
		
		int flag = 1, total = 0;
		for (Cliente cliente : clientes) {
			System.out.println("\n" + flag + "º:\n");
			
			System.out.println("Nome: " + cliente.nome);
			System.out.println("CPF: " + cliente.getCpf().getValor());
			
			System.out.println("Total de protudos e serviços consumidos:");
			total = cliente.getProdutosConsumidos().size() + 
					cliente.getServicosConsumidos().size();
			System.out.println(" - " + total + " produtos/serviços");
			
			System.out.println("--------------------------------------");
			if(flag++ > 10) break;
		}
	}

	@Override
	public void sort() {
		Collections.sort(clientes, new Comparator<Cliente>() {
			@Override
			public int compare(Cliente cli1, Cliente cli2) {
				int x = cli1.getProdutosConsumidos().size() + 
						cli1.getServicosConsumidos().size();
				
				int y = cli2.getProdutosConsumidos().size() + 
						cli2.getServicosConsumidos().size();
				
				if(ordem)
					return y - x;
				
				else return x - y;
			}
		});
	}
}
