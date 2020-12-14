package com.filipe.leilao.test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import com.filipe.leilao.domain.Lance;
import com.filipe.leilao.domain.Leilao;
import com.filipe.leilao.domain.Usuario;
import com.filipe.leilao.service.AvaliadorLeilaoService;

public class AvaliadorLeilaoTest {

	@Test
	public void avaliar() {

		// Montar o cenário
		Usuario joao = new Usuario("João");
		Usuario maria = new Usuario("Maria");
		Usuario pedro = new Usuario("Pedro");
		Usuario tereza = new Usuario("Tereza");

		Leilao leilao = new Leilao("Leilão de um PS3");

		leilao.propor(new Lance(maria, 400.0));
		leilao.propor(new Lance(joao, 300.0));
		leilao.propor(new Lance(pedro, 500.0));
		leilao.propor(new Lance(tereza, 600.0));

		// Ação
		AvaliadorLeilaoService avaliador = new AvaliadorLeilaoService();
		avaliador.avaliar(leilao);

		// Validação
		assertEquals(600.0, avaliador.getMaiorLance(), 000001);
		assertEquals(300.0, avaliador.getMenorLance(), 000001);

	}

	@Test
	public void deveEntenderLeilaoComApenasUmLance() {

		// Montar o cenário
		Usuario joao = new Usuario("João");

		Leilao leilao = new Leilao("Leilão de um PS3");

		leilao.propor(new Lance(joao, 1500.0));

		// Ação
		AvaliadorLeilaoService avaliador = new AvaliadorLeilaoService();
		avaliador.avaliar(leilao);

		// Validação
		assertEquals(1500.0, avaliador.getMaiorLance(), 000001);
		assertEquals(1500.0, avaliador.getMenorLance(), 000001);

	}
}
