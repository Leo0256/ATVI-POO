package negocio;

import java.util.List;

import io.Entrada;
import modelo.Servico;

public class CadastroServico extends Cadastro {
	private List<Servico> servicos;
	private Entrada entrada;
	
	public CadastroServico(List<Servico> servicos) {
		this.servicos = servicos;
		entrada = new Entrada();
	}
	
	@Override
	public void cadastrar() {
		System.out.println("Início do cadastro de serviço");
		System.out.println("Por favor informe o nome do serviço:");
		String nome = entrada.receberTexto();
		
		System.out.println("Por favor informe o valor do serviço:");
		double valor = entrada.receberNumeroDouble();
		
		System.out.println("Por favor informe o id do serviço:");
		String id = new Entrada().receberTexto();
		
		Servico servico = new Servico(id, nome, valor);
		this.servicos.add(servico);
	}
}
