package br.com.southsystem.SincronizacaoReceita.service;

public class ExtratoCSV {
	private String agencia;
	private String conta;
	private String saldo;
	private String status;
	private String resultado;
	
	public ExtratoCSV(String agencia, String conta, String saldo, String status, String resultado) {
		this.agencia = agencia;
		this.conta = conta;
		this.saldo = saldo;
		this.status = status;
		this.resultado = resultado;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public String getSaldo() {
		return saldo;
	}

	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
	
	
	

}
