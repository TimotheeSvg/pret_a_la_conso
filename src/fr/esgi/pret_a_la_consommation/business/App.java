package fr.esgi.pret_a_la_consommation.business;
import fr.esgi.pret_a_la_consommation.business.business.*;
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
    private static int creatingChoice = 0;
    private static int informationChoice = 0;
    private static Long idPret;

    private static Long idUser;
    private static Long idTaux;
    private static List<Pret> sortingListPret;
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
                        "Menu Ajout",
                        "Toute informations"), "Faites votre choix");

                if(responseMenuPrincipal >= 0) {
                    step = 1;
                }

                processing();
                break;

            case 1:
                switch (responseMenuPrincipal) {
                    case 1:
                        System.out.println("Choisir l'utilisateur :");
                        idUser = menuGetIdUser();
                        if (idUser >= 0) {
                            step = 2;
                        }

                        processing();
                        break;
                    case 2:
                        System.out.println("Choisir l'utilisateur :");
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
                                "Voir les prêts"), "choisir un tri");

                        if(sortingChoice >0){
                            step = 2;
                        }

                        processing();
                        break;

                    case 4:
                        creatingChoice = getResponseMenu(Arrays.asList("Ajout d'un Client","Ajout d'un Taux", "Ajout d'une durée", "Ajout d'un motif"), "Choisir votre ajout");
                        if(creatingChoice >= 0){
                            step +=1;
                        }

                        processing();
                        break;

                    case 5:
                        informationChoice = getResponseMenu(Arrays.asList("Tout les motifs", "Toutes les durées", "Tout les taux"), "Faites votre choix");
                        if(informationChoice >= 0){
                            step +=1;
                        }
                        processing();
                        break;
                }
                break;

            case 2:
                switch (responseMenuPrincipal) {
                    case 1:
                        montant = getResponseInt("Veuillez saisir le montant demandé ");
                        if (montant > 0) {
                            step = 3;
                        }
                        processing();
                        break;

                    case 2:
                        Client client = clientService.recupererClient(idUser);
                        List<Pret> prets = client.getPrets();
                        List<String>question = new ArrayList<>();
                        System.out.println("Information Client : " + client.getNom() + " " + client.getPrenom());
                        for(Pret pret: prets){
                            question.add(pret.toString());
                        }
                        idPret = (long) getResponseMenu(question, "Choisir un prêt à consulter: ");
                        if( idPret>= 0){
                            step+=1;
                        }
                        processing();
                        break;

                    case 3:
                        switch (sortingChoice) {
                            case 1:
                                sortingListPret = pretService.trierPretMontantCroissant();
                                step = 3;
                                processing();
                                break;
                            case 2:
                                sortingListPret = pretService.trierPretMontantDeCroissant();
                                step = 3;
                                processing();
                                break;
                            case 3:
                                sortingListPret = pretService.trierPretDateEffettCroissant();
                                step = 3;
                                processing();
                                break;
                            case 4:
                                sortingListPret = pretService.trierPretDateEffetDeCroissant();
                                step = 3;
                                processing();
                                break;
                            case 5:
                                scanner = new Scanner(System.in);
                                System.out.println("Veuillez saisir la première date");
                                LocalDateTime dateStart = getDate();
                                System.out.println("Veuillez saisir la dernière date");
                                LocalDateTime dateEnd = getDate();
                                sortingListPret = pretService.trierPretEntreDeuxDates(dateStart,dateEnd);
                                step=3;
                                processing();
                                break;
                            case 6:
                                step = 3;
                                processing();
                                break;
                        }
                        break;
                    case 4:
                        switch (creatingChoice){
                            case 1:
                                String nom = getResponseString("Entrer le nom : ");
                                String prenom = getResponseString("Entrer le prenom : ");
                                clientService.ajouterClient(nom,prenom);
                                step =1;
                                processing();
                                break;
                            case 2:
                                double val = getResponseInt("Entrer le % : (de 0 à 100)");
                                if(val <= 100 && val >= 0) {
                                    Long idDuree = menuGetIdDuree();
                                    if (idDuree>=0){
                                        Long idMotif = menuGetMotif();
                                        if(idMotif >=0){
                                            tauxService.ajouterTaux(dureeService.recupererDuree(idDuree),motifService.recupererMotif(idMotif), val);
                                            step = 1;
                                        }
                                    }
                                }
                                processing();
                                break;
                            case 3:
                                int temp = getResponseInt("Entrer la durée en mois : ");
                                dureeService.ajouterDuree(temp);
                                step = 1;
                                processing();
                                break;
                            case 4:
                                String nomMotif = getResponseString("Entrer le nouveaux motif : ");
                                String desc = getResponseString("Entrer la description du motif : ");
                                motifService.ajouterMotif(nomMotif,desc);
                                step = 1;
                                processing();
                                break;
                        }

                    case 5:
                        switch (informationChoice){
                            case 1:
                                for(Motif motif: motifService.recupererMotifs()){
                                    System.out.println(motif);
                                }
                                getResponseMenu(Arrays.asList(),"Faites Votre choix");
                                processing();
                                break;
                            case 2:
                                for(Duree duree: dureeService.recupererDurees()){
                                    System.out.println(duree);
                                }
                                getResponseMenu(Arrays.asList(),"Faites Votre choix");
                                processing();
                                break;
                            case 3:
                                for(Taux taux: tauxService.recupererTauxs()){
                                    System.out.println(taux);
                                }
                                getResponseMenu(Arrays.asList(),"Faites Votre choix");
                                processing();
                                break;
                        }
                }
                break;

            case 3:
                switch (responseMenuPrincipal) {
                    case 1:
                        idTaux = menuGetIdTaux();
                        if(idTaux >= 0){
                            step+=1;
                        }
                        processing();
                        break;
                    case 2:
                        Pret pretMens = pretService.recupererPret(idPret);
                        List<Mensualite> mensualites = pretMens.getMensualites();
                        System.out.println(pretMens);
                        for(Mensualite mensualite: mensualites){
                            System.out.println("\t" + mensualite);
                        }
                        getResponseMenu(Arrays.asList(),"Faites votre choix");
                        processing();
                        break;
                    case 3:
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                        for(Pret pret: sortingListPret){
                            String dateEffetStr = pret.getDateEffet().format(formatter);

                            System.out.println("id: " + pret.getId() + " | Client : " + pret.getClient().getNom() + " " + pret.getClient().getPrenom() + " | Montant: " + pret.getMontantDemande() +
                                    " | Taux: " + pret.getTaux().getValeur() * 100 + " | Duree: " + pret.getTaux().getDuree().getDureeEnMois()+ " | Mensualite: " + Math.round(pret.getMontantMensualite() * 10)/10+
                                    " | Souscription :  " + pret.getDateSouscription() + " | Effet: " + dateEffetStr + " | Motif: " + pret.getTaux().getMotif().getNom()
                            );
                        }
                        getResponseString("Choisir : ");
                        processing();
                        break;
                }
                break;
            case 4:
                switch (responseMenuPrincipal){
                    case 1:
                        LocalDateTime dateEffet = getDate();

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
            System.out.println("Erreur retour au menu principal ! ");
            Thread.sleep(2000);
            processing();
        }
    }


    public static int getResponseMenu(List<String> tab, String questionPhrase) throws InterruptedException {
        List<String> tabQuestion = new ArrayList<>(tab);
        tabQuestion.add("Retour");
        tabQuestion.add("Retour au menu");
        tabQuestion.add("Quitter");

        scanner = new Scanner(System.in);
        int response = 0;

        while(response == 0){
            int cmpt = 1;
            if(tab.size()>0){
                System.out.println();
            }
            for(String question : tabQuestion) {
                if(cmpt == tabQuestion.size()-2){
                    System.out.println();
                }
                System.out.println(cmpt++ + ". " + question);
            }
            System.out.println("\n" +questionPhrase + " : ");
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
        Long index = (long) getResponseMenu(tabClient, "Choisir l'utilisateur");
        if(index >= 0){
            return clientService.recupererClient(index).getId();
        }else{
            return -1L;
        }
    }
    public static Long menuGetIdTaux() throws InterruptedException {
        List<String> tabTaux = new ArrayList<>();
        for(Taux tau : tauxService.recupererTauxs()){
            tabTaux.add(tau.getValeur()*100 + "% sur " + tau.getDuree().getDureeEnMois() + " pour " + tau.getMotif().getDescription());
        }
        Long index = (long) getResponseMenu(tabTaux, "choisir le Taux");
        if(index >= 0){
            return tauxService.recupererTaux(index).getId();
        }
        return -1L;
    }
    public static Long menuGetIdDuree() throws InterruptedException {
        List<String> tabDuree = new ArrayList<>();

        for(Duree duree : dureeService.recupererDurees()){
            tabDuree.add(duree.getDureeEnMois() + " en mois ");
        }
        int index = getResponseMenu(tabDuree, "Choisir la durée") - 1;
        if(index > 0){
            return dureeService.recupererDurees().get(index).getId();
        }
        return -1L;
    }
    public static Long menuGetMotif() throws InterruptedException {
        List<String> tabMotif = new ArrayList<>();

        for(Motif motif : motifService.recupererMotifs()){
            tabMotif.add("Nom : " + motif.getNom() + " description : " + motif.getDescription());
        }
        int index = getResponseMenu(tabMotif, "Choisir le motif") - 1;
        if(index > 0){
            return motifService.recupererMotifs().get(index).getId();
        }
        return null;
    }
    public static int getResponseInt(String question){
        scanner = new Scanner(System.in);
        int response = 0;

        while(response == 0){
            System.out.println("R: Retour | RM: Retour Menu | Q: Quitter");
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
    public static LocalDateTime getDate(){
        LocalDateTime date = null;
        boolean valid = false;
        while (!valid) {
            String dateString = getResponseString("Veuillez saisir la date au format JJ/MM/yyyy");
            if (dateString == null){
                return null;
            }else {
                String[] dateStringSplit = dateString.split("/");
                if (dateStringSplit.length == 3) {
                    int day = Integer.parseInt(dateStringSplit[0]);
                    int month = Integer.parseInt(dateStringSplit[1]);
                    int year = Integer.parseInt(dateStringSplit[2]);

                    try{
                        date = LocalDate.of(year, month, day).atStartOfDay();

                        if (date.isBefore(LocalDateTime.now())) {
                            System.out.println("La date saisie est inférieure à la date actuelle.");
                        }else{
                            valid = true;
                        }
                    }catch (Exception ignored){
                    }
                }
            }
        }
        return date;
    }
    public static String getResponseString(String question){
        scanner = new Scanner(System.in);
        System.out.println("R: Retour | RM: Retour Menu | Q: Quitter");
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
