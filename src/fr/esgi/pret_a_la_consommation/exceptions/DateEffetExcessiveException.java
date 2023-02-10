package fr.esgi.pret_a_la_consommation.exceptions;

/**

 Classe représentant une exception pour une date d'effet excessive.
 Cette exception est levée lorsqu'une date d'effet demandée dépasse 3 ans.
 */
public class DateEffetExcessiveException extends Exception{

    public DateEffetExcessiveException(){
        super("La date d'effet demandée dépasse 3 ans");
    }
}
