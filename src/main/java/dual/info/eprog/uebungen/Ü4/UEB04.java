package dual.info.eprog.uebungen.Ü4;

import java.util.Scanner;

public class UEB04 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Radius: ");
        double radius = sc.nextDouble();
        System.out.print("Höhe: ");
        double hoehe = sc.nextDouble();

        Dosenberechnung dosenberechnung = new Dosenberechnung();
        System.out.println("Umfang: " + dosenberechnung.umfang(radius));
        System.out.println("Deckelfläche: " + dosenberechnung.deckelflaeche(radius));
        System.out.println("Mantelfläche: " + dosenberechnung.mantelflaeche(radius, hoehe));
        System.out.println("Oberfläche: " + dosenberechnung.oberflaeche(radius, hoehe));
        System.out.println("Volumen: " + dosenberechnung.volumen(radius, hoehe));
    }

}

class Dosenberechnung {

    public double umfang(double radius) {
        return 2* Math.PI * radius;
    }

    public double deckelflaeche(double radius) {
        return Math.PI * radius * radius;
    }

    public double mantelflaeche(double radius, double hoehe) {
        return umfang(radius) * hoehe;
    }

    public double oberflaeche(double radius, double hoehe) {
        return 2 * deckelflaeche(radius) + mantelflaeche(radius, hoehe);
    }

    public double volumen(double radius, double hoehe) {
        return deckelflaeche(radius) * hoehe;
    }

}