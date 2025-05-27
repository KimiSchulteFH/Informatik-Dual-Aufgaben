package dual.info.aud.baeume.bbaeume.provided;

class BBaum<T extends Comparable<T>>
{
	public BKnoten<T> wurzel;

	public BBaum(BKnoten<T> wurzel)
	{
		assert(wurzel != null);

		this.wurzel = wurzel;
	}

	// Wrapper-Methode
	public void traversieren()
	{
		traversieren(wurzel);
	}

	// Eigentliche Implementierung
	private void traversieren(BKnoten<T> knoten)
	{
		if(knoten == null)
			return;

		for (int i = 0; i < knoten.elemente.length; i++) {
			T element = knoten.elemente[i];
			traversieren(knoten.kinder[i]);
			System.out.print(element + ", ");
		}
		traversieren(knoten.kinder[knoten.kinder.length - 1]);
	}

	// Wrapper-Methode
	public boolean suchen(final T daten)
	{
		assert(daten != null);

		return suchen(daten, wurzel);
	}

	// Eigentliche Implementierung
	private boolean suchen(final T daten, BKnoten<T> knoten)
	{
		if(knoten == null || daten == null)
			return false;

		for (int i = 0; i < knoten.elemente.length; i++) {
			T element = knoten.elemente[i];
			if(daten.compareTo(element) == 0)
				return true;
			if(daten.compareTo(element) < 0)
				return suchen(daten, knoten.kinder[i]);
		}
		return suchen(daten, knoten.kinder[knoten.kinder.length - 1]);
	}
}

//package dual.info.aud.baeume.bbaeume.provided;
//
//class BBaum<T extends Comparable<T>> {
//    public BKnoten<T> wurzel;
//
//    public BBaum(BKnoten<T> wurzel) {
//        assert(wurzel != null);
//        this.wurzel = wurzel;
//    }
//
//    // Wrapper-Methode
//    public void traversieren() {
//        traversieren(wurzel);
//    }
//
//    // Eigentliche Implementierung
//    private void traversieren(BKnoten<T> knoten) {
//        int i;
//        for (i = 0; i < knoten.keys.size(); i++) {
//            // Linkes Kind traversieren
//            if (knoten.kinder != null && !knoten.kinder.isEmpty()) {
//                traversieren(knoten.kinder.get(i));
//            }
//            // Aktuellen Schlüssel ausgeben
//            System.out.print(knoten.keys.get(i) + " ");
//        }
//        // Letztes Kind traversieren
//        if (knoten.kinder != null && !knoten.kinder.isEmpty()) {
//            traversieren(knoten.kinder.get(i));
//        }
//    }
//
//    // Wrapper-Methode
//    public boolean suchen(final T daten) {
//        assert(daten != null);
//        return suchen(daten, wurzel);
//    }
//
//    // Eigentliche Implementierung
//    private boolean suchen(final T daten, BKnoten<T> knoten) {
//        int i = 0;
//        // Finde die erste Position, wo daten kleiner/gleich ist
//        while (i < knoten.keys.size() && daten.compareTo(knoten.keys.get(i)) > 0) {
//            i++;
//        }
//        // Wenn Schlüssel gefunden
//        if (i < knoten.keys.size() && daten.compareTo(knoten.keys.get(i)) == 0) {
//            return true;
//        }
//        // Wenn Blattknoten erreicht
//        if (knoten.kinder == null) {
//            return false;
//        }
//        // Rekursiv im entsprechenden Kind suchen
//        return suchen(daten, knoten.kinder.get(i));
//    }
//}