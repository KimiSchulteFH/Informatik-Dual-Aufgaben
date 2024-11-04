package dual.info.eprog.uebungen.UE5;
import java.util.Scanner;

import static java.lang.Math.sqrt;

public class UEB05Jess {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        pythTriple_Aufgabe6();
    }

    public static void intToBinaerString_Aufgabe3(int n) {
        if (n < 0) {
            System.out.println("0");
        } else {
            System.out.println(Long.toBinaryString(n));
        }
    }

    public static void Geldanlage_Aufgabe4 () {
        int auswahl;
        int bonus = 0;
        double zinssatz = 0;
        System.out.println("Laufzeit eingeben:");
        int laufzeit = scanner.nextInt();
        System.out.println("Anlagenbetrag eingeben:");
        double anlagenbetrag = scanner.nextDouble();
        System.out.println("(1) 1,5 % Verzinsung ohne Bonuszahlung\n" +
                "(2) 0,7 % Verzinsung mit 15 Euro Bonuszahlung\n" +
                "(3) 0,4 % Verzinsung mit 20 Euro Bonuszahlung\n" +
                "(4) 0,1 % Verzinsung mit 50 Euro Bonuszahlung\n" +
                "(5) Fertig\n");
        do {
            System.out.println("Bitte wählen Sie eine der Möglichkeiten 1-5 aus.");
            auswahl = scanner.nextInt();
        } while (auswahl > 5 || auswahl < 1);
        if (auswahl == 1) {zinssatz = 0.0015;}
        if (auswahl == 2) {bonus = 15; zinssatz = 1.007;}
        if (auswahl == 3) {bonus = 20; zinssatz = 1.004;}
        if (auswahl == 4) {bonus = 50; zinssatz = 1.001;}
        berechneGuthaben(zinssatz, bonus, anlagenbetrag, laufzeit);
    }

    public static void berechneGuthaben(double zinssatz, int bonus, double anlagebetrag, int laufzeit) {
        for (int i = 0; i < laufzeit; i++) {
            anlagebetrag = anlagebetrag * zinssatz + bonus;
            System.out.println(anlagebetrag);
        }
    }

    public static void pangram_Aufgabe5() {
        boolean istPangram = true;
        String zahl = scanner.nextLine();
        //String text = String.valueOf(zahl);
        for  (int j = 0; j < 10; j++) {
            boolean gefunden = false;
            for  (int i = 0; i < zahl.length(); i++) {
                if (String.valueOf(zahl.charAt(i)).equals(String.valueOf(j))) {
                    gefunden = true;
                    break;
                }
            }
            if (!gefunden) {
                istPangram = false;
                break;
            }
        }
        if (istPangram) {
            System.out.println("Die Zahl " + zahl + " ist ein Pangram.");
        } else {
            System.out.println("Die Zahl " + zahl + " ist kein Pangram.");
        }
    }

    public static void pythTriple_Aufgabe6() {
        int n = scanner.nextInt();
        int anzahl = 0;
        for (int a = 1; a <= n; a++) {
            for (int b = a; b <= n; b++) {
                double c = sqrt(a*a + b*b);
                if (c % 1 == 0) {
                    anzahl++;
                    System.out.println(a+"*"+a + " + " + b+"*"+b +" = " + c+"*"+c);
                }
            }
        }
        System.out.println("Es wurden " + anzahl + " Triple gefunden");

    }
}
