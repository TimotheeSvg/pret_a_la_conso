package fr.esgi.pret_a_la_consommation.business.service.impl;

import fr.esgi.pret_a_la_consommation.business.business.Duree;
import fr.esgi.pret_a_la_consommation.business.business.Motif;
import fr.esgi.pret_a_la_consommation.business.business.Taux;
import fr.esgi.pret_a_la_consommation.business.service.TauxService;

import java.util.ArrayList;
import java.util.List;

public class TauxServiceImpl implements TauxService {
    private static List<Taux> taux = new ArrayList<>();
    @Override
    public Taux ajouterTaux(Duree duree, Motif motif, double valeur) {
        Taux tau = new Taux(duree,motif,valeur);
        taux.add(tau);
        return tau;
    }

    @Override
    public List<Taux> recupererTauxs() {
        return taux;
    }

    @Override
    public Taux recupererTaux(Long id) {
        for (Taux tau : taux){
            if(tau.getId().equals(id)){
                return tau;
            }
        }
        return null;
    }

    @Override
    public boolean supprimerTaux(Long id) {
        Taux tau = recupererTaux(id);
        if (tau == null){
            return false;
        }else{
            return taux.remove(tau);
        }
    }

    @Override
    public void trierTaux() {

    }
}
