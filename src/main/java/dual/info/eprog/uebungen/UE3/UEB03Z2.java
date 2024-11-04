package dual.info.eprog.uebungen.UE3;

import java.util.Scanner;

public class UEB03Z2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int and = a & b;
        int or = a | b;
        int xor = a ^ b;

        System.out.println("UND: " + Long.toBinaryString(and) + " (" + and + ")");
        System.out.println("OR: " + Long.toBinaryString(or) + " (" + or + ")");
        System.out.println("XOR: " + Long.toBinaryString(xor) + " (" + xor + ")");

        int aNachLinks = a << 3;
        int aNachRechts = a >> 3;
        int bNachLinks = b << 3;
        int bNachRechts = b >> 3;

        System.out.println("Erste Zahl << 3: " + Long.toBinaryString(aNachLinks) + " (" + aNachLinks + ")");
        System.out.println("Erste Zahl >> 3: " + Long.toBinaryString(aNachRechts) + " (" + aNachRechts + ")");
        System.out.println("Zweite Zahl << 3: " + Long.toBinaryString(bNachLinks) + " (" + bNachLinks + ")");
        System.out.println("Zweite Zahl >> 3: " + Long.toBinaryString(bNachRechts) + " (" + bNachRechts + ")");


    }
}

