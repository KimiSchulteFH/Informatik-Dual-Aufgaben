package dual.info.eprog.uebungen.UE11;

public class UE11 {



}

class Manager extends Mitarbeiter {

    private double festgehalt, provision, umsatz;

    public Manager(String name, double fgehalt, double provision,
                   Abteilung abt) {
        super(name, abt);
        this.festgehalt = fgehalt;
        this.provision = provision;
    }

    public void setUmsatz(double umsatz) {
        this.umsatz = umsatz;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "name=" + getName() +
                " personalnummer=" + getPersonalnummer() +
                " festgehalt=" + festgehalt +
                ", provision=" + provision +
                ", umsatz=" + umsatz +
                '}';
    }

    @Override
    double berechneGehalt() {
        return (festgehalt + provision) * umsatz;
    }
}

class Geschaeftsfuehrer extends Manager {

    private double zulage;

    public Geschaeftsfuehrer(String name, double fgehalt, double provision, double zulage, Abteilung abt) {
        super(name, fgehalt, provision, abt);
        this.zulage = zulage;
    }

    @Override
    public String toString() {
        return "Geschaeftsfuehrer{" +
                "name=" + getName() +
                " personalnummer=" + getPersonalnummer() +
                " zulage=" + zulage +
                '}';
    }

    @Override
    double berechneGehalt() {
        return super.berechneGehalt() + zulage;
    }
}

class Angestellter extends Mitarbeiter {

    private double grundgehalt, ortszuschlag, zulage;

    public Angestellter(String name, Abteilung abt, double grundgehalt, double ortszuschlag, double zulage) {
        super(name, abt);
        this.grundgehalt = grundgehalt;
        this.ortszuschlag = ortszuschlag;
        this.zulage = zulage;
    }

    @Override
    public String toString() {
        return "Angestellter{" +
                "grundgehalt=" + grundgehalt +
                ", ortszuschlag=" + ortszuschlag +
                ", zulage=" + zulage +
                '}';
    }

    @Override
    double berechneGehalt() {
        return grundgehalt + ortszuschlag + zulage;
    }
}

class Arbeiter extends Mitarbeiter {

    private double stundenlohn, anzahlStunden, ueberstundenZuschlag, anzahlUeberstunden;

    public Arbeiter(String name, Abteilung abt, double stundenlohn, double anzahlStunden, double ueberstundenZuschlag, double anzahlUeberstunden) {
        super(name, abt);
        this.stundenlohn = stundenlohn;
        this.anzahlStunden = anzahlStunden;
        this.ueberstundenZuschlag = ueberstundenZuschlag;
        this.anzahlUeberstunden = anzahlUeberstunden;
    }

    @Override
    public String toString() {
        return "Arbeiter{" +
                "stundenlohn=" + stundenlohn +
                ", anzahlStunden=" + anzahlStunden +
                ", ueberstundenZuschlag=" + ueberstundenZuschlag +
                ", anzahlUeberstunden=" + anzahlUeberstunden +
                '}';
    }

    public void setAnzahlUeberstunden(double anzahlUeberstunden) {
        this.anzahlUeberstunden = anzahlUeberstunden;
    }

    @Override
    double berechneGehalt() {
        return anzahlStunden * stundenlohn + anzahlUeberstunden * ueberstundenZuschlag;
    }
}

class Abteilung {
    // Attribute
    private static final int MAX_MITARBEITER = 15;
    private int anzMitarbeiter;
    private Mitarbeiter[] dieMitarbeiter; // Feld von Referenzen
    // auf Mitarbeiter
    private String bezeichnung;

    // Konstruktor
    public Abteilung(String bezeichnung) {
        dieMitarbeiter = new Mitarbeiter[MAX_MITARBEITER];
        anzMitarbeiter = 0;
        this.bezeichnung = bezeichnung;
    }

    // Methoden
    public String getBezeichnung() {
        return bezeichnung;
    }

