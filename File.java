public class File {
    private Noeud premier;
    private int nbElements;
    public boolean estVide(){
        return premier == null;
    }
    public int insererALaFin(Visiteur v){
        Noeud nouveau = new Noeud(v);
        if(premier == null){
            nouveau.setProchain(premier);
            premier = nouveau;
            return ++nbElements;
        }
         Noeud courant = premier;
        for(courant=premier;courant.prochain!=null;courant=courant.prochain){

        }
    }
    public String toString(){
        return nbElements + " Visiteurs: " ;
    }
}
