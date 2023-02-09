package fr.esgi.pret_a_la_consommation.business.service;

import fr.esgi.pret_a_la_consommation.business.business.Client;
import fr.esgi.pret_a_la_consommation.business.business.Pret;

import java.util.List;

public interface ClientService {
    Client ajouterClient(String nom, String prenom);
    List<Client> recupererClients();
    Client recupererClient(Long id);

    boolean ajouterPret(Pret pret, Long id);

}