    public int getAnzahlMitarbeiter() {
// Liefert die Anzahl der zugeordneten Mitarbeiter als Ergebnis
        return anzMitarbeiter;
    }

    public void addMitarbeiter(Mitarbeiter mit) {
        // Fügt eine Verbindung von einer Abteilung zu einem
    // Mitarbeiter hinzu

        if (anzMitarbeiter < MAX_MITARBEITER) {
            dieMitarbeiter[anzMitarbeiter] = mit;
            anzMitarbeiter++;
        }
    }

    public Mitarbeiter getMitarbeiter(int i) {
        // Liefert eine Referenz auf den i-ten Mitarbeiter
        Mitarbeiter ergebnis = null;

        if (0 <= i && i < anzMitarbeiter)
            ergebnis = dieMitarbeiter[i];

        return ergebnis;
    }

    public void ausgabeMitarbeiter() {
        // Ausgabe der Mitarbeiter auf der Konsole
        System.out.println("Mitarbeiter der Abteilung " + bezeichnung +
                ":");
        for (int i = 0; i < anzMitarbeiter; i++) {
            Mitarbeiter mit = dieMitarbeiter[i];
            System.out.println(mit.getPersonalnummer() + " " +
                    mit.getName());
        }
    }

}

abstract class Mitarbeiter {
    // Attribute
    private static int anzahlMitarbeiter = 0;

    private Abteilung dieAbteilung; // Referenz auf die zugehörige Abteilung

    private String name;
    private int personalnummer;

    // Konstruktor
    public Mitarbeiter(String name, Abteilung abt) {
        this.name = name;
        this.personalnummer = ++anzahlMitarbeiter;

        // Assoziation vom Mitarbeiter zur Abteilung aufbauen
        this.dieAbteilung = abt;
        // Assoziation von der Abteilung zum Mitarbeiter aufbauen
        abt.addMitarbeiter(this);
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public int getPersonalnummer() {
        return this.personalnummer;
    }

    public Abteilung getAbteilung() {
        return this.dieAbteilung;
    }

    public boolean isKollege(Mitarbeiter m) {
        // Überprüfung, ob zwei Mitarbeiter Kollegen sind
        Abteilung a1 = this.getAbteilung();
        Abteilung a2 = m.getAbteilung();

        return this != m && a1 == a2;

  /* Kurzversion
  return this != m && this.getAbteilung() == m.getAbteilung();
  */
    }

    public Mitarbeiter[] bestimmeKollegen() {
        // Bestimmung aller Kollegen eines Mitarbeiters
        Mitarbeiter[] ergebnis = null;
        Abteilung a;
        int n;

        // Abteilung des Mitarbeiters bestimmen
        a = this.getAbteilung();

        // Mitarbeiter der Abteilung ohne ursprünglichen Mitarbeiter in
        // Feld ablegen
        n = a.getAnzahlMitarbeiter();

        if (n > 1) {
            ergebnis = new Mitarbeiter[n-1];
            int pos;

            pos = 0;
            for (int i = 0; i < n; i++) {
                Mitarbeiter m = a.getMitarbeiter(i);
                if (this != m) {
                    ergebnis[pos] = m;
                    pos++;
                }
            }
        }

        return ergebnis;
    }

    @Override
    public String toString() {
        return "Mitarbeiter{" +
                "dieAbteilung=" + dieAbteilung +
                ", name='" + name + '\'' +
                ", personalnummer=" + personalnummer +
                '}';
    }

    abstract double berechneGehalt();
}

class Mitarbeiterverwaltung {

    public static void main(String[] args) {
        Abteilung abteilung = new Abteilung("asd");
        Mitarbeiter manager = new Manager("Manager", 1, 1, abteilung);
        Mitarbeiter gf = new Geschaeftsfuehrer("GF", -1, -1, -1, abteilung);
        System.out.println(manager);
        System.out.println(manager.getName() + " Gehalt: " + manager.berechneGehalt());
        System.out.println(gf);
        System.out.println(gf.getName() + " Gehalt: " + gf.berechneGehalt());
    }

}