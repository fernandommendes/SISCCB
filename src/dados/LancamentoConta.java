package dados;

import java.util.GregorianCalendar;

import utilitarios.LtpUtil;

public class LancamentoConta {
	
	
	private GregorianCalendar dataLancamento;
	private int tipo;
	private double valor;
	public LancamentoConta(GregorianCalendar dataLancamento, int tipo, double valor) {
		
		this.dataLancamento = dataLancamento;
		this.tipo = tipo;
		this.valor = valor;
	}
	public GregorianCalendar getDataLancamento() {
		return dataLancamento;
	}
	public void setDataLancamento(GregorianCalendar dataLancamento) {
		this.dataLancamento = dataLancamento;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	@Override
	public String toString() {
		return "Lançamento da Conta: " + LtpUtil.formatarData(dataLancamento, "dd/MM/yyyy") + "\n" + 
				"Tipo: " + tipo + "\n" +
				"Valor:" + valor + "\n";
	}
	
	
	
	
}
