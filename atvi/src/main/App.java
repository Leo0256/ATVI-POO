package main;

import io.Entrada;
import modelo.Empresa;
import negocio.Cadastro;
import negocio.CadastroCliente;
import negocio.CadastroConsumo;
import negocio.CadastroProduto;
import negocio.CadastroServico;
import negocio.listagem.Listagem;
import negocio.listagem.clientes.ListarTodosClientes;
import negocio.listagem.clientes.ListarTodosGenero;
import negocio.listagem.clientes.ListarTop10Consomem;
import negocio.listagem.clientes.ListarTop5MaisGastam;
import negocio.listagem.produtos_servicos.ListarMaisConsumidos;
import negocio.listagem.produtos_servicos.ListarMaisConsumidosGenero;
import negocio.listagem.produtos_servicos.ListarProdutos;
import negocio.listagem.produtos_servicos.ListarServicos;

public class App {
	public static void main(String[] args) {
		System.out.println("Bem-vindo ao cadastro de clientes do Grupo World Beauty");
		Empresa empresa = new Empresa();
		
		// Dados prévios de Teste
		new DadosTeste(empresa);
		// 
		
		
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
				System.out.println("--------------------------------------");
				System.out.println("Cadastro de Cliente");
				System.out.println("O que gostaria de fazer?");
				System.out.println("1 - Cadastrar um novo cliente");
				System.out.println("2 - Adicionar um produto/serviço a um cliente");
				System.out.println("0 - Voltar");
				
				int cadastroCliente = entrada.receberNumeroInteiro();
				Cadastro cadastro;
				switch(cadastroCliente) {
				case 0:
					break;
					
				case 1:
					// Novo cliente
					cadastro = new CadastroCliente(empresa.getClientes());
					cadastro.cadastrar();
					break;
					
				case 2:
					// Adicionar um produto/serviço a um cliente
					cadastro = new CadastroConsumo(empresa.getClientes(), empresa.getProdutos(), empresa.getServicos());
					cadastro.cadastrar();
					break;
					
				default:
					System.out.println("Operação não entendida");
				}
				
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
				Listagem listagemCli;
				switch(listarCliente) {
				case 0:
					break;
				
				case 1:
					// Listar todos
					listagemCli = new ListarTodosClientes(empresa.getClientes());
					listagemCli.listar();
					break;
					
				case 2:
					// Listar todos por gênero
					listagemCli = new ListarTodosGenero(empresa.getClientes());
					listagemCli.listar();
					break;
					
				case 3:
					// Listar os 10 que mais consomem
					listagemCli = new ListarTop10Consomem(empresa.getClientes(), true);
					listagemCli.listar();
					break;
					
				case 4:
					// Listar os 10 que menos consomem
					listagemCli = new ListarTop10Consomem(empresa.getClientes(), false);
					listagemCli.listar();
					break;
					
				case 5: 
					// Listar os 5 que mais gastam
					listagemCli = new ListarTop5MaisGastam(empresa.getClientes());
					listagemCli.listar();
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
				Listagem listagemPS;
				switch(listarProdutoServico) {
				case 0:
					break;
					
				case 1:
					// Listar produtos
					listagemPS = new ListarProdutos(empresa.getProdutos());
					listagemPS.listar();
					break;
					
				case 2:
					// Listar serviços
					listagemPS = new ListarServicos(empresa.getServicos());
					listagemPS.listar();
					break;
					
				case 3:
					// Listar produtos e serviços mais consumidos
					listagemPS = new ListarMaisConsumidos(empresa.getClientes(), empresa.getProdutos(), empresa.getServicos());
					listagemPS.listar();
					break;
					
				case 4:
					// Listar produtos e serviços mais consumidos por gênero
					listagemPS = new ListarMaisConsumidosGenero(empresa.getClientes(), empresa.getProdutos(), empresa.getServicos());
					listagemPS.listar();
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