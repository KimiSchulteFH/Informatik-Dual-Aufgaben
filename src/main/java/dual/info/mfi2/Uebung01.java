package dual.info.mfi2;

import java.util.HashMap;

public class Uebung01 {

    private final HashMap<Integer, Integer> cache = new HashMap<>();

    public int fibonacci(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(cache.containsKey(n)) return cache.get(n);

        int result = fibonacci(n - 1) + fibonacci(n - 2);
        cache.put(n, result);
        return result;
    }

    public static void main(String[] args) {
        Uebung01 uebung01 = new Uebung01();
        uebung01.extra1();

        System.out.println();

        uebung01.extra2();
    }

    public void extra2() {
        int n = 5;

        for (int i = 0; i < 50; i++) {
            System.out.println("Fn/Fn-1 = " + (fibonacci(n) / fibonacci(n - 1)));
        }
    }

    public void extra1() {
        double highest = Math.pow(10, 9);

        int n = 0;
        int result = fibonacci(n);
        while (result < highest) {
            result = fibonacci(++n);
        }
        System.out.println("Found smallest number smaller than 10^9: " + n);
    }

}
