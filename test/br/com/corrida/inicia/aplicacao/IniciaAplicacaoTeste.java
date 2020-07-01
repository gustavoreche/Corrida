package br.com.corrida.inicia.aplicacao;

import org.junit.Assert;
import org.junit.Test;

import br.com.corrida.service.extrai.log.ExtraiPorLog;

public class IniciaAplicacaoTeste {
	
	@Test
	public void construtorPreenchido_ok() {
		IniciaAplicacao iniciaAplicacao = new IniciaAplicacao(new ExtraiPorLog());
		Assert.assertTrue(iniciaAplicacao.extraiInformacao != null);
	}
	
	@Test
	public void construtorNulo_error() {
		IniciaAplicacao iniciaAplicacao = new IniciaAplicacao(null);
		Assert.assertTrue(iniciaAplicacao.extraiInformacao == null);
	}

}
