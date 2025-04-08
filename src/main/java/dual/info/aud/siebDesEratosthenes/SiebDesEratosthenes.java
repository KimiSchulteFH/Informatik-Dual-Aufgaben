package dual.info.aud.siebDesEratosthenes;

import lombok.Getter;
import lombok.Setter;

import java.io.PrintStream;

public class SiebDesEratosthenes {

    private final int n;
    private final Zahl[] zahlen;

    public SiebDesEratosthenes(int n) {
        this.n = n;
        zahlen = new Zahl[n];
    }

    private void hinschreiben(int zahl) {
        zahlen[zahl - 1] = new Zahl(zahl);
    }

    private boolean isDurchgestrichen(int zahl) {
        return zahlen[zahl - 1].isDurchgestrichen();
    }

    private void durchstreichen(int zahl) {
        zahlen[zahl - 1].setDurchgestrichen(true);
    }

    private void durchstreichenVielfache(int zahl) {
        for (int i = zahl * 2; i <= n; i += zahl) {
                durchstreichen(i);
        }
    }

    public void berechnePrimzahlen(PrintStream out) {
        for (int i = 1; i <= n; i++)
            hinschreiben(i);
        durchstreichen(1);
        { // das hier ist nur da, weil "a" im pseudocode mehrfach definiert wird
            int a = 2;
            while ((a * a) <= n) {
                if(!isDurchgestrichen(a)) {
                    durchstreichenVielfache(a);
                }
                a++;
            }
        }
        String result = "Primzahlen:\n";
        for (int a = 1; a <= n; a++) {
            if(!isDurchgestrichen(a)) {
                result += a + ", ";
            }
        }
        result = result.substring(0, result.length() - 2);
        out.println(result);
    }

}

//das hier ist NICHT native java aber ist schöner
// es werden beim Start getBlabla und setBlabla hinzugefügt
@Getter
class Zahl {
    private final int zahl;
    @Setter
    private boolean isDurchgestrichen;

    public Zahl(int zahl) {
        this.zahl = zahl;
        this.isDurchgestrichen = false;
    }

}