package cadastro;

import java.util.HashMap;

import utilitarios.Console;
import utilitarios.LtpUtil;
import dados.ContaBancaria;
import erros.ContaException;


public class CadastroContas {

	public static HashMap<Integer, ContaBancaria> listaContas = new HashMap<Integer, ContaBancaria>();
	
	static void contaNum () throws ContaException{
		int num = Console.readInt("Número da Conta: ");
		if(listaContas.containsKey(num)){
			System.out.println(listaContas.get(num).toString());
		} else {
			throw new ContaException("Não existe conta para o número.");
		}
	}
	
	public void incluirConta (ContaBancaria obj){
		String nome;
		double saldo;
		int tipo = 0;
		
		//nome
		while (true) {
			nome = Console.readLine("Nome: ").trim();
			if (nome.equals("") || LtpUtil.contarPalavras(nome)==1) {
				System.out.println("Nome Inválido.");
			} else break;
		}
		//tipo conta
		while (true) {
			tipo = Console.readInt("Tipo (Comun-1,Especial-2 ): ");
			if (tipo < 1 || tipo > 2) {
				System.out.println("Tipo de conta inválido.");
			} else break;
		}
		
		try {
			if (tipo == ContaBancaria.CONTA_BANCARIA_COMUM) {
				while (true){
					saldo = Console.readDouble("Saldo: ");
					if (saldo < 0){
						System.out.println("Saldo da conta inválido.");
					}else break;
				}
			} else {
				while (true) {
					double limite=Console.readDouble("Limite de saldo negativo: ");
					saldo = Console.readDouble("Saldo: ");
					if (saldo < limite) {
						System.out.println("Valor hora inválido.");
					}else break;
				}
			}
			//new ContaBancaria(nome, saldo, new contaEspecial (limite));
			System.out.println("Conta cadastrada.");
		} catch (ContaException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
}
