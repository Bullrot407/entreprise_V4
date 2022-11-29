package be.ieps.poo.arnaud.model;

    public class Secretaire extends Personne {

        public Secretaire(String nom, String prenom,int id) {
            super(nom, prenom, Profession.SECRETAIRE, id);
        }


        @Override
        public String travail() {
            return "Je dois faire les tris des documents! " ;
        }

        @Override
        public String loisir() {
            return "j'ecrit un roman!";
        }
    }
