package dual.info.eprog.uebungen.UE07;

import java.util.Scanner;

public class UE07Z {

    public static void main(String[] args) {
        aufgabe1();
        System.out.println();
        aufgabe2();
    }
    
    public static void aufgabe2() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wie viele Fische (max. 100) möchten Sie anlegen?");
        int anzahlFische = scanner.nextInt();
        if(anzahlFische < 0 || anzahlFische > 100)
            throw new IllegalArgumentException("Fische < 0 oder Fische > 100");
        int[] fische = new int[100];
        for (int i = 0; i < anzahlFische; i++) {
            System.out.print("Geben Sie eine Zahl zwischen 0 und 6 ein: ");
            int currentFisch = scanner.nextInt();
            if(currentFisch < 0 || currentFisch > 6)
                throw new IllegalArgumentException("Fische < 0 oder Fische > 6");
            fische[i] = currentFisch;
        }
        for (int i = anzahlFische; i < 100; i++)
            fische[i] = -1;

        tageBis100Fische(fische, anzahlFische);
    }
    
    public static void aufgabe1() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Geben Sie eine Zahl zwischen 0 und 6 ein: ");
        int zahl1 = scanner.nextInt();
        System.out.print("Geben Sie eine weitere Zahl zwischen 0 und 6 ein: ");
        int zahl2 = scanner.nextInt();
        if(zahl1 < 0 || zahl1 > 6 || zahl2 < 0 || zahl2 > 6)
            throw new IllegalArgumentException("Zahl muss zwischen 0 und 6 liegen");
        tageBis5Fische(zahl1, zahl2);
    }

    public static int tagesablauf(int fisch) {
        if(fisch == 0) return 6;
        return fisch - 1;
    }

    public static int tagesablauf(int[] fische, int anzahlFische) {
        int zusaetzlicheFische = 0;
        int anzahlNeueFische = 0;
        for (int i = 0; i < fische.length; i++) {
            int currentFisch = fische[i];
            if(currentFisch == -1) continue; // skip den fisch wenn -1
            // wenn neuer fisch
            if(fische[i] == 0) {
                // setze einen neuen fisch ins feld
                anzahlNeueFische++;
            }
            fische[i] = tagesablauf(currentFisch);
        }
        for (int i = 0; i < anzahlNeueFische; i++) {
            int ersterLeererFischIndex = ersterLeererFischIndex(fische);
            if(ersterLeererFischIndex == -1) {
                zusaetzlicheFische++;
            } else {
                fische[ersterLeererFischIndex] = 6;
            }
        }
        return anzahlFische(fische) + zusaetzlicheFische;
    }

    private static int ersterLeererFischIndex(int[] fische) {
        for (int i = 0; i < fische.length; i++) {
            if(fische[i] == -1) return i;
        }
        return -1;
    }
    
    public static int tageBis5Fische(int fisch1, int fisch2) {
        int anzahlFische = 2;
        int anzahlTage = 0; // anzahl Tage muss auf 0 gesetzt werden (starten bei tag 0)
        while (anzahlFische < 7) {               // Zwei alte + 5 neue Fische
            if(fisch1 == 0)
                anzahlFische++;
            if(fisch2 == 0)
                anzahlFische++;
            fisch1 = tagesablauf(fisch1);
            fisch2 = tagesablauf(fisch2);

            anzahlTage++;
        }
        System.out.println("Es dauert " + anzahlTage + " Tage bis 5 neue Fische erzeugt wurden.");
        return anzahlTage;
    }

    private static int anzahlFische(int[] fische) {
        int anzahl = 0;
        for (int j : fische) {
            if (j != -1) anzahl++;
        }
        return anzahl;
    }

    public static int tageBis100Fische(int[] fische, int anzahlFische) {
        int anzahlTage = 0; // anzahl Tage muss auf 0 tagen starten
        while (anzahlFische <= 100) {               // bis 100 Fische
            anzahlFische = tagesablauf(fische, anzahlFische);

            anzahlTage++;
        }
        System.out.println("Es dauert " + anzahlTage + " Tage bis 100 neue Fische erzeugt wurden.");
        return anzahlTage;
    }

}
