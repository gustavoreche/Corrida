package br.com.corrida.domain.posicao.piloto;

import java.io.Serializable;
import java.time.LocalTime;

public class PosicaoPiloto  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int posicao;
	private int codigoPiloto;
	private LocalTime somaTempoVolta;
	private String nomePiloto;
	private int quantidadeDeVolta;
	private LocalTime tempoDaMelhorVolta;
	
	public int getPosicao() {
		return posicao;
	}
	
	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}
	
	public int getCodigoPiloto() {
		return codigoPiloto;
	}
	
	public void setCodigoPiloto(int codigoPiloto) {
		this.codigoPiloto = codigoPiloto;
	}

	public LocalTime getSomaTempoVolta() {
		return somaTempoVolta;
	}

	public void setSomaTempoVolta(LocalTime somaTempoVolta) {
		this.somaTempoVolta = somaTempoVolta;
	}

	public String getNomePiloto() {
		return nomePiloto;
	}

	public void setNomePiloto(String nomePiloto) {
		this.nomePiloto = nomePiloto;
	}

	public int getQuantidadeDeVolta() {
		return quantidadeDeVolta;
	}

	public void setQuantidadeDeVolta(int quantidadeDeVolta) {
		this.quantidadeDeVolta = quantidadeDeVolta;
	}
	
	public LocalTime getTempoDaMelhorVolta() {
		return tempoDaMelhorVolta;
	}

	public void setTempoDaMelhorVolta(LocalTime tempoDaMelhorVolta) {
		this.tempoDaMelhorVolta = tempoDaMelhorVolta;
	}
	
}
