package fr.esgi.pret_a_la_consommation.exceptions;

import java.time.LocalDateTime;

public class DateEffetExcessiveException extends Exception{

    public DateEffetExcessiveException(){
        super("La date d'effet demandée dépasse 3 ans");
    }
}
