package be.ieps.poo.arnaud.factory;

import be.ieps.poo.arnaud.exceptions.EntrepriseException;
import be.ieps.poo.arnaud.model.*;

public class EmployeFactory {

    public Personne getPersonne(String nom, String prenom, Profession profession, int id) throws EntrepriseException {
        return switch (profession) {
            /*case DIRECTEUR -> new Directeur(nom, prenom, 0f, id);*/
            case SECRETAIRE -> new Secretaire(nom, prenom, id);
            case COMPTABLE -> new Comptable(nom, prenom, id);
            case MACON -> new Macon(nom, prenom, id);
            case MACONQUALIFIE -> new MaconQualifie(nom, prenom, id);
            case MANOEUVRE -> new Manoeuvre(nom, prenom, id);
            case CONTREMAITRE -> new Contremaitre(nom, prenom, id);
            default -> throw new EntrepriseException("La profession ne peut pas etre NULL");
        };
    }

    public Personne getPersonne(String nom, String prenom, Profession profession, float porteFeuille, int id) throws EntrepriseException {
        return switch (profession) {
            case DIRECTEUR -> new Directeur(nom, prenom, 0f, id);
            default -> throw new EntrepriseException("La profession ne peut pas etre NULL");
        };
    }
}

