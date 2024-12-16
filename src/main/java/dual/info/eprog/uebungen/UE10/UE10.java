package dual.info.eprog.uebungen.UE10;

import java.util.List;
import java.util.Random;

public class UE10 {

    public static void main(String[] args) {

    }

    public static void aufgabe4() {

    }

    public static void aufgabe3() {
        //Das hier ist unsere Mitarbeiterverwaltung
        Abteilung abteilung1 = new Abteilung("Abteilung 1");
        Abteilung abteilung2 = new Abteilung("Abteilung 2");
        Abteilung abteilung3 = new Abteilung("Abteilung 3");

        for (int i = 0; i < 15; i++) {
            Mitarbeiter mitarbeiter1 = new Mitarbeiter("Mitarbeiter " + i, abteilung1);
            Mitarbeiter mitarbeiter2 = new Mitarbeiter("Mitarbeiter " + i, abteilung2);
            Mitarbeiter mitarbeiter3 = new Mitarbeiter("Mitarbeiter " + i, abteilung3);
            abteilung1.addMitarbeiter(mitarbeiter1);
            abteilung2.addMitarbeiter(mitarbeiter2);
            abteilung3.addMitarbeiter(mitarbeiter3);
        }
    }

}

class Abteilung {

    private String bezeichung;
    private List<Mitarbeiter> mitarbeiter;

    public Abteilung(String bezeichung) {
        this.bezeichung = bezeichung;
    }

    public String getBezeichung() {
        return bezeichung;
    }

    public List<Mitarbeiter> getMitarbeiter() {
        return mitarbeiter;
    }

    public int getAnzahlMitarbeiter() {
        return mitarbeiter.size();
    }

    public void addMitarbeiter(Mitarbeiter mitarbeiter) {
        this.mitarbeiter.add(mitarbeiter);
    }

    public void ausgabeMitarbeiter() {
        for (Mitarbeiter mitarbeiter1 : mitarbeiter) {
            System.out.println(mitarbeiter1.getName() + ": " + mitarbeiter1.getPersonalnummer());
        }
    }

}

class Mitarbeiter {

    public static int hoechsteMitarbeiterId = 0;

    private String name;
    private int personalnummer, anzahlMitarbeiter;
    private Abteilung abteilung;

    public Mitarbeiter(String name, Abteilung abt) {
        this.name = name;
        this.abteilung = abt;
        this.personalnummer = Integer.parseInt("1" + hoechsteMitarbeiterId++);
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
        return this.abteilung;
    }

    public boolean isKollege(Mitarbeiter mitarbeiter) {
        return mitarbeiter.abteilung.getBezeichung().equals(this.getAbteilung().getBezeichung());
    }
    
    public Mitarbeiter[] bestimmeKollegen() {
        return this.abteilung.getMitarbeiter()
                .stream()
                .filter(mitarbeiter -> mitarbeiter.personalnummer != this.personalnummer)
                .toArray(Mitarbeiter[]::new);
    }

}