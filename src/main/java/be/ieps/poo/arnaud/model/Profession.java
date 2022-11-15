package be.ieps.poo.arnaud.model;

public enum Profession {
    DIRECTEUR("directeur",1),
    SECRETAIRE("secretaire",2),
    COMPTABLE("Comptable",1),
    MACONQUALIFIE("maconqualifie",2),
    MACON("macon",3),
    MANOEUVRE("manoeuvre",4),
    CONTREMAITRE("contremaitre",1);

    private String profession;
    private int maxEmploye;

    Profession(String profession, int maxEmploye) {
        this.profession = profession;
        this.maxEmploye = maxEmploye;

    }

    public String getProfession() {
        return profession;
    }
    public int getMaxEmploye() {
        return maxEmploye;
    }
}

