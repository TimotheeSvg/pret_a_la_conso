package fr.esgi.pret_a_la_consommation.service;

import fr.esgi.pret_a_la_consommation.business.Pret;
import fr.esgi.pret_a_la_consommation.business.Mensualite;

import java.time.LocalDate;
import java.util.List;

/**
 Cette interface définit les méthodes pour gérer les mensualités d'un prêt à la consommation.
 */
public interface MensualiteService {
    /**
     Ajouter une mensualité.
     @param datePrelevement la date de prélèvement de la mensualité.
     @param partCapitalRembourse la part du capital remboursé dans cette mensualité.
     @param partInteretsRembourses la part des intérêts remboursés dans cette mensualité.
     @param pret le prêt associé à cette mensualité.
     @return la mensualité créée.
     */
    Mensualite ajouterMensualite(LocalDate datePrelevement, double partCapitalRembourse, double partInteretsRembourses, Pret pret);

    /**
     Récupérer la liste des mensualités.
     @return la liste des mensualités.
     */
    List<Mensualite> recupererMensualites();

    /**
     Récupérer une mensualité selon son identifiant.
     @param id l'identifiant de la mensualité à récupérer.
     @return la mensualité correspondant à l'identifiant.
     */
    Mensualite recupererMensualite(Long id);

}
