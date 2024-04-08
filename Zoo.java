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
    public String getNom(){return nom;}
    public boolean ajouterEnclos(Enclos[] lesEnclos){
        for (int i = 0; i < lesEnclos.length; i++){
            this.lesEnclos[i] = lesEnclos[i];
            this.nombreTotalAnimaux += lesEnclos[i].getNombreAnimaux();
        }
        return true;
    }
    public Visiteur retirerVisiteur(){

    }
    public void arriveeVisiteur(Visiteur visiteur){}
    public void ajouterGardien(Gardien gardien){
        int x = 0;
        Enclos[] enclosLibres = new Enclos[5];
        Enclos enclosChoisi;
        pileGardiens.ajouter(gardien);
        for(int i = 0; i < lesEnclos.length; i++){
            if(lesEnclos[i].getGardien() == null){
                enclosLibres[x] = lesEnclos[i];
                x++;
            }
        }
        enclosChoisi = enclosLibres[0];
        for (int i = 0; i < enclosLibres.length; i++){
            if(enclosLibres[i].getNombreAnimaux() > enclosLibres[i + 1].getNombreAnimaux()){
                enclosChoisi = enclosLibres[i + 1];
            }
        }
        enclosChoisi.setGardien(gardien);
    }
    public Gardien retirerGardien() {
        Gardien g = pileGardiens.getDernierGardien();
        boolean verifGardienActif = false;
            for(int i = 0; i < lesEnclos.length; i++){
                if(g == lesEnclos[i].getGardien()){
                    verifGardienActif = true;
                }
            }
             if ((g.getCompetence() - pileGardiens.pointCompetence()) < 20 || verifGardienActif) {
            System.out.println("On ne peut enlever le gardien" + g);
            return g;
        }
        pileGardiens.retirerDernier();
             System.out.println("On retire le dernier gardien arrive au zoo: " + g + "a ete retire");
                 return g;
    }
    public String toString(){}

    public File getFileVisiteurs() {
    }
}
