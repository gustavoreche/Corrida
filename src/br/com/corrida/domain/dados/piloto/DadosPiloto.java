package br.com.corrida.domain.dados.piloto;

import java.io.Serializable;
import java.time.LocalTime;

public class DadosPiloto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private LocalTime hora;
	private int codigoPiloto;
	private String nomePiloto;
	private int numeroDaVolta;
	private LocalTime tempoVolta;
	private double velocidadeMediaDaVolta;
	
	public LocalTime getHora() {
		return hora;
	}
	
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	
	public int getCodigoPiloto() {
		return codigoPiloto;
	}
	
	public void setCodigoPiloto(int codigoPiloto) {
		this.codigoPiloto = codigoPiloto;
	}
	
	public String getNomePiloto() {
		return nomePiloto;
	}
	
	public void setNomePiloto(String nomePiloto) {
		this.nomePiloto = nomePiloto;
	}
	
	public int getNumeroDaVolta() {
		return numeroDaVolta;
	}
	
	public void setNumeroDaVolta(int numeroDaVolta) {
		this.numeroDaVolta = numeroDaVolta;
	}
	
	public LocalTime getTempoVolta() {
		return tempoVolta;
	}

	public void setTempoVolta(LocalTime tempoVolta) {
		this.tempoVolta = tempoVolta;
	}

	public double getVelocidadeMediaDaVolta() {
		return velocidadeMediaDaVolta;
	}
	
	public void setVelocidadeMediaDaVolta(double velocidadeMediaDaVolta) {
		this.velocidadeMediaDaVolta = velocidadeMediaDaVolta;
	}
	
}
