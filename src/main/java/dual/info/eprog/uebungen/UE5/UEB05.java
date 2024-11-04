package dual.info.eprog.uebungen.UE5;

import java.util.Scanner;

public class UEB05 {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Aufgabe 4:\n");
        aufgabe4();
        System.out.println("\nAufgabe 5:\n");
        aufgabe5();
        System.out.println("\nAufgabe 6:\n");
        aufgabe6();
    }

    public static void aufgabe6() {
        System.out.println("Bitte geben Sie eine natürliche Zahl an:");
        int n = scanner.nextInt();
        System.out.println("Die pythagoräischen Tripel bis " + n + " sind:");
        pythTripel(n);
    }

    public static void pythTripel(int n) {
        int anzahlTripel = 0;
        for (int a = 1; a < n; a++) {
            for (int b = a; b < n; b++) {
                for (int c = b; c < n; c++) {
                    if(a*a + b*b == c*c) {
                        anzahlTripel++;
                        System.out.println(a + "*" + a + " + " + b + "*" + b + " = " + c + "*" + c);
                    }
                }
            }
        }
        System.out.println("Es wurden " + anzahlTripel + " pythagoräische Tripel gefunden.");
    }

    public static void aufgabe5() {
        System.out.print("Eingabe (ganzzahlig): ");
        long eingabe = scanner.nextLong();
        if(eingabe - (int) eingabe > 0) {
            System.out.println("Eingabe nicht ganzzahlig!");
            return;
        }
        System.out.println("Die Zahl " + eingabe + " ist " + (istPanagramm(eingabe) ? "" : "k") + "ein Panagramm");
    }

    public static boolean istPanagramm(long x) {
        int[] zahlen = new int[]{0,1,2,3,4,5,6,7,8,9};
        String eingabe = String.valueOf(x);
        for (char c : eingabe.toCharArray()) {
            int currentZahl = Integer.parseInt(String.valueOf(c));
            for (int i = 0; i < zahlen.length; i++) {
                int zahl = zahlen[i];
                if (currentZahl == zahl) {
                    zahlen[i] = 0;
                }
            }
        }
        for (int i : zahlen) {
            if(i != 0)
                return false;
        }
        return true;
    }

    public static void aufgabe4() {
        System.out.print("Laufzeit in Jahren: ");
        int laufzeitInJahren = scanner.nextInt();
        System.out.print("Anlagebetrag: ");
        double anlagebetrag = scanner.nextDouble();
        printAuswahlListe();
        int auswahl = -1;
        while (auswahl == -1) {
            System.out.println("Bitte wählen Sie eine der Möglichkeiten 1-5 aus.");
            int auswahlTemp = scanner.nextInt();
            if(auswahlTemp < 0 || auswahlTemp > 5) {
                System.out.println("Fehler: Falsche Auswahl");
            }
            auswahl = auswahlTemp;
            if(auswahl == 5) {
                System.out.println("Fertig");
                return;
            }
        }
        float verzinsung = 0;
        int bonus = 0;
        switch (auswahl) {
            case 1:
                verzinsung = 0.015f;
                break;
            case 2:
                verzinsung = 0.007f;
                bonus = 15;
                break;
            case 3:
                verzinsung = 0.007f;
                bonus = 20;
                break;
            case 4:
                verzinsung = 0.007f;
                bonus = 50;
                break;
        }
        System.out.println("Guthaben: " + berechneGuthaben(laufzeitInJahren, anlagebetrag, verzinsung, bonus));
    }

    private static double berechneGuthaben(int laufzeitInJahren, double anlagebetrag, float verzinsung, int bonusZahlung) {
        double guthaben = anlagebetrag + bonusZahlung;
        for (int i = 0; i < laufzeitInJahren; i++) {
            guthaben *= (1 + verzinsung);
        }
        return guthaben;
    }

    private static void printAuswahlListe() {
        String auswahlListe = "1    1,5 % Verzinsung ohne Bonuszahlung\n";
        auswahlListe += "2    0,7 % Verzinsung mit 15 Euro Bonuszahlung\n";
        auswahlListe += "3    0,7 % Verzinsung mit 20 Euro Bonuszahlung\n";
        auswahlListe += "4    0,7 % Verzinsung mit 50 Euro Bonuszahlung\n";
        auswahlListe += "5    Fertig";
        System.out.println("\n" + auswahlListe);
    }
}