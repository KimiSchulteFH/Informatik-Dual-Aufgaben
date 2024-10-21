package dual.info.mfi.aufgabe1;

public class RationaleZahlenRechner {

    public RationaleZahl add(RationaleZahl zahl1, RationaleZahl zahl2) {
        int zaehler = zahl1.getZaehler() * zahl2.getNenner() + zahl2.getZaehler() * zahl1.getNenner();
        int nenner = zahl1.getNenner() * zahl2.getNenner();
        return new RationaleZahl(zaehler, nenner);
    }

    public RationaleZahl multiply(RationaleZahl zahl1, RationaleZahl zahl2) {
        int zaehler = zahl1.getZaehler() * zahl2.getZaehler();
        int nenner = zahl1.getNenner() * zahl2.getNenner();
        return new RationaleZahl(zaehler, nenner);
    }

    public boolean sindZahlenGleich(RationaleZahl zahl1, RationaleZahl zahl2) {
        return zahl1.getZaehler() * zahl2.getNenner() == zahl1.getNenner() * zahl2.getZaehler();
    }

}