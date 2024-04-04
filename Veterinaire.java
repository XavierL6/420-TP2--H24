public class Veterinaire {
    private String nom;
    private Classe specialite;
    public Veterinaire(String nom, Classe specialite){
        this.nom = nom;
        this.specialite = specialite;
    }
    public void soignerAnimal(Animal animal){
        animal.calculBesoinAlimentaire();
    }
    public String toString(){
        return "[" + nom + ", " + specialite + "]";
    }
}
