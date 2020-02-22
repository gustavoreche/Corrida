package br.com.corrida.service.numero.volta;

import br.com.corrida.domain.dados.piloto.DadosPiloto;
import br.com.corrida.service.extrai.log.InterfaceDefineDadosDoLog;

public class PegaNumeroVoltaService implements InterfaceDefineDadosDoLog {
	
	@Override
	public void executa(String numeroVolta, DadosPiloto dadosDoLog) {
		try {
			int numeroVoltaFormatado = Integer.parseInt(numeroVolta.trim());
			dadosDoLog.setNumeroDaVolta(numeroVoltaFormatado);			
		} catch (Exception e) {
			System.err.println("ERRO NO TRATAMENTO DOS DADOS DO NUMERO DA VOLTA QUE O PILOTO ESTA REALIZANDO.");
		}
	}

}
