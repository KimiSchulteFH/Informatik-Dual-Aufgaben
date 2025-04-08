package dual.info.aud.siebDesEratosthenes;

import java.util.Scanner;

public class PrimzahlTest {

    public static void main(String[] args) {
        int zahl = new Scanner(System.in).nextInt();
        SiebDesEratosthenes sieb = new SiebDesEratosthenes(zahl);
        sieb.berechnePrimzahlen(System.out);
    }

}
