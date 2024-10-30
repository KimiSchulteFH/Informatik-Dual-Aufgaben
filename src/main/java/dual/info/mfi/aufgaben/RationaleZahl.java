package dual.info.mfi.aufgaben;

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

    @Override
    public String toString() {
        return zaehler + "/" + nenner;
    }
}
