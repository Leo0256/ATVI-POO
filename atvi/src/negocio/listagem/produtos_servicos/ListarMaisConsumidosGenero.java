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

public class ListarMaisConsumidosGenero  extends Listagem implements Sortable {
	private List<Cliente> clientes;
	private List<Produto> produtos = new ArrayList<>();
	private List<Servico> servicos = new ArrayList<>();
	
	private List<Contador> contProdutosM = new ArrayList<Contador>();
	private List<Contador> contServicosM = new ArrayList<Contador>();
	
	private List<Contador> contProdutosF = new ArrayList<Contador>();
	private List<Contador> contServicosF = new ArrayList<Contador>();
	
	public ListarMaisConsumidosGenero(List<Cliente> clientes, List<Produto> produtos, List<Servico> servicos) {
		this.clientes = clientes;
		this.produtos = produtos;
		this.servicos = servicos;
		
		setContProdutos();
		setContServicos();
		sort();
	}
	
	private void setContProdutos() {
		List<Produto> produtosCliente;
		
		for(Produto produto : produtos) {
			contProdutosM.add(new Contador(produto, 0));
			contProdutosF.add(new Contador(produto, 0));
		}
		
		for(Cliente cliente : clientes) {
			produtosCliente = cliente.getProdutosConsumidos();
			
			// M
			if(cliente.genero.compareTo("M") == 0) {
				for(Produto produto : produtosCliente) {
					for(int cont = 0; cont < contProdutosM.size(); cont++) {
						if(contProdutosM.get(cont).equals(produto)) 
							contProdutosM.get(cont).size++;
					}
				}
			}
			// F
			else {
				
				for(Produto produto : produtosCliente) {
					for(int cont = 0; cont < contProdutosF.size(); cont++) {
						if(contProdutosF.get(cont).equals(produto)) 
							contProdutosF.get(cont).size++;
					}
				}
			}
		}
	}
	
	private void setContServicos() {
		List<Servico> servicosCliente;
		
		for(Servico servico : servicos) {
			contServicosM.add(new Contador(servico, 0));
			contServicosF.add(new Contador(servico, 0));
		}
		
		for(Cliente cliente : clientes) {
			servicosCliente = cliente.getServicosConsumidos();
			
			// M
			if(cliente.genero.compareTo("M") == 0) {
				for(Servico servico : servicosCliente) {
					for(int cont = 0; cont < contServicosM.size(); cont++) {
						if(contServicosM.get(cont).equals(servico)) 
							contServicosM.get(cont).size++;
					}
				}
			}
			// F
			else {
				for(Servico servico : servicos) {
					for(int cont = 0; cont < contServicosF.size(); cont++) {
						if(contServicosF.get(cont).equals(servico)) 
							contServicosF.get(cont).size++;
					}
				}
			}
		}
	}
	
	
	@Override
	public void listar() {
		System.out.println("Lista dos mais consumidos:");
		
		System.out.println("\nProdutos:");
		
		System.out.println("Masculino:");
		showProduto(contProdutosM);
		
		System.out.println("\nFeminino:");
		showProduto(contProdutosF);
		
		System.out.println("--#--#-----------#--#-----------#--#--");
		
		System.out.println("\nServiços:");
		
		System.out.println("Masculino:");
		showServico(contServicosM);
		
		System.out.println("Feminino:");
		showServico(contServicosF);
	}
	
	private void showProduto(List<Contador> listCont) {
		int flag = 1;
		for(Contador cont : listCont) {
			System.out.println(flag + "º:\n");
			
			Produto foo = (Produto) cont.item;
			System.out.println("Id: " + foo.getId());
			System.out.println("Nome: " + foo.nome);
			System.out.println("Valor: R$" + foo.valor);
			
			System.out.println("--------------------------------------");
			if(flag++ > 3) break;
		}
	}
	
	private void showServico(List<Contador> listCont) {
		int flag = 1;
		for(Contador cont : listCont) {
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
		
		Collections.sort(contProdutosM, comparar);
		Collections.sort(contServicosM, comparar);
		
		Collections.sort(contProdutosF, comparar);
		Collections.sort(contServicosF, comparar);
	}

}
