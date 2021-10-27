package negocio.listagem;

import java.util.List;

import modelo.Cliente;

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
		System.out.println("Nome: " + cliente.nome);
		System.out.println("Nome social: " + cliente.nomeSocial);
		System.out.println("CPF: " + cliente.getCpf().getValor());
		System.out.println("--------------------------------------");
	}

}
