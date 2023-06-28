import java.util.Scanner;

/*
 * Classe que trata a interface com o usuário (menu de opções)
 */
public class InterfaceUsuario {

    // Scanner para obter dados do usuário via terminal
    private Scanner entrada;
    private Zoologico zoologico;

    /* 
     * Construtor da classe
     */
    public InterfaceUsuario() {
        entrada = new Scanner(System.in);
        zoologico = new Zoologico();
    }

    /*
     * Método que trata o loop de exibição e tratamento do menu
     */
    public void executar() {
        int opcao;
        do {
            exibirMenu();
            
            System.out.println("\nDigite sua opção: ");
            opcao = Integer.parseInt(entrada.nextLine());

            tratarMenu(opcao);

        } while (opcao != 5);

        // fecha o objeto Scanner para liberar os seus recursos
        entrada.close();
    }

    /*
     * Método que exibe as opções de menu
     */
    public void exibirMenu() {
        System.out.println("1 - Cadastrar animal");
        System.out.println("2 - Descrever animal");
        System.out.println("3 - Listar animais");        
        System.out.println("4 - Listar animais completo");
        System.out.println("5 - Sair");
    }

    /*
     * Método que trata uma opção de menu escolhida pelo usuário
     */
    private void tratarMenu(int opcao) {
        switch (opcao) {
            case 1:
                cadastrarAnimal();
                break;
            case 2:
                descreverAnimal();
                break;
            case 3:
                listarAnimais();
                break;
            case 4:
                listarAnimaisCompleto();
                break;
            case 5:
                System.out.println("Saindo do programa...");
                break;
            default:
                System.out.println("Opção inválida!");
                break;
        }

        // se o usuário não estiver saindo do programa, pede para ele digitar ENTER antes de exibir o menu novamente
        if (opcao != 5) {
            System.out.println("\nDigite ENTER para continuar!");
            entrada.nextLine();
        }
    }

    /*
     * Método auxiliar que obtém uma String do usuário
     */
    private String pedirString(String instrucao) {
        System.out.print(instrucao + ": ");
        String informacao = entrada.nextLine();
        return informacao;
    }

    /*
     * Trata a opção de menu: Cadastrar Animal
     */
    private void cadastrarAnimal() {
        // implemente seu código aqui.
        String nome = pedirString("Digite o nome do animal");
        String especie = pedirString("Digite a espécie do animal");
        int qntPatas = Integer.parseInt(pedirString("Digite a quantidade de patas que o animal possui"));
        String somCaracteristico = pedirString("Digite o som característico do animal");
        String pergunta;
        boolean voa;


        if (especie.equalsIgnoreCase("chipanzé")) {
            String cor = pedirString("Digite a cor do pelo do Chipanzé");
            zoologico.adicionarChipanze(nome, especie, qntPatas, somCaracteristico, cor);
        } else if (especie.equalsIgnoreCase("avestruz")) {
             pergunta = pedirString("O animal voa bem? (sim/não)");
             voa =  trataBooleano(pergunta);
            zoologico.adicionarAvestruz(nome, especie, qntPatas, somCaracteristico, voa);
        } else if (especie.equalsIgnoreCase("tigre")){
            String cor = pedirString("Digite a cor do pelo do Tigre");
            zoologico.adicionarTigre(nome, especie, qntPatas, somCaracteristico, cor);
        } else if (especie.equalsIgnoreCase("tucano")) {
             pergunta = pedirString("O animal voa bem? (sim/não)");
             voa =  trataBooleano(pergunta);
            zoologico.adicionarTucano(nome, especie, qntPatas, somCaracteristico, voa);
        }
    
    }

    private boolean trataBooleano(String pergunta) {
        return pergunta.equalsIgnoreCase("sim");    //Retorna True se for sim
    }

    /*
     * Trata a opção de menu: Descrever Animal
     */
    private void descreverAnimal() {
        // implemente seu código aqui.
        String nome = pedirString("Digite o nome do animal para descrição");
        String descricao = zoologico.obterDescricaoCompleta(nome);
        System.out.println(descricao);
    }

    /*
     * Trata a opção de menu: Listar Animais
     */
    private void listarAnimais() {
        // implemente seu código aqui.
        zoologico.listarDescricaoResumida();
    }

    /*
     * Trata a opção de menu: Listar Animais
     */
    private void listarAnimaisCompleto() {
        // implemente seu código aqui.
        zoologico.listarDescricaoCompleta();
    }
}