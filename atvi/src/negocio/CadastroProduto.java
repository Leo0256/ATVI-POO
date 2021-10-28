package negocio;

import java.util.List;

import io.Entrada;
import modelo.Produto;

public class CadastroProduto extends Cadastro {
	private List<Produto> produtos;
	private Entrada entrada;
	
	public CadastroProduto(List<Produto> produtos) {
		this.produtos = produtos;
		entrada = new Entrada();
	}
	
	@Override
	public void cadastrar() {
		System.out.println("Início do cadastro de produto");
		System.out.println("Por favor informe o nome do produto:");
		String nome = entrada.receberTexto();
		
		System.out.println("Por favor informe o valor do produto:");
		double valor = entrada.receberNumeroDouble();
		
		System.out.println("Por favor informe o id do produto:");
		String id = entrada.receberTexto();
		
		Produto produto = new Produto(id, nome, valor);
		this.produtos.add(produto);
	}

}
