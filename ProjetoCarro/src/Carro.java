public class Carro{
    private String modelo;
    private int velocidade;

    public Carro(String modelo) {
        this.modelo = modelo;
        velocidade = 0;
    }

    public String getModelo(){
        return modelo;
    }

    public int getVelocidade(){
        return velocidade;
    }
    
    public void acelerar(){
        velocidade += 5;
    }

    public void reduzir(){
        velocidade -= 5;
    }

}