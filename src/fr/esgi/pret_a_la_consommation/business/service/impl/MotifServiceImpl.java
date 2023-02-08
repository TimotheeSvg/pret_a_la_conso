package fr.esgi.pret_a_la_consommation.business.service.impl;

import fr.esgi.pret_a_la_consommation.business.business.Duree;
import fr.esgi.pret_a_la_consommation.business.business.Motif;
import fr.esgi.pret_a_la_consommation.business.service.MotifService;

import java.util.ArrayList;
import java.util.List;

public class MotifServiceImpl implements MotifService {
    private static List<Motif> motifs = new ArrayList<>();
    @Override
    public Motif ajouterMotif(String nom, String description) {
        Motif motif = new Motif(nom,description);
        motifs.add(motif);
        return motif;
    }

    @Override
    public List<Motif> recupererMotifs() {
        return motifs;
    }

    @Override
    public Motif recupererMotif(Long id) {
        for (Motif motif :motifs){
            if(motif.getId().equals(id)){
                return motif;
            }
        }
        return null;
    }

    @Override
    public boolean supprimerMotif(Long id) {
        Motif motif = recupererMotif(id);
        if(motif==null){
            return false;
        }else{
            return motifs.remove(motif);
        }
    }

    @Override
    public void trierMotif() {

    }
}
