package com.filipe.leilao.domain;

public class Usuario {

	private Integer id;

	private String nome;

	public Usuario(String nome) {
		super();
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
