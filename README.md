Teste Prático Elotech

OBJETIVO
* [OK] Criar uma API Rest de um cadastro de Pessoas, utilizando Spring Boot e Java

REQUISITOS
* [OK] Possuir ao menos os endpoints: GET(Buscar uma única Pessoa), GET (Busca paginada opção de filtro para retornar várias pessoas), POST, PUT, DELETE.
* [OK] O cadastro de pessoa deve ter os campos: Id, Nome, CPF, Data de nascimento.
* [OK] A pessoa deve possuir uma lista de contatos (relacionamento um para muitos) com os campos: Id, Nome, Telefone e Email.
* [OK] Os dados devem ser persistidos utilizando um banco de dados relacional.

VALIDAÇÕES
* [OK] Todos os campos são obrigatórios, tanto da pessoa como do contato.
* [OK] A Pessoa deve possuir ao menos um contato.
* [OK] O CPF deve ser um CPF válido.
* [OK] A Data de nascimento não pode ser uma data futura.
* [OK] Validar sintaxe do email do contato.

REQUISITOS TÉCNICOS
* [OK] Deverão ser criados testes unitários.
* [OK] Publicar o código em repositório público.
