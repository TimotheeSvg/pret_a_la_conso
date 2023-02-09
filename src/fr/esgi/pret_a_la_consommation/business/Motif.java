package fr.esgi.pret_a_la_consommation.business;

import java.util.ArrayList;
import java.util.List;

public class Motif {
    private final Long id;
    private String nom;
    private String description;
    private static Long compteur = 0L;

    private List<Taux> taux;


    public Motif(String nom, String description) {
        this.taux = new ArrayList<>();
        this.nom = nom;
        this.description = description;
        this.id = ++compteur;
    }

    public Long getId() {
        return id;
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

    public static long getCompteur() {
        return compteur;
    }

    public static void setCompteur(long compteur) {
        Motif.compteur = compteur;
    }

    public List<Taux> getTaux() {
        return taux;
    }

    public void setTaux(List<Taux> taux) {
        this.taux = taux;
    }

    @Override
    public String toString() {
        return "id " + id + " | nom : " + nom  + " | description : " + description;
    }
}
