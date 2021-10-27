package negocio.listagem;

import java.util.List;

import modelo.Cliente;
import modelo.Sortable;

public class ListarTopMaisConsomem extends Listagem implements Sortable<Cliente> {
	private List<Cliente> clientes;
	
	public ListarTopMaisConsomem(List<Cliente> clientes) {
		this.clientes = clientes;
		sort();
	}
	
	@Override
	public void listar() {
		
	}

	@Override
	public void sort() {
		// organiza os clientes pelos 10 que mais consomem
	}

}
