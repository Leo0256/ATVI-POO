package negocio;

import java.util.List;
import java.util.Objects;

import io.Entrada;
import modelo.Cliente;
import modelo.Produto;
import modelo.Servico;

public class CadastroConsumo extends Cadastro {
	private List<Cliente> clientes;
	private List<Produto> produtos;
	private List<Servico> servicos;
	private Entrada entrada;
	
	public CadastroConsumo(List<Cliente> clientes, List<Produto> produtos, List<Servico> servicos) {
		this.clientes = clientes;
		this.produtos = produtos;
		this.servicos = servicos;
	}
	
	@Override
	public void cadastrar() {
		System.out.println("Adicionar um produto/serviço a um cliente\n");
		while(true) {
			entrada = new Entrada();
			
			System.out.println("Informe o nome ou CPF do cliente:");
			String nomeOuCpf = entrada.receberTexto();
			
			Cliente cliente = null;
			for(Cliente cli : clientes) {
				if(cli.nome.compareTo(nomeOuCpf) == 0 
						|| cli.nomeSocial.compareTo(nomeOuCpf) == 0 
						|| cli.getCpf().getValor().compareTo(nomeOuCpf) == 0) {
					
					cliente = cli;
				}
			}
			
			if(Objects.isNull(cliente)) {
				System.out.println("Cliente não encontrado, gostaria de tentar denovo?");
				System.out.println("1 - Sim");
				System.out.println("0 - Não");
				int denovo = entrada.receberNumeroInteiro();
				
				if(denovo == 1)
					continue;
				
				break;
			}
			
			if(AddConsumo(cliente, 0) == 0)
				break;
		}
	}
	
	private int AddConsumo(Cliente cliente, int type) {
		String id;
		Entrada entrada = new Entrada();
		// Cadastrar produto
		if(type == 1) {
			System.out.println("Informe o id de um produto:");
			id = entrada.receberTexto();
			
			for(Produto produto : produtos) {
				if(produto.equals(id))
					cliente.addProdutoConsumido(produto);
			}
			
			System.out.println("Produto adicionado, gostaria de adicionar outro produto?:");
			System.out.println("1 - Sim");
			System.out.println("0 - Não");
			
			int denovo = entrada.receberNumeroInteiro();
			if(denovo == 1)
				return AddConsumo(cliente, 1);
			
			return AddConsumo(cliente, 0);

		}
		// Cadastrar serviço
		else if(type == 2){
			System.out.println("Informe o id de um serviço:");
			id = entrada.receberTexto();
			
			for(Servico servico : servicos) {
				if(servico.equals(id))
					cliente.addServicoConsumido(servico);
			}
			
			System.out.println("Serviço adicionado, gostaria de adicionar outro serviço?:");
			System.out.println("1 - Sim");
			System.out.println("0 - Não");
			
			int denovo = entrada.receberNumeroInteiro();
			if(denovo == 1)
				return AddConsumo(cliente, 2);
			
			return AddConsumo(cliente, 0);
		}
		
		System.out.println("\nAdicionar um produto/serviço a um cliente");
		System.out.println("O que gostaria de fazer?");
		System.out.println("(Cliente: " + cliente.nome + ")");
		
		System.out.println("1 - Adicionar um produto existente");
		System.out.println("2 - Adicionar um serviço existente");
		System.out.println("0 - Voltar ao início");
		
		int acao = entrada.receberNumeroInteiro();
		int flag = 0;
		switch(acao) {
		case 0:
			break;
			
		case 1:
			// produto
			flag = AddConsumo(cliente, 1);
			break;
			
		case 2:
			// serviço
			flag = AddConsumo(cliente, 2);
			break;
			
		default:
			System.out.println("Operação não entendida");
		}
		
		return flag;
	}
}
