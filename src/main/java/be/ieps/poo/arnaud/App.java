package be.ieps.poo.arnaud;

import be.ieps.poo.arnaud.controller.EntrepriseController;
import be.ieps.poo.arnaud.exceptions.EntrepriseException;
import be.ieps.poo.arnaud.factory.EmployeFactory;
import be.ieps.poo.arnaud.model.Personne;
import be.ieps.poo.arnaud.model.Profession;
import be.ieps.poo.arnaud.serialisation.Serialisation;

public class App {

    private static EmployeFactory factory;
    private static EntrepriseController entrepriseController;
    static Personne pers, pers1, pers2;


    public static void main(String[] args) throws EntrepriseException {

        factory = new EmployeFactory();
        entrepriseController = EntrepriseController.getInstance();

/*        //ajout directeur (1)
        pers = factory.getPersonne("Boss", "Jean", Profession.DIRECTEUR, 1500, 001);
        try {
            entrepriseController.ajouterEmploye(pers);
        } catch (EntrepriseException e) {
            e.printStackTrace();
        }
        //ajout secretaire (2)
        pers = factory.getPersonne("Bureau", "Claudia", Profession.SECRETAIRE, 100);
        try {
            entrepriseController.ajouterEmploye(pers);
        } catch (EntrepriseException e) {
            e.printStackTrace();
        }
        pers = factory.getPersonne("Burea", "Claudi", Profession.SECRETAIRE, 101);
        try {
            entrepriseController.ajouterEmploye(pers);
        } catch (EntrepriseException e) {
            e.printStackTrace();
        }
        try {
            entrepriseController.supprimerPersonne(200);

        } catch (
                EntrepriseException e) {
            e.printStackTrace();*/

        //ajout directeur (1)

        try {
            entrepriseController.ajouterEmploye(factory.getPersonne("Boss", "Jean", Profession.DIRECTEUR, 1500, 001));
            entrepriseController.ajouterEmploye(factory.getPersonne("Boss", "Jean", Profession.DIRECTEUR, 1500, 001));
        } catch (EntrepriseException e) {
            e.printStackTrace();
        }
        entrepriseController.afficherEntreprise();
        System.out.println("\ndeuxieme test\n");


        try {
            entrepriseController.ajouterEmploye(factory.getPersonne("Bureau", "Claudia", Profession.SECRETAIRE, 100));
            entrepriseController.ajouterEmploye(factory.getPersonne("Burea", "Claudi", Profession.SECRETAIRE, 101));
            entrepriseController.ajouterEmploye(factory.getPersonne("Chiffre", "Max", Profession.COMPTABLE, 200));
            entrepriseController.afficherEntreprise();
            entrepriseController.supprimerPersonne(200);
            entrepriseController.supprimerPersonne(300);
        } catch (EntrepriseException e) {
            e.printStackTrace();
        }
        entrepriseController.afficherEntreprise();
    }

}

