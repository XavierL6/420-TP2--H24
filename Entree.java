import java.util.Arrays;

public class Entree {
    private int nombreEnclos;
    private Enclos[] lesEnclos;
    private int prix;
    public Entree(Visiteur visiteur, Zoo zoo){
        int peutVisite = 0;
            String[] especes = new String[visiteur.getEspeces().length];
            for(int i = 0; i < especes.length; i++){
                especes[i] = visiteur.getEspeces()[i];
            }
            String[] zooEspeces = new String[zoo.getEnclos().length];
            for(int i = 0; i < zooEspeces.length; i++){
                for(int f = 0; f < zoo.getEnclos()[i].getNombreAnimaux(); f++) {
                    zooEspeces[i] = zoo.getEnclos()[i].getAnimaux()[f].getEspece();
                }
            }
        for (int i = 0; i < especes.length; i++) {
            for (int x = 0; x < zooEspeces.length; i++){
                if(especes[i].equals(zooEspeces[x])){
                    peutVisite++;
                }
            }
        }
        if(visiteur.getAge() < 12){
            this.prix = 0;
        }
        else if(visiteur.getAge() > 13 && visiteur.getAge() < 17 || visiteur.getAge() > 65){
           this.prix = 5 * peutVisite;
        }
        else {
            this.prix = 10 * peutVisite;
        }
    }
    public double getPrix(){return prix;}
    public int getNombreEnclos(){return nombreEnclos;}
    public Enclos[] getEnclos(){return lesEnclos;}
    public void afficherEnclos(){
        System.out.println("Ce billet permettra de visiter les " + nombreEnclos + "enclos suivants: " + Arrays.toString(lesEnclos));
    }
}
