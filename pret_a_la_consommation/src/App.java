import business.*;
import service.impl.PretTrier;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;
import java.util.ArrayList;

public class App {

    private static List<Client> clients;

    private static List<Taux> Ltaux;
    private static Scanner scanner;

    private static int step;

    private static int responseMenuPrincipal;

    private static int responseMenu1;
    private static int responseMenu2;


    private static int idUser;
    private static int montant;
    private static int idTaux;

    private static List<Pret> tabPret;


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

    public static String getResponseString(String question){
        scanner = new Scanner(System.in);
        System.out.println("Entrer R : Retour, RM : Retour Menu, Q : Quitter");
        System.out.println(question + " :");
        String response = scanner.nextLine();
        switch (response){
            case "R":
                step -=1;
                return null;
            case "RM":
                step = 0;
                return null;
            case "Q":
                System.exit(0);
        }
        return response;

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

    public static int menuGetIdUser() throws InterruptedException {
        List<String> tabClient = new ArrayList<>();
        for(Client client : clients){
            tabClient.add(client.getNom() + " " + client.getPrenom());
        }
        int response = getResponseMenu(tabClient);

        return  response -1;
    }

    public static int getTauxNewPret() throws InterruptedException {
        List<String> tabTaux = new ArrayList<>();

        for(Taux taux : Ltaux){
            tabTaux.add(taux.toString());
        }

        int response = getResponseMenu(tabTaux);
        return response -1;

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
            } catch (Exception ignored) {
            }
        }
        return date;



    }


    public static void processing() throws InterruptedException {

        switch (step){
            case 0:
                System.out.println("Bienvenue sur prêt à la consometion \n");
                responseMenuPrincipal = getResponseMenu(Arrays.asList("Ajouter un Pret",
                                                                        "Information Client",
                                                                     "Information Pret" ,
                                                                     "Information Taux"));
                step =1;
                processing();
                break;

            case 1:
                switch (responseMenuPrincipal){
                    case 1:
                        responseMenu1 = menuGetIdUser();
                        if(responseMenu1 >=0){
                            step = 2;
                        }
                        processing();

                        break;
                    case 2:
                        responseMenu1 = menuGetIdUser();
                        if(responseMenu1 >=0){
                            step = 2;
                        }
                        processing();

                        break;
                    case 3:
                        responseMenu1 = getResponseMenu(Arrays.asList("Voir les prêts trier par montant (Plus haut au plus Bas)",
                                "Voir les prêts trier par montant (Plus bas au plus haut)",
                                "Voir les prêts trier par Date (Le plus ancien au plus récent)" ,
                                "Voir les prêts trier par date (Le plus récent au plus ancient)",
                                "Voir les prêts entre deux date"));
                        if(responseMenu1 >0){
                            step = 2;
                        }
                        processing();
                        break;
                    case 4:
//                        for(Taux taux: Ltaux){
//                            System.out.println("Taux " + taux.getId() + " | " + taux + " |  Nombre de prêt accorder a ce taux : " + taux.getPrets().size());
//                        }
//                        getResponseMenu(Arrays.asList());
                        processing();
                        break;

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
                        clients.get(responseMenu1).information();
                        getResponseMenu(Arrays.asList());
                        processing();
                        break;
                    case 3:
                        tabPret = new ArrayList<>();
                        for(Client client: clients){
                            tabPret.addAll(client.getPrets());
                        }
                        switch (responseMenu1){
                            case 1:
                                tabPret = PretTrier.trierMontantDecroissant(tabPret);
                                step = 3;
                                processing();
                                break;
                            case 2:
                                tabPret = PretTrier.trierMontantCroissant(tabPret);
                                step = 3;
                                processing();
                                break;
                            case 3:
                                tabPret = PretTrier.trierDateSouscriptionCroissant(tabPret);
                                step = 3;
                                processing();
                                break;
                            case 4:
                                tabPret = PretTrier.trierDateSouscriptionDecroissant(tabPret);
                                step = 3;
                                processing();
                                break;

                            case 5:
                                System.out.print("Entrez une date de début au format MM/YYYY : ");
                                String dateStr = scanner.nextLine();
                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yyyy");
                                LocalDateTime dateStart = LocalDateTime.parse(dateStr, formatter);

                                System.out.print("Entrez une date de fin au format MM/YYYY : ");
                                dateStr = scanner.nextLine();
                                LocalDateTime dateEnd = LocalDateTime.parse(dateStr, formatter);


                                System.out.println("La date entrée est : " + dateStart + " et la fin : "+ dateEnd);
                        }
                }
                break;
            case 3:
                switch (responseMenuPrincipal) {
                    case 1:

                        idTaux = getTauxNewPret();
                        if (idTaux >= 0) {
                            Ltaux.get(idTaux).getDuree().addTaux(Ltaux.get(idTaux));
                            Ltaux.get(idTaux).getMotif().addTaux(Ltaux.get(idTaux));
                            step = 4;
                        }
                        processing();
                        break;

                    case 3:
                        for(Pret pret: tabPret){
                            System.out.println(pret.getMontantDemande());
                        }
                        int rep = getResponseMenu(Arrays.asList());
                        if(rep == -1){
                            step =1;
                        }
                        processing();
                        break;

                }
                break;
            case 4:
                switch (responseMenuPrincipal){
                    case 1:
                        LocalDateTime dateEffet = getDateEffet();
                        if (dateEffet != null){
                            clients.get(idUser).addPret(montant, dateEffet, Ltaux.get(idTaux));
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


    public static void main(String[] args) throws InterruptedException {
        clients = new ArrayList<>();
        Ltaux = new ArrayList<>();

        Duree unAn = new Duree(12);
        Duree deuxAns = new Duree(24);

        Motif voiture = new Motif("Auto", "Auto");
        Motif moto = new Motif("Moto", "Moto");

        Ltaux.add(new Taux(unAn, voiture, 0.01));
        Ltaux.add(new Taux(deuxAns, voiture, 0.015));
        Ltaux.add(new Taux(unAn, moto, 0.02));
        Ltaux.add(new Taux(deuxAns, moto, 0.025));

        clients.add(new Client("Sauvage", "Timothee"));
        clients.add(new Client("Robert", "Deniblo"));
        clients.add(new Client("John", "Pas"));
        clients.add(new Client("Josephine", "Ange"));
        clients.get(0).addPret(1000, LocalDateTime.of(2023, 7, 3, 0, 0), Ltaux.get(3));
        clients.get(1).addPret(2000, LocalDateTime.of(2023, 4, 29, 0, 0), Ltaux.get(0));
        clients.get(1).addPret(1300, LocalDateTime.of(2022, 8, 18, 0, 0), Ltaux.get(2));
        clients.get(1).addPret(4040, LocalDateTime.of(2023, 1, 5, 0, 0), Ltaux.get(1));
        clients.get(2).addPret(5000, LocalDateTime.of(2024, 2, 8, 0, 0), Ltaux.get(3));
        clients.get(2).addPret(400, LocalDateTime.of(2023, 7, 15, 0, 0), Ltaux.get(0));
        clients.get(3).addPret(999, LocalDateTime.of(2023, 9, 1, 0, 0), Ltaux.get(1));
        clients.get(0).addPret(9999, LocalDateTime.of(2024, 11, 25, 0, 0), Ltaux.get(1));
        clients.get(0).addPret(2345, LocalDateTime.of(2023, 10, 23, 0, 0), Ltaux.get(3));
        clients.get(0).addPret(45564, LocalDateTime.of(2025, 3, 11, 0, 0), Ltaux.get(0));

        responseMenuPrincipal = 0;
        processing();
    }

    public static int getStep() {
        return step;
    }

    public static void setStep(int step) {
        App.step = step;
    }

    public static int getIdUser() {
        return idUser;
    }

    public static void setIdUser(int idUser) {
        App.idUser = idUser;
    }

    public static int getMontant() {
        return montant;
    }

    public static void setMontant(int montant) {
        App.montant = montant;
    }

    public static int getIdTaux() {
        return idTaux;
    }

    public static void setIdTaux(int idTaux) {
        App.idTaux = idTaux;
    }

    public static int getResponseMenuPrincipal() {
        return responseMenuPrincipal;
    }

    public static void setResponseMenuPrincipal(int responseMenuPrincipal) {
        App.responseMenuPrincipal = responseMenuPrincipal;
    }
}