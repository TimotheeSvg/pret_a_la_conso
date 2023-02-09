package fr.esgi.pret_a_la_consommation.service;

import fr.esgi.pret_a_la_consommation.business.Duree;
import fr.esgi.pret_a_la_consommation.business.Taux;

import java.util.List;

public interface DureeService {
    Duree ajouterDuree(int dureeEnMois);
    List<Duree> recupererDurees();
    Duree recupererDuree(Long id);
    boolean ajouterTaux(Taux taux, Long id);
}
