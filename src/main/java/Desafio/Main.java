package Desafio;
import excecaoModelo.excecaoDominio;

public class Main {

	public static void main(String[] args) {
		
		try {
			System.out.println("=======Conta Poupanca (Exemplo)===========");
			Cliente roberto = new Cliente();
			Conta cp3 = new ContaPoupanca(roberto);
			roberto.setNome("Roberto");
			cp3.depositar(90000);
			cp3.imprimirExtrato();
			cp3.sacar(10000);
			cp3.imprimirExtrato();
			
			System.out.println("=======Conta Corrente (Exemplo)===========");
			Cliente paulo = new Cliente();
			Conta cc1 = new ContaCorrente(paulo, true, 2000.0);
			paulo.setNome("Paulo");
			cc1.imprimirExtrato();
			cc1.depositar(10000);
			cc1.imprimirExtrato();
			cc1.sacar(12000);
			cc1.imprimirExtrato();
//			
		}
		catch (excecaoDominio e) {
			System.out.println("Operação negada: " + e.getMessage());
		}
		System.out.println("FIM!");
	}
}
