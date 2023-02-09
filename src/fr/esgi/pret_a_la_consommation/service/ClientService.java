package fr.esgi.pret_a_la_consommation.service;

import fr.esgi.pret_a_la_consommation.business.Client;
import fr.esgi.pret_a_la_consommation.business.Pret;

import java.util.List;

public interface ClientService {
    Client ajouterClient(String nom, String prenom);
    List<Client> recupererClients();
    Client recupererClient(Long id);

    boolean ajouterPret(Pret pret, Long id);

}


