package br.com.corrida.service.extrai.log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.corrida.domain.dados.piloto.DadosPiloto;

public class ExtraiInformacaoDoLog {
	
	private Scanner arquivoLido = null;
	
	private static final String REGEX_PARA_SEPARAR_POR_TAB = "([^\\t]+)";
	private static final int PULA_LEITURA_DA_LINHA_1 = 1; 

	public List<DadosPiloto> executa(String nomeArquivoDeLog) {
		List<DadosPiloto> listaDeDadosDoLog = new ArrayList<>();
		Scanner log = this.arquivoLido;
		String regex = REGEX_PARA_SEPARAR_POR_TAB;
		int contadorDeLinhaDoLog = 1;
		int contadorDeDadosEncontradosNoLog;
		while (log.hasNextLine()) {
			contadorDeDadosEncontradosNoLog = 1;
			String linhaDoLog = log.nextLine();
			if(contadorDeLinhaDoLog != PULA_LEITURA_DA_LINHA_1) {
				DadosPiloto dadosDoLog = new DadosPiloto();
				Pattern modeloParaSepararCaractere = Pattern.compile(regex);
				Matcher caractereSeparado = modeloParaSepararCaractere.matcher(linhaDoLog);
				while(caractereSeparado.find()) {
					try {
						EnumTipoDadoLogCorrida pegaInformacaoDoLog = EnumTipoDadoLogCorrida.pegaDado(contadorDeDadosEncontradosNoLog);
						Class<? extends InterfaceDefineDadosDoLog> classeQueDefineDados = pegaInformacaoDoLog.getDefineDadosDoLog();
						Constructor<? extends InterfaceDefineDadosDoLog> construtorDaClasseQueDefineDados = classeQueDefineDados.getConstructor();
						construtorDaClasseQueDefineDados.newInstance().executa(caractereSeparado.group(1), dadosDoLog);
					} catch (Throwable e) {
						System.err.println("ERRO NO TRATAMENTO DOS DADOS DO LOG.");
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
		String diretorioQueDeveSerGravado = "";
		try {
			diretorioQueDeveSerGravado = new File(".").getCanonicalPath();
		} catch (IOException e2) {
			System.err.println("Erro para localizar diretorio atual.");
		}
		try {
			leituraDoArquivoDeLog = new Scanner(new FileReader(nomeArquivoDeLog));
			this.arquivoLido  = leituraDoArquivoDeLog;
		} catch (FileNotFoundException e) {
			System.err.println("Não encontrou arquivo de log. Nome do arquivo digitado: " 
		+ nomeArquivoDeLog + "\nO arquivo de log deve estar no seguinte diretorio: " + diretorioQueDeveSerGravado);
			this.arquivoLido = null;
			return false;
		}
		return true;
	}

}
