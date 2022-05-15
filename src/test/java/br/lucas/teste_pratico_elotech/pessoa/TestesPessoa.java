package br.lucas.teste_pratico_elotech.pessoa;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class TestesPessoa {
	
	@Test
	void teste_digitos_cpf() {
		
		Pessoa p = new Pessoa();
		p.setCpf("05566755925");
		
		Integer[] pesoPrimeiroDigito = {10, 9, 8, 7, 6, 5, 4, 3, 2};
		Integer[] pesoSegundoDigito = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
		
		assertEquals(
			Integer.parseInt(p.getCpf().substring(9, 10)),
			p.calcularDigito(p.getCpf().substring(0, 9), pesoPrimeiroDigito)
		);
		
		assertEquals(
			Integer.parseInt(p.getCpf().substring(10, 11)),
			p.calcularDigito(p.getCpf().substring(0, 10), pesoSegundoDigito)
		);
		
	}
	
	@Test
	void teste_cpf_valido() {
		
		Pessoa p = new Pessoa();
		p.setCpf("05566755925");
		
		assertEquals(true, p.isCpf(p.getCpf()));
		
	}
	
	@Test
	void teste_data_nascimento() {
		
		Pessoa p = new Pessoa();
		p.setDataNascimento(LocalDate.parse("2002-08-31"));
		
		assertEquals(false, p.isDataNascimentoMaiorQueHoje(p.getDataNascimento()));
		
	}

}
