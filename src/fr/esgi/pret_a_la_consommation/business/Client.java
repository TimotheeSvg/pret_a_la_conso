package fr.esgi.pret_a_la_consommation.business;
import java.util.ArrayList;
import java.util.List;

/**

 Classe représentant un client.

 Un client est caractérisé par son identifiant unique, son nom et son prénom.

 Il peut également avoir une liste de prêts.
 */

public class Client {

    private final Long id;
    private String nom;
    private String prenom;
    private static Long compteur = 0L;
    private List<Pret> prets;

    public Client(String nom, String prenom){
        this.id = ++compteur;
        this.prenom = prenom;
        this.nom = nom;
        prets = new ArrayList<>();

    }

    public Long getId() {
        return id;
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

    public long getCompteur() {
        return compteur;
    }

    public void setCompteur(long compteur) {
        this.compteur = compteur;
    }

    public List<Pret> getPrets() {
        return prets;
    }

    public void setPrets(List<Pret> prets) {
        this.prets = prets;
    }

    @Override
    public String toString() {
        String response = "Client " + id + " " + nom + " " + prenom + " \n Pret : ";
        for(Pret pret : prets){
            response += "\n\t" + pret;
        }
        return response;
    }
}
