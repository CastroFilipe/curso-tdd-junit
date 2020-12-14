package com.filipe.leilao.service;

import com.filipe.leilao.domain.Leilao;

public class AvaliadorLeilaoService {

	private Double maiorLance = Double.NEGATIVE_INFINITY;
	private Double menorLance = Double.POSITIVE_INFINITY;

	public void avaliar(Leilao leilao) {

		leilao.getLances().forEach(lance -> {
			if (lance.getValor() > maiorLance) {
				maiorLance = lance.getValor();
			}

			if (lance.getValor() < menorLance) {
				menorLance = lance.getValor();
			}

		});
	}

	public Double getMaiorLance() {
		return maiorLance;
	}

	public Double getMenorLance() {
		return menorLance;
	}

}
