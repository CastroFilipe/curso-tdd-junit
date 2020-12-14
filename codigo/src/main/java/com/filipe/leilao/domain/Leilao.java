package com.filipe.leilao.domain;

import java.util.ArrayList;
import java.util.List;

public class Leilao {

	private String descricao;

	private List<Lance> lances;

	public Leilao(String descricao) {
		super();
		this.descricao = descricao;
	}

	public Leilao(String descricao, List<Lance> lances) {
		super();
		this.descricao = descricao;
		this.lances = lances;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Lance> getLances() {
		return lances;
	}

	public void setLances(List<Lance> lances) {
		this.lances = lances;
	}
	
	public void propor(Lance lance) {
		if(lances == null) {
			lances = new ArrayList<Lance>();
		}
		
		lances.add(lance);
	}

}
