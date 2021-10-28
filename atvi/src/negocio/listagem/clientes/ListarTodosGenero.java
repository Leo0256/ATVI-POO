package negocio.listagem.clientes;

import java.time.format.DateTimeFormatter;
import java.util.List;

import modelo.Cliente;
import modelo.RG;
import modelo.Telefone;
import negocio.listagem.Listagem;

public class ListarTodosGenero extends Listagem {
	private List<Cliente> clientes;
	
	public ListarTodosGenero(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	@Override
	public void listar() {
		System.out.println("Lista de todos os clientes:");
		
		System.out.println("\nMasculino:");
		for(Cliente cliente : clientes) 
			if(cliente.genero.equals("M")) 
				DadosCliente(cliente);
		
		System.out.println("//////////////////////////////////////");
		
		System.out.println("\nFeminino:");
		for(Cliente cliente : clientes) 
			if(cliente.genero.equals("F")) 
				DadosCliente(cliente);
	}
	
	private void DadosCliente(Cliente cliente) {
		System.out.println("--------------------------------------");
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
