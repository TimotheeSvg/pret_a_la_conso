package fr.esgi.pret_a_la_consommation.service;

import fr.esgi.pret_a_la_consommation.business.Client;
import fr.esgi.pret_a_la_consommation.business.Pret;

import java.util.List;

/**

 Cette interface définit les méthodes pour gérer les clients et leurs prêts.
 */
public interface ClientService {

    /**
     Ajouter un nouveau client avec le nom et le prénom donnés.
     @param nom Le nom du client
     @param prenom Le prénom du client
     @return Le client ajouté
     */
    Client ajouterClient(String nom, String prenom);

    /**
     Récupérer la liste de tous les clients.
     @return La liste de tous les clients
     */
    List<Client> recupererClients();

    /**

     Récupérer un client en fonction de son identifiant.
     @param id L'identifiant du client
     @return Le client correspondant à l'identifiant
     */
    Client recupererClient(Long id);

    /**
     Ajouter un nouveau prêt pour un client donné.
     @param pret Le prêt à ajouter
     @param id L'identifiant du client auquel ajouter le prêt
     @return true si le prêt a été ajouté avec succès, false sinon
     */
    boolean ajouterPret(Pret pret, Long id);

}


