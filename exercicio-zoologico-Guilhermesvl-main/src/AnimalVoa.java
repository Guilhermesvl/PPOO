public class AnimalVoa extends Animal{
    private boolean voaBemMal;
    
    public AnimalVoa(String nome, String especie, int qntPatas, 
    String somCaracteristico, boolean voaBemMal) {

        super(nome, especie, qntPatas, somCaracteristico);
        this.voaBemMal = voaBemMal;
    }

    public boolean getVoaBem() {
        return voaBemMal;
    }

    @Override
    public String descricaoCompleta() {
        String bemMal = voaBemMal ? "bem" : "mal";  //variável que armazena "bem" ou "mal" em relação ao animal que voa
        String descricaoCompletaVoa = super.descricaoCompleta() + " e voa " + bemMal; 

        return descricaoCompletaVoa;
    }
}
