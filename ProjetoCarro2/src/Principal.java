import java.util.Scanner;

public class Principal {
    Carro []carros;         //Declarando o vetor de carros

    public Principal() {
        carros = new Carro[5];      //Instanciando o vetor de objetos
    }

    public void executar() {

        //Menu
        Scanner entrada = new Scanner(System.in);

        System.out.println("1)  Criar o carro");
        System.out.println("2)  Acelerar o carro");
        System.out.println("3)  Reduzir a velocidade");
        System.out.println("4)  Exibir os dados do carro");
        System.out.println("5)  Sair");

        int escolha = Integer.parseInt(entrada.nextLine());
        int indice = 0;      //índice do vetor

        while (escolha != 5) {
            if (escolha == 1) {
                if (indice < carros.length) {   //Verifica se ainda há espaço no vetor
                    System.out.println("Digite o modelo do carro que deseja criar: ");
                    String modelo = entrada.nextLine(); 
                
                    //Cria e adiciona um novo objeto de acordo com os índices disponíveis
                    Carro carro = new Carro(modelo);        
                    carros[indice] = carro;
                    indice++;   
                    
                } else {
                    System.out.println("Não é possível criar mais carros :( ");
                }

            }else if (escolha == 2) {
                System.out.println("Qual modelo de carro deseja acelerar? ");
                String modeloAcelerar = entrada.nextLine();
                
                for (int i = 0; i < carros.length; i++) {
                    if (carros[i].getModelo().equals(modeloAcelerar)) {
                        carros[i].acelerar();
                        System.out.println(carros[i].getModelo() + " acelerado :) ");
                   } 
                }
                
            }else if (escolha == 3) {
                System.out.println("Qual modelo de carro deseja reduzir: ");
                String modeloReduzir = entrada.nextLine();
                
                for (int i = 0; i < carros.length; i++) {
                    if (carros[i].getModelo().equals(modeloReduzir)) {
                        carros[i].reduzir();
                        System.out.println(carros[i].getModelo() + " reduzido :( ");
                    } 
                }
                
            }else if (escolha == 4) {
                for (int i = 0; i < carros.length; i++) {
                    System.out.println();
                    System.out.println(carros[i].getModelo() + " " + carros[i].getVelocidade());
                    System.out.println();
                }
                
            }
            
            System.out.println("1)  Criar o carro");
            System.out.println("2)  Acelerar o carro");
            System.out.println("3)  Reduzir a velocidade");
            System.out.println("4)  Exibir os dados do carro");
            System.out.println("5)  Sair");

            escolha = Integer.parseInt(entrada.nextLine());
 
        }
            
    }
            
}
