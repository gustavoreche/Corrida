package br.com.corrida.service.exibe.dados.corrida;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import br.com.corrida.domain.exibe.dados.corrida.ExibeDados;
import br.com.corrida.domain.posicao.piloto.PosicaoPiloto;

public class ProcessaDadosParaExibir {
	
	protected List<PosicaoPiloto> executa(List<ExibeDados> listaExibeDados) {
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
			piloto.setTempoDaMelhorVolta(exibe.getTempoDaMelhorVolta());
			listaPosicaoPiloto.add(piloto);
			listaExibeDados.remove(exibe);
		} while (listaExibeDados.size() != 0);
		return listaPosicaoPiloto;
	}

}
