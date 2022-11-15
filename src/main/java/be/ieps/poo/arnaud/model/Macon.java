package be.ieps.poo.arnaud.model;

    public class Macon extends Personne {

        public Macon(String nom, String prenom,int id) {
            super(nom, prenom, Profession.MACON,id);
        }


        @Override
        public String travail() {
            return "je fait du ciment! " ;
        }

        @Override
        public String loisir() {
            return "j'aime jouer aux Lego !";
        }
    }
