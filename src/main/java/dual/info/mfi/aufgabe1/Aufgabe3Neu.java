package dual.info.mfi.aufgabe1;

import java.util.Scanner;

public class Aufgabe3Neu {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wert für N: ");
        int N = scanner.nextInt();

        AbelscheGruppe gruppe = new AbelscheGruppe(N);

        if(gruppe.istAbelscheGruppe()) {
            System.out.println("Die Menge {0, 1, ..., " + (N + 1) + "} ist eine abelsche Gruppe");
        } else {
            System.out.println("Die Menge {0, 1, ..., " + (N + 1) + "} ist keine abelsche Gruppe");
        }

        if(gruppe.istAbelscheGruppeOhneNull()) {
            System.out.println("Die Menge {1, 2, ..., " + (N + 1) + "} ist eine abelsche Gruppe");
        } else {
            System.out.println("Die Menge {1, 2, ..., " + (N + 1) + "} ist keine abelsche Gruppe");
        }
    }

}