package dual.info.eprog.uebungen.UE06;

import java.util.Arrays;

public class UE06 {

    public static void main(String[] args) {
        //aufgabe2();
        //aufgabe_4();
       // aufgabe_5();
    }

    public static boolean checkNum(int[] nums) {
        return nums.length >= 1 && nums[0] == nums[nums.length - 1];
    }

    public static int count(int[] nums, int value) {
        int count = 0;
        for (int num : nums)
            if (num == value)
                count++;
        return count;
    }

    public static void fillArray(int[][] nums) { //Zu Aufgabe 2
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                nums[i][j] = i + j + 2;
            }
        }
    }
    public static void aufgabe2(){
        int[][] nums = new int[8][8];
        fillArray(nums);
        for (int[] num : nums) {
            System.out.println(Arrays.toString(num));
        }
    }

    public static void aufgabe_4() {
        char[][] zeilen = new char[][]{
                new char[]{'*', 'A', '*', 's', '*', '*'},
                new char[]{'*', ' '},
                new char[]{'B', 'C', '0', 'a'},
        };
        berechneSterneProZeile(zeilen);
        System.out.println();

        char[][] spalten = new char[][]{
                new char[]{'*', 'A', '*', 'a'},
                new char[]{'*', '*', '*', 'b'},
                new char[]{'B', 'C', '0', 'c'},
        };
        berechneSterneProSpalte(spalten);
        System.out.println();

        berechneAnzahlZeilen(spalten);
    }
    public static void berechneSterneProZeile(char[][] chars) {
        for (int i = 0; i < chars.length; i++) {
            int counter = 0;
            for (int j = 0; j < chars[i].length; j++) {
                if(chars[i][j] == '*') {
                    counter++;
                }
            }
            System.out.println("Zeile " + i + ": " + counter);
        }
    }

    public static void berechneSterneProSpalte(char[][] chars) {
        for (int i = 0; i < chars[0].length; i++) {
            int counter = 0;
            for (int j = 0; j < chars.length; j++) {
                if(chars[j][i] == '*') {
                    counter++;
                }
            }
            System.out.println("Spalte " + i + ": " + counter);
        }
    }

    public static void berechneAnzahlZeilen(char[][] chars) {
        int rowCounter = 0;
        for (int i = 0; i < chars.length; i++) {
            int counter = 0;
            for (int j = 0; j < chars[i].length; j++) {
                if(chars[i][j] == '*') {
                    counter++;
                }
            }
            if(counter >= 2)
                rowCounter++;
        }
        System.out.println("Anzahl an Zeilen mit mindestens 2 Sternen: " + rowCounter);
    }
    
    public static void aufgabe_5(){
        //System.out.println(skalarProdukt());
        int[][] matrix1 = new int[][]{
                new int[]{1, 2, 3},
                new int[]{3, 2, 1},
                new int[]{0, 0, 0},
        };
        int[][] matrix2 = new int[][]{
                new int[]{1, 2, 3},
                new int[]{3, 2, 1},
                new int[]{0, 0, 0},
        };

        int[][] ergebnis = matrixProdukt(matrix1, matrix2);
        for (int[] zeile : ergebnis) {
            System.out.println(Arrays.toString(zeile));
        }

    }

    public static int skalarProdukt(int[] v, int[] w) {
        if(v.length != w.length) throw new IllegalArgumentException("v.length != w.length");
        int result = 0;
        for (int i = 0; i < v.length; i++) {
            result += v[i] * w[i];
        }
        return result;
    }

    public static int[] getZeile(int[][] A, int i) { //5b
        return A[i];
    }

    public static int[] getSpalte(int[][] B, int j) { //5c
        int[] result = new int[B[0].length];
        for (int i = 0; i < B.length; i++) {
            result[i] = B[i][j];
        }
        return result;
    }

    public static int[][] matrixProdukt(int[][] A, int[][] B){ // Aufgabe 5 d
        int[][] matrix = new int[A[0].length][A.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = skalarProdukt(getZeile(A, i), getSpalte(B, j));
            }
        }
        return matrix;
    }

}
class RelationenPruefen {

    public static void main(String[] args) {
        final boolean[][] R1 = {
                { false, true, true },
                { true, false, true },
                { true, true, false }
        };
        final boolean[][] R2 = {
                { true, true, true },
                { false, true, true },
                { false, false, true }
        };
        final boolean[][] R3 = {
                { true, false, false, true },
                { false, true, true, false },
                { false, true, true, false },
                { true, false, false, true }
        };

        System.out.println("Dieses Programm testet ihre Funktionen zur Überprüfung der drei\n"
                + "Beispielmatrizen R1, R2 und R3, in dem es die Funktionen jeweils aufruft.");
        System.out.println("Ihre Funktion ist_reflexiv errechnet für die Beispielmatrizen\n"
                + "R1, R2 und R3 die folgenden Ausgaben " + ist_reflexiv(R1) + ", " + ist_reflexiv(R2) + " und "
                + ist_reflexiv(R3) + "\nkorrekt ist false, true und true\n");

        System.out.println("Ihre Funktion ist_symmetrisch errechnet für die Beispielmatrizen\n"
                + "R1, R2 und R3 die folgenden Ausgaben " + ist_symmetrisch(R1) + ", " + ist_symmetrisch(R2) + " und "
                + ist_symmetrisch(R3) + "\nkorrekt ist true, false und true\n");

        System.out.println("Ihre Funktion ist_antisymmetrisch errechnet für die Beispielmatrizen\n"
                + "R1, R2 und R3 die folgenden Ausgaben " + ist_antisymmetrisch(R1) + ", " + ist_antisymmetrisch(R2)
                + " und " + ist_antisymmetrisch(R3) + "\nkorrekt ist false, true und false\n");

        System.out.println("Ihre Funktion ist_transitiv errechnet für die Beispielmatrizen\n"
                + "R1, R2 und R3 die folgenden Ausgaben " + ist_transitiv(R1) + ", " + ist_transitiv(R2) + " und "
                + ist_transitiv(R3) + "\nkorrekt ist false, true und true\n");
    }

    public static boolean ist_reflexiv(boolean[][] R) {
        for (int i = 0; i < R.length; i++) {
            if(!R[i][i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean ist_symmetrisch(boolean[][] R) {
        for (int i = 0; i < R.length; i++) {
            for (int j = 0; j < R[i].length; j++) {
                if(R[i][j] != R[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean ist_antisymmetrisch(boolean[][] R) {
        for (int i = 0; i < R.length; i++) {
            for (int j = 0; j < R[i].length; j++) {
                // das ist Arschkrebs aber egal, funktioniert 👍👍
                if(!R[i][j] && !(i != j && R[j][i]))
                    return false;
            }
        }
        return true;
    }

    public static boolean ist_transitiv(boolean[][] R) {
        /*
        * true wenn:
        * R[i][j]
        * R[j][k]
        * R[i][k]
        * */
        for (int i = 0; i < R.length; i++) {
            for (int j = 0; j < R[i].length; j++) {
                for (int k = 0; k < R[i].length; k++) {
                    if(R[i][j] && R[j][k]) {
                        if(!R[i][k]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

}
