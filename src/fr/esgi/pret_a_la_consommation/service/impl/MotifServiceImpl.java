package fr.esgi.pret_a_la_consommation.service.impl;

import fr.esgi.pret_a_la_consommation.business.Taux;
import fr.esgi.pret_a_la_consommation.business.Motif;
import fr.esgi.pret_a_la_consommation.service.MotifService;

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
    public boolean ajouterTaux(Taux taux, Long id){
        Motif motif = recupererMotif(id);
        if(motif == null){
            return false;
        }
        List<Taux> listTauxMotif = motif.getTaux();
        listTauxMotif.add(taux);
        motif.setTaux(listTauxMotif);
        return true;
    }

}
