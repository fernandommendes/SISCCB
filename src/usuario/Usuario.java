package usuario;

import utilitarios.Console;

public class Usuario {

	public static void main(String[] args) {
		menu();
		System.out.println("Programa Finalizado.");
	}

	private static void menu() {
		int opcao = 0;
		do {
			System.out.println("\nMenu SisPag");
			System.out.println("1-Incluir Conta");
			System.out.println("2-Consultar Conta pelo Número");
			System.out.println("3-Consultar Conta pelo Nome");
			System.out.println("4-Excluir conta pelo Número");
			System.out.println("5-Registrar deposito ou retirada");
			System.out.println("0-Sair");
			opcao = Console.readInt("Opção: ");
			switch (opcao) {
				case 1:
					incluirContaBancaria();
					break;
				case 2:
					consultarNum();
					break;
				case 3:
					consultarNome();
					break;
				case 4:
					excliurNum();
					break;					
				case 5:
					depoureti();
					break;					
				case 0:
					break;
	
				default:
					System.out.println("Opção inválida.");
					break;
			}
		} while (opcao!=0);
		
	}

	private static void depoureti() {
		// TODO Auto-generated method stub
		
	}

	private static void excliurNum() {
		// TODO Auto-generated method stub
		
	}

	private static void consultarNome() {
		// TODO Auto-generated method stub
		
	}

	private static void consultarNum() {
		// TODO Auto-generated method stub
		
	}

	private static void incluirContaBancaria() {
		// TODO Auto-generated method stub
		
	}

}
