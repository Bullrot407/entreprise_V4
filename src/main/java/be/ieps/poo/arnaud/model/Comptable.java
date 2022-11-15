package be.ieps.poo.arnaud.model;

public class Comptable extends Personne {


    public Comptable(String nom, String prenom, int id) {

        super(nom, prenom, Profession.COMPTABLE, id);
    }


    @Override
    public String travail() {
        return "J'aime compter les sous! ";
    }

    @Override
    public String loisir() {
        return "j'aime jouer au monopoly !";
    }

}