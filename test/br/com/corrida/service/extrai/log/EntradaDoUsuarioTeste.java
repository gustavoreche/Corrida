package br.com.corrida.service.extrai.log;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class EntradaDoUsuarioTeste {
	
	@Mock
	EntradaDoUsuario entrada;
	
	@Before
	public void iniciaAmbiente() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void executaComRetornoComTexto_ok() {
		String qualquerTexto = "qualquer texto";
		Mockito.when(this.entrada.executa()).thenReturn(qualquerTexto);
		Assert.assertFalse(this.entrada.executa().isEmpty());
	}
	
	@Test
	public void executaComRetornoSemTexto_ok() {
		String qualquerTexto = "";
		Mockito.when(this.entrada.executa()).thenReturn(qualquerTexto);
		Assert.assertTrue(this.entrada.executa().isEmpty());
	}
	
	@Test
	public void executaComRetornoNulo_ok() {
		String qualquerTexto = null;
		Mockito.when(this.entrada.executa()).thenReturn(qualquerTexto);
		Assert.assertNull(this.entrada.executa());
	}
	
}
