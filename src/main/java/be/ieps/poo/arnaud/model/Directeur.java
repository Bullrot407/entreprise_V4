package be.ieps.poo.arnaud.model;


    public  class Directeur extends Personne {

private Float portefeuille;
        public Directeur(String nom, String prenom, float porteFeuille,int id) {
            super(nom, prenom,Profession.DIRECTEUR, id);
            this.portefeuille = porteFeuille;
        }

        public Directeur(String nom, String prenom,int id) {
            super(nom, prenom,Profession.DIRECTEUR, id);
        }


        @Override
        public String toString() {
            return "PROFESSION: " + getProfession()  +

                    " / NOM: " + getNom()  +
                    " / PRENOM:  " + getPrenom() +
                    " / ID: " + getId() +
                    " / PORTEFEUILLE: " + getPortefeuille() +
                    " / TRAVAIL: " + travail() +
                    " / LOISIR: " + loisir();
        }

        public Float getPortefeuille() {
            return portefeuille;
        }

        public void setPortefeuille(Float portefeuille) {
            this.portefeuille = portefeuille;
        }

        @Override
        public String travail() {
            return "Je suis le Boss !!!!";
        }

        @Override
        public String loisir() {
            return "J'aime jouer à virer des gens !";
        }
    }
