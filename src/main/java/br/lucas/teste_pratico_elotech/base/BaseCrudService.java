package br.lucas.teste_pratico_elotech.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class BaseCrudService <ENTITY extends BaseEntity, REPOSITORY extends JpaRepository<ENTITY, String>> {

	@Autowired
	private REPOSITORY repo;
	
	public List<ENTITY> obterTodas() {
		return repo.findAll();
	}
	
	public ENTITY obterPeloId(String id) {
		return repo.findById(id).get();
	}
	
	public String criar(ENTITY nova) {
		if (repo.existsById(nova.getId()))
			throw new RuntimeException("Registro já existente.");
		return repo.save(nova).getId();
	}
	
	public void atualizar(ENTITY modificada) {
		repo.save(modificada);
	}
	
	public void excluirPeloId(String id) {
		repo.deleteById(id);
	}
	
}
