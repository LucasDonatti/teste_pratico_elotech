package br.lucas.teste_pratico_elotech.pessoa;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import br.lucas.teste_pratico_elotech.base.BaseEntity;
import br.lucas.teste_pratico_elotech.pessoa.contato.Contato;

@Entity
public class Pessoa extends BaseEntity {
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String cpf;
	
	@Column(nullable = false)
	private Date dataNascimento;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "pessoa_id")
	private List<Contato> contatos;
	
	public Pessoa() {}
	
	public Pessoa(String nome, String cpf, Date dataNascimento, List<Contato> contatos) {
		setNome(nome);
		setCpf(cpf);
		setDataNascimento(dataNascimento);
		setContatos(contatos);
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public List<Contato> getContatos() {
		return contatos;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCpf(String cpf) {
		if (validarCpf(cpf) == false)
			throw new RuntimeException("CPF inválido. Informe um CPF existente.");
		this.cpf = cpf;
	}
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}
	
	Boolean verificarSequenciaCpf (String cpf) {
		if (cpf.equals("00000000000") || cpf.equals("11111111111") ||
			cpf.equals("22222222222") || cpf.equals("33333333333") ||
			cpf.equals("44444444444") || cpf.equals("55555555555") ||
			cpf.equals("66666666666") || cpf.equals("77777777777") ||
			cpf.equals("88888888888") || cpf.equals("99999999999"))
			return false;
		return true;
	}
	
	Integer calcularDigito(String cpf, Integer[] peso) {
		Integer soma = 0;
		for (int i = cpf.length()-1; i >= 0; i--) 
			soma += Integer.parseInt(cpf.substring(i, i+1)) * peso[i];
		Integer resto = soma % 11;
		return resto < 2 ? 0 : 11-resto;
	}

	public Boolean validarCpf(String cpf) {
		if (cpf.length() != 11) 
			return false;
		if (verificarSequenciaCpf(cpf) == false)
			return false;
		Integer[] pesoDigito1 = {10, 9, 8, 7, 6, 5, 4, 3, 2};
		Integer[] pesoDigito2 = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
		Integer digito1 = calcularDigito(cpf.substring(0,9), pesoDigito1);
		Integer digito2 = calcularDigito(cpf.substring(0,9) + digito1, pesoDigito2);
		return cpf.equals(cpf.substring(0,9) + digito1.toString() + digito2.toString());
	}
	
}
