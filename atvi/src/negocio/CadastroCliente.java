package negocio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import io.Entrada;
import modelo.CPF;
import modelo.Cliente;
import modelo.RG;
import modelo.Telefone;

public class CadastroCliente extends Cadastro {
	private List<Cliente> clientes;
	private Entrada entrada;

	public CadastroCliente(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	@Override
	public void cadastrar() {
		while(true) {
			entrada = new Entrada();
			System.out.println("Início do cadastro do cliente\n");
			
			// Nome
			System.out.println("Por favor informe o nome do cliente:");
			String nome = entrada.receberTexto();
			
			// Nome Social
			System.out.println("Por favor informe o nome social do cliente:");
			String nomeSocial = entrada.receberTexto();
			
			// Gênero
			System.out.println("Por favor informe o gênero do cliente (M ou F):");
			String genero = entrada.receberTexto();
			
			// CPF
			System.out.println("Por favor informe o número do cpf:");
			String valor = entrada.receberTexto();
			
			System.out.println("Por favor informe a data de emissão do cpf, no padrão dd/mm/yyyy:");
			String data = entrada.receberTexto();
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate dataEmissao = LocalDate.parse(data, formato);
			
			CPF cpf = new CPF(dataEmissao, valor);
			
			// RG
			List<RG> rgs = getRg();
			
			// Telefone
			List<Telefone> tels = getTel();
			
			
			Cliente cliente = new Cliente(nome, nomeSocial, genero, cpf, rgs, tels);
			this.clientes.add(cliente);
			
			
			// Ação de cadastrar produto/serviço ao cliente
			
			
			System.out.println("\nQuer cadastrar mais um cliente?");
			System.out.println("1 - Sim");
			System.out.println("0 - Não");
			
			int maisUm = entrada.receberNumeroInteiro();
			if(maisUm == 1)
				System.out.println("--------------------------------------");
			
			else break;
		}
	}
	
	private List<RG> getRg(){
		int cadastrarRg;
		System.out.println("Quer cadastrar um RG?");
		System.out.println("1 - Sim");
		System.out.println("0 - Não");
		
		cadastrarRg = entrada.receberNumeroInteiro();
		List<RG> rgs = new ArrayList<RG>();
		if(cadastrarRg == 1) {
			Entrada addRg = new Entrada();
			while(cadastrarRg == 1) {
				
				System.out.println("Por favor informe o número do rg:");
				String valor = addRg.receberTexto();
				
				System.out.println("Por favor informe a data de emissão do rg, no padrão dd/mm/yyyy:");
				String data = addRg.receberTexto();
				DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate dataEmissao = LocalDate.parse(data, formato);
				
				
				RG rg = new RG(dataEmissao, valor);
				rgs.add(rg);
				
				System.out.println("Quer cadastrar mais um RG?");
				System.out.println("1 - Sim");
				System.out.println("0 - Não");
				
				cadastrarRg = entrada.receberNumeroInteiro();
				if(cadastrarRg == 1)
					System.out.println("\n");
			}
		}
		
		return rgs;
	}
	
	private List<Telefone> getTel(){
		int cadastrarTel;
		System.out.println("Quer cadastrar um telefone?");
		System.out.println("1 - Sim");
		System.out.println("0 - Não");
		
		cadastrarTel = entrada.receberNumeroInteiro();
		List<Telefone> tels = new ArrayList<Telefone>();
		if(cadastrarTel == 1) {
			Entrada addTel = new Entrada();
			while(cadastrarTel == 1) {
				System.out.println("Por favor informe o número do ddd:");
				String ddd = addTel.receberTexto();
				
				System.out.println("Por favor informe o número de telefone:");
				String valorTel = addTel.receberTexto();
				
				Telefone tel = new Telefone(ddd, valorTel);
				tels.add(tel);
				
				System.out.println("Quer cadastrar mais um telefone?");
				System.out.println("1 - Sim");
				System.out.println("0 - Não");
				
				cadastrarTel = entrada.receberNumeroInteiro();
				if(cadastrarTel == 1)
					System.out.println("\n");
			}
		}
		
		return tels;
	}
}