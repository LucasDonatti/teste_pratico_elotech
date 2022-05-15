package br.lucas.teste_pratico_elotech.pessoa;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.lucas.teste_pratico_elotech.base.BaseCrudController;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController extends BaseCrudController<Pessoa, PessoaRepository, PessoaService> {}
