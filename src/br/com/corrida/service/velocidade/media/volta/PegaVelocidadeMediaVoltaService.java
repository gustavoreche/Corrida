package br.com.corrida.service.velocidade.media.volta;

import br.com.corrida.domain.dados.piloto.DadosPiloto;
import br.com.corrida.service.extrai.log.InterfaceDefineDadosDoLog;

public class PegaVelocidadeMediaVoltaService implements InterfaceDefineDadosDoLog {
	
	
	@Override
	public void executa(String velocidadeMediaVolta, DadosPiloto dadosDoLog) {
		try {
			double velocidadeMediaVoltaFormatado = Double.parseDouble(velocidadeMediaVolta.replace(",","."));
			dadosDoLog.setVelocidadeMediaDaVolta(velocidadeMediaVoltaFormatado);			
		} catch (Exception e) {
			System.err.println("ERRO NO TRATAMENTO DOS DADOS DA HORA QUE O PILOTO INICIOU A VOLTA.");
		}
	}

}
