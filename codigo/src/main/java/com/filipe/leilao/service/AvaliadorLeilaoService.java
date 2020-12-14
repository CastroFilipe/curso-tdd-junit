package com.filipe.leilao.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.filipe.leilao.domain.Lance;
import com.filipe.leilao.domain.Leilao;

public class AvaliadorLeilaoService {

	private Double maiorLance = Double.NEGATIVE_INFINITY;
	private Double menorLance = Double.POSITIVE_INFINITY;
	private List<Lance> maiores;

	public void avaliar(Leilao leilao) {

		leilao.getLances().forEach(lance -> {
			if (lance.getValor() > maiorLance) {
				maiorLance = lance.getValor();
			}

			if (lance.getValor() < menorLance) {
				menorLance = lance.getValor();
			}

		});

		maiores = new ArrayList<Lance>(leilao.getLances());

		// Mecanismo para pegar os três maiores lances
		Collections.sort(maiores, new Comparator<Lance>() {

			@Override
			public int compare(Lance o1, Lance o2) {

				if (o1.getValor() < o2.getValor())
					return 1;
				if (o1.getValor() > o2.getValor())
					return -1;
				return 0;
			}
		});

		maiores = maiores.subList(0, maiores.size() > 3 ? 3 : maiores.size());
	}

	public Double getMaiorLance() {
		return maiorLance;
	}

	public Double getMenorLance() {
		return menorLance;
	}

	public List<Lance> getTresMaiores() {
		return maiores;
	}

}
