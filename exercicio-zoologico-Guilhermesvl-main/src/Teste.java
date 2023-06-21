public class Teste {
    public static void main(String[] args) throws Exception {
        Animal animal;

        animal = new Tigre("simba", "tigre", 4, "roar", "laranja");
        String nomeAnimal = animal.getNome();
        System.out.println(nomeAnimal);

        animal = new Tucano("araçari", "tucano", 2, "tri tri tri", true);
        String nomeTucano = animal.getNome();
        System.out.println(nomeTucano);

        exibirDescricaoCompleta(animal);

        animal = new Avestruz("Frank", "avestruz", 2, "aaahn", false);
        exibirDescricaoCompleta(animal);
    }
    
    public static void exibirDescricaoCompleta(Animal animal) {
        String resultado = animal.descricaoCompleta();
        System.out.println(resultado);
    }
}