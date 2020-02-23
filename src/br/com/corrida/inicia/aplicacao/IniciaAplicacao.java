package br.com.corrida.inicia.aplicacao;

import java.util.Scanner;

import br.com.corrida.service.exibe.dados.corrida.ExibeDadosDaCorrida;
import br.com.corrida.service.extrai.log.ExtraiInformacaoDoLog;

public class IniciaAplicacao {
	
	private static final String SAIR = "sair";
	
	private static final int SIM = 1;
	private static final int NAO = 0;
	
	public void executa() {
		ExtraiInformacaoDoLog extraiInformacao = new ExtraiInformacaoDoLog();
		String nomeArquivoDeLog = "";
		int sairDoSistema = 0;
		do {
			@SuppressWarnings("resource")
			Scanner entradaUsuario = new Scanner(System.in);
			System.out.println("");
			System.out.print("DIGITE O NOME DO ARQUIVO DE LOG. EX: teste.log OU DIGITE SAIR: ");
			nomeArquivoDeLog = entradaUsuario.nextLine();
			sairDoSistema = nomeArquivoDeLog.equalsIgnoreCase(SAIR) ? SIM : NAO;
		} while(sairDoSistema == NAO && !extraiInformacao.leArquivoDigitado(nomeArquivoDeLog));
		
		if(sairDoSistema == SIM) {
			System.err.print("VOCÊ OPTOU POR SAIR DO SISTEMA. MUITO OBRIGADO. \nSistema desenvolvido por Gustavo Dolmen Reche.");
			return;
		}
		
		new ExibeDadosDaCorrida().executa(extraiInformacao.executa(nomeArquivoDeLog));
		System.err.print("\nMUITO OBRIGADO. \nSistema desenvolvido por Gustavo Dolmen Reche.");
	}

}
