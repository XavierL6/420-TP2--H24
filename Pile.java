public class Pile {
    private final int TAILLE_INITIALE = 4;
    private final int RATIO_AGREANDISSEMENT = 2;
    private final int capacite = 8;
    private Gardien[] lesGardiens = new Gardien[capacite];
    private int nbElements;
    public int ajouter(Gardien gard){
        for(int i = 0; i < lesGardiens.length; i++){
            if(lesGardiens[i] == null){
                lesGardiens[i] = gard;
                return nbElements++;
            }
        }
        lesGardiens[lesGardiens.length - 1] = gard;
        return nbElements++;
    }
    public Gardien getDernierGardien(){
        if(lesGardiens[0] != null) {
            for (int i = 0; i < lesGardiens.length; i++) {
                if (lesGardiens[i] == null) {
                    return lesGardiens[--i];
                }
            }
            return lesGardiens[lesGardiens.length - 1];
        }
        return null;
    }
    public int pointCompetence(){
        int competence = 0;
        for (int i = 0; i < lesGardiens.length; i++){
            if (lesGardiens[i] != null) {
                competence += lesGardiens[i].getCompetence();
            }
        }
        return competence;
    }
    public int retirerDernier() {
        if (lesGardiens[0] != null) {
            for (int i = 0; i < lesGardiens.length; i++) {
                if (lesGardiens[i] == null) {
                    lesGardiens[i] = null;
                    return nbElements--;
                }
            }
            lesGardiens[lesGardiens.length - 1] = null;
            return nbElements--;
        }
    return -1;
    }
    public String toString(){
        return lesGardiens[0] + "->" + lesGardiens[1] + "->" + lesGardiens[2];
    }
}
