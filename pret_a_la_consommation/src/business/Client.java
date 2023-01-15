package business;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Client {

    private long id;
    private String nom;
    private String prenom;
    private long compteur = 0L;

    private List<Pret> prets;

    public Client(String nom, String prenom){
        this.id = ++compteur;
        this.prenom = prenom;
        this.nom = nom;
        prets = new ArrayList<>();

    }

    public void addPret(double montantDemande, LocalDateTime dateSouscription, Taux taux){
        prets.add(new Pret(montantDemande, dateSouscription, taux, this));
        taux.addPret(prets.get(prets.size()-1));
    }

    public List<Pret> getPrets() {
        return prets;
    }

    public void setPrets(List<Pret> prets) {
        this.prets = prets;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        StringBuilder phrase = new StringBuilder("Client " + id + " : " + nom + " " + prenom + " pret : \n");
        for(Pret pret : prets){
            phrase.append("\t").append(pret.toString()).append(" \n");
        }
        return phrase.toString();
    }
}
