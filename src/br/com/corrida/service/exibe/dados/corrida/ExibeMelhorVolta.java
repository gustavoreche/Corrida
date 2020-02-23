package br.com.corrida.service.exibe.dados.corrida;

import java.util.Comparator;
import java.util.List;

import br.com.corrida.domain.posicao.piloto.PosicaoPiloto;

public class ExibeMelhorVolta {
	
	protected void executa(List<PosicaoPiloto> listaPosicaoPiloto) {
		PosicaoPiloto dadosDoPilotoDaMelhorVolta = listaPosicaoPiloto.stream().min(Comparator.comparing(PosicaoPiloto::getTempoDaMelhorVolta)).get();
		System.out.println("--------------------------------------------------------------------------\n"
				+ "--------------------------------------------------------------------------\n");
		System.out.println("TEMPO DA MELHOR VOLTA DA CORRIDA: " + dadosDoPilotoDaMelhorVolta.getTempoDaMelhorVolta() + ".\nPiloto: "
				+ dadosDoPilotoDaMelhorVolta.getCodigoPiloto() + " - " + dadosDoPilotoDaMelhorVolta.getNomePiloto());
	}

}
