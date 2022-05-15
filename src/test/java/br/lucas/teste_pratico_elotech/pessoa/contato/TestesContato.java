package br.lucas.teste_pratico_elotech.pessoa.contato;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TestesContato {

	@Test
	void teste_sintaxe_email() {
		
		Contato c = new Contato();
		c.setEmail("lucas.eu@email.com");
		
		assertEquals(true, c.isEmail(c.getEmail()));
		
	}

}
