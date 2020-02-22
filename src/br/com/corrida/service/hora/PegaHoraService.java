package br.com.corrida.service.hora;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import br.com.corrida.domain.dados.piloto.DadosPiloto;
import br.com.corrida.service.extrai.log.InterfaceDefineDadosDoLog;

public class PegaHoraService implements InterfaceDefineDadosDoLog {
	
	private static final String FORMATO_TEMPO = "[HH:mm:ss.SSS]";
	
	@Override
	public void executa(String hora, DadosPiloto dadosDoLog) {
		try {
			DateTimeFormatter modeloTempoFormatado = DateTimeFormatter.ofPattern(FORMATO_TEMPO);
			LocalTime horaFormatada = LocalTime.parse(hora.trim(), modeloTempoFormatado);
			dadosDoLog.setHora(horaFormatada);			
		} catch (Exception e) {
			System.err.println("ERRO NO TRATAMENTO DOS DADOS DA HORA QUE O PILOTO INICIOU A VOLTA.");
		}
	}

}
