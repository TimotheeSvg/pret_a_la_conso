import business.*;


import java.lang.invoke.SwitchPoint;
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
    private static Duree unAn;



    public static List<Pret> sortByMontant(List<Pret> prets){
        for(Pret pret: prets){
            System.out.println(pret.getMontantDemande());
        }
        Collections.sort(prets);

        return prets;
    }

    public static int getResponseInt(String question){
        scanner = new Scanner(System.in);
        int response = 0;

        while(response == 0){
            System.out.println(question + " :");
            try {
                response = scanner.nextInt();
            }catch (Exception e){
                scanner.nextLine();
            }
        }
        return response;
    }

    public static String getResponseString(String question){
        scanner = new Scanner(System.in);
        System.out.println(question + " :");
        return scanner.nextLine();

    }
    public static int getIdNewPret(){
        int response = 0;

        for(int i = 0; i < clients.size(); i++){
            System.out.println(i+1 + ". " + clients.get(i).getNom() + " " + clients.get(i).getPrenom());
        }
        System.out.println(clients.size()+1 + ". Quitter");

        response = getResponseInt("Faite votre choix");

        if (response == clients.size()+1){
            System.exit(0);
        }

        return response- 1;
    }

    public static int getTauxNewPret(){
        int response = 0;

        for(int i = 0; i < Ltaux.size(); i++){
            System.out.println(i+1 + ". " + Ltaux.get(i));
        }

        System.out.println(clients.size()+1 + ". Quitter");

        response = getResponseInt("Veuillez saisir l'id du taux annuel");

        if (response == clients.size() + 1){
            System.exit(0);
        }

        return response -1;

    }

    public static LocalDateTime getDateEffet(){
        LocalDateTime date = null;
        boolean valid = false;
        Scanner scan = new Scanner(System.in);
        while (!valid) {
            try {

                String dateString = getResponseString("Veuillez saisir la date d'effet au format MM/yyyy");
                String[] dateStringSplit = dateString.split("/");

                if(dateStringSplit.length == 2) {
                    int month = Integer.parseInt(dateStringSplit[0]);
                    int year = Integer.parseInt(dateStringSplit[1]);

                    if ((0 < month && month < 13) && (2022 < year)) {
                        date = LocalDate.of(year, month, 1).atStartOfDay();
                        valid = true;
                    }
                }
            } catch (Exception e) {
                continue;
            }
        }
        return date;



    }

    public static int menu(){
        int response = 0;

        System.out.println("Bienvenue sur prêt à la consometion \n");
        System.out.println("1. Voir tous les prêts triées par montant (du plus élevé au plus petit)");
        System.out.println("2. Voir tous les prêts triées par taux (du plus élevé au plus petit)");
        System.out.println("3. Voir la liste des prêts qui débutent entre deux dates données");
        System.out.println("4. Ajouter un prêt");
        System.out.println("5. Quitter");
        while (response == 0 || response > 5) {
            response = getResponseInt("Faites votre choix");
        }
        return response;
    }

    public static void processing(){
        int responseMenu;
        boolean active = true;
        while (active){
            responseMenu = menu();

            switch (responseMenu){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    int idUser = getIdNewPret();
                    int montant = getResponseInt("Veuillez saisir le montant demandé ");
                    int idTaux = getTauxNewPret();
                    Ltaux.get(idTaux).getDuree().addTaux(Ltaux.get(idTaux));
                    Ltaux.get(idTaux).getMotif().addTaux(Ltaux.get(idTaux));
                    LocalDateTime dateEffet = getDateEffet();
                    clients.get(idUser).addPret(montant, dateEffet, Ltaux.get(idTaux));

                    break;
                case 5:
                    active = false;
                    break;

            }


        }

        System.out.println(unAn);


    }
    public static void main(String[] args) {
        clients = new ArrayList<>();
        Ltaux = new ArrayList<>();

        unAn = new Duree(12);
        Duree deuxAns = new Duree(24);

        Motif voiture = new Motif("Auto", "Auto");
        Motif moto = new Motif("Moto", "Moto");

        Ltaux.add(new Taux(unAn, voiture, 0.01));
        Ltaux.add(new Taux(deuxAns, voiture, 0.015));
        Ltaux.add(new Taux(unAn, moto, 0.02));
        Ltaux.add(new Taux(deuxAns, moto, 0.025));
//
//
//        List<Client> clients = new ArrayList<>();
//
        clients.add(new Client("Sauvage", "Timothee"));
        clients.add(new Client("Robert", "Deniblo"));
        clients.add(new Client("John", "Pas"));
        clients.add(new Client("Josephine", "Ange"));
//
//
//        clients.get(0).addPret(1000, LocalDateTime.of(2023, 7, 3, 0, 0), unAnMoto);
//        clients.get(1).addPret(2000, LocalDateTime.of(2023, 4, 29, 0, 0), unAnMoto);
//        clients.get(1).addPret(1300, LocalDateTime.of(2022, 8, 18, 0, 0), unAnMoto);
//        clients.get(1).addPret(4040, LocalDateTime.of(2023, 1, 5, 0, 0), unAnMoto);
//        clients.get(2).addPret(5000, LocalDateTime.of(2024, 2, 8, 0, 0), unAnMoto);
//        clients.get(2).addPret(400, LocalDateTime.of(2023, 7, 15, 0, 0), unAnMoto);
//        clients.get(3).addPret(999, LocalDateTime.of(2023, 9, 1, 0, 0), unAnMoto);
//        clients.get(0).addPret(9999, LocalDateTime.of(2024, 11, 25, 0, 0), unAnMoto);
//        clients.get(0).addPret(2345, LocalDateTime.of(2023, 10, 23, 0, 0), unAnMoto);
//        clients.get(0).addPret(45564, LocalDateTime.of(2025, 3, 11, 0, 0), unAnMoto);
        processing();

    }



}