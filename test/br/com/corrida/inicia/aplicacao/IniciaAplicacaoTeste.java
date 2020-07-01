package br.com.corrida.inicia.aplicacao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.corrida.service.extrai.ExtraiInformacao;

public class IniciaAplicacaoTeste {
	
	@Mock
	private ExtraiInformacao extraiInformacao;
	
	@Before
	public void iniciaAmbiente() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void construtorPreenchido_ok() {
		IniciaAplicacao iniciaAplicacao = new IniciaAplicacao(this.extraiInformacao);
		Assert.assertNotNull(iniciaAplicacao.extraiInformacao);
	}
	
	@Test
	public void construtorNulo_error() {
		IniciaAplicacao iniciaAplicacao = new IniciaAplicacao(null);
		Assert.assertNull(iniciaAplicacao.extraiInformacao);
	}
	
	@Test
	public void executaComRetornoTrue_ok() {
		IniciaAplicacao iniciaAplicacao = new IniciaAplicacao(this.extraiInformacao);
		Mockito.when(this.extraiInformacao.extrai()).thenReturn(true);
		Assert.assertTrue(iniciaAplicacao.executa());
	}
	
	@Test
	public void executaComRetornoFalse_ok() {
		IniciaAplicacao iniciaAplicacao = new IniciaAplicacao(this.extraiInformacao);
		Mockito.when(this.extraiInformacao.extrai()).thenReturn(false);
		Assert.assertFalse(iniciaAplicacao.executa());
	}
	
	@Test
	public void executaComException_error() {
		Assert.assertThrows(RuntimeException.class, () -> {
			new IniciaAplicacao(null).executa();			
		});
	}

}
