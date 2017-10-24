package fr.utt.if26.michel_tp05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


public class Cursus {

    private ArrayList<Module> profil;
    //String label;

    public Cursus() {
        profil = new ArrayList();
        init();
    }

    public void ajoute(Module m) {
        profil.add(m);
    }

    public void init() {
        ajoute(new Module("LO07", "TM", 6, Resultat.A));
        ajoute(new Module("IF26", "TM", 6, Resultat.B));
        ajoute(new Module("NF19", "TM", 6, Resultat.C));
        ajoute(new Module("NF16", "CS", 6, Resultat.A));
        ajoute(new Module("ST09", "ST", 30, Resultat.B));
        ajoute(new Module("IF10", "CS", 6, Resultat.D));
        ajoute(new Module("ST10", "ST", 30, Resultat.C));
    }

    public ArrayList<String> getSigles() {
        ArrayList res = new ArrayList();
        Iterator iterateur = profil.iterator();
        while (iterateur.hasNext()) {
            Module m = (Module) (iterateur.next());
            res.add (m.getSigle());
        }
        return res;
    }

    // A faire par les étudiants
    public ArrayList<String> getResumes() {
        ArrayList res = new ArrayList();
        Iterator iterateur = profil.iterator();
        while (iterateur.hasNext()) {
            Module m = (Module) (iterateur.next());
            String resume = m.getSigle() + " (c=" + m.getCredit() + ", R=" + m.getResultat() + ")";
            res.add(resume);
        }
        return res;
    }

    public ArrayList<Module> getModules() {
        System.out.println (profil.toString());
        return profil;
    }

    public void triParCredit() {
        Collections.sort(profil, new ModuleTriCredit());
    }

    public void triParResultat() {
        Collections.sort(profil, new ModuleTriResultat());
    }
}
