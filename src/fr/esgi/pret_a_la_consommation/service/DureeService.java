package fr.esgi.pret_a_la_consommation.service;

import fr.esgi.pret_a_la_consommation.business.Duree;
import fr.esgi.pret_a_la_consommation.business.Taux;

import java.util.List;

/**
 Interface pour les services liés à la gestion des durées de prêts.
 */

public interface DureeService {

    /**

     Ajouter une durée en mois.
     @param dureeEnMois la durée en mois à ajouter.
     @return la durée ajoutée.
     */
    Duree ajouterDuree(int dureeEnMois);

    /**
     Récupérer toutes les durées.
     @return la liste de toutes les durées.
     */
    List<Duree> recupererDurees();

    /**
     Récupérer une durée en fonction de son identifiant.
     @param id l'identifiant de la durée à récupérer.
     @return la durée correspondante.
     */
    Duree recupererDuree(Long id);

    /**
     Ajouter un taux pour une durée.
     @param taux le taux à ajouter.
     @param id l'identifiant de la durée pour laquelle ajouter le taux.
     @return true si l'ajout a été effectué avec succès, false sinon.
     */
    boolean ajouterTaux(Taux taux, Long id);
}
