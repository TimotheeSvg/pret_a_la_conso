package fr.esgi.pret_a_la_consommation.business.service.impl;

import fr.esgi.pret_a_la_consommation.business.business.Client;
import fr.esgi.pret_a_la_consommation.business.business.Mensualite;
import fr.esgi.pret_a_la_consommation.business.business.Pret;
import fr.esgi.pret_a_la_consommation.business.business.Taux;
import fr.esgi.pret_a_la_consommation.business.service.PretService;
import fr.esgi.pret_a_la_consommation.business.service.ClientService;
import fr.esgi.pret_a_la_consommation.business.util.ComparateurPretSurDateEffetCroissant;
import fr.esgi.pret_a_la_consommation.business.util.ComparateurPretSurMontantCroissant;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


// Ajouter le calcul des mensualiter dans le processing,
// ajouter dans le constructeur Mensualite l'jaout d'un appel a une methode du service Pret pour ajouter une mensualiter
// CF client et pret
//
//




public class PretServiceImpl implements PretService {
    private static List<Pret> prets = new ArrayList<>();
    private static ClientService clientService = new ClientServiceImpl();

    @Override
    public Pret ajouterPret(double montantDemande, LocalDateTime dateEffet, Taux taux, Client client) {
        Pret pret = new Pret(montantDemande, dateEffet, taux, client);
        calculMensualites(pret);
        clientService.ajouterPret(pret, client.getId());
        prets.add(pret);
        afficherPretMensualite(pret.getId());
        return pret;
    }

    @Override
    public void calculMensualites(Pret pret) {
        double tauxInteret = pret.getTaux().getValeur() / (double)pret.getTaux().getDuree().getDureeEnMois();
        double mensualiteVal = pret.getMontantDemande() * tauxInteret / (1.0 - Math.pow(1.0 + tauxInteret, (double)(-pret.getTaux().getDuree().getDureeEnMois())));
        pret.setMontantMensualite(mensualiteVal);

        DecimalFormat df = new DecimalFormat("#.##");
        double montantRembourser = 0.0;

        for(int i = 1; i <= pret.getTaux().getDuree().getDureeEnMois(); ++i) {
            LocalDate datePrelevement = pret.getDateEffet().plusMonths((long)(i)).toLocalDate();
            double interet = (pret.getMontantDemande() - montantRembourser) * tauxInteret;
            double amorti = mensualiteVal - interet;
            montantRembourser += amorti;
            Mensualite mensualite = new Mensualite(datePrelevement, Double.parseDouble(df.format(montantRembourser).replace(",", ".")), Double.parseDouble(df.format(interet).replace(",", ".")), pret);
            List<Mensualite> listMensualitePret = pret.getMensualites();
            listMensualitePret.add(mensualite);
            pret.setMensualites(listMensualitePret);

        }

    }
    @Override
    public List<Pret> recupererPrets() {
        return prets;
    }

    @Override
    public Pret recupererPret(Long id) {
        for(Pret pret : prets){
            if(pret.getId().equals(id)){
                return pret;
            }
        }
        return null;
    }

    @Override
    public boolean supprimerPret(Long id) {
        Pret pret = recupererPret(id);
        if(pret == null){
            return false;
        }else{
            return prets.remove(pret);
        }
    }

    @Override
    public void afficherPretMensualite(Long id) {
        Pret pret = recupererPret(id);
        System.out.println(pret);
        int i = 1;
        for(Mensualite mensualite: pret.getMensualites()){
            System.out.println("\t"+i + " - " + mensualite);
            i++;
        }
    }

    @Override
    public List<Pret> trierPretMontantCroissant() {
        List<Pret> sortingList = recupererPrets();
        Collections.sort(sortingList, new ComparateurPretSurMontantCroissant());
        return sortingList;
    }    @Override
    public List<Pret> trierPretMontantDeCroissant() {
        List<Pret> sortingList = recupererPrets();
        Collections.sort(sortingList, new ComparateurPretSurMontantCroissant());
        Collections.reverse(sortingList);
        return sortingList;
    }
    @Override
    public List<Pret> trierPretDateEffettCroissant() {
        List<Pret> sortingList = recupererPrets();
        Collections.sort(sortingList, new ComparateurPretSurDateEffetCroissant());
        return sortingList;
    }
    @Override
    public List<Pret> trierPretDateEffetDeCroissant() {
        List<Pret> sortingList = recupererPrets();
        Collections.sort(sortingList, new ComparateurPretSurDateEffetCroissant());
        Collections.reverse(sortingList);
        return sortingList;
    }

    @Override
    public List<Pret> trierPretEntreDeuxDates(LocalDateTime start, LocalDateTime end) {
        List<Pret> sortingList = recupererPrets();
        Collections.sort(sortingList, new ComparateurPretSurDateEffetCroissant());
        sortingList = sortingList.stream().filter(e -> e.getDateEffet().isAfter(start) && e.getDateEffet().isBefore(end)).collect(Collectors.toList());
        return sortingList;
    }
}
