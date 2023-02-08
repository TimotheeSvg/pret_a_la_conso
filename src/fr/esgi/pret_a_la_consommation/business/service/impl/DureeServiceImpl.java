package fr.esgi.pret_a_la_consommation.business.service.impl;

import fr.esgi.pret_a_la_consommation.business.business.Client;
import fr.esgi.pret_a_la_consommation.business.business.Duree;
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

    @Override
    public boolean supprimerDuree(Long id) {
        Duree duree = recupererDuree(id);
        if(duree==null){
            return false;
        }else{
            return durees.remove(duree);
        }
    }

    @Override
    public void trierDuree() {

    }
}
