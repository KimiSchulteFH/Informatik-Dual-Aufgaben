package dual.info.mfi.aufgabe1;

public class RationaleZahl {

    private final int zaehler, nenner;

    public RationaleZahl(int zaehler, int nenner) {
        if(nenner == 0)
            throw new IllegalArgumentException("nenner is zero");
        this.zaehler = zaehler;
        this.nenner = nenner;
    }

    public int getZaehler() {
        return zaehler;
    }

    public int getNenner() {
        return nenner;
    }
}
