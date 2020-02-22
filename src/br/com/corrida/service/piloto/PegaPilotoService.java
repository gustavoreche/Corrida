package br.com.corrida.service.piloto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.corrida.domain.dados.piloto.DadosPiloto;
import br.com.corrida.service.extrai.log.InterfaceDefineDadosDoLog;

public class PegaPilotoService implements InterfaceDefineDadosDoLog {
	
	private static final String FORMATA_CODIGO_E_NOME_DO_PILOTO = "([A-Za-z0-9\\.]+)";
	
	@Override
	public void executa(String piloto, DadosPiloto dadosDoLog) {
		try {
			Pattern formatoDaSeparacaoDeString = Pattern.compile(FORMATA_CODIGO_E_NOME_DO_PILOTO);
			Matcher pegaStringFormatada = formatoDaSeparacaoDeString.matcher(piloto.trim());
			int contadorDeDadosDoPiloto = 1;
			while(pegaStringFormatada.find()) {
				switch (EnumTipoDadoPiloto.pegaDado(contadorDeDadosDoPiloto)) {
				case CODIGO:
					String codigoPiloto = pegaStringFormatada.group(1) != null ? pegaStringFormatada.group(1) : "0"; 
					int codigoPilotoFormatado = Integer.parseInt(codigoPiloto);
					dadosDoLog.setCodigoPiloto(codigoPilotoFormatado);
					break;
				case NOME:
					String nomePiloto = pegaStringFormatada.group(1) != null ? pegaStringFormatada.group(1) : "Sem nome";							
					dadosDoLog.setNomePiloto(nomePiloto);
					break;
				default:
					System.err.println("Não corresponde a nenhum dado mapeado.");
					break;
				}
				contadorDeDadosDoPiloto++;
			}
		} catch (Exception e) {
			System.err.println("ERRO NO TRATAMENTO DOS DADOS DO PILOTO.");
		}
	}

}
