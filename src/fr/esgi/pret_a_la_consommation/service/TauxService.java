package fr.esgi.pret_a_la_consommation.service;

import fr.esgi.pret_a_la_consommation.business.Duree;
import fr.esgi.pret_a_la_consommation.business.Pret;
import fr.esgi.pret_a_la_consommation.business.Taux;
import fr.esgi.pret_a_la_consommation.business.Motif;

import java.util.List;

public interface TauxService {

    Taux ajouterTaux(Duree duree, Motif motif, double valeur);
    List<Taux> recupererTauxs();
    Taux recupererTaux(Long id);
    boolean ajouterPret(Pret pret, Long id);
}
