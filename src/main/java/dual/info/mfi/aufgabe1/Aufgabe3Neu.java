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

class AbelscheGruppe {

    private final int N;

    public AbelscheGruppe(int n) {
        N = n;
    }

    /**
     * Gibt (a + b) modulo N zurück
     * */
    public int add(int a, int b) {
        return (a + b) % N;
    }

    /**
     * a + inv(a) == 0<br>
     * inv(a) == N - a<br>
     * a + (N - a) == a + N - a = N<br>
     * a + (N - a) == 0<br>
     *<br>
     * Beispiel: N = 7; a = 3<br>
     * inv(3) = (7-3)%7 = 4<br>
     * 3 + 4 = 7      7 % 7 = 0<br>
     * */
    public int inv(int a) {
        return (N - a) % N;
    }

    public boolean istAssoziativ(int start) {
        for (int a = start; a < N; a++) {
            for (int b = start; b < N; b++) {
                for (int c = start; c < N; c++) {
                    if (add(add(a, b), c) != add(a, add(b, c))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean istKommutativ(int start) {
        for (int a = start; a < N; a++) {
            for (int b = start; b < N; b++) {
                if (add(a, b) != add(b, a)) {
                    return false;
                }
            }
        }
        return true;
    }

    // Bei addition ist das "identitäts-element" 0
    public boolean checkIdentity(int start) {
        for (int a = 0; a < N; a++) {
            if (add(a, 0) != a || add(0, a) != a) {
                return false;
            }
        }
        return true;
    }

    public boolean checkInverse(int start) {
        for (int a = start; a < N; a++) {
            if(add(a, inv(a)) != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean additionIstInMenge(int start) {
        for (int a = start; a < N; a++) {
            for (int b = start; b < N; b++) {
                int result = add(a, b);
                if(result < start || result >= N) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean istAbelscheGruppe() {
        return additionIstInMenge(0) && istAssoziativ(0) &&
                istKommutativ(0) && checkIdentity(0) && checkInverse(0);
    }

    public boolean istAbelscheGruppeOhneNull() {
        return additionIstInMenge(1) && istAssoziativ(1) &&
                istKommutativ(1) && checkIdentity(1) && checkInverse(1);
    }
}
