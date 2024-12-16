package dual.info.eprog.uebungen.UE10;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class UE10 {

    public static void main(String[] args) {
       // aufgabe3();
        aufgabe4();
    }

    public static void aufgabe4() {
        Game game = new Game();
        game.start();
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

class Game {

    private Wanderer[] wanderer;
    private Taschenlampe taschenlampe;

    public Game() {
        wanderer = new Wanderer[]{
                new Wanderer('A', 5),
                new Wanderer('B', 10),
                new Wanderer('C', 20),
                new Wanderer('D', 25),
        };
        taschenlampe = new Taschenlampe(60);
    }

    public void start() {
        while (!istGewonnen()) {
            System.out.println("Taschenlampe: " + taschenlampe.minutesLeft);
            System.out.println("Die Lampe ist " + taschenlampe.position.toString() + ", diese Wanderer können gehen:");
            for (Wanderer wanderer1 : wanderer) {
                if(wanderer1.position == taschenlampe.position)
                    System.out.print(wanderer1.name + "(" + wanderer1.distanceInMinutes + ")   ");
            }
            Scanner scanner = new Scanner(System.in);
            System.out.print("\nWelche Wanderer sollen gehen (1 oder 2 Zeichen zwischen A und D): ");
            String input = scanner.nextLine();
            if(input.length() > 2 || !input.matches("[A-D]*"))
                continue;
            int slowest = 0;
            for (char c : input.toCharArray()) {
                Wanderer wanderer = getWanderer(c);
                if(wanderer.distanceInMinutes > slowest)
                    slowest = wanderer.distanceInMinutes;
                switchPosition(wanderer);
            }
            switchPosition(taschenlampe);
            taschenlampe.useLamp(slowest);
        }
        System.out.println("Gewonnen!");
    }

    public boolean istGewonnen() {
        for (Wanderer wanderer1 : wanderer) {
            if(wanderer1.position == Position.Links)
                return false;
        }
        return true;
    }

    private Wanderer getWanderer(char c) {
        for (Wanderer wanderer1 : wanderer) {
            if(wanderer1.name == c && wanderer1.position == taschenlampe.position) {
                return wanderer1;
            }
        }
        System.out.println("Systemfehler: Falscher Input!");
        System.exit(69);
        return null;
    }

    private void switchPosition(Wanderer wanderer) {
        if(wanderer.position == Position.Links) {
            wanderer.position = Position.Rechts;
        } else {
            wanderer.position = Position.Links;
        }
    }

    private void switchPosition(Taschenlampe lampe) {
        if(lampe.position == Position.Links) {
            lampe.position = Position.Rechts;
        } else {
            lampe.position = Position.Links;
        }
    }
}

class Wanderer {
    final char name;
    final int distanceInMinutes;
    Position position;

    public Wanderer(char name, int distanceInMinutes) {
        this.name = name;
        this.distanceInMinutes = distanceInMinutes;
        position = Position.Links;
    }
}
enum Position {
    Rechts, Links
}

class Taschenlampe {

    int minutesLeft;
    Position position;

    public Taschenlampe(int minutesLeft) {
        this.minutesLeft = minutesLeft;
        position = Position.Links;
    }

    public void useLamp(int minutes) {
        this.minutesLeft -= minutes;
        if(minutesLeft < 0) {
            System.out.println("Leider verloren");
            System.exit(69420);
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