package br.com.corrida.service.exibe.dados.corrida;

import java.time.LocalTime;
import java.util.List;

import br.com.corrida.domain.posicao.piloto.PosicaoPiloto;

public class ExibeInformacoes {
	
	protected void executa(List<PosicaoPiloto> listaPosicaoPiloto) {
		System.out.println("--------------------------------------------------------------------------\n"
				+ "--------------------------------------------------------------------------\n");
		System.out.println("INFORMAÇÕES DA CORRIDA\n");
		listaPosicaoPiloto.forEach(lista -> {
			System.out.println(lista.getCodigoPiloto() + " - " + lista.getNomePiloto() + "\nTempo da melhor volta: " +  lista.getTempoDaMelhorVolta() + 
					".\nVelocidade média durante a corrida: " + pegaVelocidadeMediaPorPiloto(lista) + ".\n");
		});
	}
	
	private LocalTime pegaVelocidadeMediaPorPiloto(PosicaoPiloto lista) {
		  long tempoEmNanoSegundo = lista.getSomaTempoVolta().toNanoOfDay();
		  return LocalTime.ofNanoOfDay(tempoEmNanoSegundo / (lista.getQuantidadeDeVolta()));
	}

}
