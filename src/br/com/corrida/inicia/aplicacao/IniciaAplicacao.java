package br.com.corrida.inicia.aplicacao;

import br.com.corrida.service.extrai.ExtraiInformacao;

public class IniciaAplicacao {
	
	protected ExtraiInformacao extraiInformacao;
	
	public IniciaAplicacao(ExtraiInformacao extraiInformacao) {
		this.extraiInformacao = extraiInformacao;
	}
	
	public void executa() {
		this.extraiInformacao.extrai();
		System.err.print("\nMUITO OBRIGADO. \nSistema desenvolvido por Gustavo Dolmen Reche.");
	}

}
