package dados;

import java.util.ArrayList;

import erros.ContaException;
import utilitarios.Console;
import utilitarios.LtpUtil;

public class ContaBancaria {

	//CONSTANTES
	public static final int CONTA_BANCARIA_COMUM = 1;
	public static final int CONTA_BANCARIA_ESPECIAL = 2;
	public static final int DEPOSITO = 10;
	public static final int RETIRADA = 20;
	
	// ATRIBUTOS
	private static int seq = 0;
	
	private int numConta;
	private String nome;
	private double saldo;
	private ArrayList<LancamentoConta> listaLancametno = new ArrayList<LancamentoConta>();
	
	
	public ContaBancaria(String nome, double saldo) {
		
		numConta = ++seq;
		this.nome = nome;
		this.saldo = saldo;
		this.listaLancametno = listaLancametno;
	}


	public static int getSeq() {
		return seq;
	}


	public static void setSeq(int seq) {
		ContaBancaria.seq = seq;
	}


	public int getNumConta() {
		return numConta;
	}


	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public double getSaldo() {
		return saldo;
	}


	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}


	public ArrayList<LancamentoConta> getListaLancametno() {
		return listaLancametno;
	}


	public void setListaLancametno(ArrayList<LancamentoConta> listaLancametno) {
		this.listaLancametno = listaLancametno;
	}
	
	void sacar (LancamentoConta obj) throws ContaException {
		double valor = Console.readDouble("Digite o valor a sacar: ");
		
		saldo -= valor;
		if(saldo < 0){
			throw new ContaException("Não é possivel sacar este valor. Saldo negativo");
		}else listaLancametno.add(obj);
	}
	
	void depositar (LancamentoConta obj){
		double valor = Console.readDouble("Digite o valor a sacar: ");
		
		saldo += valor;
		listaLancametno.add(obj);
	}

	public int getTipoConta(){
		return CONTA_BANCARIA_COMUM;
	}
	

	@Override
	public String toString() {
		return "Conta Bancaria: " + numConta +"\n" +
				"Nome: " + nome + "\n" +
				"Saldo: " + saldo + "\n";
	}
	
	public class ContaEspecial{
		
		private double limiteSaldoNegativo;

		public ContaEspecial(double limiteSaldoNegativo) {
			super();
			this.limiteSaldoNegativo = limiteSaldoNegativo;
		}

		public double getLimiteSaldoNegativo() {
			return limiteSaldoNegativo;
		}

		public void setLimiteSaldoNegativo(double limiteSaldoNegativo) {
			this.limiteSaldoNegativo = limiteSaldoNegativo;
		}
		
		void sacar (LancamentoConta obj) throws ContaException {
			double valor = Console.readDouble("Digite o valor a sacar: ");
			//double limite = Console.readDouble("Digite o limite do saldo negativo: ");
			
			saldo -= valor;
			if(saldo < limiteSaldoNegativo){
				throw new ContaException("Valor do saque ultrapassa o limite");
			}else listaLancametno.add(obj);			
		}
		
		public int getTipoConta(){
			return CONTA_BANCARIA_ESPECIAL;
		}

		@Override
		public String toString() {
			return "Conta Bancaria:" + limiteSaldoNegativo;
		}		
		
	}
	
}
