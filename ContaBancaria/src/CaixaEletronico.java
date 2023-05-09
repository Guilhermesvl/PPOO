import java.util.Scanner;

public class CaixaEletronico {
    private ContaBancaria conta1;
    private ContaBancaria conta2;
    private Cliente usuario;
    private Cliente usuario2;

    private Scanner entrada = new Scanner(System.in);

    public void exibirMenu() {
        System.out.println("1)  Criar Conta");
        System.out.println("2)  Consultar Saldo");
        System.out.println("3)  Depositar");
        System.out.println("4)  Sacar");
        System.out.println("5)  Transferir");
        System.out.println("6)  Sair");
    }

    public void menu() {

        exibirMenu();

        int escolha = Integer.parseInt(entrada.nextLine());
        tratarMenu(escolha);

        while (escolha != 6) {

            exibirMenu();

            escolha = Integer.parseInt(entrada.nextLine());
            tratarMenu(escolha);

        }
        entrada.close();

    }

    public void tratarMenu(int escolha) {
        if (escolha == 1) {
            // Criando o primeiro cliente e a conta para ele
            System.out.println("Digite o nome do dono da conta: ");
            String nomeUsuario = entrada.nextLine();
            System.out.println("Digite o CPF do dono da conta: ");
            String cpfUsuario = entrada.nextLine();

            usuario = new Cliente(nomeUsuario, cpfUsuario);

            System.out.println("Digite qual o limite inicial deseja ter em sua conta: ");
            double limiteInicial = Double.parseDouble(entrada.nextLine());
            this.conta1 = new ContaBancaria(usuario, limiteInicial);
            System.out.println("Conta I criada com sucesso!");
            System.out.println("O número da sua conta é: " + conta1.getnumeroConta());

            // Criando a outra conta e a conta com escolha de limite para ele
            System.out.println("Digite o nome do dono da outra conta: ");
            String nomeUsuario2 = entrada.nextLine();
            System.out.println("Digite o CPF do dono da conta: ");
            String cpfUsuario2 = entrada.nextLine();

            usuario2 = new Cliente(nomeUsuario2, cpfUsuario2);

            System.out.println("Digite qual o limite inicial deseja ter em sua outra conta: ");
            double limiteInicial2 = Double.parseDouble(entrada.nextLine());

            System.out.println("Digite também qual o valor do saldo inicial: ");
            double saldoInicial = Double.parseDouble(entrada.nextLine());

            this.conta2 = new ContaBancaria(usuario2, limiteInicial2, saldoInicial);

            System.out.println("Conta II criada com sucesso!");
            System.out.println("O número da sua conta é: " + conta2.getnumeroConta());

        } else if (escolha == 2) {
            // Recebe o número da conta e trata em qual delas ocorrá a consulta
            System.out.println("Digite em qual conta deseja consultar o saldo: ");
            int numContaSaldo = Integer.parseInt(entrada.nextLine());

            if (numContaSaldo == conta1.getnumeroConta()) {
                System.out.println(usuario.getNome() + ", seu saldo atual é: " + conta1.getSaldo());
            } else {
                System.out.println(usuario2.getNome() + ", seu saldo atual é: " + conta2.getSaldo());
            }

        } else if (escolha == 3) {
            // Recebe o valor da conta e trata em qual delas ocorrerá o depósito
            System.out.println("Digite em qual conta deseja fazer o depósito: ");
            int numContaDeposito = Integer.parseInt(entrada.nextLine());

            System.out.println("Digite o valor que deseja depositar na conta " + numContaDeposito + ":");
            double valorDeposito = Double.parseDouble(entrada.nextLine());

            if (numContaDeposito == conta1.getnumeroConta()) {
                // Chama a função de depósito e já verifica se foi executada ou não
                if (conta1.depositar(valorDeposito)) {
                    System.out.println("Operação aprovada.");
                } else {
                    System.out.println("Operação recusada.");
                }
            } else {
                if (conta2.depositar(valorDeposito)) {
                    System.out.println("Operação aprovada.");
                } else {
                    System.out.println("Operação recusada");
                }
            }

        } else if (escolha == 4) {
            System.out.println("Digite em qual conta deseja fazer o saque: ");
            int numContaSaque = Integer.parseInt(entrada.nextLine());

            System.out.println("Digite qual o valor que deseja sacar da conta " + numContaSaque + ":");
            double valorSaque = Double.parseDouble(entrada.nextLine());

            if (numContaSaque == conta1.getnumeroConta()) {
                // Chama a função de sacar e já verifica se foi executada ou não
                if (conta1.sacar(valorSaque)) {
                    System.out.println("Operação aprovada.");
                } else {
                    System.out.println("Operação recusada");
                    System.out.println("Saldo Insuficiente");
                }
            } else {
                if (conta2.sacar(valorSaque)) {
                    System.out.println("Operação aprovada.");
                } else {
                    System.out.println("Operação recusada");
                    System.out.println("Saldo Insuficiente");
                }
            }

        } else if (escolha == 5) {
            System.out.println("Digite o número da conta que fará a transferência: ");
            int numContaTransferencia = Integer.parseInt(entrada.nextLine());
            System.out.println("Digite também o número da conta destino: ");
            int numContaDestino = Integer.parseInt(entrada.nextLine());
            System.out.println("Qual valor deseja transferir para a conta " + numContaDestino + "?");
            double valorTransferencia = Double.parseDouble(entrada.nextLine());

            // Verifica qual conta receberá a transferência
            if (conta1.getnumeroConta() == numContaDestino) {
                // Chama a função de transferencia e já verifica se foi executada ou não
                if (conta2.transferencia(valorTransferencia, conta1)) {
                    System.out.println("Operação realizada com sucesso");
                } else {
                    System.out.println("Operação recusada.");
                }

            } else {
                if (conta1.transferencia(valorTransferencia, conta2)) {
                    System.out.println("Operação realizada com sucesso");
                } else {
                    System.out.println("Operação recusada.");
                }
            }
        }
    }

}
