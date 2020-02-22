package br.com.corrida.service.exibe.dados.corrida;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import br.com.corrida.domain.dados.piloto.DadosPiloto;
import br.com.corrida.domain.exibe.dados.corrida.ExibeDados;
import br.com.corrida.domain.posicao.piloto.PosicaoPiloto;

public class ExibeDadosDaCorrida {
	
	public void executa(List<DadosPiloto> listaDeDadosDoPiloto) {
		
		Map<Integer, List<DadosPiloto>> listaNova = listaDeDadosDoPiloto.stream().collect(Collectors.groupingBy(DadosPiloto::getCodigoPiloto));
		System.out.println(listaNova);
		List<ExibeDados> listaExibeDados = new ArrayList<>();
		for (Entry<Integer, List<DadosPiloto>>  entry : listaNova.entrySet()) {
			int codigoDoPiloto = entry.getKey();
			 List<DadosPiloto> dadosDoPiloto = entry.getValue();
			 
			 ExibeDados exibeDados = new ExibeDados();
			 LocalTime somaDosTempos = null;
			 for (DadosPiloto dadosPiloto : dadosDoPiloto) {
				 LocalTime tempoVolta = dadosPiloto.getTempoVolta();
				 somaDosTempos = somaDosTempos == null ? tempoVolta : somaTempo(somaDosTempos, tempoVolta);					
			 }
			 exibeDados.setTempoSomado(somaDosTempos);
			 exibeDados.setCodigoPiloto(codigoDoPiloto);
			 exibeDados.setQuantidadeDeVolta(dadosDoPiloto.stream().map(DadosPiloto::getNumeroDaVolta).max(Comparator.naturalOrder()).get());
			 exibeDados.setNomePiloto(dadosDoPiloto.get(0).getNomePiloto());
			 listaExibeDados.add(exibeDados);
		}
		List<PosicaoPiloto> listaPosicaoPiloto = new ArrayList<>();
		
		do {
			ExibeDados exibe = new ExibeDados();
			LocalTime melhorTempo = null;
			int codigoPiloto = 0;
			for (ExibeDados exibeDados : listaExibeDados) {
				if(melhorTempo == null || (melhorTempo.isAfter(exibeDados.getTempoSomado()) && exibe.getQuantidadeDeVolta() >= exibe.getQuantidadeDeVolta())) {
					melhorTempo = exibeDados.getTempoSomado();
					codigoPiloto = exibeDados.getCodigoPiloto();
					exibe = exibeDados;
				}
			}
			PosicaoPiloto piloto = new PosicaoPiloto();
			piloto.setPosicao(listaPosicaoPiloto.size() + 1);
			piloto.setCodigoPiloto(codigoPiloto);
			piloto.setNomePiloto(exibe.getNomePiloto());
			piloto.setQuantidadeDeVolta(exibe.getQuantidadeDeVolta());
			piloto.setSomaTempoVolta(melhorTempo);
			listaPosicaoPiloto.add(piloto);
			listaExibeDados.remove(exibe);
		} while (listaExibeDados.size() != 0);
		
//		posicao de chegada
//		codigo do piloto
//		nome do piloto
//		qtd de volta completada
//		tempo total de prova
		System.out.println("RESULTADOS:");
		listaPosicaoPiloto.forEach(lista -> {
			System.out.println(lista.getPosicao() + "° - " + lista.getCodigoPiloto() + " - " + lista.getNomePiloto() + "\nQuantidade de Voltas "
					+ "Completadas: " + lista.getQuantidadeDeVolta() + ". Tempo total da prova: " + lista.getSomaTempoVolta());
		});
		
	}
	
	private LocalTime somaTempo(LocalTime somaDosTempos, LocalTime tempoASomar) {
		somaDosTempos = somaDosTempos.plusNanos(tempoASomar.getNano());
		somaDosTempos = somaDosTempos.plusSeconds(tempoASomar.getSecond());
		somaDosTempos = somaDosTempos.plusMinutes(tempoASomar.getMinute());
		somaDosTempos = somaDosTempos.plusHours(tempoASomar.getHour());
		return somaDosTempos;
	}
	
}
