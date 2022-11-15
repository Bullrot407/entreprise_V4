package be.ieps.poo.arnaud.controller;

import be.ieps.poo.arnaud.exceptions.EntrepriseException;
import be.ieps.poo.arnaud.factory.EmployeFactory;
import be.ieps.poo.arnaud.model.Entreprise;
import be.ieps.poo.arnaud.model.Personne;
import be.ieps.poo.arnaud.model.Profession;


public class EntrepriseController {

    /**
      * static Singleton instance.
      */
    private static volatile EntrepriseController instance;

    /**
      * Private constructor for singleton.
      */
    private EntrepriseController() {
    }

    /**
      * Return a singleton instance of EntrepriseController.
      */
    public static EntrepriseController getInstance() {
// Double lock for thread safety.
        if (instance == null) {
            synchronized(EntrepriseController.class){
                if (instance == null) {
                    instance = new EntrepriseController();
                }
            }
        }
        return instance;
    }
}
