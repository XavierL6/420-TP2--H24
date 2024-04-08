public class Enclos {
    private String nom;
    private int nombreAnimaux;
    private int capaciteMax;
    private Animal[] lesAnimaux;
    private Veterinaire veterianire;
    private Gardien gardien;
    public Enclos(String nom, int capaciteMax, Veterinaire veterianire, Gardien gardien){
        this.nom = nom;
        this.capaciteMax = capaciteMax;
        this.veterianire = veterianire;
        this.gardien = gardien;
    }
    public Gardien getGardien(){return gardien;}
    public Veterinaire getVeterinaire(){return veterianire;}
    public void ajouterAnimaux(Animal[] lesAnimaux){
        for(int i = 0; i < lesAnimaux.length; i++){
            for(int x = 0; x < this.lesAnimaux.length; x++){
                if(this.lesAnimaux[x] == null){
                    this.lesAnimaux[x] = lesAnimaux[i];
                }
            }
        }
    }
    public int getNombreAnimaux() {return nombreAnimaux;}
    public Animal[] getAnimaux(){return lesAnimaux;}
    public String getNom(){return nom;}
    public void setGardien(Gardien g){gardien = g;}
    public String toString(){
        return "L'enclos '" + nom + "' est peuple avec " + nombreAnimaux + ". Sa capacite est de " +
                capaciteMax + " animaux. Le veterinaire assigne est " + veterianire + ". Le gardien actuel est " + gardien
                + ". \nLes animaux dans cet enclos: "; // a finir
    }
}
