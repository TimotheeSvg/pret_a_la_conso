package fr.esgi.pret_a_la_consommation.business.service;

import fr.esgi.pret_a_la_consommation.business.business.Mensualite;
import fr.esgi.pret_a_la_consommation.business.business.Pret;

import java.time.LocalDate;
import java.util.List;

public interface MensualiteService {
    Mensualite ajouterMensualite(LocalDate datePrelevement, double partCapitalRembourse, double partInteretsRembourses, Pret pret);
    List<Mensualite> recupererMensualites();
    Mensualite recupererMensualite(Long id);
    boolean supprimerMensualite(Long id);
    void trierMensualite();

}
