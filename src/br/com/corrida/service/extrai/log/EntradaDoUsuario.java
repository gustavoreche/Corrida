package br.com.corrida.service.extrai.log;

import java.util.Scanner;

public class EntradaDoUsuario {
	
	private static final String ENTRADA_DO_USUARIO = "DIGITE O NOME DO ARQUIVO DE LOG. EX: teste.log OU DIGITE SAIR: ";
	
	public String executa() {
		@SuppressWarnings("resource")
		Scanner entradaUsuario = new Scanner(System.in);
		System.out.println("");
		System.out.print(ENTRADA_DO_USUARIO);
		return entradaUsuario.nextLine();
	}

}
