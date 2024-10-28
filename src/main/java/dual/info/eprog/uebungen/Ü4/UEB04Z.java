package dual.info.eprog.uebungen.Ü4;

import java.util.Scanner;

public class UEB04Z {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wie viele Aufgaben haben Sie vorgerechnet?");
        int vorrechnen = scanner.nextInt();
        System.out.println("Wie viele Punkte haben Sie beim 1. Bonustest erreicht?");
        int bonustest1 = scanner.nextInt();
        System.out.println("Wie viele Punkte haben Sie beim 2. Bonustest erreicht?");
        int bonustest2 = scanner.nextInt();

        int ergebnis = getBonuspunkteGesamt(vorrechnen, bonustest1, bonustest2);
        System.out.println("In der Klausur werden Ihnen " + ergebnis + " Bonuspunkte angerechnet.");
    }

    public static int getBonuspunkteGesamt(int vorrechnen, int bonustest1, int bonustest2) {
        if(vorrechnen < 0 || bonustest1 < 0 || bonustest2 < 0)
            throw new IllegalArgumentException("Werte können nicht negativ sein. :(");
        if(bonustest1 > 40 || bonustest2 > 40)
            throw new IllegalArgumentException("Punkte > 40 beim Bonustest sind nicht zulässig. :(");
        vorrechnen = (vorrechnen > 4) ? 4 : vorrechnen;
        int bonustest1Ergebnis = kaufmaennischGerundet(bonustest1);
        int bonustest2Eregebnis = kaufmaennischGerundet(bonustest2);
        int ergebnis = vorrechnen + bonustest1Ergebnis + bonustest2Eregebnis;
        return ergebnis > 10 ? 10 : ergebnis;
    }

    public static int kaufmaennischGerundet(double value) {
        double zwischenErgebnis = value / 10;
        return zwischenErgebnis - ((int) zwischenErgebnis) > 0.5 ? (int) zwischenErgebnis + 1 : (int) zwischenErgebnis;
    }

}
