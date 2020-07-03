package br.com.corrida.service.extrai.log;

import br.com.corrida.service.exibe.dados.corrida.ExibeDadosDaCorrida;
import br.com.corrida.service.extrai.ExtraiInformacao;

public class ExtraiPorLog implements ExtraiInformacao {
	
	private static final String SAIDA_DO_USUARIO = "VOCÊ OPTOU POR SAIR DO SISTEMA.";
	private static final String LIMITE_MAXIMO_ATINGIDO = "LIMITE DE TENTATIVA MÁXIMO ATINGIDO.";
	
	private static final int LIMITE_MAXIMO = 3;
	
	private ExtraiInformacaoDoLog extraiInformacao;
	private ExibeDadosDaCorrida exibeDadosDaCorrida;
	private EntradaDoUsuario entradaDoUsuario;
	private SaidaDoSistema saidaDoSistema;
	
	public ExtraiPorLog() {
		this.extraiInformacao = new ExtraiInformacaoDoLog();
		this.exibeDadosDaCorrida = new ExibeDadosDaCorrida();
		this.entradaDoUsuario = new EntradaDoUsuario();
		this.saidaDoSistema = new SaidaDoSistema();
	}

	@Override
	public boolean extrai() {
		String nomeArquivoDeLog = "";
		int quantidadeDeVezesDeErroDeDigitacaoDoArquivoLog = 0;
		do {
			nomeArquivoDeLog = this.entradaDoUsuario.executa();
			quantidadeDeVezesDeErroDeDigitacaoDoArquivoLog++;
		} while(!this.saidaDoSistema.executa(nomeArquivoDeLog) && !this.extraiInformacao.leArquivoDigitado(nomeArquivoDeLog) && 
				quantidadeDeVezesDeErroDeDigitacaoDoArquivoLog < LIMITE_MAXIMO);
		
		if(this.saidaDoSistema.executa(nomeArquivoDeLog)) {
			System.err.print(SAIDA_DO_USUARIO);
			quantidadeDeVezesDeErroDeDigitacaoDoArquivoLog = 0;
			return false;
		}
		
		if(quantidadeDeVezesDeErroDeDigitacaoDoArquivoLog == LIMITE_MAXIMO) {
			System.err.print(LIMITE_MAXIMO_ATINGIDO);
			quantidadeDeVezesDeErroDeDigitacaoDoArquivoLog = 0;
			return false;
		}
		
		this.exibeDadosDaCorrida.executa(this.extraiInformacao.executa(nomeArquivoDeLog));
		quantidadeDeVezesDeErroDeDigitacaoDoArquivoLog = 0;
		return true;
	}
	
	protected ExtraiInformacaoDoLog getExtraiInformacao() {
		return extraiInformacao;
	}
	
	protected ExibeDadosDaCorrida getExibeDadosDaCorrida() {
		return exibeDadosDaCorrida;
	}
	
	protected EntradaDoUsuario getEntradaDoUsuario() {
		return entradaDoUsuario;
	}
	
	protected SaidaDoSistema getSaidaDoSistema() {
		return saidaDoSistema;
	}
	
}
