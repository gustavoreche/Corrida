package br.com.corrida.service.erro;

import br.com.corrida.domain.dados.piloto.DadosPiloto;
import br.com.corrida.service.extrai.log.InterfaceDefineDadosDoLog;

public class PegaErroService implements InterfaceDefineDadosDoLog {
	
	@Override
	public void executa(String velocidadeMediaVolta, DadosPiloto dadosDoLog) {
		try {
			System.err.println("Não corresponde a nenhum dado mapeado.");		
		} catch (Exception e) {
			System.err.println("ERRO NO TRATAMENTO DOS DADOS DA HORA QUE O PILOTO INICIOU A VOLTA.");
		}
	}

}
