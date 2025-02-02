public class File {
    private Noeud premier;
    private int nbElements;
    public boolean estVide(){
        if (nbElements == 0){
            return true;
        }
        return false;
    }
    public int insererALaFin(Visiteur v){
        Noeud nouveau = new Noeud(v);
        if(premier == null){
            nouveau.setProchain(premier);
            premier = nouveau;
            return ++nbElements;
        }
         Noeud courant = premier;
        for(courant=premier;courant.getProchain()!=null;courant=courant.getProchain()){
            courant = courant.getProchain();
        }
        courant.setProchain(nouveau);
        return nbElements++;
    }
    public Visiteur getValeur(int index) {
        Noeud n = getNoeud(index);
        if (n != null)
            return n.getValeur();
        else
            return null;
    }
    private Noeud getNoeud(int index) {
        if (index < 0 || index >= nbElements)
            return null; // On retourne null si l'index est invalide

        Noeud courant = premier;
        while (index-- != 0)
            courant = courant.suivant;
        return courant;
    }
    public int supprimerAuDebut() {
        if (nbElements == 0) {
            return 0;
        }
        if (nbElements == 1) {
            premier = null;
        }
        else {
            premier = premier.suivant;
        }
        return --nbElements;
    }
    public int insererAuMilieu(int index, Visiteur v) {
        if (index == 0)
            return insererAuDebut(v);
        else if (index == nbElements)
            return insererALaFin(v);
        Noeud avant = getNoeud(index - 1);
        if (avant == null)
            return 0;
        Noeud apres = avant.suivant;
        Noeud nouveau = new Noeud(v);
        avant.setProchain(nouveau);
        nouveau.setProchain(apres);
        return ++nbElements;
    }
    public int insererAuDebut(Visiteur v) {
        Noeud nouv = new Noeud(v);
        nouv.setProchain(premier);
        premier = nouv;
        return ++nbElements;
    }
    public Noeud getPremier(){return premier;}
    public int getNbElements(){return nbElements;}
    public String toString(){
        return nbElements + " Visiteurs: " ;
    }
}
