package br.com.corrida.service.exibe.dados.corrida;

import java.util.List;

import br.com.corrida.domain.dados.piloto.DadosPiloto;
import br.com.corrida.domain.exibe.dados.corrida.ExibeDados;
import br.com.corrida.domain.posicao.piloto.PosicaoPiloto;

public class ExibeDadosDaCorrida {
	
	public void executa(List<DadosPiloto> listaDeDadosDoPiloto) {
		
		List<ExibeDados> listaExibeDados = new PegaListaParaExibirDados().executa(listaDeDadosDoPiloto);
		
		List<PosicaoPiloto> listaPosicaoPiloto = new ProcessaDadosParaExibir().executa(listaExibeDados);
		
		new ExibeResultado().executa(listaPosicaoPiloto);
		new ExibeInformacoes().executa(listaPosicaoPiloto);
		new ExibeMelhorVolta().executa(listaPosicaoPiloto);
	}

}
