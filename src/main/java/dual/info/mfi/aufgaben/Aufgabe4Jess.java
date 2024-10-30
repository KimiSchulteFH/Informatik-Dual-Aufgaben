package dual.info.mfi.aufgaben;

public class Aufgabe4Jess {

    public static void main(String[] args) {
        multiplication(2006);
        System.out.println("Aufgabe 4:");
        RatZahlJess a = kuerzen(new RatZahlJess(12, 24));
        RatZahlJess b = kuerzen(new RatZahlJess(6,24));
        RatZahlJess ergebnisAdd = add(a, b);
        RatZahlJess ergebnisDivide = divide(a, b);
        boolean ergebnisGreater = isGreaterThan(a,b);
        print(ergebnisAdd);
        print(ergebnisDivide);
        System.out.println(ergebnisGreater);

    }

    public static void multiplication(int n) {
       for (int i = 1; i < n; i++) { //alle Zahlen in Zn
           if (((37 * i) % n - 2) % n == 0) { //ebenfalls möglich: (37*i)%n == 2
               System.out.println("(37 * " + i + " - 2) % " + n + " ist 0 | x = " + i);
           }
       }
    }

    public static void print(RatZahlJess ratZahl) {
        int zaehler = ratZahl.getZaehler();
        int nenner = ratZahl.getNenner();
        System.out.println(zaehler + " / " + nenner);
    }

    public static RatZahlJess add(RatZahlJess a, RatZahlJess b) {
        int zaehler = (a.getZaehler() * b.getNenner()) + (a.getNenner() * b.getZaehler());
        int nenner = a.getNenner() * b.getNenner();
        return kuerzen(new RatZahlJess(zaehler, nenner));
    }

    public static RatZahlJess divide(RatZahlJess a, RatZahlJess b) {
        int zaehler = a.getZaehler() * b.getNenner();
        int nenner = a.getNenner() * b.getZaehler();
        return kuerzen(new RatZahlJess(zaehler, nenner));
    }

    public static boolean isGreaterThan(RatZahlJess a, RatZahlJess b) {
        int kGV = kGV(a.getNenner(), b.getNenner());
        a = erweitern(a, kGV);
        b = erweitern(b, kGV);
        return a.getZaehler() > b.getZaehler();
    }

    public static RatZahlJess erweitern(RatZahlJess a, int kGV) {
        int multi = kGV / a.getNenner();
        int zaehler = a.getZaehler() * multi;
        int nenner = a.getNenner() * multi;
        return new RatZahlJess(zaehler, nenner);
    }

    public static RatZahlJess kuerzen(RatZahlJess ratZahl) {
        if (ratZahl.getNenner() > ratZahl.getZaehler()) {
            int higherNumber = ratZahl.getNenner();
            int smallerNumber = ratZahl.getZaehler();

            int gcd = gcd(higherNumber, smallerNumber);

            int zaehler = ratZahl.getZaehler() / gcd;
            int nenner = ratZahl.getNenner() / gcd;

            return new RatZahlJess(zaehler, nenner);
        } else if (ratZahl.getNenner() < ratZahl.getZaehler()) {
            int smallerNumber = ratZahl.getNenner();
            int higherNumber = ratZahl.getZaehler();

            int gcd = gcd(higherNumber, smallerNumber);

            int zaehler = ratZahl.getZaehler() / gcd;
            int nenner = ratZahl.getNenner() / gcd;

            return new RatZahlJess(zaehler, nenner);
        } else {
            return new RatZahlJess(1, 1);
        }
    }


    public static int gcd(int higherNumber, int smallerNumber) {
        if (smallerNumber == 0) {
            return higherNumber;
        }
        return gcd(smallerNumber, higherNumber % smallerNumber);
    }

    public static int kGV(int nennerEins, int nennerZwei) {
        if (nennerEins > nennerZwei) {
            return (nennerEins * nennerZwei) / gcd(nennerEins, nennerZwei);
        } else {
            return (nennerEins * nennerZwei) / gcd(nennerZwei, nennerEins);
        }
    }
}
