package dual.info.eprog.uebungen.UE08;

import java.util.Random;

public class UE08 {



}

class LottoMaschine {

    private final int[] zahlen = new int[7];
    private final Random random = new Random();

    public void zieheZahlen() {
        int index = 0;
        while (index < zahlen.length) {
            int zahl = random.nextInt(49) + 1;
            if(hatZahl(zahl)) continue;
            zahlen[index] = zahl;
            index++;
        }
        sortieren();
    }

    public void sortieren() {
        for (int i = 0; i < zahlen.length - 1; i++) {
            int minIndex = i; // Minimumsuche
            for (int j = i + 1; j < zahlen.length; j++)
                if (zahlen[j] < zahlen[minIndex])
                    minIndex = j;
            int zw = zahlen[i]; // Vertauschen
            zahlen[i] = zahlen[minIndex];
            zahlen[minIndex] = zw;
        }
    }

    private boolean hatZahl(int zahl) {
        for (int i : zahlen) {
            if(zahl == i)
                return true;
        }
        return false;
    }

    public int[] getZahlen() {
        return zahlen;
    }
}

class Zufallsexperimente {

    public static void main(String[] args) {
        Wuerfel wuerfel = new Wuerfel();
        int[] zahlen = new int[6];
        System.out.println("Der Würfel wurde 100000 mal geworfen.");
        for (int i = 0; i < 100_000; i++) {
            int zahl = wuerfel.wuerfeln();
            zahlen[zahl - 1]++;
        }
        for (int i = 0; i < zahlen.length; i++) {
            int zahl = i + 1;
            System.out.println("Die Zahl " + zahl + " kam " + zahlen[i] + " mal vor.");
        }

        LottoMaschine lottoMaschine = new LottoMaschine();
        lottoMaschine.zieheZahlen();
        System.out.println("Die Ziehung der Lottozahlen ergab folgende 7 Zahlen:");
        for (int zahl : lottoMaschine.getZahlen()) {
            System.out.print(zahl + "    ");
        }
    }
}

class Wuerfel {

    private final Random random = new Random();

    public int wuerfeln() {
        return random.nextInt(6) + 1;
    }

}

class DozentTest {

    public static void main(String[] args) {
        Dozent dieDozentin = new Dozent("Kimi", "Automobilreparatur", 'M');
        Dozent derDekan = new Dozent("Jan", "Automatikfahrer", 'F');
        derDekan.setDekan(true);

        System.out.println("derDekan.getLehrgebiet() = " + derDekan.getLehrgebiet());
        System.out.println("derDekan.getName() = " + derDekan.getName());
        System.out.println("derDekan.isDekan() = " + derDekan.isDekan());
        System.out.println("derDekan.getGeschlecht() = " + derDekan.getGeschlecht());

        dieDozentin.setLehrgebiet("Zündspulenwechsler");
    }

}

class Dozent {
    private String name, lehrgebiet;
    private boolean dekan = false;
    private char geschlecht;

    public Dozent(String name, String lehrgebiet, char geschlecht) {
        this.name = name;
        this.lehrgebiet = lehrgebiet;
        this.geschlecht = geschlecht;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLehrgebiet() {
        return lehrgebiet;
    }

    public void setLehrgebiet(String lehrgebiet) {
        this.lehrgebiet = lehrgebiet;
    }

    public boolean isDekan() {
        return dekan;
    }

    public void setDekan(boolean dekan) {
        this.dekan = dekan;
    }

    public char getGeschlecht() {
        return geschlecht;
    }

    public void setGeschlecht(char geschlecht) {
        this.geschlecht = geschlecht;
    }
}