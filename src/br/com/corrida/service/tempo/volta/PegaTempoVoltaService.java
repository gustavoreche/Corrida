package br.com.corrida.service.tempo.volta;

import java.time.LocalTime;

import br.com.corrida.domain.dados.piloto.DadosPiloto;
import br.com.corrida.service.extrai.log.InterfaceDefineDadosDoLog;

public class PegaTempoVoltaService implements InterfaceDefineDadosDoLog {
	
	@Override
	public void executa(String tempoVolta, DadosPiloto dadosDoLog) {
		try {
			String[] divideInformacaoDoTempoDaVolta = tempoVolta.split("[:.]");
			String minuto = divideInformacaoDoTempoDaVolta[0] != null ? divideInformacaoDoTempoDaVolta[0].trim() : "0"; 
			String segundo = divideInformacaoDoTempoDaVolta[1] != null ? divideInformacaoDoTempoDaVolta[1].trim() : "0";
			String milissegundo = divideInformacaoDoTempoDaVolta[2] != null ? divideInformacaoDoTempoDaVolta[2].trim() : "0";
			int minutoFormatado = Integer.parseInt(minuto);
			int segundoFormatado = Integer.parseInt(segundo);
			int milissegundoFormatado = Integer.parseInt(milissegundo);
			LocalTime tempoVoltaFormatado = LocalTime.of(0, minutoFormatado, segundoFormatado, (milissegundoFormatado * 1_000_000));
			dadosDoLog.setTempoVolta(tempoVoltaFormatado);
		} catch (Exception e) {
			System.err.println("ERRO NO TRATAMENTO DOS DADOS DO TEMPO EM QUE O PILOTO LEVOU PARA REALIZAR A VOLTA.");
		}
	}

}
