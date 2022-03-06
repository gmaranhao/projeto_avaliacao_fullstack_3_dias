package com.desafio.gabrielmaranhao.controllers;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.desafio.gabrielmaranhao.models.dao.ContatoDAO;
import com.desafio.gabrielmaranhao.models.entities.Contato;
import com.google.gson.Gson;



@Path("/api/contatos")
public class contatosResource {


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String requisitaPrimeirosDez() {
		
		ContatoDAO dao = new ContatoDAO();
        List<Contato> contatos = dao.obterRange(0, 10);
		
		return new Gson().toJson(contatos);
    }
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response adicionaContato(String conteudo){ 

		ContatoDAO dao = new ContatoDAO();
		Contato contato = new Gson().fromJson(conteudo, Contato.class);
		dao.incluirAtomico(contato).fechar();
		URI uri = URI.create(contato.getCodigo().toString());
		return Response.created(uri).build();
	}

	@Path("{id}")
	@PUT
	public Response atualizaContato(String conteudo, @PathParam("id") Long id) {
		ContatoDAO dao = new ContatoDAO();
		Contato contatoAtualizado = new Gson().fromJson(conteudo, Contato.class);
		dao.alterarContato(id, contatoAtualizado);
		return Response.ok().build();
	}
	
	@Path("{id}")
	@DELETE
	public Response removeContato(@PathParam("id") Long id) {
		ContatoDAO dao = new ContatoDAO();
		dao.excluirContato(id);
		return Response.ok().build();
	}
	
	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String buscaContato(@PathParam("id") Long id) {
		ContatoDAO dao = new ContatoDAO();
		Contato contato =  dao.obterContatoById(id);
		return contato.toJson();
    }
	
	@Path("{id}/enderecos")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String requisitaEndereco(@PathParam("id") Long id) {
		ContatoDAO dao = new ContatoDAO();
		return new Gson().toJson(dao.obterContatoById(id).getEndereco());
    }
	
	@Path("/todos")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String requisitaTodos() { //Para teste
		
		ContatoDAO dao = new ContatoDAO();
        List<Contato> contatos = dao.obterTodos();
		
		return new Gson().toJson(contatos);
    }
}


//TESTES:
//curl.exe -v http://localhost:8080/api/contatos
//curl.exe -v -H "Content-Type: application/json" -d '{"nome": "Branson","sobreNome": "Key","cpf": "83069074788","email": "Branson@gmail.com","endereco": "endereco_tal"}' http://localhost:8080/api/contatos
//curl.exe -v -X "DELETE" http://localhost:8080/api/contatos/1
//curl.exe -v -X "PUT" -d "..." http://localhost:8080/api/contatos

//http://localhost:8080/api/contatos/1
//curl.exe -v -X "PUT" -d '{"nome": "Leao","sobreNome": "Key","cpf": "83069074788"}' http://localhost:8080/api/contatos