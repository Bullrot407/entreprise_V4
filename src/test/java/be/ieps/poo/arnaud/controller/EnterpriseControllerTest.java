package be.ieps.poo.arnaud.controller;

import be.ieps.poo.arnaud.exceptions.EntrepriseException;
import be.ieps.poo.arnaud.factory.EmployeFactory;
import be.ieps.poo.arnaud.model.*;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EnterpriseControllerTest {
    private static EmployeFactory factory;
    private static Entreprise entreprise;
    static Personne pers;

    @BeforeAll
    static void initialisation() {
        factory = new EmployeFactory();
        entreprise = new Entreprise();
    }


    @Test
    @Order(1)
    void ajoutEmployeEntreprise() throws EntrepriseException {
        //ajout directeur (1)
        pers = factory.getPersonne("Boss", "Jean", Profession.DIRECTEUR, 1500, 001);
        entreprise.ajouterEmploye(pers);
        //ajout secretaire (2)
        pers = factory.getPersonne("Bureau", "Claudia", Profession.SECRETAIRE, 100);
        entreprise.ajouterEmploye(pers);
        pers = factory.getPersonne("Mercury", "Julie", Profession.SECRETAIRE, 101);
        entreprise.ajouterEmploye(pers);
        //ajout comptable (1)
        pers = factory.getPersonne("Chiffre", "Max", Profession.COMPTABLE, 200);
        entreprise.ajouterEmploye(pers);
        //ajout contremaitre (1)
        pers = factory.getPersonne("Dujardin", "Julien", Profession.CONTREMAITRE, 300);
        entreprise.ajouterEmploye(pers);
        //ajout macon (3)
        pers = factory.getPersonne("Ciment", "Linda", Profession.MACON, 400);
        entreprise.ajouterEmploye(pers);
        pers = factory.getPersonne("Truelle", "Romuald", Profession.MACON, 401);
        entreprise.ajouterEmploye(pers);
        pers = factory.getPersonne("Placard", "Christopher", Profession.MACON, 402);
        entreprise.ajouterEmploye(pers);
        //ajout maconqualifie (2)
        pers = factory.getPersonne("Piperzel", "Lionel", Profession.MACONQUALIFIE, 500);
        entreprise.ajouterEmploye(pers);
        pers = factory.getPersonne("Chaudron", "Michel", Profession.MACONQUALIFIE, 501);
        entreprise.ajouterEmploye(pers);
        //ajout manoeuvre (4)
        pers = factory.getPersonne("Ducamion", "Gauthier", Profession.MANOEUVRE, 600);
        entreprise.ajouterEmploye(pers);
        pers = factory.getPersonne("Carref", "Maxime", Profession.MANOEUVRE, 601);
        entreprise.ajouterEmploye(pers);
        pers = factory.getPersonne("Dutemps", "Marc", Profession.MANOEUVRE, 602);
        entreprise.ajouterEmploye(pers);
        pers = factory.getPersonne("LeCourte", "Arno", Profession.MANOEUVRE, 603);
        entreprise.ajouterEmploye(pers);
    }
    @Test
    @Order(2)
    void verifieDonneeDirecteur() {
        List<Directeur> expectedDirecteurList = Arrays.asList(
                new Directeur("Boss", "Jean",1500, 001)
        );

        ArrayList<Personne> actualDirecteurList = entreprise.getListeEmploye().get(Profession.DIRECTEUR);
        assertEquals(expectedDirecteurList, actualDirecteurList);
    }
    @Test
    @Order(3)
    void verifieDonneeSecretaire() {
        List<Secretaire> expectedSecretaireList = Arrays.asList(
                new Secretaire("Bureau", "Claudia", 100),
                new Secretaire("Mercury", "Julie", 101)
        );

        ArrayList<Personne> actualSecretaireList = entreprise.getListeEmploye().get(Profession.SECRETAIRE);
        assertEquals(expectedSecretaireList, actualSecretaireList);
    }
    @Test
    @Order(4)
    void verifieDonneeComptable() {
        List<Comptable> expectedComptableList = Arrays.asList(
                new Comptable("Chiffre", "Max", 200)
        );

        ArrayList<Personne> actualComptableList = entreprise.getListeEmploye().get(Profession.COMPTABLE);
        assertEquals(expectedComptableList, actualComptableList);
    }
    @Test
    @Order(5)
    void testTropDEmployee() {
        try {
            pers = factory.getPersonne("Ruelle", "Max", Profession.SECRETAIRE, 102);
            entreprise.ajouterEmploye(pers);
        } catch (EntrepriseException exMsgEnt) {
            assertEquals("Une erreur inatendue est survenue avec la profession: SECRETAIRE", exMsgEnt.getMessage());
        }
    }

    @Test
    @Order(6)
    void testSuppDEmployee() {
        System.out.println("affichage avant suppression");
        entreprise.afficherEntreprise();
        assertEquals(14, entreprise.nombreEmpEntreprise());
        entreprise.supprimerPersonne(101);
        assertEquals(13, entreprise.nombreEmpEntreprise());
        System.out.println("\naffichage apres suppression");
        entreprise.afficherEntreprise();
    }

    @Test
    @Order(7)
    void testDoulonEmploye() {
        try {
            pers = factory.getPersonne("Bureau", "Claudia", Profession.SECRETAIRE, 100);
            entreprise.ajouterEmploye(pers);
        } catch (EntrepriseException exMsgEnt) {
            assertEquals("L'employé avec l'id 100 existe deja", exMsgEnt.getMessage());
        }
    }
}