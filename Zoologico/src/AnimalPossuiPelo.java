public class AnimalPossuiPelo extends Animal {
    private String corPelo;
    
    public AnimalPossuiPelo(String nome, String especie, int qntPatas, 
    String somCaracteristico, String corPelo) {

        super(nome, especie, qntPatas, somCaracteristico);
        this.corPelo = corPelo;
    }

    public String getCorPelo() {
        return corPelo;
    }

    @Override
    public String descricaoCompleta() {
        String descricaoCompletaPelo = super.descricaoCompleta() + 
        " e tem pelo " + this.getCorPelo() ; 
        
        return descricaoCompletaPelo;
    }
}

