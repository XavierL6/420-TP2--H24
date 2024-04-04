import java.util.Objects;

public class Animal {
    private String nom;
    private String regimeAlimentaire;
    private double poids;
    private Classe classe;
    private String espece;
    private double besoinAlimentaire;

    public Animal(String nom, String regimeAlimentaire, double poids, Classe classe, String espece){
        this.nom = nom;
        this.regimeAlimentaire = regimeAlimentaire;
        this.poids = poids;
        this.classe = classe;
        this.espece = espece;
    }
    public String getEspece(){return espece;}
    public void calculBesoinAlimentaire(){
        if(regimeAlimentaire.equals("carnivore")){
            this.besoinAlimentaire = poids * 0.05;
        }
        else if (regimeAlimentaire.equals("herbivore")) {
            this.besoinAlimentaire = poids * 0.03;
        }
        else if (regimeAlimentaire.equals("omnivore")) {
            this.besoinAlimentaire = poids * 0.02;
        }
        else if (regimeAlimentaire.equals("piscivore")){
            this.besoinAlimentaire = poids * 0.01;
        }

    }
    public double getPoids(){return poids;}
    public void setPoids(double poid){this.poids = poid;}
    public double getBesoinAlimentaire(){return besoinAlimentaire;}
    public String toString(){
        return "le " + espece + " nomme " + nom + " pese " + poids + " kg et son besoin alimentaire " + regimeAlimentaire + " de " + besoinAlimentaire + " kg.";
    }
}
