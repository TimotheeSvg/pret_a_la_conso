package service.impl;

import business.Pret;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PretTrier {
    public static List<Pret> trierMontantCroissant(List<Pret> prets) {
        prets.sort(Comparator.comparingDouble(Pret::getMontantDemande));
        return prets;
    }

    public static List<Pret> trierMontantDecroissant(List<Pret> prets) {
        prets.sort(Comparator.comparingDouble(Pret::getMontantDemande).reversed());
        return prets;
    }

    public static List<Pret> trierDateSouscriptionCroissant(List<Pret> prets) {
        prets.sort(Comparator.comparing(Pret::getDateSouscription));
        return prets;
    }

    public static List<Pret> trierDateSouscriptionDecroissant(List<Pret> prets) {
        prets.sort(Comparator.comparing(Pret::getDateSouscription).reversed());
        return prets;
    }

    public static List<Pret> getPretsBetweenDates(List<Pret> prets, LocalDateTime startDate, LocalDateTime endDate) {
        return prets.stream().filter(p -> p.getDateSouscription().isAfter(startDate) && p.getDateSouscription().isBefore(endDate)).collect(Collectors.toList());
    }
}
