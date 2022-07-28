# projeto_avaliacao_fullstack_3_dias

O projeto está configura com Maven. O objetivo era cumprir o desafio abaixo em 3 dias.

Pelo tempo acabei não utilizando Angular no front, apenas um html/css/js básico para testar o backend. 

Como era pra utilizar Jax-rs jersey optei por deixar simples como grizzly server. Para testar basta executar a classe Servidor. 

Url para abrir o front: http://localhost:8080/index.html

Para banco de dados utilizei JPA com MySql. Nome do schema do db: projeto-contatos. Nome do db: contatos. Com as seguintes colunas: código, cpf, email, endereço, nome e sobre nome. Quando for criar o db coloque a senha no arquivo src/main/java/META-INF/persistence.xml.


```
Visão do projeto
O teste consiste em uma simples aplicação web para gerenciamento de contatos. Permitindo a listagem, pesquisa, inclusão e remoção de contatos em uma base de dados.

Tecnologias CORE
JAVA 12;
JAVAEE 8;
RESTful API JAX-RS RESTEasy ou framework Jersey;
Single Page Application com Angular Framework 9+;
Gerenciador de dependências Maven.

Requisitos:
Criar a estrutura da base de dados;
Permitir o cadastro de contatos;
Realizar testes unitários e/ou de integração.
Realizar as validações que achar necessário.
A versão final do projeto deve ser disponibilizado em um serviço como heroku ou aws - free tier
Tarefas
O teste consiste no desenvolvimento de um CRUD, criando duas aplicações para cadastramento de contatos, divididas em:

Back-end: Aplicação JavaEE utilizando RESTful JAX-RS RESTEasy ou Jersey JAX-RS.
Front-end: Utilizar o Angular Framework 9+, comunicando-se com o serviço do backend.
O cadastro, atualização e exclusão de Contato deverá conter os seguintes atributos:

Código: O identificador do contato, implícito, obrigatório e não nulo.
Nome: O nome do contato, obrigatório, não nulo e com no máximo 100 caracteres;
SobreNome: O sobrenome do contato, obrigatório, não nulo e com no máximo 100 caracteres;
CPF: O CPF do contato, obrigatório, único, não nulo, válido e com no máximo 11 caracteres;
Aplicar formatação na view ao digitar e ao apresentar exemplo: 000.000.000-00

E-mail: O e-mail do contato, obrigatório, único, não nulo, válido e com no máximo 100 caracteres;
Endereço(s): O(s) endereço(s) do contato (Logradouro, Bairro, UF, Cidade, CEP e tipo de endereço {Trabalho ou Residência})
Diferencial: Utilizar alguma API pública que após o usuário digitar o CEP do endereço, seja retornado o restante dos dados sendo automaticamente preenchidos no formulário. Adicionar um loader de carregamento na página indicando que a consulta a API está sendo realizada

Criar as camadas MVC do projeto

Criar a API Rest para gerenciamento do Contato utilizando os verbos HTTP:

GET /api/contatos : Recupera a lista com os 10 primeiro Contatos ordenado pelo atributo Nome;
Adicionar filtros: Nome, Sobre Nome, CPF sendo o Nome um campo obrigatório da consulta

POST /api/contatos : Cria um novo Contato a partir de um JSON enviado no body;
PUT /api/contatos : Atualiza um Contato a partir de um JSON enviado no body com o atributo Código existente;
DELETE /api/contatos/{id} : Remove um contato a partir do código informado;
GET /api/contatos/{id} : Retorna um JSON do contato referente ao código informado.
GET /api/contatos/{id}/enderecos : Retorna um JSON dos endereços do contato referente ao código informado.
Criar testes unitários e/ou de integração.

Criar camada de iteração com o usuário, utilizando o framework Angular.

Diferenciais
Utilizar o Maven para gerenciamento de dependências e builds;
Utilizar o banco de dados configurado no projeto através do Maven;
Utilizar Database Migrations with Flyway para controle da base de dados;
Utilizar Bean Validation no JPA;
Utilizar o Arquillian para orquestração de testes;
Utilizar o servidor de aplicação configurado no projeto através do Maven;
Utilizar o modulo Data do Apache Deltaspike;
Utilizar automatizadores como NPM na aplicação front-end.
Critérios avaliados
Solução
Projeto funcional e atendimento aos itens especificados.
Facilidade para configuração do projeto
Documentação do projeto e arquitetura.
Conhecimento da plataforma e tecnologias
Evidências através do código de conhecimentos de padrões de projeto, da plataforma Java e seus recursos.
Code Style
Código limpo? Código legível? Fácil entendimento para outros desenvolvedores? Desineg Patterns.
Uso adequado da ferramenta de controle de versão
```
