package br.com.corrida.domain.exibe.dados.corrida;

import java.io.Serializable;
import java.time.LocalTime;

public class ExibeDados implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int codigoPiloto;
	private LocalTime tempoSomado;
	private int quantidadeDeVolta;
	private String nomePiloto;
	
	public int getCodigoPiloto() {
		return codigoPiloto;
	}
	
	public void setCodigoPiloto(int codigoPiloto) {
		this.codigoPiloto = codigoPiloto;
	}
	
	public LocalTime getTempoSomado() {
		return tempoSomado;
	}
	
	public void setTempoSomado(LocalTime tempoSomado) {
		this.tempoSomado = tempoSomado;
	}

	public int getQuantidadeDeVolta() {
		return quantidadeDeVolta;
	}

	public void setQuantidadeDeVolta(int quantidadeDeVolta) {
		this.quantidadeDeVolta = quantidadeDeVolta;
	}

	public String getNomePiloto() {
		return nomePiloto;
	}

	public void setNomePiloto(String nomePiloto) {
		this.nomePiloto = nomePiloto;
	}
	
}
