import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Variáveis
        int numero;
        String agencia;
        String nomeCliente;
        double saldo;

        //Solicitando os dados do usuário

        // Conta
        System.out.println("Por favor, insira o número da conta");
        numero = scanner.nextInt();
        scanner.nextLine();

        //Agência
        System.out.println("Por favor, digite o número da Agência!");
        agencia = scanner.nextLine();

        //Nome
        System.out.println("Por favor, digite o seu Nome!");
        nomeCliente = scanner.nextLine();

        //Saldo
        System.out.println("Por favor, digite o Saldo!");
        saldo = scanner.nextDouble();

        // Fechando o scanner para evitar vazamento de recursos
        scanner.close();

        // Exibindo a mensagem final com os dados inseridos
        System.out.println("Olá " + nomeCliente + ", obrigado por criar uma conta em nosso banco, " +
                "sua agência é " + agencia + ", conta " + numero + " e seu saldo " +
                saldo + " já está disponível para saque");

    }
}