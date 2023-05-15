public class ContaBancaria {
    private double saldo;
    private double limite;
    private Cliente usuario;
    private int numeroConta;
    private static int nUltimaConta = 100;
    private static double taxaRendimento = 0.5;

    public ContaBancaria(Cliente usuario, double limiteConta) {
        saldo = 0.0;
        limite = limiteConta;
        this.usuario = usuario;
        numeroConta = ++nUltimaConta;
    }

    public ContaBancaria(Cliente usuario, double limiteConta, double saldoInicial) {
        saldo = saldoInicial;
        limite = limiteConta;
        this.usuario = usuario;
        numeroConta = ++nUltimaConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean sacar(double valorSaque) {
        if (valorSaque <= 0) {
            return false;
        } else {
            // Só realiza o saque se ainda estiver dentro do limite da conta
            if ((saldo - valorSaque) >= (-limite)) {
                saldo -= valorSaque;
                return true;
            }
        }
        return false;
    }

    public boolean depositar(double valorDeposito) {
        if (valorDeposito <= 0) {
            return false;
        } else {
            saldo += valorDeposito;
        }
        return true;
    }

    public int getnumeroConta() {
        return numeroConta;
    }

    public boolean transferencia(double valorTransferencia, ContaBancaria conta) {
        if (this.sacar(valorTransferencia)) { // Só permite a transferÊncia se o saque for executado
            conta.depositar(valorTransferencia);
            return true;
        } else {
            return false;
        }
    }

    public boolean render() {
        double rendimento = this.saldo * (taxaRendimento / 100);
        this.saldo += rendimento;
        return true;
    }

    public static boolean alterarRendimento(double novaTaxa) {
        taxaRendimento = novaTaxa;
        return true;
    }

    public String getNomeDono() {
        return this.usuario.getNome();
    }
}