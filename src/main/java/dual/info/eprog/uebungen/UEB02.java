package dual.info.eprog.uebungen;

import java.io.File;
import java.util.Scanner;

public class UEB02 {

    // Übungen sind unten
    public static Scanner scanner = new Scanner(System.in);

}

/**
 * Aufgabe 4
 * steht hier
 */
class Polynom {

    public static void main(String[] args) {
        final int x;
        x = UEB02.scanner.nextInt();
        int mon1 = 5 * x;
        int mon2 = mon1 + 3 * x * x;
        mon1 = mon2 + x * x * x;
        System.out.println(mon1);
    }
}

/**
 * Aufgabe 5
 */
class AdditionMitMatrNr {

    public static void main(String[] args) {
        final int x = UEB02.scanner.nextInt();
        final int y = UEB02.scanner.nextInt();
        final int jessMatrNr = 7221356;
        int kimiMatrNr = 7221230;
        System.out.println("Jess' Summe = " + (x + y + jessMatrNr));
        System.out.println("Kimis Summe = " + (x + y + kimiMatrNr));
    }

}

/**
 * Aufgabe 6
 * Zusatz 1
 */
class WorteAndersherum {

    public static void main(String[] args) {
        System.out.println("Geben Sie die erste Zeichenkette ein:");
        String x = UEB02.scanner.nextLine();
        System.out.println("Geben Sie die zweite Zeichenkette ein:");
        String y = UEB02.scanner.nextLine();
        System.out.println("Geben Sie die dritte Zeichenkette ein:");
        String z = UEB02.scanner.nextLine();

        System.out.println(z + " " + y + " " + x);
    }

}

/**
 * Aufgabe 7
 * Zusatz 2
 */
class Zahlen {

    public static void main(String[] args) {
        System.out.println("Geben Sie eine ganze Zahl ein: ");
        int eingabe = UEB02.scanner.nextInt();

        if (eingabe % 2 == 0) {
            System.out.println("Die Zahl " + eingabe + " ist gerade.");
        } else {
            System.out.println("Die Zahl " + eingabe + " ist ungerade.");
        }

        if (eingabe % 3 == 0) {
            System.out.println("Die Zahl " + eingabe + " ist durch 3 teilbar.");
        } else {
            System.out.println("Die Zahl " + eingabe + " ist nicht durch 3 teilbar.");
        }

        if (eingabe > 0) {
            System.out.println("Die Zahl " + eingabe + " ist positiv.");
        } else if (eingabe < 0) {
            System.out.println("Die Zahl " + eingabe + " ist negativ.");
        } else {
            System.out.println("Die Zahl " + eingabe + " ist weder positiv noch negativ.");
        }

        if (isZweierpotenz(eingabe)) {
            System.out.println("Der Betrag der Zahl " + eingabe + " ist eine Zweierpotenz.");
        } else {
            System.out.println("Der Betrag der Zahl " + eingabe + " ist keine Zweierpotenz.");
        }
    }

    private static boolean isZweierpotenz(int eingabe) {
        int i = 0;
        if(eingabe < 0) {
            eingabe = -eingabe;
        }
        while (i <= eingabe) {
            if (Math.pow(2, i) == eingabe) {
                return true;
            }
            i++;
        }
        return false;
    }

}