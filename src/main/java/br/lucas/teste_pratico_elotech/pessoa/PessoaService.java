package br.lucas.teste_pratico_elotech.pessoa;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.lucas.teste_pratico_elotech.base.BaseCrudService;

@Service
@Transactional
public class PessoaService extends BaseCrudService<Pessoa, PessoaRepository> {
	
	@Override
	public String criar(Pessoa nova) {
		if (nova.getContatos() == null)
			throw new RuntimeException("É necessário informar ao menos um contato.");
		return super.criar(nova);
	}
	
	@Override
	public void atualizar(Pessoa modificada) {
		if (modificada.getContatos() == null)
			throw new RuntimeException("É necessário informar ao menos um contato.");
		super.atualizar(modificada);
	}
	
}
