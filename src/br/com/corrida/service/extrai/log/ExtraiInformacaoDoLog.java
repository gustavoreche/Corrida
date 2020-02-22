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

	public List<DadosPiloto> executa(String nomeArquivoDeLog) {
		List<DadosPiloto> listaDeDadosDoLog = new ArrayList<>();
		Scanner entrada = this.arquivoLido;
		String regex = "([^\\t]+)";
		int contadorDeLinha = 1;
		int contadorDeDadosEncontradosNoLog;
		while (entrada.hasNextLine()) {
			contadorDeDadosEncontradosNoLog = 1;
			String linha = entrada.nextLine();
			if(contadorDeLinha != 1) {
				DadosPiloto dadosDoLog = new DadosPiloto();
				Pattern p = Pattern.compile(regex);
				Matcher matcher = p.matcher(linha);
				while(matcher.find()) {
					try {
						EnumTipoDadoLogCorrida pegaDado = EnumTipoDadoLogCorrida.pegaDado(contadorDeDadosEncontradosNoLog);
						Class<? extends InterfaceDefineDadosDoLog> classeQueDefineDados = pegaDado.getDefineDadosDoLog();
						Constructor<? extends InterfaceDefineDadosDoLog> construtor = classeQueDefineDados.getConstructor();
						construtor.newInstance().executa(matcher.group(1), dadosDoLog);
					} catch (Throwable e) {
						System.err.println("ERRO NO TRATAMENTO DOS DADOS DO LOG.");
					}
					contadorDeDadosEncontradosNoLog++;
				}
				listaDeDadosDoLog.add(dadosDoLog);
			} else {
				System.out.println("IniciaAplicacao - executa - Ignora a leitura da primeira linha, "
						+ "pois são os titulos dos campos.");
			}
			contadorDeLinha++;
		}		
		return listaDeDadosDoLog;
	}
	
	public boolean leArquivoDigitado(String nomeArquivoDeLog) {
		Scanner entrada = null;
		String diretorioQueDeveSerGravado = "";
		try {
			diretorioQueDeveSerGravado = new File(".").getCanonicalPath();
		} catch (IOException e2) {
			System.err.println("Erro para localizar diretorio atual.");
		}
		try {
			entrada = new Scanner(new FileReader(nomeArquivoDeLog));
			this.arquivoLido  = entrada;
		} catch (FileNotFoundException e) {
			System.err.println("Não encontrou arquivo de log. Nome do arquivo digitado: " 
		+ nomeArquivoDeLog + "\nO arquivo de log deve estar no seguinte diretorio: " + diretorioQueDeveSerGravado);
			this.arquivoLido = null;
			return false;
		}
		return true;
	}

}
