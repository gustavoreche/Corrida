package br.com.corrida.inicia.aplicacao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.corrida.service.extrai.ExtraiInformacao;

public class IniciaAplicacaoTeste {
	
	@Mock
	private ExtraiInformacao extraiInformacao;
	
	@InjectMocks
	private IniciaAplicacao iniciaAplicacao = new IniciaAplicacao(this.extraiInformacao);
	
	@Before
	public void iniciaAmbiente() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void construtorPreenchido_ok() {
		IniciaAplicacao iniciaAplicacao = new IniciaAplicacao(this.extraiInformacao);
		Assert.assertNotNull(iniciaAplicacao.getExtraiInformacao());
	}
	
	@Test
	public void construtorNulo_error() {
		IniciaAplicacao iniciaAplicacao = new IniciaAplicacao(null);
		Assert.assertNull(iniciaAplicacao.getExtraiInformacao());
	}
	
	@Test
	public void executaComRetornoTrue_ok() {
		Mockito.when(this.extraiInformacao.extrai()).thenReturn(true);
		Assert.assertTrue(this.iniciaAplicacao.executa());
	}
	
	@Test
	public void executaComRetornoFalse_ok() {
		Mockito.when(this.extraiInformacao.extrai()).thenReturn(false);
		Assert.assertFalse(this.iniciaAplicacao.executa());
	}
	
	@Test
	public void executaComException_error() {
		Assert.assertThrows(RuntimeException.class, () -> {
			new IniciaAplicacao(null).executa();			
		});
	}

}
