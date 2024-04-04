public class Noeud {
    private Visiteur valeur;
    private Noeud suivant;
    public Noeud (Visiteur valeur){
        this.valeur = valeur;
        suivant = null;
    }
    public Visiteur getVisiteur(){return valeur;}
    public Noeud getProchain(){return suivant;}
    public void setProchain (Noeud prochain){
        suivant = prochain;
    }
    public String toString(){}
}
