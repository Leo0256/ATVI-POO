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
	private List<Contador> contProdutosM = new ArrayList<Contador>();
	private List<Contador> contServicosM = new ArrayList<Contador>();
	
	private List<Contador> contProdutosF = new ArrayList<Contador>();
	private List<Contador> contServicosF = new ArrayList<Contador>();
	
	public ListarMaisConsumidosGenero(List<Cliente> clientes) {
		this.clientes = clientes;
		setContProdutos();
		setContServicos();
		sort();
	}
	
	private void setContProdutos() {
		List<Produto> produtos;
		for(Cliente cliente : clientes) {
			produtos = cliente.getProdutosConsumidos();
			
			if(cliente.genero.compareTo("M") == 0) {
				if(contProdutosM.isEmpty())
					contProdutosM.add(new Contador(produtos.get(0), 0));
				
				for(Produto produto : produtos) {
					for(int cont = 0; cont < contProdutosM.size(); cont++) {
						if(contProdutosM.get(cont).equals(produto)) 
							contProdutosM.get(cont).size++;
						else
							contProdutosM.add(new Contador(produto, 1));
					}
				}
			}
			else {
				if(contProdutosF.isEmpty())
					contProdutosF.add(new Contador(produtos.get(0), 0));
				
				for(Produto produto : produtos) {
					for(int cont = 0; cont < contProdutosF.size(); cont++) {
						if(contProdutosF.get(cont).equals(produto)) 
							contProdutosF.get(cont).size++;
						else
							contProdutosF.add(new Contador(produto, 1));
					}
				}
			}
		}
	}
	
	private void setContServicos() {
		List<Servico> servicos;
		for(Cliente cliente : clientes) {
			servicos = cliente.getServicosConsumidos();
			
			if(cliente.genero.compareTo("M") == 0) {
				if(contServicosM.isEmpty())
					contServicosM.add(new Contador(servicos.get(0), 0));
				
				for(Servico servico : servicos) {
					for(int cont = 0; cont < contServicosM.size(); cont++) {
						if(contServicosM.get(cont).equals(servico)) 
							contServicosM.get(cont).size++;
						else
							contServicosM.add(new Contador(servico, 1));
					}
				}
			}
			else {
				if(contServicosF.isEmpty())
					contServicosF.add(new Contador(servicos.get(0), 0));
				
				for(Servico servico : servicos) {
					for(int cont = 0; cont < contServicosF.size(); cont++) {
						if(contServicosF.get(cont).equals(servico)) 
							contServicosF.get(cont).size++;
						else
							contServicosF.add(new Contador(servico, 1));
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
