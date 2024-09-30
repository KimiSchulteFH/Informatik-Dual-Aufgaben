package dual.info.mfi.aufgabe1;

public class Aufgabe1 {

    public int c(int n, int k) {
        if(n < 0)
            throw new IllegalArgumentException("n < 0");
        if (n == 0) {
            return k == 0 ? 1 : 0;
            // fancy if Schreibweise, auch genannt "inline if"
        } else {
            return c(n-1, k-1) + c(n-1, k);
        }
    }

}
