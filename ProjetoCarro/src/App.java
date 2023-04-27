import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        

        Scanner entrada = new Scanner(System.in);

        String modeloCarro = entrada.nextLine();
        int quantVelocidade = Integer.parseInt(entrada.nextLine());

        Carro carro1 = new Carro(modeloCarro);

        for (int i = 0; i < quantVelocidade; i++) {
            carro1.acelerar();
        }
        
        System.out.println(carro1.getModelo());
        System.out.println(carro1.getVelocidade());
        

        

    }

}