package fr.esgi.pret_a_la_consommation.service;

import fr.esgi.pret_a_la_consommation.business.Pret;
import fr.esgi.pret_a_la_consommation.business.Mensualite;

import java.time.LocalDate;
import java.util.List;

public interface MensualiteService {
    Mensualite ajouterMensualite(LocalDate datePrelevement, double partCapitalRembourse, double partInteretsRembourses, Pret pret);
    List<Mensualite> recupererMensualites();
    Mensualite recupererMensualite(Long id);

}
