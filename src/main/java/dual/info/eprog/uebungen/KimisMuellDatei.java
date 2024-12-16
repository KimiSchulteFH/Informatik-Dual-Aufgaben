import java.util.Scanner; // Import für Benutzereingaben
import java.util.Random;  // Import für die Generierung von Zufallszahlen

// Hauptklasse der Anwendung
public class KimisMuellDatei {

    // Einstiegspunkt des Programms
    public static void main(String[] args) {
        // Prüfen, ob der Test erfolgreich ist
        if (!test()) {
            System.out.println("Fehler");
        }

        // Verschiedene Methoden aufrufen
        macheSchafUndArray(); // Erstellt ein Schaf und füllt ein Array
        scannerEinlesen();    // Liest Benutzereingaben ein
        kleinsteZahlIn2DimensionalemArray(); // Sucht die kleinste Zahl in einem 2D-Array
    }

    // Liest Benutzereingaben ein und gibt eine Nachricht aus
    public static void scannerEinlesen() {
        Scanner scanner = new Scanner(System.in); // Scanner-Objekt für Eingaben erstellen
        System.out.println("Gib hier die Anzahl an Stunden ein, die du in der Woche Arbeitszeitbetrug begehst: ");

        // Eingabe des Benutzers wird gelesen
        int arbeitszeitBetrug = scanner.nextInt();
        System.out.println("Du begehst " + arbeitszeitBetrug + "h Arbeitszeitbetrug die Woche");

        scanner.close(); // Scanner schließen, um Ressourcen freizugeben
    }

    // Generiert ein 2D-Array mit Zufallszahlen und sucht die kleinste Zahl
    public static void kleinsteZahlIn2DimensionalemArray() {
        Random random = new Random(); // Zufallsgenerator initialisieren
        int kleinste = Integer.MAX_VALUE; // Variable für die kleinste Zahl, initialisiert auf maximal möglichen Wert
        int zeile = 0, spalte = 0; // Variablen für die Position der kleinsten Zahl
        int[][] zahlen = new int[25][15]; // 2D-Array mit festen Dimensionen erstellen

        // Zufallszahlen in das Array einfügen
        for (int i = 0; i < zahlen.length; i++) {
            for (int j = 0; j < zahlen[i].length; j++) {
                zahlen[i][j] = random.nextInt(1000); // Zufallszahl zwischen 0 und 999
            }
        }

        // Kleinste Zahl und deren Position suchen
        for (int i = 0; i < zahlen.length; i++) {
            for (int j = 0; j < zahlen[i].length; j++) {
                if (zahlen[i][j] < kleinste) {
                    kleinste = zahlen[i][j];
                    zeile = i;
                    spalte = j;
                }
            }
        }

        // Array ausgeben
        System.out.println("Array-Inhalt:");
        for (int[] row : zahlen) {
            for (int value : row) {
                System.out.print(value + "    ");
            }
            System.out.println();
        }

        // Ergebnis ausgeben
        System.out.println("Die kleinste Zahl ist " + kleinste + " bei Spalte: " + spalte + " und Zeile: " + zeile);
    }

    // Erstellt ein Schaf-Objekt und fügt es in ein Array ein
    public static void macheSchafUndArray() {
        Scanner scanner = new Scanner(System.in); // Scanner für Benutzereingaben
        System.out.println("Gib den Namen ein: ");

        // Schaf-Objekt erstellen und Name setzen
        Schaf hans = new Schaf();
        hans.name = scanner.nextLine(); // Name wird über die Eingabe gesetzt
        System.out.println("Name des Schafs: " + hans.name);

        // 2D-Array aus Schaf-Objekten erstellen
        Schaf[][] scharfesArray = new Schaf[2][4];
        scharfesArray[1][1] = hans; // Objekt im Array platzieren

        // Name des Schafs aus dem Array ausgeben
        System.out.println("Schaf im Array: " + scharfesArray[1][1].name);
    }

    // Testmethode, die immer `false` zurückgibt
    public static boolean test() {
        // Rückgabewert kann als Platzhalter für spätere Logik dienen
        return false;
    }

    // Klasse für das Schaf-Objekt
    static class Schaf {
        public String name;     // Name des Schafs
        public byte alter;      // Alter des Schafs
        public float wollMenge; // Menge der Wolle, die das Schaf liefert
    }
}
