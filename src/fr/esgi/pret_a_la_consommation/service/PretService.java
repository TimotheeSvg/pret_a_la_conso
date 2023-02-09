package fr.esgi.pret_a_la_consommation.service;

import fr.esgi.pret_a_la_consommation.business.Client;
import fr.esgi.pret_a_la_consommation.business.Pret;
import fr.esgi.pret_a_la_consommation.business.Taux;

import java.time.LocalDateTime;
import java.util.List;

public interface PretService {
    Pret ajouterPret(double montantDemande, LocalDateTime dateSouscription, Taux taux, Client client);
    List<Pret> recupererPrets();
    Pret recupererPret(Long id);
    void afficherPretMensualite(Long id);
    List<Pret> trierPretMontantCroissant();
    List<Pret> trierPretMontantDeCroissant();
    List<Pret> trierPretDateEffettCroissant();
    List<Pret> trierPretDateEffetDeCroissant();
    public void calculMensualites(Pret pret);
    List<Pret> trierPretEntreDeuxDates(LocalDateTime start, LocalDateTime end);
}