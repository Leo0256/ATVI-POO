package negocio.listagem.produtos_servicos;

import java.util.List;

import modelo.Produto;
import negocio.listagem.Listagem;

public class ListarProdutos extends Listagem {
	private List<Produto> produtos;
	
	public ListarProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	@Override
	public void listar() {
		System.out.println("Lista de todos os produtos:");
		
		for(Produto produto : produtos) {
			System.out.println("Id: " + produto.getId());
			System.out.println("Nome: " + produto.nome);
			System.out.println("Valor: R$" + produto.valor);
			
			System.out.println("--------------------------------------");
		}
	}

}
