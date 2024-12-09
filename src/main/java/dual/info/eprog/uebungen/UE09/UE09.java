package dual.info.eprog.uebungen.UE09;

public class UE09 {



}

class Girokonto {

    private String kontonummer;
    private double kontostand, dispokredit;

    private static int anzahlKonten = 0;

    public Girokonto() {
        anzahlKonten++;
        StringBuffer sb = new StringBuffer("0822");
        int amountOfZeros = 6 - (anzahlKonten + "").length();
        if(amountOfZeros < 0) {
            System.err.println("Es gibt zu viele Konten!");
            System.exit(69);
        }
        for (int i = 0; i < amountOfZeros; i++)
            sb.append("0");
        sb.append(anzahlKonten);
        kontonummer = sb.toString();
    }

    public String getKontonummer() {
        return kontonummer;
    }

    public double getKontostand() {
        return kontostand;
    }

    public double getDispokredit() {
        return dispokredit;
    }

    public void setDispokredit(double dispokredit) {
        this.dispokredit = dispokredit;
    }

    public void einzahlen(double betrag) {
        kontostand += betrag;
    }

    public boolean auszahlen(double betrag) {
        if(kontostand + dispokredit >= betrag) {
            kontostand -= betrag;
            return true;
        }
        return false;
    }

    public boolean ueberweisung(Girokonto zweitesKonto, double betrag) {
        if(auszahlen(betrag)) {
            zweitesKonto.einzahlen(betrag);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Girokonto{" +
                "kontonummer='" + kontonummer + '\'' +
                ", kontostand=" + kontostand +
                ", dispokredit=" + dispokredit +
                '}';
    }

    public static int getAnzahlKonten() {
        return anzahlKonten;
    }
}

class GirokontoTest {

    public static void main(String[] args) {
        Girokonto kimi = new Girokonto();
        kimi.einzahlen(0.02);
        kimi.setDispokredit(100_000);

        Girokonto jan = new Girokonto();

        Girokonto tom = new Girokonto();
        tom.einzahlen(9);



        kimi.ueberweisung(tom, 5_000); // funktioniert
        System.out.println("Kimi: " + kimi);
        System.out.println("Tom: " + tom);
        jan.ueberweisung(kimi, 5_000); // geht nicht
        System.out.println("Jan: " + jan);

        tom.auszahlen(10_000); // geht nicht
        kimi.auszahlen(2); // geht
        System.out.println("Kimi: " + kimi);
        System.out.println("Tom: " + tom);

        jan.ueberweisung(kimi, -10_000);
        System.out.println("Jan: " + jan);
    }

}