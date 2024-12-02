package dual.info.eprog.uebungen.UE08;

public class UE08Z {

}

class RechteckTest {

    public static void main(String[] args) {
        Rechteck r1 = new Rechteck(0,0,7,5); //Rechteck was Punkte hat
        System.out.println(r1);
        Rechteck r2 = new Rechteck(6,4,2,2); //Rechteck wo anderes Rechteck liegen soll
        System.out.println(r2);
        Rechteck r3 = new Rechteck(-1,2,9,2); // 1 und 3 ist kaputt ->
        System.out.println(r3);
        Rechteck r4 = new Rechteck(-1,-1,2,2);
        System.out.println(r4);
        Rechteck r5 = new Rechteck(5,-1,3,7);
        System.out.println(r5);
        System.out.print(r1.schneidet(r2) + " ");
        System.out.print(r1.schneidet(r3) + " ");
        System.out.print(r1.schneidet(r4) + " ");
        System.out.print(r1.schneidet(r5) + " ");
        System.out.println(r4.schneidet(r2));
        // da sollte "true true true true false" rauskommen
    }

}

class Rechteck {

    private final Punkt2D eckeLinksUnten;
    private double seitenlaengeX, seitenlaengeY;

    public Rechteck(double x, double y, double seitenlaengeX, double seitenlaengeY) {
        eckeLinksUnten = new Punkt2D(x, y);
        this.seitenlaengeX = seitenlaengeX;
        this.seitenlaengeY = seitenlaengeY;
    }

    public boolean jessMagieFunktion(Rechteck R) {
        for (double j = R.getEckeLinksUnten().x; j <= R.getEckeLinksUnten().x + R.seitenlaengeX; j++) { //alle x Höhen durchegehen von R
            if (j >= eckeLinksUnten.x && j <= eckeLinksUnten.x + seitenlaengeX) { //wenn R2 mit x R1 schneidet, wird geguckt, ob dort auch Schnitt bei y ist...sonst halt nicht loooool
                for (double l = R.getEckeLinksUnten().x; l <= R.getEckeLinksUnten().x + R.seitenlaengeY; l++) { //alle y Höhen von R
                    if (R.getEckeLinksUnten().x <= l && R.getEckeLinksUnten().x + R.seitenlaengeY >= l) { //wenn sie auch Schnitt bei y haben -> sie schneiden sich

                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean schneidet(Rechteck R) {
        if(false) // zu true ändern wenn man jessMagieFUnktion benutzen möchte
            return jessMagieFunktion(R);

        Punkt2D andereEckeLinksUnten = R.getEckeLinksUnten();
        Punkt2D andereEckeRechtsOben = R.getEckeRechtsOben();

        Punkt2D eigeneEckeRechtsOben = this.getEckeRechtsOben();

        // Prüfen, ob eines der Rechtecke komplett links, rechts, oberhalb oder unterhalb des anderen liegt
        if (eckeLinksUnten.x >= andereEckeRechtsOben.x || // aktuelles ist rechts vom anderen
                eigeneEckeRechtsOben.x <= andereEckeLinksUnten.x || // aktuelles ist links vom anderen
                eckeLinksUnten.y >= andereEckeRechtsOben.y || // aktuelles ist oberhalb des anderen
                eigeneEckeRechtsOben.y <= andereEckeLinksUnten.y) { // aktuelles ist unterhalb des anderen
            return false;
        }
        return true; // Ansonsten schneiden sich die Rechtecke :D
    }

    public Punkt2D getEckeLinksUnten() {
        return eckeLinksUnten;
    }

    public Punkt2D getEckeLinksOben() {
        return new Punkt2D(eckeLinksUnten.x, eckeLinksUnten.y + seitenlaengeY);
    }

    public Punkt2D getEckeRechtsOben() {
        return new Punkt2D(eckeLinksUnten.x + seitenlaengeX, eckeLinksUnten.y + seitenlaengeY);
    }

    public Punkt2D getEckeRechtsUnten() {
        return new Punkt2D(eckeLinksUnten.x + seitenlaengeX, eckeLinksUnten.y);
    }

    public double getSeitenlaengeX() {
        return seitenlaengeX;
    }

    public void setSeitenlaengeX(double seitenlaengeX) {
        this.seitenlaengeX = seitenlaengeX;
    }

    public double getSeitenlaengeY() {
        return seitenlaengeY;
    }

    public void setSeitenlaengeY(double seitenlaengeY) {
        this.seitenlaengeY = seitenlaengeY;
    }

    @Override
    public String toString() {
        return "Rechteck mit Seitenlängen " + seitenlaengeX
                + " und " + seitenlaengeY + " an der Stelle ("
                + eckeLinksUnten.x + "," + eckeLinksUnten.y + ")";
    }
}

class Punkt2D {

    double x, y;

    public Punkt2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Punkt2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}