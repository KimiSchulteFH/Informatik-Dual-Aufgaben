package dual.info.mfi.aufgaben;

import java.util.Scanner;


public class Aufgabe3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Aufgabe3 aufgabe3 = new Aufgabe3();

        System.out.println("Geben Sie einen Wert für a ein: ");
        final int a = scanner.nextInt();
        System.out.println("Geben Sie einen Wert für b ein: ");
        final int b = scanner.nextInt();
        /*
        Lassen wir weg, da n in add() definiert wird
        System.out.println("Geben Sie einen Wert für n ein: ");
        final int n = scanner.nextInt();
        */
        System.out.println("ADDMOD: " + aufgabe3.add(a, b));
        System.out.println("INV: " + aufgabe3.inv(a));
        System.out.println("ABEL: " + aufgabe3.abel(a, b));

    }

    public int add(int a, int b) {
        int n;
        if (a < b) {
            n = b + 1;
        } else {
            n = a + 1;
        }
        return (a + b) % n;
    }

    public int inv(int a) {
        int n = a / 2; //muss immer 0 sein, da sonst der Rückgabewert kleiner 0 ist und damit nicht in Z liegt
        return -a % n;
    }

    /** Def.:
     *  <a href="https://www.math.uni-bielefeld.de/~sek/top/leit/alg2.htm">...</a>
     */
    public boolean abel(int a, int b) {
        int e = 0; //Neutrales Element
        //1.AG
        boolean first =  ((a + b) + 1 == a + (b + 1));
        //2.AG
        boolean second = (a + b == b + a);
        //3.AG
        boolean third = (add(a, e) == a);
        //4.AG
        boolean forth = (add(-a, a) == 0);

        return first && second && third && forth;
    }
}
