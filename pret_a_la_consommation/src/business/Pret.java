package business;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Pret {

    private long id;
    private double montantDemande;
    private double montantMensualite;

    //Date actuel a la creation
    private LocalDateTime dateSouscription;

    //Date renseigner a la souscription
    private LocalDate dateEffet;
    private String observation;
    private static long compteur = 0L;

    public Pret(double montantDemande, LocalDateTime dateSouscription){

    }
}
