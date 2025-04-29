package dual.info.aud.rekursion;
import java.util.Scanner;
public class PR05 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Geben Sie n-te Fibonacci-Zahl ein :");
        int n = scanner.nextInt();
        System.out.println("Rekursiv:");
        System.out.println(rekursiv(n));
        System.out.println("Iterativ:");
        System.out.println(iterativ(n));

       // System.out.println(sose14(12, 1, 1));
    }

    public static int rekursiv (int n){
        if (n <= 0) return 0;
        if (n == 1) return 1;
        return rekursiv(n - 1) + rekursiv(n - 2);
    }
    public static int iterativ (int n) {

        if (n <= 0) return 0;
        if (n == 1) return 1;
        int vorgaenger = 0;
        int ergebnis = 1;
        for(int i = 2; i <= n; i++) {
            int zwischenvariable = ergebnis; //für umschreiben vorvorgaenger
            ergebnis = vorgaenger + ergebnis; //berechnen derzeitiges ergebnis
            vorgaenger = zwischenvariable;
        }
        return ergebnis;
    }

    public static long sose14(int grenze, long fib1, long fib2) { //warum sose14? weil sommersemester 2014 aber warum 2014?
        if(grenze <= 1)
            return fib2;
        
       return sose14(grenze - 1, fib2, fib1 + fib2);
    }
}


