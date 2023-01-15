package business;

import sun.util.resources.LocaleData;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.lang.Math;
import java.util.Locale;

public class Pret implements Comparable<Pret>{

    private final long id;
    private double montantDemande;

    //Date actuel a la creation
    private final LocalDateTime dateSouscription;

    private LocalDate dateEffet;
    private String observation;
    private static long compteur = 0L;
    private List<Mensualite> mensualites;
    private Taux taux;

    private Client client;




    public Pret(double montantDemande, LocalDateTime dateSouscription, Taux taux, Client client){
        this.client = client;
        this.taux = taux;
        this.mensualites = new ArrayList<>();
        this.montantDemande = montantDemande;
        this.dateSouscription = dateSouscription;
        this.id = ++compteur;

        calculMensualites();


    }


    public void calculMensualites(){
        double tauxInteret = taux.getValeur()/taux.getDuree().getDureeEnMois();
        double mensualite = montantDemande * tauxInteret / (1 - Math.pow(1+tauxInteret, -taux.getDuree().getDureeEnMois()));


        DecimalFormat df = new DecimalFormat("#.##");

        double montantRembourser = 0;
        for(int i = 1; i <= taux.getDuree().getDureeEnMois(); i++){
            LocalDate datePrelevement = dateSouscription.plusMonths(i-1).toLocalDate();

            double interet = (montantDemande - montantRembourser) * tauxInteret;
            double amorti = mensualite - interet;

            montantRembourser += amorti;



            mensualites.add(new Mensualite(datePrelevement, Double.parseDouble(df.format(montantRembourser).replace(",",".")), Double.parseDouble(df.format(interet).replace(",",".")), this));
        }

    }

    public double getMontantDemande() {
        return montantDemande;
    }

    public void setMontantDemande(double montantDemande) {
        this.montantDemande = montantDemande;
    }

    @Override
    public String toString() {
        return "id : " + id + " Montant : " + montantDemande + " souscription : " + dateSouscription + "\n\t\t"+taux + "\n\n\t\t\t Mensualiter : \n" + mensualites.toString();
    }
    @Override
    public int compareTo(Pret pret) {
        return Double.compare(getMontantDemande(), pret.getMontantDemande());

    }


}
