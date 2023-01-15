package business;

import java.time.LocalDate;

public class Mensualite {
    private final long id;
    private final LocalDate datePrelevement;
    private final double partInteretsRembourses;
    private final double partCapitalRembourse;
    private static long compteur = 0L;

    private Pret pret;


    public Mensualite(LocalDate datePrelevement, double partCapitalRembourse, double partInteretsRembourses, Pret pret){
        this.pret = pret;
        this.id = ++compteur;
        this.datePrelevement = datePrelevement;
        this.partCapitalRembourse =partCapitalRembourse;
        this.partInteretsRembourses = partInteretsRembourses;

    }

    @Override
    public String toString(){
        return id + " Date : " + datePrelevement + " capital R : " + partCapitalRembourse + " interet R : " + partInteretsRembourses + " \n";
    }


}
