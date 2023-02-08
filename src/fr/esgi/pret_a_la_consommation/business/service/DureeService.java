package fr.esgi.pret_a_la_consommation.business.service;

import fr.esgi.pret_a_la_consommation.business.business.Client;
import fr.esgi.pret_a_la_consommation.business.business.Duree;

import java.util.List;

public interface DureeService {
    Duree ajouterDuree(int dureeEnMois);
    List<Duree> recupererDurees();
    Duree recupererDuree(Long id);
    boolean supprimerDuree(Long id);
    void trierDuree();
}
