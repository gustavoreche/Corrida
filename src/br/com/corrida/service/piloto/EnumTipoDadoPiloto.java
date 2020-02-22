package br.com.corrida.service.piloto;

public enum EnumTipoDadoPiloto {
	
	CODIGO(1, "Código do piloto"),
	NOME(2, "Nome do piloto"),
	ERRO(1000, "Erro"),
	;
	
	private int id;
	private String descricao;
	
	private EnumTipoDadoPiloto(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

	public static EnumTipoDadoPiloto pegaDado(int contadorDeDadosEncontradosNoLog) {
		for (EnumTipoDadoPiloto dadosDoPiloto : EnumTipoDadoPiloto.values()) {
			if(dadosDoPiloto.getId() == contadorDeDadosEncontradosNoLog) {
				return dadosDoPiloto;
			}
		}
		return EnumTipoDadoPiloto.ERRO;
	}
	

}
