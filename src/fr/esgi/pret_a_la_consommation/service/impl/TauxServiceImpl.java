package fr.esgi.pret_a_la_consommation.service.impl;

import fr.esgi.pret_a_la_consommation.business.Duree;
import fr.esgi.pret_a_la_consommation.business.Motif;
import fr.esgi.pret_a_la_consommation.business.Pret;
import fr.esgi.pret_a_la_consommation.business.Taux;
import fr.esgi.pret_a_la_consommation.service.DureeService;
import fr.esgi.pret_a_la_consommation.service.MotifService;
import fr.esgi.pret_a_la_consommation.service.TauxService;

import java.util.ArrayList;
import java.util.List;

public class TauxServiceImpl implements TauxService {
    private static List<Taux> taux = new ArrayList<>();
    private static DureeService dureeService = new DureeServiceImpl();
    private static MotifService motifService = new MotifServiceImpl();

    @Override
    public Taux ajouterTaux(Duree duree, Motif motif, double valeur) {
        Taux tau = new Taux(duree,motif,valeur);
        dureeService.ajouterTaux(tau, duree.getId());
        motifService.ajouterTaux(tau, motif.getId());
        taux.add(tau);
        return tau;
    }

    @Override
    public boolean ajouterPret(Pret pret, Long id) {
        Taux tau = recupererTaux(id);

        if(tau ==null){
            return false;
        }

        List<Pret> prets = tau.getPrets();
        prets.add(pret);
        tau.setPrets(prets);
        return true;
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
}
