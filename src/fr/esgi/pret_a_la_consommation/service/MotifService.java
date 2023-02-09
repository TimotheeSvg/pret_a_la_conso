package fr.esgi.pret_a_la_consommation.service;

import fr.esgi.pret_a_la_consommation.business.Taux;
import fr.esgi.pret_a_la_consommation.business.Motif;

import java.util.List;

public interface MotifService {

    Motif ajouterMotif(String nom, String description);
    List<Motif> recupererMotifs();
    Motif recupererMotif(Long id);
    boolean ajouterTaux(Taux taux, Long id);

}
