package fr.esgi.pret_a_la_consommation.business;
import fr.esgi.pret_a_la_consommation.business.business.Client;
import fr.esgi.pret_a_la_consommation.business.business.Pret;
import fr.esgi.pret_a_la_consommation.business.business.Taux;
import fr.esgi.pret_a_la_consommation.business.service.*;
import fr.esgi.pret_a_la_consommation.business.service.impl.*;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class App {

    private static final DureeService dureeService = new DureeServiceImpl();
    private static final MotifService motifService = new MotifServiceImpl();
    private static final TauxService tauxService = new TauxServiceImpl();
    private static final ClientService clientService = new ClientServiceImpl();
    private static final PretService pretService = new PretServiceImpl();

    private static int step = 0;
    private static int responseMenuPrincipal = 0;
    private static int sortingChoice = 0;

    private static Long idUser;
    private static Long idTaux;
    private static Scanner scanner;

    private static int montant;


    public static void main(String[] args) throws InterruptedException {

        dureeService.ajouterDuree(12);
        dureeService.ajouterDuree(24);

        motifService.ajouterMotif("Auto", "Auto");
        motifService.ajouterMotif("Moto", "Moto");

        tauxService.ajouterTaux(dureeService.recupererDuree(1L), motifService.recupererMotif(1L), 0.01);
        tauxService.ajouterTaux(dureeService.recupererDuree(1L), motifService.recupererMotif(2L), 0.015);
        tauxService.ajouterTaux(dureeService.recupererDuree(2L), motifService.recupererMotif(1L), 0.02);
        tauxService.ajouterTaux(dureeService.recupererDuree(2L), motifService.recupererMotif(2L), 0.025);

        clientService.ajouterClient("Sauvage", "Timothee");
        clientService.ajouterClient("Robert", "Deniblo");
        clientService.ajouterClient("John", "Pas");
        clientService.ajouterClient("Josephine", "Ange");

        LocalDateTime j1 = LocalDateTime.of(2023, 7, 3, 0, 0);
        LocalDateTime j2 = LocalDateTime.of(2024, 5, 1, 0, 0);
        LocalDateTime j3 = LocalDateTime.of(2025, 8, 8, 0, 0);
        LocalDateTime j4 = LocalDateTime.of(2023, 1, 3, 0, 0);
        LocalDateTime j5 = LocalDateTime.of(2024, 5, 4, 0, 0);
        LocalDateTime j6 = LocalDateTime.of(2025, 2, 5, 0, 0);
        LocalDateTime j7 = LocalDateTime.of(2023, 3, 6, 0, 0);
        LocalDateTime j8 = LocalDateTime.of(2024, 4, 7, 0, 0);

        pretService.ajouterPret(1000,j1,tauxService.recupererTaux(1L),clientService.recupererClient(1L));
        pretService.ajouterPret(5000,j2,tauxService.recupererTaux(2L),clientService.recupererClient(1L));
        pretService.ajouterPret(10000,j3,tauxService.recupererTaux(3L),clientService.recupererClient(1L));

        pretService.ajouterPret(3211,j4,tauxService.recupererTaux(1L),clientService.recupererClient(2L));
        pretService.ajouterPret(5443,j5,tauxService.recupererTaux(3L),clientService.recupererClient(2L));
        pretService.ajouterPret(53343,j6,tauxService.recupererTaux(2L),clientService.recupererClient(2L));

        pretService.ajouterPret(5443,j7,tauxService.recupererTaux(2L),clientService.recupererClient(3L));
        pretService.ajouterPret(123,j8,tauxService.recupererTaux(3L),clientService.recupererClient(3L));
        pretService.ajouterPret(12334,j2,tauxService.recupererTaux(1L),clientService.recupererClient(3L));

        pretService.ajouterPret(535,j2,tauxService.recupererTaux(2L),clientService.recupererClient(4L));
        pretService.ajouterPret(5342,j3,tauxService.recupererTaux(1L),clientService.recupererClient(4L));
        pretService.ajouterPret(7754,j1,tauxService.recupererTaux(2L),clientService.recupererClient(4L));

        processing();
    }


    public static void processing() throws InterruptedException {

        switch (step) {
            case 0:
                System.out.println("Bienvenue sur prêt à la consometion \n");
                responseMenuPrincipal = getResponseMenu(Arrays.asList("Ajouter un Pret",
                        "Information Client",
                        "Information Pret",
                        "Information Taux"));
                step = 1;
                processing();
                break;

            case 1:
                switch (responseMenuPrincipal) {
                    case 1:
                        idUser = menuGetIdUser();
                        if (idUser >= 0) {
                            step = 2;
                        }
                        processing();

                        break;
                    case 2:
                        idUser = menuGetIdUser();
                        if(idUser >=0){
                            step = 2;
                        }
                        processing();
                        break;
                    case 3:
                        sortingChoice = getResponseMenu(Arrays.asList("Voir les prêts trier par montant (Plus haut au plus Bas)",
                                "Voir les prêts trier par montant (Plus bas au plus haut)",
                                "Voir les prêts trier par Date (Le plus ancien au plus récent)" ,
                                "Voir les prêts trier par date (Le plus récent au plus ancient)",
                                "Voir les prêts entre deux date",
                                "Voir les prêts"));
                        if(sortingChoice >0){
                            step = 2;
                        }

                        processing();
                        break;
//                    case 4:
////                        for(Taux taux: Ltaux){
////                            System.out.println("Taux " + taux.getId() + " | " + taux + " |  Nombre de prêt accorder a ce taux : " + taux.getPrets().size());
////                        }
////                        getResponseMenu(Arrays.asList());
//                        processing();
//                        break;
//
                }
                break;
            case 2:
                switch (responseMenuPrincipal){
                    case 1:
                        montant = getResponseInt("Veuillez saisir le montant demandé ");
                        if(montant > 0) {
                            step = 3;
                        }
                        processing();
                        break;

                    case 2:
                        System.out.println(clientService.recupererClient(idUser));
                        getResponseString("Choisir quoi faire : ");
                        processing();
                        break;

                    case 3:
                        switch (sortingChoice){
                            case 1:
                                pretService.trierPretMontantCroissant();
                                step = 3;
                                processing();
                                break;
                            case 2:
                                pretService.trierPretMontantDeCroissant();
                                step = 3;
                                processing();
                                break;
                            case 3:
                                pretService.trierPretDateEffettCroissant();
                                step = 3;
                                processing();
                                break;
                            case 4:
                                pretService.trierPretDateEffetDeCroissant();
                                step = 3;
                                processing();
                                break;
                            case 5:
                                scanner = new Scanner(System.in);
                                try{
                                    System.out.print("Entrez une date de début au format MM/YYYY : ");
                                    String dateStr = scanner.nextLine();
                                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yyyy");
                                    LocalDateTime dateStart = LocalDateTime.parse(dateStr, formatter);

                                    System.out.print("Entrez une date de fin au format MM/YYYY : ");
                                    dateStr = scanner.nextLine();
                                    LocalDateTime dateEnd = LocalDateTime.parse(dateStr, formatter);
                                    System.out.println("La date entrée est : " + dateStart + " et la fin : "+ dateEnd);

                                }
                                catch(DateTimeException e){
                                    System.out.println(e);
                                    System.out.println("Mauvaise Saisie");
                                    processing();
                                }
                                break;
                            case 6:
                                step = 3;
                                processing();
                                break;
                        }
                }
                break;
            case 3:
                switch (responseMenuPrincipal) {
                    case 1:

                        idTaux = menuGetIdTaux();
                        processing();
                        break;

                    case 3:
                        for(Pret pret: pretService.recupererPrets()){
                            System.out.println(pret.getMontantDemande() + " " + pret.getDateEffet());
                        }
                        getResponseString("Choisir : ");
                        processing();
                        break;

                }
                break;
            case 4:
                switch (responseMenuPrincipal){
                    case 1:
                        LocalDateTime dateEffet = getDateEffet();
                        if (dateEffet != null){
                            pretService.ajouterPret(montant, dateEffet,tauxService.recupererTaux(idTaux), clientService.recupererClient(idUser));
                            System.out.println("Ajout effectuer");
                            Thread.sleep(2000);
                            step = 0;
                        }
                        processing();
                        break;
                }
                    default:
                        step = 0;
                        System.out.println("Erreur retour au menu principal : ");
                        Thread.sleep(2000);
                }
        }


    public static int getResponseMenu(List<String> tab) throws InterruptedException {
        List<String> tabQuestion = new ArrayList<>(tab);
        tabQuestion.add("Retour");
        tabQuestion.add("Retour au menu");
        tabQuestion.add("Quitter");

        scanner = new Scanner(System.in);
        int response = 0;

        while(response == 0){
            int cmpt = 1;
            for(String question : tabQuestion) {
                if(cmpt == tabQuestion.size()-2){
                    System.out.println();
                }
                System.out.println(cmpt++ + ". " + question);
            }
            System.out.println("Faites votre choix : ");
            try {
                response = scanner.nextInt();
                if (response < 1){
                    throw new Exception();
                }
            }catch (Exception e){
                System.out.println("Saisie Incorrect");
                response = 0;
                Thread.sleep(2000);
                scanner.nextLine();
            }
        }

        if (response == tabQuestion.size()-2){
            step -=1;
            return -1;
        }else if (response == tabQuestion.size()-1){
            step = 0;
            return -1;
        } else if (response == tabQuestion.size()) {
            System.exit(0);
        }
        return response;
    }
    public static Long menuGetIdUser() throws InterruptedException {
        List<String> tabClient = new ArrayList<>();
        for(Client client : clientService.recupererClients()){
            tabClient.add(client.getNom() + " " + client.getPrenom());
        }
        Long index = (long) getResponseMenu(tabClient);
        return clientService.recupererClient(index).getId();
    }
    public static Long menuGetIdTaux() throws InterruptedException {
        List<String> tabTaux = new ArrayList<>();
        for(Taux tau : tauxService.recupererTauxs()){
            tabTaux.add(tau.getValeur()*100 + "% sur " + tau.getDuree().getDureeEnMois() + " pour " + tau.getMotif().getDescription());
        }
        Long index = (long) getResponseMenu(tabTaux);
        return tauxService.recupererTaux(index).getId();
    }
    public static int getResponseInt(String question){
        scanner = new Scanner(System.in);
        int response = 0;

        while(response == 0){
            System.out.println("Entrer R : Retour, RM : Retour Menu, Q : Quitter");
            System.out.println(question + " :");
            try {
                response = scanner.nextInt();
            }catch (Exception e){
                String rep = scanner.nextLine();

                switch (rep) {
                    case "R":
                        step -= 1;
                        return -1;
                    case "RM" :
                        step = 0;
                        return -1;

                    case "Q" :
                        System.exit(0);
                }
            }
        }
        return response;
    }
    public static LocalDateTime getDateEffet(){
        LocalDateTime date = null;
        boolean valid = false;
        while (!valid) {
            try {
                String dateString = getResponseString("Veuillez saisir la date d'effet au format MM/yyyy");
                if (dateString == null){
                    return null;
                }else {
                    String[] dateStringSplit = dateString.split("/");
                    if (dateStringSplit.length == 2) {
                        int month = Integer.parseInt(dateStringSplit[0]);
                        int year = Integer.parseInt(dateStringSplit[1]);

                        if ((0 < month && month < 13) && (2022 < year)) {
                            date = LocalDate.of(year, month, 1).atStartOfDay();
                            valid = true;
                        }
                    }
                }
            } catch (Exception ignored) {}
        }
        return date;
    }
    public static String getResponseString(String question){
        scanner = new Scanner(System.in);
        System.out.println("Entrer R : Retour, RM : Retour Menu, Q : Quitter");
        System.out.println(question + " :");
        String response = scanner.nextLine();
        switch (response){
            case "R":
                if(responseMenuPrincipal == 3 && step == 3){
                    step -=2;
                }else{
                    step -=1;
                }
                return null;
            case "RM":
                step = 0;
                return null;
            case "Q":
                System.exit(0);
        }
        return response;
    }

}
