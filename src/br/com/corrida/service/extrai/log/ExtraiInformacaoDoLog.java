package br.com.corrida.service.extrai.log;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.corrida.domain.dados.piloto.DadosPiloto;

public class ExtraiInformacaoDoLog {
	
	private Scanner arquivoLido = null;
	
	private static final String REGEX_PARA_SEPARAR_POR_TAB = "(\\b[^\\t]+\\b)";
	private static final int PULA_LEITURA_DA_LINHA_1 = 1; 
	
	private static final String NAO_ENCONTROU_LOG = "Não encontrou arquivo de log. Nome do arquivo digitado: ";
	private static final String DIRETORIO_CORRETO = "\nO arquivo de log deve estar no seguinte diretorio: ";
	private static final String ERRO_NA_ANALISE_DO_LOG = "ERRO NO TRATAMENTO DOS DADOS DO LOG.";
	
	private PegaDiretorioAtual pegaDiretorioAtual;
	
	public ExtraiInformacaoDoLog() {
		this.pegaDiretorioAtual = new PegaDiretorioAtual();
	}

	public List<DadosPiloto> executa(String nomeArquivoDeLog) {
		List<DadosPiloto> listaDeDadosDoLog = new ArrayList<>();
		Scanner log = this.arquivoLido;
		int contadorDeLinhaDoLog = 1;
		int contadorDeDadosEncontradosNoLog;
		while (log.hasNextLine()) {
			contadorDeDadosEncontradosNoLog = 1;
			String linhaDoLog = log.nextLine();
			if(contadorDeLinhaDoLog != PULA_LEITURA_DA_LINHA_1) {
				DadosPiloto dadosDoLog = new DadosPiloto();
				Pattern modeloParaSepararCaractere = Pattern.compile(REGEX_PARA_SEPARAR_POR_TAB);
				Matcher caractereSeparado = modeloParaSepararCaractere.matcher(linhaDoLog);
				while(caractereSeparado.find()) {
					try {
						EnumTipoDadoLogCorrida pegaInformacaoDoLog = EnumTipoDadoLogCorrida.pegaDado(contadorDeDadosEncontradosNoLog);
						Class<? extends InterfaceDefineDadosDoLog> classeQueDefineDados = pegaInformacaoDoLog.getDefineDadosDoLog();
						Constructor<? extends InterfaceDefineDadosDoLog> construtorDaClasseQueDefineDados = classeQueDefineDados.getConstructor();
						construtorDaClasseQueDefineDados.newInstance().executa(caractereSeparado.group(1), dadosDoLog);
					} catch (Throwable e) {
						System.err.println(ERRO_NA_ANALISE_DO_LOG);
					}
					contadorDeDadosEncontradosNoLog++;
				}
				listaDeDadosDoLog.add(dadosDoLog);
			} 
			contadorDeLinhaDoLog++;
		}		
		return listaDeDadosDoLog;
	}
	
	public boolean leArquivoDigitado(String nomeArquivoDeLog) {
		Scanner leituraDoArquivoDeLog = null;
		String diretorioQueDeveSerGravado = this.pegaDiretorioAtual.executa();
		try {
			leituraDoArquivoDeLog = new Scanner(new FileReader(nomeArquivoDeLog));
			this.arquivoLido  = leituraDoArquivoDeLog;
		} catch (FileNotFoundException e) {
			System.err.println(NAO_ENCONTROU_LOG + nomeArquivoDeLog + DIRETORIO_CORRETO + diretorioQueDeveSerGravado);
			this.arquivoLido = null;
			return false;
		}
		return true;
	}

}
