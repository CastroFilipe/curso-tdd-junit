package com.filipe.exemplo.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AritmeticaServiceTest {
	
	@Test
	public void testSoma() {
		Integer valor = 10;
		Integer valor2 = 20;
		
		AritmeticaService somador = new AritmeticaService();
		Integer resultado = somador.somar(valor, valor2);
		
		Assertions.assertEquals(30, resultado);
		
	}
	
}
