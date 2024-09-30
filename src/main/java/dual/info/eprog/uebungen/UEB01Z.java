package dual.info.eprog.uebungen;

public class UEB01Z {
    public static void main(String[] args) {
        int x = 31;
        String result = "";
        int current = x;
        while (current > 0) {
            int rest = current % 2;
            current /= 2;
            result = rest + result;
        }
        System.out.println(result);
    }


}
