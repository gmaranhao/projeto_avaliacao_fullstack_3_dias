# projeto_avaliacao_fullstack_3_dias

O projeto está configura com Maven. O objetivo era esse comprir esse desafio em 3 dias: http://pdi.mobitbrasil.com.br:8601/projects/ANP/repos/programador-java/browse

Pelo tempo acabei não utilizando Angular no front, apenas um html/css/js básico para testar o backend. 

Como era pra utilizar Jax-rs jersey optei por deixar simples como grizzly server. Para testar basta executar a classe Servidor. 

Url para abrir o front: http://localhost:8080/index.html

Para banco de dados utilizei JPA com MySql. Nome do schema do db: projeto-contatos. Nome do db: contatos. Com as seguintes colunas: código, cpf, email, endereço, nome e sobre nome. Quando for criar o db coloque a senha no arquivo src/main/java/META-INF/persistence.xml.
