import java.util.Arrays;

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
        int scoreCompetence = 0;
        for (int i = 0; i < lesEnclos.length; i++) {
        scoreCompetence += lesEnclos[i].getGardien().getCompetence();
        }
        if(scoreCompetence >= 20) {
            for (int i = 0; i < lesEnclos.length; i++) {
                this.lesEnclos[i] = lesEnclos[i];
                this.nombreTotalAnimaux += lesEnclos[i].getNombreAnimaux();
            }
            return true;
        }
        System.out.println("echec de l'ajout des enclos (competence des gardiens pas assez eleve!)");
        return false;
    }
    public Visiteur retirerVisiteur(){
        fileVisiteurs.supprimerAuDebut();
        return fileVisiteurs.getPremier().getVisiteur();
    }
    public void arriveeVisiteur(Visiteur visiteur){
        if(fileVisiteurs.getNbElements() != 0) {
            if (visiteur.getAge() >= 65) {
                for (int i = 0; i < fileVisiteurs.getNbElements(); i++) {
                    if(fileVisiteurs.getValeur(i).getAge() >= 65){
                        fileVisiteurs.insererAuMilieu(i + 1, visiteur);
                    }
                }
            }
        }
        else{
            fileVisiteurs.insererALaFin(visiteur);
        }
    }
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
    public String toString(){
        return "voici la pile des gardiens:\n" + pileGardiens + "et la file des visiteurs:\n" + fileVisiteurs + "Le zoo est peuple avec" + nombreTotalAnimaux +
                "animaux. Il y a " + nombreEnclos + " enclos." + lesEnclos; }

    public File getFileVisiteurs() {return fileVisiteurs;}
}
