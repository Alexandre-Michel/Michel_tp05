package fr.utt.if26.michel_tp05;

import java.util.Comparator;

public class ModuleTriResultat implements Comparator<Module> {

    public int compare(Module m1, Module m2) {
        if (m1.getResultat().getNote() > m2.getResultat().getNote()) {
            return 1;
        } else if (m1.getResultat().getNote() < m2.getResultat().getNote()) {
            return -1;
        } else {
            return 0;
        }

    }
}