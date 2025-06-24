package dual.info.aud.suchen;

public class Suche {

    public static boolean binaereSuche(final String[] worte, final String begriff) {
        int leftIndex = 0;
        int rightIndex = worte.length - 1;
        boolean found = false;
        while (!found) {
            if (leftIndex > rightIndex) {
                break;
            }
            int middleIndex = (leftIndex + rightIndex) / 2;
            if (worte[middleIndex].equals(begriff)) {
                found = true;
            } else if (worte[middleIndex].compareTo(begriff) < 0) {
                leftIndex = middleIndex + 1;
            } else {
                rightIndex = middleIndex - 1;
            }
        }
        System.out.println("Fertig!");
        return found;
    }

    public static void main(String[] args) {
        String[] beispiel = {"A", "B", "C", "D", "E", "F", "G", "H"};
        if(binaereSuche(beispiel, "A")) {
            System.out.println("Gefunden :)");
        } else {
            System.out.println("Nicht gefunden :(");
        }
    }

}
/*

binäreSuche(A, k, links, rechts)
if links > rechts then
das gesuchte Element wurde nicht gefunden
else
m  (rechts + links)/2
        if
A[m].Schlüssel > k  then
binäreSuche(A, k, links, m-1)
       else if A[m].Schlüssel < k  then
binäreSuche(A, k, m+1, rechts)
       else
das gesuchte Element ist gefunden
        endif
endif*/
