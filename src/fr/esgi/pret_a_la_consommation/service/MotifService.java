package fr.esgi.pret_a_la_consommation.service;

import fr.esgi.pret_a_la_consommation.business.Taux;
import fr.esgi.pret_a_la_consommation.business.Motif;

import java.util.List;
/**
 Interface de service pour la gestion des motifs d'un prêt à la consommation.
 */
public interface MotifService {
    /**
     Ajoute un nouveau motif avec un nom et une description.
     @param nom Nom du motif.
     @param description Description du motif.
     @return Le motif ajouté.
     */
    Motif ajouterMotif(String nom, String description);
    /**
     Récupérer la liste de tous les motifs.
     @return la liste de tous les motifs
     */
    List<Motif> recupererMotifs();
    /**
     Récupérer un motif en particulier en fonction de son identifiant.
     @param id L'identifiant du motif
     @return le motif correspondant à l'identifiant
     */
    Motif recupererMotif(Long id);
    /**
     Ajouter un taux pour un motif en particulier.
     @param taux Le taux à ajouter
     @param id L'identifiant du motif associé
     @return un booléen indiquant si l'ajout a réussi ou non
     */
    boolean ajouterTaux(Taux taux, Long id);

}
