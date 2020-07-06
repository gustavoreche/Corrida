package br.com.corrida.service.extrai.log;

import java.io.File;
import java.io.IOException;

public class PegaDiretorioAtual {
	
	private static final String ERRO_DIRETORIO_ATUAL = "Erro para localizar diretorio atual.";
	
	public String executa() {
		String diretorioQueDeveSerGravado = "";
		try {
			diretorioQueDeveSerGravado = new File(".").getCanonicalPath();
		} catch (IOException e2) {
			System.err.println(ERRO_DIRETORIO_ATUAL);
			return null;
		}
		return diretorioQueDeveSerGravado;
	}

}
