package br.com.corrida.inicia.aplicacao;

import br.com.corrida.service.extrai.ExtraiInformacao;

public class IniciaAplicacao {
	
	private final static String FRASE_ENCERRAMENTO = "\nMUITO OBRIGADO. \nSistema desenvolvido por Gustavo Dolmen Reche.";
	private final static String ERRO = "ERRO NO SISTEMA\nContate o desenvolvedor: gustavodreche@msn.com";
	
	private ExtraiInformacao extraiInformacao;
	
	public IniciaAplicacao(ExtraiInformacao extraiInformacao) {
		this.extraiInformacao = extraiInformacao;
	}
	
	public boolean executa() {
		try {
			boolean executou = this.extraiInformacao.extrai();
			System.err.print(FRASE_ENCERRAMENTO);
			return executou;
		} catch (Exception e) {
			System.err.print(ERRO);
			throw new RuntimeException();
		}
	}
	
	public ExtraiInformacao getExtraiInformacao() {
		return extraiInformacao;
	}

}
