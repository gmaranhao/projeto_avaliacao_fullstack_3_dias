package com.desafio.gabrielmaranhao;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.http.server.StaticHttpHandler;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class Servidor {

	public static void main(String[] args) throws IOException {
		HttpServer server = inicializaServidor();
		System.out.println("Aplicao executando na porta 8080");
		System.in.read();
		server.stop();
	}

	public static HttpServer inicializaServidor() {
		ResourceConfig config = new ResourceConfig().packages("com.desafio.gabrielmaranhao");
		URI uri = URI.create("http://localhost:8080/");
		HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri, config);
		server.getServerConfiguration().addHttpHandler(new StaticHttpHandler("src/main/webapp"), "/static", "/index.html");
		return server;
	}
}
