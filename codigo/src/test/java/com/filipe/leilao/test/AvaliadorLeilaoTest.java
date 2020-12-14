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

	@Test
	public void deveEncontrarOsTresMaioresLances() {

		// Montar o cenário
		Usuario joao = new Usuario("João");
		Usuario maria = new Usuario("Maria");

		Leilao leilao = new Leilao("Leilão de um PS3");

		leilao.propor(new Lance(maria, 400.0));
		leilao.propor(new Lance(joao, 500.0));
		leilao.propor(new Lance(maria, 550.0));
		leilao.propor(new Lance(joao, 600.0));

		// Ação
		AvaliadorLeilaoService avaliador = new AvaliadorLeilaoService();
		avaliador.avaliar(leilao);

		// Validação
		assertEquals(3, avaliador.getTresMaiores().size());

		assertEquals(600.0, avaliador.getTresMaiores().get(0).getValor(), 00001);
		assertEquals(550.0, avaliador.getTresMaiores().get(1).getValor(), 00001);
		assertEquals(500.0, avaliador.getTresMaiores().get(2).getValor(), 00001);
	}
	
	@Test
	public void deveEntenderLeilaoComLancesEmOrdemRandomica() {

		// Montar o cenário
		Usuario joao = new Usuario("João");
		Usuario maria = new Usuario("Maria");

		Leilao leilao = new Leilao("Leilão de um PS3");

		leilao.propor(new Lance(maria, 200.0));
		leilao.propor(new Lance(joao, 500.0));
		leilao.propor(new Lance(maria, 550.0));
		leilao.propor(new Lance(joao, 600.0));
		leilao.propor(new Lance(maria, 350.0));
		leilao.propor(new Lance(joao, 700.0));
		leilao.propor(new Lance(joao, 250.0));

		// Ação
		AvaliadorLeilaoService avaliador = new AvaliadorLeilaoService();
		avaliador.avaliar(leilao);

		// Validação
		assertEquals(200.0, avaliador.getMenorLance(), 00001);
		assertEquals(700.0, avaliador.getMaiorLance(), 00001);
	}
	
	@Test
	public void deveEntenderLeilaoComLancesEmOrdemDecrescente() {

		// Montar o cenário
		Usuario joao = new Usuario("João");
		Usuario maria = new Usuario("Maria");

		Leilao leilao = new Leilao("Leilão de um PS3");

		leilao.propor(new Lance(maria, 700.0));
		leilao.propor(new Lance(joao, 600.0));
		leilao.propor(new Lance(maria, 550.0));
		leilao.propor(new Lance(joao, 500.0));
		leilao.propor(new Lance(maria, 450.0));
		leilao.propor(new Lance(joao, 400.0));
		leilao.propor(new Lance(joao, 200.0));

		// Ação
		AvaliadorLeilaoService avaliador = new AvaliadorLeilaoService();
		avaliador.avaliar(leilao);

		// Validação
		assertEquals(200.0, avaliador.getMenorLance(), 00001);
		assertEquals(700.0, avaliador.getMaiorLance(), 00001);
	}

}
