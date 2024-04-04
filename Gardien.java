public class Gardien {
    private String nom;
    private int competence;
    private int id;
    public Gardien(String nom, int competence){
        this.nom = nom;
        this.competence = competence;
    }
    public void entrainerAnimal(Animal animal, double temps){
        if(temps < 10){
            animal.setPoids((animal.getPoids() * 1.01));
        }
        else if(temps >= 10 && temps <= 30){
            animal.setPoids((animal.getPoids() * 0.98));
        }
        else{
            animal.setPoids((animal.getPoids() * 0.95));
        }
    }
    public String toString(){
        return "[" + nom + " (" + id + "), " + competence + "]";
    }
}
