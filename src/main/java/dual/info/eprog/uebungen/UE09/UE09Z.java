package dual.info.eprog.uebungen.UE09;
import java.util.Scanner;

public class UE09Z {

}

class UmfrageTool {

    private final static Scanner scanner = new Scanner(System.in);
    private static Umfrage umfrage;

    public static void main(String[] args) {
        while (true) {
            System.out.println("""
                    1: Umfrage anlegen
                    2: Umfrage durchführen
                    3: Beenden
                    """);
            int state = scanner.nextInt();
            switch (state) {
                case 1:
                    umfrage = new Umfrage();
                    umfrage.create();
                    break;
                case 2:
                    if(umfrage == null) {
                        System.out.println("Umfrage noch nicht erstellt");
                    } else {
                        umfrage.start();
                    }
                    break;
                case 3:
                    return;
            }
        }
    }

}
class Umfrage {

    private String titel;
    private int anzahlFragen, anzahlTeilnehmer;
    private Frage[] fragen;

    public void create() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Geben Sie den Titel der Umfrage an:");
        titel = scanner.nextLine();
        System.out.println("Wie viele Fragen enthält die Umfrage?");
        anzahlFragen = scanner.nextInt();
        scanner.nextLine();
        fragen = new Frage[anzahlFragen];
        for (int i = 0; i < anzahlFragen; i++) {
            System.out.println("Geben Sie Frage Nr. " + (i + 1) + " ein:");
            String frage = scanner.nextLine();
            fragen[i] = new Frage(frage);
        }
        System.out.println("Sie haben alle Fragen angelegt. ");
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Durchführung der Umfrage: " + titel);
        System.out.println("Beantworten Sie jede Frage mit j oder n für ja bzw. nein");
        while (true) {
            anzahlTeilnehmer++;
            for (int i = 0; i < fragen.length; i++) {
                System.out.println("Frage " + (i + 1) + "/" + fragen.length + ":");
                System.out.println(fragen[i].getText());
                String output = scanner.nextLine();
                if(istJa(output)) {
                    fragen[i].beantworteJa();
                } else {
                    fragen[i].beantworteNein();
                }
            }
            System.out.println("Weitere Teilnehmer? (j/n)");
            if(istNein(scanner.nextLine())) {
                break;
            }
        }
        System.out.println("Die Umfrage ist beendet.");

        System.out.println("An der Umfrage " + titel + " haben " + anzahlTeilnehmer + " Personen teilgenommen. :)");
        for (Frage frage : fragen) {
            System.out.println("Frage: " + frage.getText());
            double prozentJa = (double) frage.getAnzahlJa() / anzahlTeilnehmer * 100;
            System.out.println(prozentJa + " % der Teilnehmer haben mit ja geantwortet.");
            double prozentNein = 100 - prozentJa;
            System.out.println(prozentNein + " % der Teilnehmer haben mit nein geantwortet.");
            System.out.println();
        }
    }

    private boolean istNein(String input) {
        return !istJa(input);
    }

    private boolean istJa(String input) {
        return input.equalsIgnoreCase("j");
    }
}

class Frage {

    private final String text;
    private int anzahlJa = 0, anzahlNein = 0;

    public Frage(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void beantworteJa() {
        anzahlJa++;
    }

    public void beantworteNein() {
        anzahlNein++;
    }

    public int getAnzahlJa() {
        return anzahlJa;
    }
}