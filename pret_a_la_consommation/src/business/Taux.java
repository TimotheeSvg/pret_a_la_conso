package business;

import java.util.ArrayList;
import java.util.List;

public class Taux {

    private final long id;
    private double valeur;
    private static long compteur = 0L;
    private Duree duree;
    private Motif motif;

    private List<Pret> prets;

    public Taux(Duree duree, Motif motif, double valeur){
        this.prets = new ArrayList<>();

        this.id = ++compteur;
        this.duree = duree;
        this.motif = motif;
        this.valeur = valeur;
    }

    public void addPret(Pret pret){
        this.prets.add(pret);
    }


    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }

    public Duree getDuree() {
        return duree;
    }

    public void setDuree(Duree duree) {
        this.duree = duree;
    }

    public Motif getMotif() {
        return motif;
    }

    public void setMotif(Motif motif) {
        this.motif = motif;
    }

    public void printInfoPret(){
        for(Pret pret: prets){
            System.out.println("Pret : " + pret.getId());
        }
    }
    @Override
    public String toString() {

        return valeur*100 + " % sur " + duree.getDureeEnMois() + " mois pour " +motif.getDescription();
    }
}
