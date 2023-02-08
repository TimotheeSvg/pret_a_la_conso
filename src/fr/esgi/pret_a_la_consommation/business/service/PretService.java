package fr.esgi.pret_a_la_consommation.business.service;

import fr.esgi.pret_a_la_consommation.business.business.Client;
import fr.esgi.pret_a_la_consommation.business.business.Pret;
import fr.esgi.pret_a_la_consommation.business.business.Taux;

import java.time.LocalDateTime;
import java.util.List;

public interface PretService {
    Pret ajouterPret(double montantDemande, LocalDateTime dateSouscription, Taux taux, Client client);
    List<Pret> recupererPrets();
    Pret recupererPret(Long id);
    boolean supprimerPret(Long id);
    void trierPretMontantCroissant();
    void trierPretMontantDeCroissant();
    void trierPretDateEffettCroissant();
    void trierPretDateEffetDeCroissant();
}
