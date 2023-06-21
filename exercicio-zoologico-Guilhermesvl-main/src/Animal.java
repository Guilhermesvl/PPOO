public class Animal {
    private String nome;
    private String especie;
    int qntPatas;
    String somCaracteristico;

    public Animal(String nome, String especie, int qntPatas, String somCaracteristico) {
        this.nome = nome;
        this.especie = especie;
        this.qntPatas = qntPatas;
        this.somCaracteristico = somCaracteristico;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecie() {
        return especie;
    }

    public int getQntPatas() {
        return qntPatas;
    }

    public String getSomCaracteristico() {
        return somCaracteristico;
    }

    public String descricao() {
        String descricaoPequena = this.getNome() + " é um(a) " + this.getEspecie();
        return descricaoPequena;
    }

    public String descricaoCompleta() {
        String descricaoGrande = this.getNome() + " é um(a) " + this.getEspecie() 
        + " que faz " + this.getSomCaracteristico(); 
        return descricaoGrande;
    }

}