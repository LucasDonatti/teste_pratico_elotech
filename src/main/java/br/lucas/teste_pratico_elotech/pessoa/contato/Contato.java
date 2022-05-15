package br.lucas.teste_pratico_elotech.pessoa.contato;

import javax.persistence.Column;
import javax.persistence.Entity;

import br.lucas.teste_pratico_elotech.base.BaseEntity;

@Entity
public class Contato extends BaseEntity {
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String telefone;
	
	@Column(nullable = false)
	private String email;
	
	public String getNome() {
		return nome;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public String getEmail() {
		return email;
	}
	
}
