package br.com.corrida.service.extrai.log;

import java.io.File;
import java.io.FileWriter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ExtraiInformacaoDoLogTeste {
	
	ExtraiInformacaoDoLog extrai;
	
	@Before
	public void iniciaAmbiente() {
		this.extrai = new ExtraiInformacaoDoLog();
	}
	
	@Test
	public void leArquivoDigitadoComRetornoFalse_ok() {
		String qualquerTexto = "qualquer texto";
		Assert.assertFalse(this.extrai.leArquivoDigitado(qualquerTexto));
	}
	
	@Test
	public void leArquivoDigitadoComRetornoTrue_ok() {
		String qualquerTexto = "qualquerTexto.txt";
		this.criaArquivo(qualquerTexto);
		Assert.assertTrue(this.extrai.leArquivoDigitado(qualquerTexto));
	}
	
	@Test
	public void leArquivoDigitadoComValorNulo_error() {
		Assert.assertThrows(NullPointerException.class, () -> {
			String qualquerTexto = null;
			this.extrai.leArquivoDigitado(qualquerTexto);
		});
	}
	
	@Test
	public void executa_ok() {
		String qualquerTexto = "qualquerTexto.txt";
		this.criaArquivo(qualquerTexto);
		Assert.assertTrue(this.extrai.leArquivoDigitado(qualquerTexto));
	}
	
	private void criaArquivo(String qualquerTexto) {
		String diretorioQueDeveSerGravado = "";
		try {
			diretorioQueDeveSerGravado = new File(".").getCanonicalPath();
			@SuppressWarnings({ "unused", "resource" })
			FileWriter arquivo = new FileWriter(diretorioQueDeveSerGravado + "/" + qualquerTexto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
