package main;

import io.Entrada;
import modelo.Empresa;
import negocio.Cadastro;
import negocio.CadastroCliente;
import negocio.CadastroProduto;
import negocio.CadastroServico;
import negocio.listagem.Listagem;
import negocio.listagem.ListarTodosClientes;
import negocio.listagem.ListarTodosGenero;

public class App {
	public static void main(String[] args) {
		System.out.println("Bem-vindo ao cadastro de clientes do Grupo World Beauty");
		Empresa empresa = new Empresa();
		boolean execucao = true;
		while (execucao) {
			System.out.println("======================================");
			System.out.println("Que tipo de operação você deseja fazer:");
			System.out.println("1 - Cadastrar cliente");
			System.out.println("2 - Cadastrar produto");
			System.out.println("3 - Cadastrar serviço");
			System.out.println("4 - Listar clientes");
			System.out.println("5 - Listar produtos e serviços");
			System.out.println("0 - Sair");

			Entrada entrada = new Entrada();
			int operacao = entrada.receberNumeroInteiro();

			switch (operacao) {
			case 0:
				execucao = false;
				System.out.println("Até mais!\n");
				break;
				
			case 1:
				// Cadastrar cliente
				Cadastro cadastro = new CadastroCliente(empresa.getClientes());
				cadastro.cadastrar();
				break;
				
			case 2:
				// Cadastrar produto
				Cadastro produto = new CadastroProduto(empresa.getProdutos());
				produto.cadastrar();
				break;
				
			case 3:
				// Cadastrar serviço
				Cadastro servico = new CadastroServico(empresa.getServicos());
				servico.cadastrar();
				break;
				
			case 4:
				System.out.println("--------------------------------------");
				System.out.println("Listar clientes:");
				System.out.println("1 - Listar todos os clientes");
				System.out.println("2 - Listar todos os clientes por gênero");
				System.out.println("3 - Listar os 10 clientes que mais consomem");
				System.out.println("4 - Listar os 10 clientes que menos consomem");
				System.out.println("5 - Listar os 5 clientes que mais gastam");
				System.out.println("0 - Voltar");
				
				int listarCliente = entrada.receberNumeroInteiro();
				Listagem listagem;
				switch(listarCliente) {
				case 0:
					break;
				
				case 1:
					// Listar todos
					listagem = new ListarTodosClientes(empresa.getClientes());
					listagem.listar();
					break;
					
				case 2:
					// Listar todos por gênero
					listagem = new ListarTodosGenero(empresa.getClientes());
					listagem.listar();
					break;
					
				case 3:
					// Listar os 10 que mais consomem
					break;
					
				case 4:
					// Listar os 10 que menos consomem
					break;
					
				case 5: 
					// Listar os 5 que mais gastam
					break;
					
				default:
					System.out.println("Operação não entendida");
				}
				
				break;
				
			case 5:
				System.out.println("--------------------------------------");
				System.out.println("Listar produtos e serviços:");
				System.out.println("1 - Listar todos os produtos");
				System.out.println("2 - Listar todos os serviços");
				System.out.println("3 - Listar os produtos e serviços mais consumidos");
				System.out.println("4 - Listar os produtos e serviços mais consumidos por gênero");
				System.out.println("0 - Voltar");
				
				int listarProdutoServico = entrada.receberNumeroInteiro();
				
				switch(listarProdutoServico) {
				case 0:
					break;
					
				case 1:
					// Listar produtos
					break;
					
				case 2:
					// Listar serviços
					break;
					
				case 3:
					// Listar produtos e serviços mais consumidos
					break;
					
				case 4:
					// Listar produtos e serviços mais consumidos por gênero
					break;
					
				default:
					System.out.println("Operação não entendida");
				}
				
				break;
				
			default:
				System.out.println("Operação não entendida");
			}
		}
	}
}