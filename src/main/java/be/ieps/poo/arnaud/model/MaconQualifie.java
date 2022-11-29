package be.ieps.poo.arnaud.model;

    public class MaconQualifie extends Personne {

        public MaconQualifie(String nom, String prenom,int id) {
            super(nom, prenom, Profession.MACONQUALIFIE, id);
        }

        public MaconQualifie() {

        }

        @Override
        public String travail() {
            return "je regarde le macon :) " ;
        }

        @Override
        public String loisir() {
            return "j'aime jouer avec le macon aux Lego !";
        }
    }

