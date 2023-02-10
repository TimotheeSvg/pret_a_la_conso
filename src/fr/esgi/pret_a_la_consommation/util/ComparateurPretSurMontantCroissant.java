package fr.esgi.pret_a_la_consommation.util;

import fr.esgi.pret_a_la_consommation.business.Pret;

import java.util.Comparator;

/**

 Package util contenant la classe ComparateurPretSurMontantCroissant.
 Importe la classe Pret du package fr.esgi.pret_a_la_consommation.business.
 La classe ComparateurPretSurMontantCroissant implémente l'interface Comparator de Java.
 Elle permet de comparer deux objets de type Pret en se basant sur leur montant demandé.
 */
public class ComparateurPretSurMontantCroissant implements Comparator<Pret> {
    @Override
    public int compare(Pret pret1, Pret pret2) {
        return (int) (pret1.getMontantDemande() - pret2.getMontantDemande());
    }
}
