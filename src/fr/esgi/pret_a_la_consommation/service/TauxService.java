package fr.esgi.pret_a_la_consommation.service;

import fr.esgi.pret_a_la_consommation.business.Duree;
import fr.esgi.pret_a_la_consommation.business.Pret;
import fr.esgi.pret_a_la_consommation.business.Taux;
import fr.esgi.pret_a_la_consommation.business.Motif;

import java.util.List;
/**
 Classe qui définit les méthodes pour gérer les taux associés aux prêts.
 */

public interface TauxService {
    /**
    Permet d'ajouter un taux pour un prêt.
    @param duree La durée du prêt.
    @param motif Le motif du prêt.
    @param valeur La valeur du taux.
    */
    Taux ajouterTaux(Duree duree, Motif motif, double valeur);

    /**
     Permet de récupérer tous les taux enregistrés.
     @return La liste de tous les taux.
     */
    List<Taux> recupererTauxs();

    /**
     Permet de récupérer un taux en particulier.
     @param id L'identifiant du taux.
     @return Le taux correspondant à l'identifiant.
     */
    Taux recupererTaux(Long id);

    /**
     Permet d'ajouter un nouveau prêt au système avec un taux spécifique associé.
     @param pret l'objet de type Pret qui contient les informations sur le prêt
     @param id l'identifiant du taux associé au prêt
     @return true si le prêt a été ajouté avec succès, false sinon.
     */
    boolean ajouterPret(Pret pret, Long id);
}
