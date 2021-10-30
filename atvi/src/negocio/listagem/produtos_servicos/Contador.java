package negocio.listagem.produtos_servicos;

import modelo.Produto;
import modelo.Servico;

public class Contador {
	public Object item;
	public int size;
	public Contador(Object item, int size) {
		this.item = item;
		this.size = size;
	}
	
	public boolean equals(Produto produto) {
		return ((Produto) item).getId().equals(produto.getId());
	}
	
	public boolean equals(Servico servico) {
		return ((Servico) item).getId().equals(servico.getId());
	}
}
