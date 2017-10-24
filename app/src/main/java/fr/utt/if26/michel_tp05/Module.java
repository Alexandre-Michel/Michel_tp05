package fr.utt.if26.michel_tp05;

import java.io.Serializable;

public class Module implements Serializable {

    private String sigle;
    private String categorie;
    private int credit;
    private Resultat resultat;

    public Module(String sigle, String categorie, int credit, Resultat resultat) {
        this.sigle = sigle;
        this.categorie = categorie;
        this.credit = credit;
        this.resultat = resultat;
    }

    public String getSigle() {return sigle;}

    public void setSigle(String sigle) {
        this.sigle = sigle;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }


    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public Resultat getResultat() {
        return resultat;
    }

    public void setResultat(Resultat resultat) {
        this.resultat = resultat;
    }

    public String toString() {
        return "Module{" + "sigle=" + getSigle() + ", categorie=" + getCategorie() + ", credit=" + getCredit() +  ", resultat=" + getResultat() + '}';
    }

    public void affiche() {
        System.out.println(toString());
    }
}
