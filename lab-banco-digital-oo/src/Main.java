
public class Main {

	public static void main(String[] args) {
		Cliente lucas = new Cliente();
		lucas.setNome("Lucas");
		
		Conta cc = new ContaCorrente(lucas);
		Conta poupanca = new ContaPoupanca(lucas);

		cc.depositar(50);
		cc.transferir(25, poupanca);
		
		cc.imprimirExtrato();
		poupanca.imprimirExtrato();
	}

}
