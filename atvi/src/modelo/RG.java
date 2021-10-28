package modelo;

import java.time.LocalDate;

public class RG {
	private LocalDate dataEmissao;
	private String valor;

	public RG(LocalDate dataEmissao, String valor) {
		this.dataEmissao = dataEmissao;
		this.valor = valor;
	}

	public LocalDate getDataEmissao() {
		return dataEmissao;
	}

	public String getValor() {
		return valor;
	}
}