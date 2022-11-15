package be.ieps.poo.arnaud.model;

public abstract class Personne implements IPersonne {

    private String nom;
    private String prenom;
    private Profession profession;
    private int id;

    @Override
    public String toString() {
        return "PROFESSION: " + profession +
                " / NOM: " + nom +
                " / PRENOM: " + prenom  +
                " / ID: " + id +
                " / TRAVAIL: " + travail() +
                " / LOISIR: " + loisir();

    }

//Constructeur
    public Personne(String nom, String prenom, Profession profession,int id) {
        this.nom = nom;
        this.prenom = prenom;
        this.profession = profession;
        this.id = id;
    }
    public Personne() {

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }
    public int getId() {return id; }

    public void setId(int id) {this.id = id;}
    //utilisé lors d'un HashSet/Map

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Personne personne = (Personne) o;

        if (!nom.equals(personne.nom)) return false;
        if (!prenom.equals(personne.prenom)) return false;
        return profession.equals(personne.profession);
    }

    @Override
    public int hashCode() {
        int result = nom.hashCode();
        result = 31 * result + prenom.hashCode();
        result = 31 * result + profession.hashCode();
        return result;
    }
}
