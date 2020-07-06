package br.com.corrida.service.extrai.log;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PegaDiretorioAtualTeste {
	
	PegaDiretorioAtual pegaDiretorioAtual;
	
	@Before
	public void iniciaAmbiente() {
		this.pegaDiretorioAtual = new PegaDiretorioAtual();
	}
	
	@Test
	public void executaComRetornoPreenchido_ok() {
		Assert.assertFalse(this.pegaDiretorioAtual.executa().isEmpty());
	}
	
}
