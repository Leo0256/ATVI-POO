package negocio;

import java.util.List;
import java.util.Objects;

import io.Entrada;
import modelo.Cliente;

public class CadastroConsumo extends Cadastro {
	private List<Cliente> clientes;
	private Entrada entrada;
	
	public CadastroConsumo(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	@Override
	public void cadastrar() {
		System.out.println("Adicionar um produto/servi�o a um cliente\n");
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
				System.out.println("Cliente n�o encontrado, gostaria de tentar denovo?");
				System.out.println("1 - Sim");
				System.out.println("0 - N�o");
				int denovo = entrada.receberNumeroInteiro();
				
				if(denovo == 1)
					continue;
				else
					break;
			}
			
			System.out.println("\nO que gostaria de fazer?");
			System.out.println("(Cliente: " + cliente.nome + ")");
			
			System.out.println("1 - Adicionar um produto existente");
			System.out.println("2 - Adicionar um servi�o existente");
			System.out.println("0 - Voltar ao in�cio");
			
			int acao = entrada.receberNumeroInteiro();
			int flag = 0;
			switch(acao) {
			case 0:
				break;
				
			case 1:
				// produto
				break;
				
			case 2:
				// servi�o
				break;
				
			default:
				System.out.println("Opera��o n�o entendida");
			}
			
			if(flag == 0)
				break;
		}
	}

}
