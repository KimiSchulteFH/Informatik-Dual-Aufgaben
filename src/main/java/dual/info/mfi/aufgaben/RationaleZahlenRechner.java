package dual.info.mfi.aufgaben;

public class RationaleZahlenRechner {

    public boolean isGreater(RationaleZahl zahl1, RationaleZahl zahl2) {
        if (sindZahlenGleich(zahl1, zahl2))
            return false;
        int zahl1mitNennerVon2 = zahl1.getZaehler() * zahl2.getNenner();
        int zahl2mitNennerVon1 = zahl2.getZaehler() * zahl1.getNenner();
        return zahl1mitNennerVon2 > zahl2mitNennerVon1;
    }

    public RationaleZahl divide(RationaleZahl zahl1, RationaleZahl zahl2) {
        return multiply(zahl1, new RationaleZahl(zahl2.getNenner(), zahl2.getZaehler()));
    }

    public RationaleZahl add(RationaleZahl zahl1, RationaleZahl zahl2) {
        int zaehler = zahl1.getZaehler() * zahl2.getNenner() + zahl2.getZaehler() * zahl1.getNenner();
        int nenner = zahl1.getNenner() * zahl2.getNenner();
        int gcd = gcd(zaehler, nenner);
        // kürzen mit größtem gemeinsamen Teiler
        int gekuerzterZaehler = zaehler / gcd;
        int gekuerzterNenner = nenner / gcd;
        return new RationaleZahl(gekuerzterZaehler, gekuerzterNenner);
    }

    public RationaleZahl multiply(RationaleZahl zahl1, RationaleZahl zahl2) {
        int zaehler = zahl1.getZaehler() * zahl2.getZaehler();
        int nenner = zahl1.getNenner() * zahl2.getNenner();
        return new RationaleZahl(zaehler, nenner);
    }

    public boolean sindZahlenGleich(RationaleZahl zahl1, RationaleZahl zahl2) {
        return zahl1.getZaehler() * zahl2.getNenner() == zahl1.getNenner() * zahl2.getZaehler();
    }

    // https://stackoverflow.com/a/4009247
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }


}