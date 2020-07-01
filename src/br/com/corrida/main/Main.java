package br.com.corrida.main;

import br.com.corrida.inicia.aplicacao.IniciaAplicacao;
import br.com.corrida.service.extrai.log.ExtraiPorLog;

public class Main {

	public static void main(String[] args) {
		new IniciaAplicacao(new ExtraiPorLog()).executa();
	}
	
}