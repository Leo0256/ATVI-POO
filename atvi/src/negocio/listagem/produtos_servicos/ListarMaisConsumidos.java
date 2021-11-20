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
	private List<Produto> produtos = new ArrayList<>();
	private List<Servico> servicos = new ArrayList<>();
	
	
	private List<Contador> contProdutos = new ArrayList<Contador>();
	private List<Contador> contServicos = new ArrayList<Contador>();
	
	public ListarMaisConsumidos(List<Cliente> clientes, List<Produto> produtos, List<Servico> servicos) {
		this.clientes = clientes;
		this.produtos = produtos;
		this.servicos = servicos;
		
		setContProdutos();
		setContServicos();
		sort();
	}
	
	private void setContProdutos() {
		List<Produto> produtosCliente;
		
		for(Produto produto : produtos) 
			contProdutos.add(new Contador(produto, 0));
		
		for(Cliente cliente : clientes) {
			produtosCliente = cliente.getProdutosConsumidos();
			
			for(Produto produto : produtosCliente) {
				for(int cont = 0; cont < contProdutos.size(); cont++) {
					if(contProdutos.get(cont).equals(produto)) 
						contProdutos.get(cont).size++;
				}
			}
		}
	}
	
	private void setContServicos() {
		List<Servico> servicosCliente;
		
		for(Servico servico : servicos)
			contServicos.add(new Contador(servico, 0));
		
		for(Cliente cliente : clientes) {
			servicosCliente = cliente.getServicosConsumidos();
			
			for(Servico servico : servicosCliente) {
				for(int cont = 0; cont < contServicos.size(); cont++) {
					if(contServicos.get(cont).equals(servico)) 
						contServicos.get(cont).size++;
				}
			}
		}
	}
	
	
	@Override
	public void listar() {
		System.out.println("Lista dos mais consumidos:");
		
		int flag = 1;
		System.out.println("\nProdutos:");
		for(Contador cont : contProdutos) {
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
		for(Contador cont : contServicos) {
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
		
		Collections.sort(contProdutos, comparar);
		Collections.sort(contServicos, comparar);
	}

}
