package negocio.listagem.clientes;

import java.time.format.DateTimeFormatter;
import java.util.List;

import modelo.Cliente;
import modelo.RG;
import modelo.Telefone;
import negocio.listagem.Listagem;

public class ListarTodosClientes extends Listagem {
	private List<Cliente> clientes;

	public ListarTodosClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	@Override
	public void listar() {
		System.out.println("Lista de todos os clientes:\n");
		for (Cliente cliente : clientes) {
			System.out.println("Nome: " + cliente.nome);
			System.out.println("Nome social: " + cliente.nomeSocial);
			System.out.println("CPF: " + cliente.getCpf().getValor());
			
			
			if(!cliente.getRgs().isEmpty()) {
				System.out.println("RGs:");
				for(RG rg : cliente.getRgs()) {
					System.out.println(" - " + rg.getValor() + " (" + 
							rg.getDataEmissao().format(
									DateTimeFormatter.ofPattern("dd/MM/yyyy")) 
							+ ")");
				}
			}
			
			if(!cliente.getTelefones().isEmpty()) {
				System.out.println("Telefones:");
				for(Telefone tel : cliente.getTelefones()) {
					System.out.println(" - (" + tel.getDdd() + ") " + 
							tel.getNumero());
				}
			}
			
			System.out.println("--------------------------------------");
		}
	}
}
