package br.com.corrida.service.extrai.log;

import java.util.Scanner;

import br.com.corrida.service.exibe.dados.corrida.ExibeDadosDaCorrida;
import br.com.corrida.service.extrai.ExtraiInformacao;

public class ExtraiPorLog implements ExtraiInformacao {
	
	private static final int SIM = 1;
	private static final int NAO = 0;
	
	private static final String SAIR = "sair";
	
	protected ExtraiInformacaoDoLog extraiInformacao;
	
	public ExtraiPorLog() {
		this.extraiInformacao = new ExtraiInformacaoDoLog();
	}

	@Override
	public boolean extrai() {
		String nomeArquivoDeLog = "";
		int sairDoSistema = NAO;
		do {
			@SuppressWarnings("resource")
			Scanner entradaUsuario = new Scanner(System.in);
			System.out.println("");
			System.out.print("DIGITE O NOME DO ARQUIVO DE LOG. EX: teste.log OU DIGITE SAIR: ");
			nomeArquivoDeLog = entradaUsuario.nextLine();
			sairDoSistema = nomeArquivoDeLog.equalsIgnoreCase(SAIR) ? SIM : NAO;
		} while(sairDoSistema == NAO && !this.extraiInformacao.leArquivoDigitado(nomeArquivoDeLog));
		
		if(sairDoSistema == SIM) {
			System.err.print("VOCÊ OPTOU POR SAIR DO SISTEMA. MUITO OBRIGADO. \nSistema desenvolvido por Gustavo Dolmen Reche.");
			return false;
		}
		
		new ExibeDadosDaCorrida().executa(this.extraiInformacao.executa(nomeArquivoDeLog));
		return true;
	}

}
