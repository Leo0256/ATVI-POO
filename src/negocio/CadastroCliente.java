package negocio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import io.Entrada;
import modelo.CPF;
import modelo.Cliente;

public class CadastroCliente extends Cadastro {
	private List<Cliente> clientes;
	private Entrada entrada;

	public CadastroCliente(List<Cliente> clientes) {
		this.clientes = clientes;
		this.entrada = new Entrada();
	}

	@Override
	public void cadastrar() {
		System.out.println("Início do cadastro do cliente");
		System.out.println("Por favor informe o nome do cliente:");
		String nome = entrada.receberTexto();
		
		System.out.println("Por favor informe o nome social do cliente:");
		String nomeSocial = entrada.receberTexto();
		
		System.out.println("Por favor informe o gênero do cliente (M ou F):");
		String genero = entrada.receberTexto();
		
		System.out.println("Por favor informe o número do cpf:");
		String valor = entrada.receberTexto();
		
		System.out.println("Por favor informe a data de emissão do cpf, no padrão dd/mm/yyyy:");
		String data = entrada.receberTexto();
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataEmissao = LocalDate.parse(data, formato);
		
		CPF cpf = new CPF(dataEmissao, valor);
		Cliente cliente = new Cliente(nome, nomeSocial, genero, cpf);
		this.clientes.add(cliente);
	}
}