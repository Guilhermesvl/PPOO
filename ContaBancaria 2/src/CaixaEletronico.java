import java.util.Scanner;
import java.util.ArrayList;

public class CaixaEletronico {
    private ArrayList<ContaBancaria> contas;
    private Cliente usuario;
    private Scanner entrada;
    private ContaBancaria conta;
    private ContaBancaria contaD;   //Objetos auxiliares
    private ContaBancaria contaO;   //para facilitar a transferencia 

    public CaixaEletronico() {
        contas = new ArrayList<ContaBancaria>();
        usuario = null;
        entrada = new Scanner(System.in);
        conta = null;
        contaD = null;  
        contaO = null;
    }

    public void exibirMenu() {
        System.out.println();
        System.out.println("*********************************************");
        System.out.println("1)  Criar Conta");
        System.out.println("2)  Consultar Saldo");
        System.out.println("3)  Depositar");
        System.out.println("4)  Sacar");
        System.out.println("5)  Transferir");
        System.out.println("6)  Render");
        System.out.println("7)  Alterar taxa de rendimento");
        System.out.println("8)  Listar todas as contas criadas");
        System.out.println("9)  Remover conta");
        System.out.println("10) Buscar contas");
        System.out.println("11) Sair");
        System.out.println("*********************************************");
        System.out.println();
    }

    public void menu() {

        exibirMenu();

        int escolha = Integer.parseInt(entrada.nextLine());
        tratarMenu(escolha);

        while (escolha != 11) {

            exibirMenu();

            escolha = Integer.parseInt(entrada.nextLine());
            tratarMenu(escolha);

        }
        entrada.close();
    }

