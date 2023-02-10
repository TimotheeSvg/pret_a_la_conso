package fr.esgi.pret_a_la_consommation.business;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 La classe Pret permet de définir un objet Pret, qui contiendra les informations sur le prêt
 accordé à un client.
 */

public class Pret {

    private final Long id;
    private double montantDemande;
    private double montantMensualite;

    //Date actuel a la creation
    private final LocalDate dateSouscription;

    private LocalDateTime dateEffet;
    private String observation;
    private static Long compteur = 0L;
    private List<Mensualite> mensualites;
    private Taux taux;

    private Client client;

    public Pret(double montantDemande, LocalDateTime dateEffet, Taux taux, Client client){
        this.client = client;
        this.taux = taux;
        this.mensualites = new ArrayList<>();
        this.montantDemande = montantDemande;
        this.dateEffet = dateEffet;
        this.dateSouscription = LocalDate.now();
        this.id = ++compteur;


    }

    public Long getId() {
        return id;
    }

    public double getMontantDemande() {
        return montantDemande;
    }

    public void setMontantDemande(double montantDemande) {
        this.montantDemande = montantDemande;
    }

    public LocalDate getDateSouscription() {
        return dateSouscription;
    }

    public LocalDateTime getDateEffet() {
        return dateEffet;
    }

    public void setDateEffet(LocalDateTime dateEffet) {
        this.dateEffet = dateEffet;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public static long getCompteur() {
        return compteur;
    }

    public static void setCompteur(long compteur) {
        Pret.compteur = compteur;
    }

    public List<Mensualite> getMensualites() {
        return mensualites;
    }

    public void setMensualites(List<Mensualite> mensualites) {
        this.mensualites = mensualites;
    }

    public Taux getTaux() {
        return taux;
    }

    public void setTaux(Taux taux) {
        this.taux = taux;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getMontantMensualite() {
        return montantMensualite;
    }

    public void setMontantMensualite(double montantMensualite) {
        this.montantMensualite = montantMensualite;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String dateEffetStr = dateEffet.format(formatter);
        return  "id: "+id + " | Montant du prêt: " + montantDemande + " | Montant mensualite: "+ Math.round(montantMensualite * 10.0) / 10.0 + " | Date souscription: "+ dateSouscription+
                " | Taux : " + taux.getValeur() * 100 + "% | Duree: " + taux.getDuree().getDureeEnMois() + " mois | Motif: " + taux.getMotif().getNom();
    }
}
