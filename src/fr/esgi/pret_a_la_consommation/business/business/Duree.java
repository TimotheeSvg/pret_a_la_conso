package fr.esgi.pret_a_la_consommation.business.business;

import java.util.ArrayList;
import java.util.List;

public class Duree {
    private final Long id;
    private int dureeEnMois;
    private static Long compteur = 0L;

    private List<Taux> taux;

    public Duree(int dureeEnMois){
        this.taux = new ArrayList<>();
        this.id = ++compteur;
        this.dureeEnMois = dureeEnMois;
    }

    public Long getId() {
        return id;
    }

    public int getDureeEnMois() {
        return dureeEnMois;
    }

    public void setDureeEnMois(int dureeEnMois) {
        this.dureeEnMois = dureeEnMois;
    }

    public static long getCompteur() {
        return compteur;
    }

    public static void setCompteur(long compteur) {
        Duree.compteur = compteur;
    }

    public List<Taux> getTaux() {
        return taux;
    }

    public void setTaux(List<Taux> taux) {
        this.taux = taux;
    }

    @Override
    public String toString() {
        return "id : " + id + " | duree "+dureeEnMois;
    }
}
