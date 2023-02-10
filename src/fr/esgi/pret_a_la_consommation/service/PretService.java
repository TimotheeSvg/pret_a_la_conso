package fr.esgi.pret_a_la_consommation.service;

import fr.esgi.pret_a_la_consommation.business.Client;
import fr.esgi.pret_a_la_consommation.business.Pret;
import fr.esgi.pret_a_la_consommation.business.Taux;

import java.time.LocalDateTime;
import java.util.List;

/**
 Interface PretService qui définit les méthodes pour gérer les prêts.
 */

public interface PretService {
    /**
     Ajouter un nouveau prêt.
     @param montantDemande Montant demandé pour le prêt.
     @param dateSouscription Date de souscription du prêt.
     @param taux Taux associé au prêt.
     @param client Client ayant souscrit le prêt.
     @return Le nouveau prêt ajouté.
     */

    Pret ajouterPret(double montantDemande, LocalDateTime dateSouscription, Taux taux, Client client);
    /**
     Récupérer tous les prêts.
     @return La liste de tous les prêts.
     */
    List<Pret> recupererPrets();
    /**
     Récupérer un prêt en fonction de son identifiant.
     @param id Identifiant du prêt.
     @return Le prêt associé à l'identifiant.
     */
    Pret recupererPret(Long id);

    /**
     Afficher les mensualités d'un prêt.
     @param id Identifiant du prêt.
     */
    void afficherPretMensualite(Long id);

    /**
     Trier les prêts par ordre croissant de montant.
     @return La liste de prêts triée par ordre croissant de montant.
     */
    List<Pret> trierPretMontantCroissant();

    /**
     Trier les prêts par ordre décroissant de montant.
     @return La liste de prêts triée par ordre décroissant de montant.
     */
    List<Pret> trierPretMontantDeCroissant();

    /**
     Trier les prêts par ordre croissant de date d'effet.
     @return La liste de prêts triée par ordre croissant de date d'effet.
     */
    List<Pret> trierPretDateEffettCroissant();

    /**
     Trier les prêts par ordre décroissant de date d'effet.
     @return La liste de prêts triée par ordre décroissant de date d'effet.
     */
    List<Pret> trierPretDateEffetDeCroissant();

    /**
     Calculer les mensualités d'un prêt.
     @param pret Le prêt pour lequel les mensualités doivent être calculées.
     */
    public void calculMensualites(Pret pret);

    /**
     Cette méthode permet de trier les prêts entre deux dates données en entrée
     @param start : Date de début
     @param end : Date de fin
     @return : Une liste de prêts triée entre les deux dates
     */
    List<Pret> trierPretEntreDeuxDates(LocalDateTime start, LocalDateTime end);
}
