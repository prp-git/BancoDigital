package Desafio;
import excecaoModelo.excecaoDominio;

public class ContaCorrente extends Conta {

	private Boolean chequeespecial;

	private Double limiteespecial;

	double limiteSaque = 20000.00;

	public ContaCorrente(Cliente cliente) {
		super(cliente);
	}

	public ContaCorrente(Cliente cliente, Boolean chequeespecial, Double limiteespecial) {
		super(cliente);
		this.chequeespecial = chequeespecial;
		this.limiteespecial = limiteespecial;
	}

	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Corrente ===");
		super.imprimirInfosComuns();
	}

	public Boolean getChequeespecial() {
		return chequeespecial;
	}

	@Override
	public void sacar(double valor) {
		// Verifica se valor sacado é coberto pelo saldo + limite do cheque especial definido na abertura da conta
		Double saldoDisponivel = this.saldo + limiteespecial;
		if (valor > saldoDisponivel) {
			throw new excecaoDominio("Saldo disponível insuficiente");
		}
		// Verifica se valor sacado está abaixo do limite de saque padrao do banco (20.000)
		else if (valor > limiteSaque) {
			throw new excecaoDominio("Limite de saque superado!");
		}
		else {
			saldo -= valor;
		} 
	}

}
