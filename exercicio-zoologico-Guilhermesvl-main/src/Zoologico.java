import java.util.ArrayList;

public class Zoologico {
    /* (PARTE 1)
     * /private ArrayList<Chipanze> chipanzes;
     * private ArrayList<Avestruz> avestruzes;
     * private ArrayList<Tigre> tigres;
     * private ArrayList<Tucano> tucanos;
     * 
     * public Zoologico () {
     * chipanzes = new ArrayList<>();
     * avestruzes = new ArrayList<>();
     * tigres = new ArrayList<>();
     * tucanos = new ArrayList<>();
     * }
     * 
     * public void adicionarChipanze(String nome, String especie, int qntPatas,
     * String somCaracteristico, String corPelo) {
     * Chipanze chipanze = new Chipanze(nome, especie, qntPatas,
     * somCaracteristico, corPelo);
     * chipanzes.add(chipanze);
     * 
     * }
     * 
     * public void adicionarAvestruz(String nome, String especie, int qntPatas,
     * String somCaracteristico, boolean voaBemMal ) {
     * Avestruz avestruz = new Avestruz(nome, especie, qntPatas, somCaracteristico, voaBemMal);
     * avestruzes.add(avestruz);
     * }
     * 
     * public void adicionarTigre(String nome, String especie, int qntPatas,
     * String somCaracteristico, String corPelo) {
     * Tigre tigre = new Tigre(nome, especie, qntPatas, somCaracteristico, corPelo);
     * tigres.add(tigre);
     * }
     * 
     * public void adicionarTucano(String nome, String especie, int qntPatas,
     * String somCaracteristico, boolean voaBemMal) {
     * Tucano tucano = new Tucano(nome, especie, qntPatas, somCaracteristico,
     * voaBemMal);
     * tucanos.add(tucano);
     * }
     * 
     * public String obterDescricaoCompleta(String nome) {
     * for (Chipanze i : chipanzes) {
     * if(i.getNome().equalsIgnoreCase(nome)) {
     * return i.descricaoCompleta();
     * }
     * }
     * 
     * for (Avestruz i : avestruzes) {
     * if (i.getNome().equalsIgnoreCase(nome)) {
     * return i.descricaoCompleta();
     * }
     * }
     * 
     * for (Tigre i : tigres) {
     * if (i.getNome().equalsIgnoreCase(nome)) {
     * return i.descricaoCompleta();
     * }
     * }
     * 
     * for (Tucano i : tucanos) {
     * if (i.getNome().equalsIgnoreCase(nome)) {
     * return i.descricaoCompleta();
     * }
     * }
     * 
     * return "Animal não encontrado";
     * }
     * 
     * public void listarDescricaoResumida() {
     * for (Chipanze i : chipanzes) {
     * System.out.println(i.descricao());
     * }
     * 
     * for (Avestruz i : avestruzes) {
     * System.out.println(i.descricao());
     * }
     * 
     * for (Tigre i : tigres) {
     * System.out.println(i.descricao());
     * }
     * 
     * for (Tucano i : tucanos) {
     * System.out.println(i.descricao());
     * }
     * }
     * 
     * public void listarDescricaoCompleta() {
     * for (Chipanze i : chipanzes) {
     * System.out.println(i.descricaoCompleta());
     * }
     * 
     * for (Avestruz i : avestruzes) {
     * System.out.println(i.descricaoCompleta());
     * }
     * 
     * for (Tigre i : tigres) {
     * System.out.println(i.descricaoCompleta());
     * }
     * 
     * for (Tucano i : tucanos) {
     * System.out.println(i.descricaoCompleta());
     * }
     * }
     */
    
    //(PARTE 3)
    private ArrayList<Animal> animais;

    public Zoologico() {
        animais = new ArrayList<>();
    }

    public void adicionarChipanze(String nome, String especie, int qntPatas,
            String somCaracteristico, String corPelo) {

        Chipanze chipanze = new Chipanze(nome, especie, qntPatas,
                somCaracteristico, corPelo);

        animais.add(chipanze);

    }

    public void adicionarAvestruz(String nome, String especie, int qntPatas, String somCaracteristico, boolean voaBemMal) {
            Avestruz avestruz = new Avestruz(nome, especie, qntPatas, somCaracteristico, voaBemMal);
        
        animais.add(avestruz);
    }

    public void adicionarTigre(String nome, String especie, int qntPatas,
            String somCaracteristico, String corPelo) {
        
                Tigre tigre = new Tigre(nome, especie, qntPatas, somCaracteristico, corPelo);
        animais.add(tigre);
    }

    public void adicionarTucano(String nome, String especie, int qntPatas,
            String somCaracteristico, boolean voaBemMal) {

        Tucano tucano = new Tucano(nome, especie, qntPatas, somCaracteristico, voaBemMal);
        animais.add(tucano);
    }

    public String obterDescricaoCompleta(String nome) {
        for (Animal i : animais) {
            if (i.getNome().equalsIgnoreCase(nome)) {
                return i.descricaoCompleta();
            }
        }
        return "Animal não encontrado";
    }

    public void listarDescricaoResumida() {
        for (Animal i : animais) {
            System.out.println(i.descricao());
        }
    }

    public void listarDescricaoCompleta() {
        for (Animal i : animais) {
            System.out.println(i.descricaoCompleta());
        }
    }
       
}
