package fr.esgi.pret_a_la_consommation.util;
import fr.esgi.pret_a_la_consommation.business.Pret;

import java.util.Comparator;

/**

 Package util contenant la classe ComparateurPretSurDateEffetCroissant.
 Importe la classe Pret du package fr.esgi.pret_a_la_consommation.business.
 La classe ComparateurPretSurDateEffetCroissant implémente l'interface Comparator de Java.
 Elle permet de comparer deux objets de type Pret en se basant sur leur date d'effet.
 */

public class ComparateurPretSurDateEffetCroissant implements Comparator<Pret> {
/**
La méthode compare prend en entrée deux objets Pret et les compare en se basant sur leur date d'effet.
@param pret1 Le premier objet Pret à comparer
@param pret2 Le deuxième objet Pret à comparer
@return Un entier représentant la comparaison des deux dates d'effet
 */
    @Override
    public int compare(Pret pret1, Pret pret2) {
        return  pret1.getDateEffet().compareTo(pret2.getDateEffet());
    }
}
