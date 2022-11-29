package be.ieps.poo.arnaud.controller;

import be.ieps.poo.arnaud.exceptions.EntrepriseException;
import be.ieps.poo.arnaud.factory.EmployeFactory;
import be.ieps.poo.arnaud.model.*;
import be.ieps.poo.arnaud.serialisation.Serialisation;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EnterpriseControllerTest {
    private static EmployeFactory factory;
    private static EntrepriseController entrepriseController;
    private static Serialisation serialisation;
    static Personne pers;

    @BeforeAll
    static void initialisation() {
        factory = new EmployeFactory();
        entrepriseController = EntrepriseController.getInstance();
        serialisation = new Serialisation();
    }


    @Test
    @Order(1)
    void ajoutEmployeEntreprise() throws EntrepriseException {
        //ajout directeur (1)
        pers = factory.getPersonne("Boss", "Jean", Profession.DIRECTEUR, 1500, 001);
        entrepriseController.ajouterEmploye(pers);
        //ajout secretaire (2)
        pers = factory.getPersonne("Bureau", "Claudia", Profession.SECRETAIRE, 100);
        entrepriseController.ajouterEmploye(pers);
        pers = factory.getPersonne("Mercury", "Julie", Profession.SECRETAIRE, 101);
        entrepriseController.ajouterEmploye(pers);
        //ajout comptable (1)
        pers = factory.getPersonne("Chiffre", "Max", Profession.COMPTABLE, 200);
        entrepriseController.ajouterEmploye(pers);
        //ajout contremaitre (1)
        pers = factory.getPersonne("Dujardin", "Julien", Profession.CONTREMAITRE, 300);
        entrepriseController.ajouterEmploye(pers);
        //ajout macon (3)
        pers = factory.getPersonne("Ciment", "Linda", Profession.MACON, 400);
        entrepriseController.ajouterEmploye(pers);
        pers = factory.getPersonne("Truelle", "Romuald", Profession.MACON, 401);
        entrepriseController.ajouterEmploye(pers);
        pers = factory.getPersonne("Placard", "Christopher", Profession.MACON, 402);
        entrepriseController.ajouterEmploye(pers);
        //ajout maconqualifie (2)
        pers = factory.getPersonne("Piperzel", "Lionel", Profession.MACONQUALIFIE, 500);
        entrepriseController.ajouterEmploye(pers);
        pers = factory.getPersonne("Chaudron", "Michel", Profession.MACONQUALIFIE, 501);
        entrepriseController.ajouterEmploye(pers);
        //ajout manoeuvre (4)
        pers = factory.getPersonne("Ducamion", "Gauthier", Profession.MANOEUVRE, 600);
        entrepriseController.ajouterEmploye(pers);
        pers = factory.getPersonne("Carref", "Maxime", Profession.MANOEUVRE, 601);
        entrepriseController.ajouterEmploye(pers);
        pers = factory.getPersonne("Dutemps", "Marc", Profession.MANOEUVRE, 602);
        entrepriseController.ajouterEmploye(pers);
        pers = factory.getPersonne("LeCourte", "Arno", Profession.MANOEUVRE, 603);
        entrepriseController.ajouterEmploye(pers);
        serialisation.ecriture(entrepriseController.getListeEmploye());
    }

    @Test
    @Order(2)
    void supprimeDonnee() {
        entrepriseController.supprimerListeEmploye();
        System.out.println("affichage apres suppression1");
        entrepriseController.afficherEntreprise();


    }

    @Test
    @Order(3)
    void ajoutDepuisFichier() {
        entrepriseController.setListeEmploye(serialisation.lectureFichierPersonne());
        System.out.println("apres ajout de fichier2");
        entrepriseController.afficherEntreprise();
    }

    @Test
    @Order(4)
    void verifieDonneeDirecteur() {
        List<Directeur> expectedDirecteurList = Arrays.asList(
                new Directeur("Boss", "Jean", 1500, 001)
        );

        ArrayList<Personne> actualDirecteurList = entrepriseController.getListeEmploye().get(Profession.DIRECTEUR);
        assertEquals(expectedDirecteurList, actualDirecteurList);
    }

    @Test
    @Order(5)
    void verifieDonneeSecretaire() {
        List<Secretaire> expectedSecretaireList = Arrays.asList(
                new Secretaire("Bureau", "Claudia", 100),
                new Secretaire("Mercury", "Julie", 101)
        );

        ArrayList<Personne> actualSecretaireList = entrepriseController.getListeEmploye().get(Profession.SECRETAIRE);
        assertEquals(expectedSecretaireList, actualSecretaireList);
    }

    @Test
    @Order(6)
    void verifieDonneeComptable() {
        List<Comptable> expectedComptableList = Arrays.asList(
                new Comptable("Chiffre", "Max", 200)
        );

        ArrayList<Personne> actualComptableList = entrepriseController.getListeEmploye().get(Profession.COMPTABLE);
        assertEquals(expectedComptableList, actualComptableList);
    }

    @Test
    @Order(7)
    void testTropDEmployee() {
        try {
            pers = factory.getPersonne("Ruelle", "Max", Profession.SECRETAIRE, 102);
            entrepriseController.ajouterEmploye(pers);
        } catch (EntrepriseException exMsgEnt) {
            assertEquals("Une erreur inatendue est survenue avec la profession: SECRETAIRE", exMsgEnt.getMessage());
        }
    }

    @Test
    @Order(8)
    void testSuppDEmployee() {
        System.out.println("affichage avant suppression de l'employé 101\n");
        entrepriseController.afficherEntreprise();
        assertEquals(14, entrepriseController.nombreEmpEntreprise());
        entrepriseController.supprimerPersonne(101);
        assertEquals(13, entrepriseController.nombreEmpEntreprise());
        System.out.println("\naffichage apres suppression de l'employé 101");
        entrepriseController.afficherEntreprise();
    }

    @Test
    @Order(9)
    void testDoublonEmploye() {
        try {
            pers = factory.getPersonne("Bureau", "Claudia", Profession.SECRETAIRE, 100);
            entrepriseController.ajouterEmploye(pers);
        } catch (EntrepriseException exMsgEnt) {
            assertEquals("L'employé avec l'id 100 existe deja", exMsgEnt.getMessage());
        }
    }
}