package br.lucas.teste_pratico_elotech.pessoa.contato;

import javax.mail.internet.InternetAddress;
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
	
	public Contato() {}
	
	public Contato(String nome, String telefone, String email) {
		setNome(nome);
		setTelefone(telefone);
		setEmail(email);
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public void setEmail(String email) {
		if (!isEmail(email))
			throw new RuntimeException("Endereço de E-mail inválido.");
		this.email = email;
	}

	public Boolean isEmail(String email) {
		try {
			InternetAddress enderecoEmail = new InternetAddress(email);
			enderecoEmail.validate();
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
}
