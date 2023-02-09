package fr.esgi.pret_a_la_consommation.business.service.impl;

import fr.esgi.pret_a_la_consommation.business.business.Client;
import fr.esgi.pret_a_la_consommation.business.business.Pret;
import fr.esgi.pret_a_la_consommation.business.service.ClientService;

import java.util.ArrayList;
import java.util.List;
public class ClientServiceImpl implements ClientService {
    private static List<Client> clients = new ArrayList<>();

    @Override
    public Client ajouterClient(String nom, String prenom){
        Client client = new Client(nom, prenom);
        clients.add(client);
        return client;
    }

    @Override
    public List<Client> recupererClients() {
        return clients;
    }

    @Override
    public Client recupererClient(Long id) {
        for(Client client: clients){
            if(client.getId().equals(id)){
                return client;
            }
        }
        return null;
    }

    @Override
    public boolean ajouterPret(Pret pret, Long id) {
        Client client = recupererClient(id);

        if(client ==null){
            return false;
        }

        List<Pret> prets = client.getPrets();
        prets.add(pret);
        client.setPrets(prets);
        return true;
    }

}
