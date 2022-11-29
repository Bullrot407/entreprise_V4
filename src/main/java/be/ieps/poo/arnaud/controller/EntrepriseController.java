package be.ieps.poo.arnaud.controller;

import be.ieps.poo.arnaud.exceptions.EntrepriseException;
import be.ieps.poo.arnaud.model.Personne;
import be.ieps.poo.arnaud.model.Profession;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class EntrepriseController implements Serializable {


    /**
     *  * static Singleton instance.
     *  
     */
    private static volatile EntrepriseController instance;

    /**
     *  * Private constructor for singleton.
     *  
     */
    private EntrepriseController() {
        initialisationEntreprise();
    }

    /**
     *  * Return a singleton instance of EntrepriseController.
     *  
     */
    public static EntrepriseController getInstance() {
// Double lock for thread safety.
        if (instance == null) {
            instance = new EntrepriseController();
        }
        return instance;
    }

    private HashMap<Profession, ArrayList<Personne>> listeEmploye;

    private void initialisationEntreprise() {
        listeEmploye = new HashMap<>();
        listeEmploye.put(Profession.DIRECTEUR, new ArrayList<>());
        listeEmploye.put(Profession.SECRETAIRE, new ArrayList<>());
        listeEmploye.put(Profession.COMPTABLE, new ArrayList<>());
        listeEmploye.put(Profession.MACON, new ArrayList<>());
        listeEmploye.put(Profession.CONTREMAITRE, new ArrayList<>());
        listeEmploye.put(Profession.MANOEUVRE, new ArrayList<>());
        listeEmploye.put(Profession.MACONQUALIFIE, new ArrayList<>());
    }

    public void afficherEntreprise() {
        for (ArrayList<Personne> arLisPersonnes : listeEmploye.values()) {
            for (Personne personne : arLisPersonnes) {
                System.out.println(personne.toString());
            }
        }
    }

    public int nombreEmpEntreprise() {
        int nbEmpEnt = 0;
        for (ArrayList<Personne> arLisPersonnes : listeEmploye.values()) {
            nbEmpEnt += arLisPersonnes.size();
        }
        return nbEmpEnt;
    }

    public void ajouterEmploye(Personne personne) throws EntrepriseException {
        if (peuxAjouterPersonne(personne)) {
            listeEmploye.get(personne.getProfession()).add(personne);
        } else {
            throw new EntrepriseException(String.format("Une erreur inatendue est survenue avec la profession: %s", personne.getProfession()));
        }
    }

    public boolean peuxAjouterPersonne(Personne personne) throws EntrepriseException {
        if (employeDejaPresent(personne)) {
            throw new EntrepriseException(String.format("L'employé avec l'id %s existe deja", personne.getId()));
        }
        if (listeEmploye.get(personne.getProfession()).size() >= personne.getProfession().getMaxEmploye()) return false;
        return true;
    }

    public boolean employeDejaPresent(Personne personne) {
        for (ArrayList<Personne> personnes : listeEmploye.values()) {
            for (Personne employe : personnes) {
                if (employe.getId() == personne.getId()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void supprimerPersonne(int id) {
        try {
            Personne pers = cherchePersonne(id);
            listeEmploye.get(pers.getProfession()).remove(pers);
        } catch (EntrepriseException entExMsg) {
            System.out.println(entExMsg.getMessage());
        }
    }

    public void supprimerListeEmploye() {
        listeEmploye.clear();
    }

    public Personne cherchePersonne(int id) throws EntrepriseException {
        for (ArrayList<Personne> arLisPersonnes : listeEmploye.values()) {
            for (Personne personne : arLisPersonnes) {
                if (personne.getId() == id) {
                    return personne;
                }

            }
        }
        throw new EntrepriseException(String.format("La perseronne avec l'%s n'existe pas", id));
    }

    public HashMap<Profession, ArrayList<Personne>> getListeEmploye() {
        return listeEmploye;
    }

    public void setListeEmploye(HashMap<Profession, ArrayList<Personne>> listeEmploye) {
        this.listeEmploye = listeEmploye;
    }
}