    public void tratarMenu(int escolha) {        
        if (escolha == 1) {
            // Criando o primeiro cliente e a conta para ele
            System.out.println("Digite quantas contas deseja criar: ");
            int quantContas = Integer.parseInt(entrada.nextLine());

            for (int i = 0; i < quantContas; i++) {
                System.out.println("Digite o nome do dono da conta: ");
                String nomeUsuario = entrada.nextLine();
                System.out.println("Digite o CPF do dono da conta: ");
                String cpfUsuario = entrada.nextLine();
                usuario = new Cliente(nomeUsuario, cpfUsuario);

                System.out.println("Digite qual o limite inicial deseja ter em sua conta: ");
                double limiteInicial = Double.parseDouble(entrada.nextLine());

                System.out.println("Deseja acrescentar saldo inicial? S/N");
                String desejo = entrada.nextLine();

                if (desejo.equals("S")) {
                    System.out.println("Digite qual o valor do saldo inicial: ");
                    double saldoInicial = Double.parseDouble(entrada.nextLine());
                    conta = new ContaBancaria(usuario, limiteInicial, saldoInicial);
                } else {
                    conta = new ContaBancaria(usuario, limiteInicial);
                }

                contas.add(conta);
                System.out.println("Conta criada com sucesso!");
                int numero = conta.getnumeroConta();
                System.out.println("Seu número é: " + numero);
            }

        } else if (escolha == 2) {
            // Recebe o número da conta e trata em qual delas ocorrá a consulta
            System.out.println("Digite em qual conta deseja consultar o saldo: ");
            int numContaSaldo = Integer.parseInt(entrada.nextLine());
            boolean encontradoSaldo = false;

            for (ContaBancaria conta : contas) {
                if (conta.getnumeroConta() == numContaSaldo) {
                    System.out.println(conta.getNomeDono() + ", seu saldo atual é: " + conta.getSaldo());
                    encontradoSaldo = true;
                }
            }

            // Informar que a conta não foi encontrada para realizar a consulta do saldo
            if (!encontradoSaldo) {
                System.out.println("Conta não encontrada");
            }

        } else if (escolha == 3) {
            // Recebe o valor da conta e trata em qual delas ocorrerá o depósito
            System.out.println("Digite em qual conta deseja fazer o depósito: ");
            int numContaDeposito = Integer.parseInt(entrada.nextLine());
            boolean encontradoDeposito = false;

            System.out.println("Digite o valor que deseja depositar na conta " + numContaDeposito + ":");
            double valorDeposito = Double.parseDouble(entrada.nextLine());

            for (ContaBancaria conta : contas) {
                if (conta.getnumeroConta() == numContaDeposito) {
                    if (conta.depositar(valorDeposito)) {
                        System.out.println("Operação aprovada.");
                        encontradoDeposito = true;
                    }
                }

            }
            // Informar que a conta não foi encontrada para realizar o depósito
            if (!encontradoDeposito) {
                System.out.println("Conta não encontrada");
            }

        } else if (escolha == 4) {
            System.out.println("Digite em qual conta deseja fazer o saque: ");
            int numContaSaque = Integer.parseInt(entrada.nextLine());
            boolean sacou = false;

            System.out.println("Digite qual o valor que deseja sacar da conta " + numContaSaque + ":");
            double valorSaque = Double.parseDouble(entrada.nextLine());

            for (ContaBancaria conta : contas) {
                if (conta.getnumeroConta() == numContaSaque) {
                    if (conta.sacar(valorSaque)) {
                        System.out.println("Operação aprovada.");
                        sacou = true;
                    }
                }
            }
            // Informar que não foi possível realizar o saque
            if (!sacou) {
                System.out.println("Operação recusada");
                System.out.println("Saldo Insuficiente");
            }

        } else if (escolha == 5) {
            System.out.println("Digite o número da conta que fará a transferência: ");
            int numContaTransferencia = Integer.parseInt(entrada.nextLine());
            System.out.println("Digite também o número da conta destino: ");
            int numContaDestino = Integer.parseInt(entrada.nextLine());
            System.out.println("Qual valor deseja transferir para a conta " + numContaDestino + "?");
            double valorTransferencia = Double.parseDouble(entrada.nextLine());
            boolean transferiu = false;

            // Atribui as contas de destino e transferencia para objetos auxiliares, 
            //  caso forem encontrados
            for (ContaBancaria conta : contas) {
                if (conta.getnumeroConta() == numContaDestino) {
                    contaD = conta;
                }
                if (conta.getnumeroConta() == numContaTransferencia) {
                    contaO = conta;
                }     
            }

            if (contaO != null && contaD!= null){
            // Chama a função de transferencia e já verifica se foi executada ou não
                if (contaO.transferencia(valorTransferencia, contaD)) {
                        System.out.println("Operação realizada com sucesso");
                        transferiu = true;
                    }
            }      
            if (!transferiu) {
                System.out.println("Operação recusada.");
            }

        } else if (escolha == 6) {
            boolean rendeu = false;
            for (ContaBancaria conta : contas) {
                if (conta.render()) {
                    rendeu = true;
                }
            }
            if (!rendeu) {
                System.out.print("Operação recusada");
            } else {
                System.out.println("Contas rendidas");
            }

        } else if (escolha == 7) {
            System.out.println("Digite o valor da nova taxa de rendimento: ");
            double novaTaxa = Double.parseDouble(entrada.nextLine());

            if (ContaBancaria.alterarRendimento(novaTaxa)) {
                System.out.println("Operação aprovada");
            } else {
                System.out.println("Operação recusada");
            }

        } else if (escolha == 8) {
            for (ContaBancaria conta : contas) {
                String nome = conta.getNomeDono();
                int n = conta.getnumeroConta();
                System.out.println(n + " " + nome);
            }
        } else if (escolha == 9) {
            System.out.println("Digite o número da conta que deseja excluir: ");
            int numContaExcluir = Integer.parseInt(entrada.nextLine());

            for (int i = 0; i < contas.size(); i++) {
                ContaBancaria conta = contas.get(i);
                if ((conta.getnumeroConta() == numContaExcluir) && (conta.getSaldo() == 0)) {
                    contas.remove(i);
                    System.out.println("Conta removida com sucesso");
                    break;
                } else if ((conta.getnumeroConta() == numContaExcluir) && (conta.getSaldo() > 0)) {
                    System.out.println("Não é possível cancelar contas com saldo disponível");
                } else if ((conta.getnumeroConta() == numContaExcluir) && (conta.getSaldo() < 0)) {
                    System.out.println("Não é possível cancelar contas em débito");
                }
            }
        } else if (escolha == 10) {
            System.out.println("Digite o nome ou parte do nome que deseja fazer a busca");
            String nomeBusca = entrada.nextLine();
            boolean encontrado = false;

            for (ContaBancaria conta : contas) {
                String nome = conta.getNomeDono();
                if (nome.contains(nomeBusca)) {
                    int n = conta.getnumeroConta();
                    System.out.println(n + " " + nome);
                    encontrado = true;
                }
            } 
            if(!encontrado) {
                System.out.println("Não foi encontrado nenhum cliente de nome: " + nomeBusca);
            }
        }
    }
}

// Dúvidas:
// O que fazer com o usuário 2
// O que está errado com o método de transferencia
// Como corrigir a escolha 8 que está imprimindo o mesmo nome para todos os
// objetos já criados
