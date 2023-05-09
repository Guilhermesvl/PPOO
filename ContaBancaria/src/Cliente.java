public class Cliente {
    private String nome;
    private String cpf;

    public Cliente(String nomeUsuario, String cpfUsuario) {
        nome = nomeUsuario;
        cpf = cpfUsuario;
    }

    public String getNome() {
        return nome;
    }

    public String getCPF() {
        return cpf;
    }

}
