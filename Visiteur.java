public class Visiteur {
    private String nom;
    private int age;
    private int nombreAnimaux;
    private String[] especes;
    public Visiteur(String nom, int age, String[] especes){
        this.nom = nom;
        this.age = age;
        especes = new String[especes.length];
        for(int i = 0 ; i < especes.length; i++){
            this.especes[i] = especes[i];
        }
    }
    public String[] getEspeces(){return especes;}
    public void entrerDansZoo(Zoo zoo){
    System.out.println("[" + nom + ", " + age + "]" + "entre dans le zoo '" + zoo.getNom() + "'.");
    }
    public void entrerDansEnclo(Enclos enclo){
        System.out.println("[" + nom + ", " + age + "]" + "entre dans l'enclos" + "'" + enclo.getNom() + "'.");
    }
    public void quitterZoo(){
        System.out.println("[" + nom + ", " + age + "]" + "quitte le zoo.");
    }
    public void quitterEnclo(){
        System.out.println("[" + nom + ", " + age + "]" + "quitte l'enclos.");
    }
    public String toString(){
        return "[" + nom + ", " + age + "]";
    }
}
