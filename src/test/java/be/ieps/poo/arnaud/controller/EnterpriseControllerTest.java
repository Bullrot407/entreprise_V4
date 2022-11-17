package be.ieps.poo.arnaud.controller;

import be.ieps.poo.arnaud.exceptions.EntrepriseException;
import be.ieps.poo.arnaud.factory.EmployeFactory;
import be.ieps.poo.arnaud.model.Entreprise;
import be.ieps.poo.arnaud.model.Personne;
import be.ieps.poo.arnaud.model.Profession;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        //ajout directeur
        pers = factory.getPersonne("Lebic", "Bobile", Profession.DIRECTEUR, 001);
        entreprise.ajouterEmploye(pers);
        //ajout secretaire
        pers = factory.getPersonne("Lebic", "Bobile", Profession.SECRETAIRE, 100);
        entreprise.ajouterEmploye(pers);
        pers = factory.getPersonne("Lebrun", "Jule", Profession.SECRETAIRE, 101);
        entreprise.ajouterEmploye(pers);
    }

    @Test
    @Order(2)
    void testTropDEmployee() {
        try {
            pers = factory.getPersonne("Ruelle", "Max", Profession.SECRETAIRE, 102);
            entreprise.ajouterEmploye(pers);
        } catch (EntrepriseException exMsgEnt) {
            System.out.println("Trop d'employé");
        }
        //assertThrows(EntrepriseException.class, () -> {entreprise.ajouterEmploye(pers); },"pas bien");

    }

    @Test
    @Order(3)
    void testSuppDEmployee() {
        System.out.println("affichage avant suppression");
        entreprise.afficherEntreprise();
        assertEquals(2, entreprise.nombreEmpEntreprise());
        entreprise.supprimerPersonne(101);
        assertEquals(1, entreprise.nombreEmpEntreprise());
        System.out.println("\naffichage apres suppression");
        entreprise.afficherEntreprise();

    }
}