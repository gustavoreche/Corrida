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

public class PegaListaParaExibirDados {
	
	protected List<ExibeDados> executa(List<DadosPiloto> listaDeDadosDoPiloto) {
		Map<Integer, List<DadosPiloto>> listaAgrupadaPorCodigoDoPiloto = listaDeDadosDoPiloto.stream().collect(Collectors.groupingBy(DadosPiloto::getCodigoPiloto));
		List<ExibeDados> listaExibeDados = new ArrayList<>();
		for (Entry<Integer, List<DadosPiloto>>  entry : listaAgrupadaPorCodigoDoPiloto.entrySet()) {
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
			 exibeDados.setTempoDaMelhorVolta(dadosDoPiloto.stream().map(DadosPiloto::getTempoVolta).min(Comparator.naturalOrder()).get());
			 listaExibeDados.add(exibeDados);
		}
		return listaExibeDados;
	}
	
	private LocalTime somaTempo(LocalTime somaDosTempos, LocalTime tempoASomar) {
		  long somaDosTemposEmNanoSegundo = somaDosTempos.toNanoOfDay();
		  long tempoASomarEmNanoSegundo = tempoASomar.toNanoOfDay();
		  return LocalTime.ofNanoOfDay(somaDosTemposEmNanoSegundo + tempoASomarEmNanoSegundo);
	}

}
