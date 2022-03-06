package com.desafio.gabrielmaranhao.models.entities;

import java.lang.reflect.Field;

import javax.persistence.Column;

//doc: https://docs.oracle.com/javaee/7/api/index.html

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.google.gson.Gson;

@Entity
@Table(name = "contatos")
public class Contato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@Column(name = "nome", nullable = false, length = 100)
	private String nome;

	@Column(name = "sobre_nome", nullable = false, length = 10)
	private String sobreNome;

	@Column(name = "cpf", nullable = false, length = 11)
	private String cpf;

	@Column(name = "email", nullable = false, length = 100)
	private String email;

	@Column(name = "endereco", nullable = false, length = 1000)
	private String endereco; // Se der tempo transformo em outra E/R

	public Contato() {

	}

	public Contato(String nome, String sobreNome, String cpf, String email, String endereco) {
		super();
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.cpf = cpf;
		this.email = email;
		this.endereco = endereco;
	}

	public Contato(String nome, String sobreNome, String cpf, String email) {
		super();
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.cpf = cpf;
		this.email = email;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSobreNome() {
		return sobreNome;
	}

	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String toJson() {
		return new Gson().toJson(this);
	}

	/**
	 * Fill current object fields with new object values, ignoring new NULLs. Old
	 * values are overwritten.
	 *
	 * @param newObject Same type object with new values.
	 */
	public void mergeObj(Object newObject) {

		assert this.getClass().getName().equals(newObject.getClass().getName());

		for (Field field : this.getClass().getDeclaredFields()) {

			for (Field newField : newObject.getClass().getDeclaredFields()) {

				if (field.getName().equals(newField.getName())) {

					try {

						field.set(
								this,
								newField.get(newObject) == null
										? field.get(this)
										: newField.get(newObject));

					} catch (IllegalAccessException ignore) {
						// Field update exception on final modifier and other cases.
					}
				}
			}
		}
	}
}
