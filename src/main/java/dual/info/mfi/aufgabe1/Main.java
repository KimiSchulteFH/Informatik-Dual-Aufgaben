package dual.info.mfi.aufgabe1;

public class Main {

    public static void main(String[] args) {
        Aufgabe1 aufgabe1 = new Aufgabe1();
        System.out.println(aufgabe1.c(0, 0) == 1);
        System.out.println(aufgabe1.c(0, 1) == 0);
        System.out.println(aufgabe1.c(1, 1));
        System.out.println(aufgabe1.c(4, 4));
        System.out.println(aufgabe1.c(4, 3));
        System.out.println(aufgabe1.c(3, 2));
    }
}