package br.com.corrida.inicia.aplicacao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IniciaAplicacao {
	
	private static final String NOME_ARQUIVO_LEITURA = "corrida.log";
	
	public void executa() {
		List<Object> lista = new ArrayList<>();
		Scanner entrada = null;
//		String regex = "([^\\t]+[\\w*]+)"; 
		String regex = "([^\\t]+)";
		try {
			entrada = new Scanner(new FileReader(NOME_ARQUIVO_LEITURA));
		} catch (FileNotFoundException e) {
			System.err.println("IniciaAplicacao - executa - Exception: " + e);
		}
		int contadorDeLinha = 1;
		while (entrada.hasNextLine()) {
			String linha = entrada.nextLine();
			if(contadorDeLinha != 1) {
				Pattern p = Pattern.compile(regex);
				Matcher matcher = p.matcher(linha);
				while(matcher.find()) {
					System.out.println(matcher.group(1));	
					lista.add(matcher.group(1));
				}
				System.out.println(lista);
			} else {
				System.out.println("IniciaAplicacao - executa - Ignora a leitura da primeira linha, "
						+ "pois são os titulos dos campos.");
			}
			contadorDeLinha++;
		}		
	}

}
