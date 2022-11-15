package be.ieps.poo.arnaud.model;


    public  class Directeur extends Personne {

        public float porteFeuille;

        public Directeur(String nom, String prenom, float porteFeuille,int id) {
            super(nom, prenom,Profession.DIRECTEUR,id);

            this.porteFeuille = porteFeuille;
        }

        public Directeur(String nom, String prenom,int id) {
            super(nom, prenom,Profession.DIRECTEUR,id);
        }


        @Override
        public String toString() {
            return "PROFESSION: " + getProfession()  +
                    " / NOM: " + getNom()  +
                    " / PRENOM:  " + getPrenom() +
                    " / PORTEFEUILLE: " + porteFeuille +
                    " / TRAVAIL: " + travail() +
                    " / LOISIR: " + loisir();
        }

        public float getPorteFeuille() {
            return porteFeuille;
        }

        public void setPorteFeuille(float porteFeuille) {
            this.porteFeuille = porteFeuille;
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
