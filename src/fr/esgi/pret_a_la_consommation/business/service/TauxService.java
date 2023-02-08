package fr.esgi.pret_a_la_consommation.business.service;

import fr.esgi.pret_a_la_consommation.business.business.Duree;
import fr.esgi.pret_a_la_consommation.business.business.Motif;
import fr.esgi.pret_a_la_consommation.business.business.Taux;

import java.util.List;

public interface TauxService {

    Taux ajouterTaux(Duree duree, Motif motif, double valeur);
    List<Taux> recupererTauxs();
    Taux recupererTaux(Long id);
    boolean supprimerTaux(Long id);
    void trierTaux();



}
