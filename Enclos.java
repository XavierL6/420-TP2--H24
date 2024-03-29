public class Enclos {
    private String nom;
    private int nombreAnimaux;
    private int capaciteMax;
    private Animal[] animaux;
    private Veterinaire veterianire;
    private Gardien gardien;
    public Enclos(String nom, int capaciteMax, Veterinaire veterianire, Gardien gardien){
        this.nom = nom;
        this.capaciteMax = capaciteMax;
        this.veterianire = veterianire;
        this.gardien = gardien;
    }
    public Gardien getGardien(){return gardien;}
}
