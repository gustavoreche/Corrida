package br.com.corrida.service.extrai.log;

import br.com.corrida.service.erro.PegaErroService;
import br.com.corrida.service.hora.PegaHoraService;
import br.com.corrida.service.numero.volta.PegaNumeroVoltaService;
import br.com.corrida.service.piloto.PegaPilotoService;
import br.com.corrida.service.tempo.volta.PegaTempoVoltaService;
import br.com.corrida.service.velocidade.media.volta.PegaVelocidadeMediaVoltaService;

public enum EnumTipoDadoLogCorrida {
	
	HORA(1, "Hora que o piloto iniciou a volta", PegaHoraService.class),
	PILOTO(2, "Código e nome do piloto", PegaPilotoService.class),
	NUMERO_VOLTA(3, "Número da volta que o piloto está realizando", PegaNumeroVoltaService.class),
	TEMPO_VOLTA(4, "Tempo que o piloto levou para realizar a volta", PegaTempoVoltaService.class),
	VELOCIDADE_MEDIA_VOLTA(5, "Velocidade média em que o piloto completou a volta", PegaVelocidadeMediaVoltaService.class),
	ERRO(1000, "Erro", PegaErroService.class),
	;
	
	private int id;
	private String descricao;
	private Class <? extends InterfaceDefineDadosDoLog> defineDadosDoLog;
	
	private EnumTipoDadoLogCorrida(int id, String descricao, Class <? extends InterfaceDefineDadosDoLog> defineDadosDoLog) {
		this.id = id;
		this.descricao = descricao;
		this.defineDadosDoLog = defineDadosDoLog;
	}

	public int getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public Class<? extends InterfaceDefineDadosDoLog> getDefineDadosDoLog() {
		return defineDadosDoLog;
	}

	public static EnumTipoDadoLogCorrida pegaDado(int contadorDeDadosEncontradosNoLog) {
		for (EnumTipoDadoLogCorrida dadosDoLog : EnumTipoDadoLogCorrida.values()) {
			if(dadosDoLog.getId() == contadorDeDadosEncontradosNoLog) {
				return dadosDoLog;
			}
		}
		return EnumTipoDadoLogCorrida.ERRO;
	}
	
}
