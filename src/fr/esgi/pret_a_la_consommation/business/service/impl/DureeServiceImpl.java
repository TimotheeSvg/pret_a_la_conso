package fr.esgi.pret_a_la_consommation.business.service.impl;

import fr.esgi.pret_a_la_consommation.business.business.Client;
import fr.esgi.pret_a_la_consommation.business.business.Duree;
import fr.esgi.pret_a_la_consommation.business.business.Taux;
import fr.esgi.pret_a_la_consommation.business.service.DureeService;

import java.util.ArrayList;
import java.util.List;

public class DureeServiceImpl implements DureeService {

    private static List<Duree> durees = new ArrayList<>();
    public DureeServiceImpl() {
        super();
    }

    @Override
    public Duree ajouterDuree(int dureeEnMois) {
        Duree duree = new Duree(dureeEnMois);
        durees.add(duree);
        return duree;
    }

    @Override
    public boolean ajouterTaux(Taux taux, Long id){
        Duree duree = recupererDuree(id);
        if(duree == null){
            return false;
        }
        List<Taux> listTauxDuree = duree.getTaux();
        listTauxDuree.add(taux);
        duree.setTaux(listTauxDuree);
        return true;
    }
    @Override
    public List<Duree> recupererDurees() {
        return durees;
    }

    @Override
    public Duree recupererDuree(Long id) {
        for (Duree duree : durees){
            if(duree.getId().equals(id)){
                return duree;
            }
        }
        return null;
    }

}
