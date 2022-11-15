package be.ieps.poo.arnaud.model;

    public class Manoeuvre extends Personne {

        public Manoeuvre(String nom, String prenom,int id ){
            super(nom, prenom, Profession.MANOEUVRE,id);
        }

        @Override
        public String travail() {
            return "Je pilote les grues " ;
        }

        @Override
        public String loisir() {
            return "j'ai pas d'amis :'( !";
        }
    }

