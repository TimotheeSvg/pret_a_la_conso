package fr.esgi.pret_a_la_consommation.business.service.impl;

import fr.esgi.pret_a_la_consommation.business.business.Duree;
import fr.esgi.pret_a_la_consommation.business.business.Mensualite;
import fr.esgi.pret_a_la_consommation.business.business.Pret;
import fr.esgi.pret_a_la_consommation.business.service.MensualiteService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MensualiteServiceImpl implements MensualiteService {
    private static List<Mensualite> mensualites = new ArrayList<>();
    @Override
    public Mensualite ajouterMensualite(LocalDate datePrelevement, double partCapitalRembourse, double partInteretsRembourses, Pret pret) {
        Mensualite mensualite = new Mensualite(datePrelevement, partCapitalRembourse, partInteretsRembourses, pret);
        mensualites.add(mensualite);
        return mensualite;
    }

    @Override
    public List<Mensualite> recupererMensualites() {
        return mensualites;
    }

    @Override
    public Mensualite recupererMensualite(Long id) {
        for (Mensualite mensualite : mensualites){
            if(mensualite.getId().equals(id)){
                return mensualite;
            }
        }
        return null;
    }

    @Override
    public boolean supprimerMensualite(Long id) {
        Mensualite mensualite = recupererMensualite(id);
        if(mensualite == null){
            return false;
        }else{
            return mensualites.remove(mensualite);
        }
    }

    @Override
    public void trierMensualite() {

    }
}
