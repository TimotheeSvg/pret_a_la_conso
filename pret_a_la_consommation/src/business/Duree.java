package business;

import java.util.List;
import java.util.ArrayList;
public class Duree {

    private final long id;
    private int dureeEnMois;
    private static long compteur = 0L;

    private List<Taux> taux;

    public Duree(int dureeEnMois){
        this.taux = new ArrayList<>();
        this.id = ++compteur;
        this.dureeEnMois = dureeEnMois;
    }

    public void addTaux(Taux taux){
        this.taux.add(taux);
    }

    public int getDureeEnMois() {
        return dureeEnMois;
    }

    public void setDureeEnMois(int dureeEnMois) {
        this.dureeEnMois = dureeEnMois;
    }

    @Override
    public String toString() {
        return "Duree "+ id +": "+dureeEnMois+ " mois nbr de lien : " + taux.size();
    }


}
