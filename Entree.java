import java.util.Arrays;

public class Entree {
    private int nombreEnclos;
    private Enclos[] lesEnclos;
    private int prix;
    public Entree(Visiteur visiteur, Zoo zoo){

    }
    public double getPrix(){return prix;}
    public int getNombreEnclos(){return nombreEnclos;}
    public Enclos[] getEnclos(){return lesEnclos;}
    public void afficherEnclos(){
        System.out.println("Ce billet permettra de visiter les " + nombreEnclos + "enclos suivants: " + Arrays.toString(lesEnclos));
    }
}
