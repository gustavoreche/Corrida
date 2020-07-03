package br.com.corrida.service.extrai.log;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SaidaDoSistemaTeste {
	
	SaidaDoSistema saida;
	
	@Before
	public void iniciaAmbiente() {
		this.saida = new SaidaDoSistema();
	}
	
	@Test
	public void executaComRetornoTrue_ok() {
		Assert.assertTrue(this.saida.executa(SaidaDoSistema.getSair()));
	}
	
	@Test
	public void executaComRetornoFalse_ok() {
		String qualquerTexto = "qualquer texto";
		Assert.assertFalse(this.saida.executa(qualquerTexto));
	}
	
	@Test
	public void executaComException_error() {
		Assert.assertThrows(NullPointerException.class, () -> {
			String qualquerTexto = null;
			this.saida.executa(qualquerTexto);
		});
	}
	
}
