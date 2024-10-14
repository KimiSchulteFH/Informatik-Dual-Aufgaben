package dual.info.eprog.uebungen.Ü3;

import java.util.Scanner;

public class UEB03Z {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Geben Sie eine Zahl ein: ");
        final int a = scanner.nextInt();
        System.out.println("Geben Sie eine zweite Zahl ein: ");
        final int b = scanner.nextInt();
        int and = a & b;
        int or = a | b;
        int xor = a ^ b;
        System.out.println("Ergebnisse der bitweisen Operationen:");
        System.out.println("UND (&): " + Long.toBinaryString(and) + " (" + and + ")");
        System.out.println("ODER (|): " + toBinary(or) + " (" + or + ")");
        System.out.println("XOR (^): " + toBinary(xor) + " (" + xor + ")");
        System.out.println();

        int leftA = a << 3;
        int rightA = a >> 3;
        int leftB = b << 3;
        int rightB = b >> 3;


        System.out.println("Bitverschiebungsergebnisse:");
        System.out.println("Erste Zahl << 3: " + toBinary(leftA) + " (" + leftA + ")");
        System.out.println("Erste Zahl >> 3: " + toBinary(rightA) + " (" + rightA + ")");
        System.out.println("Zweite Zahl << 3: " + toBinary(leftB) + " (" + leftB + ")");
        System.out.println("Zweite Zahl >> 3: " + toBinary(rightB) + " (" + rightB + ")");
    }

    public static String toBinary(int x) {
        String result = "";
        int current = x;
        while (current > 0) {
            int rest = current % 2;
            current /= 2;
            result = rest + result;
        }
        return result;
    }
}
