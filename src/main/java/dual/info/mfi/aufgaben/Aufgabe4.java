package dual.info.mfi.aufgaben;

public class Aufgabe4 {

    public static void main(String[] args) {
        aufgabe4_1();
        aufgabe4_2();
        aufgabe4_4();
    }

    public static void aufgabe4_4() {
        System.out.println("\n\nAufgabe 4.4:");
        int a = 6, b = 3, c = 4, d = 2;
        RationaleZahlenRechner rechner = new RationaleZahlenRechner();

        RationaleZahl zahl1 = new RationaleZahl(a, b);
        RationaleZahl zahl2 = new RationaleZahl(c, d);
        RationaleZahl ergebnis = rechner.add(zahl1, zahl2);
        System.out.println(zahl1 + " + " + zahl2 + " = " + ergebnis);

        RationaleZahl dividend = new RationaleZahl(a, b);
        RationaleZahl divisor = new RationaleZahl(c, d);
        RationaleZahl ergebnis2 = rechner.divide(dividend, divisor);
        System.out.println(dividend + " / " + divisor + " = " + ergebnis2);

        boolean isGreater = rechner.isGreater(zahl1, zahl2);
        System.out.println(zahl1 + " " + (isGreater ? ">" : "<") + " " + zahl2);
    }

    public static void aufgabe4_2() {
        System.out.println("\n\nAufgabe 4.2:");
        int N = 2006;
        System.out.println("1) x ∈ ℤ" + N + " | 37x = 2   ist für folgende x erfüllt:");
        AbelscheGruppe abel = new AbelscheGruppe(N);
        for (int x = 0; x < N; x++) {
            if (abel.multiply(37, x) == 2)
                System.out.println("x = " + x);
        }
    }

    public static void aufgabe4_1() {
        System.out.println("\n\nAufgabe 4.1:");
        System.out.println("1) x ∈ ℤ3 | 2x = 1   ist für folgende x erfüllt:");
        int N1 = 3;
        AbelscheGruppe a1 = new AbelscheGruppe(N1);
        for (int x = 0; x < N1; x++) {
            if (a1.multiply(2, x) == 1)
                System.out.println("x = " + x);
        }

        System.out.println("\n2) x ∈ ℤ5 | x^2 = 1   ist für folgende x erfüllt:");
        int N2 = 5;
        AbelscheGruppe a2 = new AbelscheGruppe(N2);
        for (int x = 0; x < N2; x++) {
            if (a2.multiply(x, x) == 1)
                System.out.println("x = " + x);
        }

        System.out.println("\n3) x ∈ ℤ19 | x * (x + 2) + 1 = 0   ist für folgende x erfüllt:");
        int N3 = 19;
        AbelscheGruppe a3 = new AbelscheGruppe(N3);
        for (int x = 0; x < N3; x++) {
            if (a3.add(a3.multiply(x, a3.add(x, 2)), 1) == 0)
                System.out.println("x = " + x);
        }
    }

}
