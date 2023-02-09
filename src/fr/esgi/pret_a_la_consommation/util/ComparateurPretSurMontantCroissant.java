package fr.esgi.pret_a_la_consommation.util;

import fr.esgi.pret_a_la_consommation.business.Pret;

import java.util.Comparator;

public class ComparateurPretSurMontantCroissant implements Comparator<Pret> {
    @Override
    public int compare(Pret pret1, Pret pret2) {
        return (int) (pret1.getMontantDemande() - pret2.getMontantDemande());
    }
}
