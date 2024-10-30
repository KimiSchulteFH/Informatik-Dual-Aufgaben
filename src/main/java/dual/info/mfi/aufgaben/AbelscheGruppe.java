package dual.info.mfi.aufgaben;

public class AbelscheGruppe {

    private final int N;

    public AbelscheGruppe(int n) {
        N = n;
    }

    public int multiply(int a, int b) {
        return (a * b) % N;
    }

    public int multiply_inv(int a) {
        return a * N;
    }

    public int add(int a, int b) {
        return (a + b) % N;
    }

    public int add_inv(int a) {
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
        for (int a = start; a < N; a++) {
            if (add(a, 0) != a || add(0, a) != a) {
                return false;
            }
        }
        return true;
    }

    public boolean checkInverse(int start) {
        for (int a = start; a < N; a++) {
            if(add(a, add_inv(a)) != 0) {
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
