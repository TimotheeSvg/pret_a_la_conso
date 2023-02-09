package fr.esgi.pret_a_la_consommation.business.business;

import java.util.ArrayList;
import java.util.List;

public class Taux {

    private final Long id;
    private double valeur;
    private static Long compteur = 0L;
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

    public Long getId() {
        return id;
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }

    public static long getCompteur() {
        return compteur;
    }

    public static void setCompteur(long compteur) {
        Taux.compteur = compteur;
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

    public List<Pret> getPrets() {
        return prets;
    }

    public void setPrets(List<Pret> prets) {
        this.prets = prets;
    }

    @Override
    public String toString() {
        return "id " + id + " | valeur " + valeur * 100 + " | duree " + duree.getDureeEnMois() + " | motif :" + motif.getNom();
    }
}
