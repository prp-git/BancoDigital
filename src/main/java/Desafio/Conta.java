package Desafio;

import excecaoModelo.excecaoDominio;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @EqualsAndHashCode

public abstract class Conta implements IConta {

	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	
	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;

	}

	double LIMITE_SAQUE_POUPANÇA = 10000.00;

	public void sacar(double valor) {
		Object CPClasse = new ContaPoupanca(null).getClass();
		if (saldo < valor) {
			throw new excecaoDominio("Saldo insuficiente!");
		}
		//Verificar se a conta é POUPANCA e aplica o limite de saque da mesma
		else if (this.getClass() == CPClasse && valor > LIMITE_SAQUE_POUPANÇA) { 
			throw new excecaoDominio("Limite de saque superado!");
		} else
		saldo -= valor;
		}
	 

	public void depositar(double valor) {
		saldo += valor;
	}

	public void transferir(double valor, IConta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
}
