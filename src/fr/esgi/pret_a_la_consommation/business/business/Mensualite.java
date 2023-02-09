package fr.esgi.pret_a_la_consommation.business.business;

import java.time.LocalDate;

public class Mensualite {

    private final Long id;
    private final LocalDate datePrelevement;
    private final double partInteretsRembourses;
    private final double partCapitalRembourse;
    private static Long compteur = 0L;

    private Pret pret;


    public Mensualite(LocalDate datePrelevement, double partCapitalRembourse, double partInteretsRembourses, Pret pret){
        this.pret = pret;
        this.id = ++compteur;
        this.datePrelevement = datePrelevement;
        this.partCapitalRembourse = partCapitalRembourse;
        this.partInteretsRembourses = partInteretsRembourses;

    }

    public Long getId() {
        return id;
    }

    public LocalDate getDatePrelevement() {
        return datePrelevement;
    }

    public double getPartInteretsRembourses() {
        return partInteretsRembourses;
    }

    public double getPartCapitalRembourse() {
        return partCapitalRembourse;
    }

    public static long getCompteur() {
        return compteur;
    }

    public static void setCompteur(long compteur) {
        Mensualite.compteur = compteur;
    }

    public Pret getPret() {
        return pret;
    }

    public void setPret(Pret pret) {
        this.pret = pret;
    }

    @Override
    public String toString() {
        return "datePrelevement : " + datePrelevement + " | partInteretsRembourses: " + partInteretsRembourses + " | partCapitalRembourse: " + partCapitalRembourse;
    }
}
