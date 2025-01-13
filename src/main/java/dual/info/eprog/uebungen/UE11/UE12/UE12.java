package dual.info.eprog.uebungen.UE11.UE12;

public class UE12 {

    public static void main(String[] args) {
        Regal regal = new Regal();
        CD cd = new CD(100);
        if(regal.fuegeHinzu(cd)) {
            System.out.println("CD hinzugefügt");
        }
        CD cd2 = new CD(100);
        if(regal.fuegeHinzu(cd2)) {
            System.out.println("CD2 hinzugefügt");
        }
        CD cd3 = new CD(100);
        if(regal.fuegeHinzu(cd3)) {
            System.out.println("CD3 hinzugefügt");
        }
    }

}

class Regal {

    private RegalBrett[] regalBretter = new RegalBrett[10];

    public Regal() {
        RegalBrett brett1 = new RegalBrett(100, 100);
        RegalBrett brett2 = new RegalBrett(100, 100);
        regalBretter[0] = brett1;
        regalBretter[1] = brett2;
        // es muss mindestens 2 bretter geben
    }

    public boolean fuegeHinzu(Medium medium) {
        for (RegalBrett regalBrett : regalBretter) {
            if(regalBrett != null
                    && regalBrett.addMedium(medium)) {
                return true;
            }
        }
        return false;
    }

}

class RegalBrett {

    private int breite;
    private double tragkraft;

    private Medium[] media = new Medium[100];

    public RegalBrett(int breite, double tragkraft) {
        this.breite = breite;
        this.tragkraft = tragkraft;
    }

    public boolean addMedium(Medium medium) {
        if(getGesamtTragkraft() + medium.getGewicht() > tragkraft
                || getGesamtBreite() + medium.getBreite() > breite)
            return false;
        for (int i = 0; i < media.length; i++) {
            if(media[i] == null)
                media[i] = medium;
            return true;
        }
        return false;
    }

    public boolean removeMedium(int index) {
        if(index < 0 || index >= media.length)
            return false;
        media[index] = null;
        return true;
    }

    private double getGesamtTragkraft() {
        double sum = 0;
        for (Medium medium : media) {
            if(medium != null) {
                sum += medium.getGewicht();
            }
        }
        return sum;
    }

    private int getGesamtBreite() {
        int sum = 0;
        for (Medium medium : media) {
            if(medium != null) {
                sum += medium.getBreite();
            }
        }
        return sum;
    }
}

class Buch implements Medium {

    private double gewicht;
    private int breite;

    public Buch(double gewicht, int breite) {
        this.gewicht = gewicht;
        this.breite = breite;
    }

    @Override
    public double getGewicht() {
        return gewicht;
    }

    @Override
    public int getBreite() {
        return breite;
    }
}

class CD implements Medium {

    private int breite;

    public CD(int breite) {
        this.breite = breite;
    }

    @Override
    public double getGewicht() {
        return 1.5;
    }

    @Override
    public int getBreite() {
        return breite;
    }
}

interface Medium {
    double getGewicht();
    int getBreite();
}