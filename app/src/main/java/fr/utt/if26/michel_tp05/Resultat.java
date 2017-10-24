package fr.utt.if26.michel_tp05;

public enum Resultat {

    A(18), B(16), C(14), D(12), E(10), FX(-2), F(-5), ABS(0), R(0);

    private int note;

    Resultat(int note) {
        this.note = note;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }
}