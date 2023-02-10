package fr.esgi.pret_a_la_consommation.exceptions;

/**
 Classe représentant une exception pour un montant excessif
 */

public class MontantExcessifException extends Exception{

    public MontantExcessifException(double montant){
        super("Le montant de " + montant + " euros est supérieur à la limite autorisée de 20000 euros");
    }

}
