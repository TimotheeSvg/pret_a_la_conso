package business;

import java.util.ArrayList;
import java.util.List;

public class Motif {

    private final long id;
    private String nom;
    private String description;
    private static long compteur = 0L;

    private List<Taux> taux;


    public Motif(String nom, String description) {
        this.taux = new ArrayList<>();
        this.nom = nom;
        this.description = description;
        this.id = ++compteur;
    }

    public void addTaux(Taux taux){
        this.taux.add(taux);
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Motif " + id + " : " + nom;
    }
}
