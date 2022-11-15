package be.ieps.poo.arnaud.controller;

import be.ieps.poo.arnaud.exceptions.EntrepriseException;
import be.ieps.poo.arnaud.factory.EmployeFactory;
import be.ieps.poo.arnaud.model.Entreprise;
import be.ieps.poo.arnaud.model.Personne;
import be.ieps.poo.arnaud.model.Profession;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


class EnterpriseControllerTest {
    private  EmployeFactory factory;
    private Entreprise entreprise;
    static Personne pers;

    @BeforeEach
    void initialisation(){
     this.factory  = new EmployeFactory();
     this.entreprise   = new Entreprise();
    }

    @Test
    void testTropDEmployee() throws EntrepriseException {
        pers = factory.getPersonne("Lebic", "Bobile", Profession.SECRETAIRE, 100);
        System.out.println(pers);
        entreprise.ajouterEmploye(pers);
        pers = factory.getPersonne("Lebrun", "Jule", Profession.SECRETAIRE, 101);
        entreprise.ajouterEmploye(pers);
        System.out.println(entreprise.getListeEmploye().get(Profession.SECRETAIRE).size());
        pers = factory.getPersonne("Ruelle", "Max", Profession.SECRETAIRE, 102);

       //assertThrows(EntrepriseException.class, () -> {entreprise.ajouterEmploye(pers); },"pas bien");

    }
}
  /*  @Test
    void testProfessionInconnue() throws EntrepriseException {
        EntrepriseException ex = assertThrows(EntrepriseException.class, () -> {
            entCont.ajouterEmploye("Importe", "Jean", "Brol", 999);
        });
        assertEquals("La profession \"Brol\" demandée n'existe pas!!!", ex.getMessage());
    }
}

    @Test
    void testSuppDEmployee(Personne personne) throws EntrepriseException {
        entCont.supprimerEmploye(personne.getProfession(), personne.getId());

    }



    @Test
    void testDirecteur() throws EntrepriseException {
        entCont.ajouterEmploye("LeMacon", "Bob", Profession.DIRECTEUR, 001);
        assertEquals(entCont.entreprise.listeEmploye.get("Directeur").iterator().next().getPrenom(), "Bob");
        assertEquals(entCont.entreprise.listeEmploye.get("Directeur").iterator().next().getNom(), "LeMacon");
        assertEquals(entCont.entreprise.listeEmploye.get("Directeur").iterator().next().getProfession(), "Directeur");
        assertEquals(entCont.entreprise.listeEmploye.get("Directeur").iterator().next().getId(), "001");
    }

    @Test
    void testSecretaire() throws EntrepriseException {
        entCont.ajouterEmploye("Lebic", "Bobile", "Secretaire", 100);
        entCont.ajouterEmploye("Lebrun", "Jule", "Secretaire", 101);

        Iterator<Personne> it = entCont.entreprise.listeEmploye.get("Secretaire").iterator();
        Personne sec1 = it.next();
        assertEquals(sec1.getPrenom(), "Bobile");
        assertEquals(sec1.getNom(), "Lebic");
        assertEquals(sec1.getProfession(), "Secretaire");
        assertEquals(sec1.getId(), 100);
        Personne sec2 = it.next();
        assertEquals(sec2.getNom(), "Lebrun");
        assertEquals(sec2.getPrenom(), "Jule");
        assertEquals(sec2.getProfession(), "Secretaire");
        assertEquals(sec1.getId(), 101);
    }

    @Test
    void testComptable() throws EntrepriseException {
        entCont.ajouterEmploye("Lebic", "Bobile", "Comptable", 200);

        Iterator<Personne> it = entCont.entreprise.listeEmploye.get("Comptable").iterator();
        Personne comp1 = it.next();
        assertEquals(comp1.getPrenom(), "Bobile");
        assertEquals(comp1.getNom(), "Lebic");
        assertEquals(comp1.getProfession(), "Comptable");
        assertEquals(comp1.getId(), "200");
    }

    @Test
    void testContrmaitre() throws EntrepriseException {
        entCont.ajouterEmploye("Lebic", "Bobile", "contreMaitre", 300);

        Iterator<Personne> it = entCont.entreprise.listeEmploye.get("contreMaitre").iterator();
        Personne comp1 = it.next();
        assertEquals(comp1.getPrenom(), "Bobile");
        assertEquals(comp1.getNom(), "Lebic");
        assertEquals(comp1.getProfession(), "contreMaitre");
        assertEquals(comp1.getId(), "300");
    }

    @Test
    void testMacon() throws EntrepriseException {
        entCont.ajouterEmploye("Lebic", "Bobile", "macon", 300);

        Iterator<Personne> it = entCont.entreprise.listeEmploye.get("macon").iterator();
        Personne comp1 = it.next();
        assertEquals(comp1.getPrenom(), "Bobile");
        assertEquals(comp1.getNom(), "Lebic");
        assertEquals(comp1.getProfession(), "contreMaitre");
        assertEquals(comp1.getId(), "300");
    }

}*/