import java.util.Arrays;

public class Zoo {
    private String nom;
    private int nombreEnclos;
    private Pile pileGardiens = new Pile();
    private File fileVisiteurs = new File();
    private Enclos[] lesEnclos = new Enclos[5];
    private int nombreTotalAnimaux;
    public Zoo(String nom){
        this.nom = nom;
    }
    public String getNom(){return nom;}
    public Enclos[] getEnclos(){return lesEnclos;}
    public boolean ajouterEnclos(Enclos[] lesEnclos){
        int scoreCompetence = 0;
        for (int i = 0; i < lesEnclos.length; i++) {
        scoreCompetence += lesEnclos[i].getGardien().getCompetence();
        }
        if(scoreCompetence >= 20) {
            for (int i = 0; i < lesEnclos.length; i++) {
                this.lesEnclos[i] = lesEnclos[i];
                this.nombreTotalAnimaux += lesEnclos[i].getNombreAnimaux();
                nombreEnclos++;
            }
            return true;
        }
        System.out.println("echec de l'ajout des enclos (competence des gardiens pas assez eleve!)");
        return false;
    }
    public Visiteur retirerVisiteur(){
        int verif = fileVisiteurs.supprimerAuDebut();
        if(verif != 0) {
            return fileVisiteurs.getPremier().getVisiteur();
        }
        return null;
    }
    public void arriveeVisiteur(Visiteur visiteur){ //probleme ici
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
            if(lesEnclos[i] != null) {
                if (lesEnclos[i].getGardien() == null) {
                    enclosLibres[x] = lesEnclos[i];
                    x++;
                }
            }
        }
        if(enclosLibres[0] != null) {
            enclosChoisi = enclosLibres[0];
            for (int i = 0; i < enclosLibres.length; i++) {
                if (enclosLibres[i].getNombreAnimaux() > enclosLibres[i + 1].getNombreAnimaux()) {
                    enclosChoisi = enclosLibres[i + 1];
                }
            }
            enclosChoisi.setGardien(gardien);
        }
    }
    public Gardien retirerGardien() {
        Gardien g = pileGardiens.getDernierGardien();
        boolean verifGardienActif = false;
        if (g != null) {
            for (int i = 0; i < lesEnclos.length; i++) {
                if (g == lesEnclos[i].getGardien()) {
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
        System.out.println("il n'y a pas de gardien dans la pile");
        return g;
    }
    public String toString(){
        return "voici la pile des gardiens:\n" + pileGardiens + "\n et la file des visiteurs:\n" + fileVisiteurs + "Le zoo est peuple avec " + nombreTotalAnimaux +
                " animaux. Il y a " + nombreEnclos + " enclos." + lesEnclos[0] + "\n" + lesEnclos[1] + "\n" + lesEnclos[2] + "\n" + lesEnclos[3] + "\n" + lesEnclos[4]; }

    public File getFileVisiteurs() {return fileVisiteurs;}
}
