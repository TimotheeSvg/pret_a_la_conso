package fr.esgi.pret_a_la_consommation.business.util;

import fr.esgi.pret_a_la_consommation.business.business.Pret;

import java.util.Comparator;

public class ComparateurPretSurDateEffetCroissant implements Comparator<Pret> {

    @Override
    public int compare(Pret pret1, Pret pret2) {
        return  pret1.getDateEffet().compareTo(pret2.getDateEffet());
    }
}
