package negocio.listagem.produtos_servicos;

import java.util.List;

import modelo.Servico;
import negocio.listagem.Listagem;

public class ListarServicos extends Listagem {
	private List<Servico> servicos;
	
	public ListarServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}
	
	@Override
	public void listar() {
		System.out.println("Lista de todos os serviços:");
		
		for(Servico servico : servicos) {
			System.out.println("Id: " + servico.getId());
			System.out.println("Nome: " + servico.nome);
			System.out.println("Valor: R$" + servico.valor);
			
			System.out.println("--------------------------------------");
		}
	}

}
