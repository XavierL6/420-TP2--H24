public class Zoo {
    private String nom;
    private int nombreEnclos;
    private Pile pileGardiens;
    private File fileVisiteurs;
    private Enclos[] lesEnclos = new Enclos[5];
    private int nombreTotalAnimaux;
    public Zoo(String nom){
        this.nom = nom;
    }
    public boolean ajouterEnclos(Enclos[] lesEnclos){}
    public Visiteur retirerVisiteur(){}
    public void arriveeVisiteur(Visiteur visiteur){}
    public void ajouterGardien(Gardien gardien){}
    public Gardien retirerGardien(){}
    public String toString(){}
}
