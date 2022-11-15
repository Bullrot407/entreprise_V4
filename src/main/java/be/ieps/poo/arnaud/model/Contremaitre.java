package be.ieps.poo.arnaud.model;

public class Contremaitre extends Personne {

    public Contremaitre(String nom, String prenom,int id) {

            super(nom, prenom, Profession.CONTREMAITRE,id);
        }


        @Override
        public String travail() {
            return "Battre les Jedi!!! " ;
        }

        @Override
        public String loisir() {
            return " Allez au cinéma !";
        }
    }
