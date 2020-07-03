package br.com.corrida.service.extrai.log;

public class SaidaDoSistema {
	
	private static final int SIM = 1;
	private static final int NAO = 0;
	
	private static final String SAIR = "sair";
	
	public boolean executa(String nomeArquivoDeLog) {
		int saiDoSistema = nomeArquivoDeLog.equalsIgnoreCase(SAIR) ? SIM : NAO;
		return saiDoSistema == SIM;
	}
	
	public static String getSair() {
		return SAIR;
	}

}
