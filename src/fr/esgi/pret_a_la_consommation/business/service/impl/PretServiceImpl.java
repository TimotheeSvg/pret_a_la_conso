package fr.esgi.pret_a_la_consommation.business.service.impl;

import fr.esgi.pret_a_la_consommation.business.business.Client;
import fr.esgi.pret_a_la_consommation.business.business.Pret;
import fr.esgi.pret_a_la_consommation.business.business.Taux;
import fr.esgi.pret_a_la_consommation.business.service.PretService;
import fr.esgi.pret_a_la_consommation.business.service.ClientService;
import fr.esgi.pret_a_la_consommation.business.util.ComparateurPretSurDateEffetCroissant;
import fr.esgi.pret_a_la_consommation.business.util.ComparateurPretSurMontantCroissant;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PretServiceImpl implements PretService {
    private static List<Pret> prets = new ArrayList<>();
    private static ClientService clientService = new ClientServiceImpl();

    @Override
    public Pret ajouterPret(double montantDemande, LocalDateTime dateSouscription, Taux taux, Client client) {
        Pret pret = new Pret(montantDemande, dateSouscription, taux, client);
        clientService.ajouterPret(pret, client.getId());
        prets.add(pret);
        return pret;
    }

    @Override
    public List<Pret> recupererPrets() {
        return prets;
    }

    @Override
    public Pret recupererPret(Long id) {
        for(Pret pret : prets){
            if(pret.getId().equals(id)){
                return pret;
            }
        }
        return null;
    }

    @Override
    public boolean supprimerPret(Long id) {
        Pret pret = recupererPret(id);
        if(pret == null){
            return false;
        }else{
            return prets.remove(pret);
        }
    }

    @Override
    public void trierPretMontantCroissant() {
        Collections.sort(prets, new ComparateurPretSurMontantCroissant());
    }    @Override
    public void trierPretMontantDeCroissant() {
        Collections.sort(prets, new ComparateurPretSurMontantCroissant());
        Collections.reverse(prets);
    }
    @Override
    public void trierPretDateEffettCroissant() {
        Collections.sort(prets, new ComparateurPretSurDateEffetCroissant());
    }
    @Override
    public void trierPretDateEffetDeCroissant() {
        Collections.sort(prets, new ComparateurPretSurDateEffetCroissant());
        Collections.reverse(prets);
    }
}
