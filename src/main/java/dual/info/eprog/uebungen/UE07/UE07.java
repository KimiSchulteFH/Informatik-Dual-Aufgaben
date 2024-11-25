package dual.info.eprog.uebungen.UE07;

import java.util.Arrays;
import java.util.Scanner;

public class UE07 {

    public static void main(String[] args) {
        aufgabe5();
    }

    public static void aufgabe5() {
        int[][] feld = new int[][]{
                new int[]{1, 2, 3, 4, 5, 6, 8},
                new int[]{7, 6, 5, 4, 3, 2, 1},
                new int[]{1, 0, 1,     0, 1,     0, 1},
                new int[]{1, 1, 1,     1, 1,     1, 1},
                new int[]{2, 2, 2, 2, 2, 2, 2},
                new int[]{3, 3, 3, 3, 3, 3, 3},
        };
        int i = 2, j = 3;
        // sollte 3 ergeben [= 0 + 1 + 1 + 1]
        System.out.println(summeQuadrat(feld, i, j));
        System.out.println(summeGroesstesQuadrat(feld));
    }

    public static int summeQuadrat(int[][] feld, int i, int j) {
        if(i == feld.length - 1 || j == feld[0].length - 1)
            return -1; // oder exception, ist nicht in der aufgabe definiert
        int ergebnis = feld[i][j] + feld[i + 1][j] + feld[i][j + 1] + feld[i + 1][j + 1];
        return ergebnis;
    }

    public static int summeGroesstesQuadrat(int[][] feld) {
        int highestI = -1;
        int highestJ = -1;
        int ergebnis = -1;
        for (int i = 0; i < feld.length - 1; i++) {
            for (int j = 0; j < feld[i].length; j++) {
                int summe = summeQuadrat(feld, i, j);
                if (summe > ergebnis) {
                    ergebnis = summe;
                    highestI = i;
                    highestJ = j;
                }
            }
        }
        System.out.println("Im Teilfeld mit der größten 2x2-Summe hat die linke obere\n" +
                "Ecke die Indexzeile " + highestJ +" und die Indexspalte " + highestI);
        return ergebnis;
        // spalte = j
        // zeile = i
    }

    public static void aufgabe4() {
        Scanner scanner = new Scanner(System.in);
        int n = -1;
        while (true) {
            System.out.println("""
                
                --------------------------
                1   Teileranzahl für n
                2   Maximale Teileranzahl für die Zahlen 1 bis n
                3   Fertig
                --------------------------
                """);
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.print("Zahl: ");
                    n = scanner.nextInt();
                    System.out.println(berechneTeileranzahl(n));
                    break;
                case 2:
                    System.out.print("Zahl: ");
                    n = scanner.nextInt();
                    berechneMaximaleTeileranzahl(n);
                    break;
                case 3:
                    System.out.println("Fertig");
                    return;
                default:
                    System.out.println("Falsche Eingabe");
                    break;
            }
        }
    }

    public static int berechneTeileranzahl(double n) {
        int counter = 0;
        double moeglicherTeiler = n;
        while (moeglicherTeiler > 0) {
            if((n / moeglicherTeiler) % 1 == 0)
                counter++;
            moeglicherTeiler--;
        }
        return counter;
    }

    public static void berechneMaximaleTeileranzahl(int n) {
        int zahlMitMeistenTeilern = -1;
        int meisteTeiler = -1;
        for (int i = 1; i < n; i++) {
            int maxTeiler = berechneTeileranzahl(i);
            if(maxTeiler > meisteTeiler) {
                meisteTeiler = maxTeiler;
                zahlMitMeistenTeilern = i;
            }
        }
        System.out.println("Zwischen 1 und " + n + " ergibt sich eine maximale Teileranzahl von " + meisteTeiler +
                ", nämlich für die Zahl " + zahlMitMeistenTeilern);
    }

    public static void aufgabe3() {
        int[] a = new int[]{1, 5, 7};
        int[] b = new int[]{2, 3, 9, 10};
        int[] merged = merge(a, b);
        // könnte auch mit for loop ausgegeben werden, aber ist hässlicher
        System.out.println(Arrays.toString(merged));
    }

    public static int[] merge(int[] a, int[] b) {
        int aIndex = 0, bIndex = 0;
        int[] merged = new int[a.length + b.length];
        int i = 0;
        // fülle sortiert
        while (aIndex < a.length && bIndex < b.length) {
            int currentA = a[aIndex];
            int currentB = b[bIndex];
            if(currentA < currentB) {
                merged[i++] = currentA;
                aIndex++;
            } else {
                merged[i++] = currentB;
                bIndex++;
            }
        }
        // fülle den rest wenn noch nicht alle elemente genommen wurden
        if(aIndex < a.length) {
            for (int j = aIndex; j < a.length; j++) {
                merged[i++] = a[j];
            }
        }
        if(bIndex < b.length) {
            for (int j = bIndex; j < b.length; j++) {
                merged[i++] = b[j];
            }
        }
        return merged;
    }

    public static void aufgabe2() {
        int n = 5;
        for (int i = 0; i < n; i++) {
            int spaces = n / 2 - i + 1;
            int starts = 2 * i + 1;
            for (int j = 0; j < spaces; j++)
                System.out.print(" ");
            for (int j = 0; j < starts; j++)
                System.out.print("*");
            for (int j = 0; j < spaces; j++)
                System.out.print(" ");
            System.out.println();
        }
        System.out.println();
    }

    public static void aufgabe1() {
        System.out.println(geometrischeSumme(4, 2));
    }

    public static double geometrischeSumme(int n, double q) {
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += pow(i, q);
        }
        return sum;
    }

    public static double pow(int pow, double num) {
        double sum = 1;
        for (int i = 0; i < pow; i++) {
            sum *= num;
        }
        return sum;
    }

}
