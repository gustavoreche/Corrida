package br.com.corrida.service.extrai.log;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.corrida.domain.dados.piloto.DadosPiloto;
import br.com.corrida.service.exibe.dados.corrida.ExibeDadosDaCorrida;

public class ExtraiPorLogTeste {
	
	@InjectMocks
	private ExtraiPorLog extraiPorLog = new ExtraiPorLog();
	
	@Mock
	private EntradaDoUsuario entradaDoUsuario;
	
	@Mock
	private SaidaDoSistema saidaDoSistema;
	
	@Mock
	private ExtraiInformacaoDoLog extraiInformacao;
	
	@Mock
	private ExibeDadosDaCorrida exibeDadosDaCorrida;
	
	@Before
	public void iniciaAmbiente() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void construtorPreenchidoDoAtributoExtraiInformacao_ok() {
		ExtraiPorLog extraiPorLog = new ExtraiPorLog();
		Assert.assertNotNull(extraiPorLog.getExtraiInformacao());
	}
	
	@Test
	public void construtorPreenchidoDoAtributoExibeDadosDaCorrida_ok() {
		ExtraiPorLog extraiPorLog = new ExtraiPorLog();
		Assert.assertNotNull(extraiPorLog.getExibeDadosDaCorrida());
	}
	
	@Test
	public void construtorPreenchidoDoAtributoEntradaDoUsuario_ok() {
		ExtraiPorLog extraiPorLog = new ExtraiPorLog();
		Assert.assertNotNull(extraiPorLog.getEntradaDoUsuario());
	}
	
	@Test
	public void construtorPreenchidoDoAtributoSaidaDoSistema_ok() {
		ExtraiPorLog extraiPorLog = new ExtraiPorLog();
		Assert.assertNotNull(extraiPorLog.getSaidaDoSistema());
	}
	
//	@Test
//	public void saiDoSistemaComRetornoTrue_ok() {
//		Assert.assertTrue(new ExtraiPorLog().saiDoSistema(ExtraiPorLog.SAIR));
//	}
//	
//	@Test
//	public void saiDoSistemaComRetornoFalse_ok() {
//		Assert.assertFalse(this.extraiPorLog.saiDoSistema(Matchers.anyString()));
//	}
//	
//	@Test
//	public void entradaDoUsuarioPreenchida_ok() {
//		String qualquerTexto = "teste";
//		Mockito.when(this.extraiPorLog.entradaDoUsuario()).thenReturn(qualquerTexto);
//	    Assert.assertEquals(qualquerTexto, this.extraiPorLog.entradaDoUsuario());
//	}
//	
//	@Test
//	public void entradaDoUsuarioVazia_error() {
//		String qualquerTexto = "";
//		Mockito.when(this.extraiPorLog.entradaDoUsuario()).thenReturn(qualquerTexto);
//	    Assert.assertTrue(this.extraiPorLog.entradaDoUsuario().isEmpty());
//	}
//	
//	@Test
//	public void entradaDoUsuarioNula_error() {
//		String qualquerTexto = null;
//		Mockito.when(this.extraiPorLog.entradaDoUsuario()).thenReturn(qualquerTexto);
//	    Assert.assertNull(this.extraiPorLog.entradaDoUsuario());
//	}
	
	@Test
	public void extraiComSaidaDoSistemaFalseELeArquivoDigitadoTrue_RetornoTrue_ok() {
		this.configuraAmbiente("qualquerTexto", false, true);
		Assert.assertTrue(this.extraiPorLog.extrai());
	}
	
	@Test
	public void extraiComSaidaDoSistemaTrueELeArquivoDigitadoTrue_RetornoFalse_ok() {
		this.configuraAmbiente("qualquerTexto", true, true);
		Assert.assertFalse(this.extraiPorLog.extrai());
	}
	
	@Test
	public void extraiComSaidaDoSistemaTrueELeArquivoDigitadoFalse_RetornoFalse_ok() {
		this.configuraAmbiente("qualquerTexto", true, false);
		Assert.assertFalse(this.extraiPorLog.extrai());
	}
	
	@Test
	public void extraiComSaidaDoSistemaFalseELeArquivoDigitadoFalse_RetornoFalse_ok() {
		this.configuraAmbiente("qualquerTexto", false, false);
		Assert.assertFalse(this.extraiPorLog.extrai());
	}
	
	@Test
	public void extraiComSaidaDoSistemaFalseELeArquivoDigitadoFalseEArquivoTextoNulo_RetornoFalse_ok() {
		this.configuraAmbiente(null, false, false);
		Assert.assertFalse(this.extraiPorLog.extrai());
	}
	
	private void configuraAmbiente(String qualquerTexto, boolean saidaDoSistema, boolean leArquivoDigitado) {
		Mockito.when(this.entradaDoUsuario.executa()).thenReturn(qualquerTexto);
		
		Mockito.when(this.saidaDoSistema.executa(Matchers.anyString())).thenReturn(saidaDoSistema);
		
		Mockito.when(this.extraiInformacao.leArquivoDigitado(Matchers.anyString())).thenReturn(leArquivoDigitado);
		Mockito.when(this.extraiInformacao.executa(Matchers.anyString())).thenReturn(new ArrayList<DadosPiloto>());
		
		Mockito.doNothing().when(this.exibeDadosDaCorrida).executa(Matchers.anyListOf(DadosPiloto.class));
	}
	
}
