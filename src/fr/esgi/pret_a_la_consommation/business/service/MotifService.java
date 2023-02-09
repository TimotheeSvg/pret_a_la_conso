package fr.esgi.pret_a_la_consommation.business.service;

import fr.esgi.pret_a_la_consommation.business.business.Motif;
import fr.esgi.pret_a_la_consommation.business.business.Taux;

import java.util.List;

public interface MotifService {

    Motif ajouterMotif(String nom, String description);
    List<Motif> recupererMotifs();
    Motif recupererMotif(Long id);
    boolean ajouterTaux(Taux taux, Long id);

}
