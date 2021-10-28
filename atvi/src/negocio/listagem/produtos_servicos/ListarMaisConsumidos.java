package negocio.listagem.produtos_servicos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import modelo.Cliente;
import modelo.Produto;
import modelo.Servico;
import negocio.listagem.Listagem;
import negocio.listagem.Sortable;

public class ListarMaisConsumidos extends Listagem implements Sortable {
	private List<Cliente> clientes;
	
	public ListarMaisConsumidos(List<Cliente> clientes) {
		this.clientes = clientes;
		setCountProdutos();
		setCountServicos();
		sort();
	}
	
	private class Contador {
		public Object item;
		public int size;
		public Contador(Object item, int size) {
			this.item = item;
			this.size = size;
		}
	}
	
	private List<Contador> countProdutos = new ArrayList<Contador>();
	private void setCountProdutos() {
		List<Produto> prds;
		for(Cliente cliente : clientes) {
			prds = cliente.getProdutosConsumidos();
			for(Produto prd : prds)
				for(Contador obj : countProdutos) {
					if(prd.equals((Produto) obj.item)) 
						obj.size++;
					
					else
						countProdutos.add(new Contador(prd, 1));
				}
		}
	}
	
	private List<Contador> countServicos = new ArrayList<Contador>();
	private void setCountServicos() {
		List<Servico> srvs;
		for(Cliente cliente : clientes) {
			srvs = cliente.getServicosConsumidos();
			for(Servico srv : srvs)
				for(Contador obj : countServicos) {
					if(srv.equals((Servico) obj.item)) 
						obj.size++;
					
					else
						countServicos.add(new Contador(srv, 1));
				}
		}
	}
	
	@Override
	public void listar() {
		System.out.println("Lista dos mais consumidos:");
		
		int flag = 1;
		System.out.println("\nProdutos:");
		for(Contador cont : countProdutos) {
			System.out.println(flag + "º:\n");
			
			Produto foo = (Produto) cont.item;
			System.out.println("Id: " + foo.getId());
			System.out.println("Nome: " + foo.nome);
			System.out.println("Valor: R$" + foo.valor);
			
			System.out.println("--------------------------------------");
			if(flag++ > 3) break;
		}
		
		
		flag = 1;
		System.out.println("\nServiços:");
		for(Contador cont : countServicos) {
			System.out.println(flag + "º:\n");
			
			Servico foo = (Servico) cont.item;
			System.out.println("Id: " + foo.getId());
			System.out.println("Nome: " + foo.nome);
			System.out.println("Valor: R$" + foo.valor);
			
			System.out.println("--------------------------------------");
			if(flag++ > 3) break;
		}
	}

	@Override
	public void sort() {
		
		Comparator<Contador> comparar = new Comparator<Contador>() {
			@Override
			public int compare(Contador cont1, Contador cont2) {
				return cont2.size - cont1.size;
			}
		};
		
		Collections.sort(countProdutos, comparar);
		Collections.sort(countServicos, comparar);
	}

}
