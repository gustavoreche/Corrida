package br.com.corrida.service.exibe.dados.corrida;

import java.time.LocalTime;
import java.util.List;

import br.com.corrida.domain.posicao.piloto.PosicaoPiloto;

public class ExibeResultado {

	protected void executa(List<PosicaoPiloto> listaPosicaoPiloto) {
		System.out.println("--------------------------------------------------------------------------\n"
				+ "--------------------------------------------------------------------------\n");
		System.out.println("RESULTADOS:\n");
		listaPosicaoPiloto.forEach(lista -> {
			System.out.println(lista.getPosicao() + "° Colocado = " + lista.getCodigoPiloto() + " - " + 
					lista.getNomePiloto() + "\nQuantidade de Voltas Completadas: " + lista.getQuantidadeDeVolta() + 
					". Tempo total da prova: " + lista.getSomaTempoVolta() + "\n" + 
					"Tempo para chegar ao 1° Colocado: " + pegaTempoQueFaltaParaChegarNoPrimeiroColocado(lista, listaPosicaoPiloto) + ".\n");
		});
	}
	
	private LocalTime pegaTempoQueFaltaParaChegarNoPrimeiroColocado(PosicaoPiloto lista, List<PosicaoPiloto> listaCompleta) {
		  long tempoTotalDaProvaEmNanoSegundoDoPilotoAtual = lista.getSomaTempoVolta().toNanoOfDay();
		  long tempoTotalDaProvaEmNanoSegundoDoPilotoPrimeiroColocado = listaCompleta.get(0).getSomaTempoVolta().toNanoOfDay();
		  return LocalTime.ofNanoOfDay(tempoTotalDaProvaEmNanoSegundoDoPilotoAtual - tempoTotalDaProvaEmNanoSegundoDoPilotoPrimeiroColocado);
	}
	
}
