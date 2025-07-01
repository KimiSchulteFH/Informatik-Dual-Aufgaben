package dual.info.aud.graphen;

import java.util.*;

public class Graph
{
	private static final int KNOTENZAHL = 7;
	private static boolean[] besucht;
	private Knoten[] knoten;
	private boolean[][] matrix = {
			{false, true, false, false, false, false, false},
			{false, false, true, false, false, false, false},
			{false, true, false, false, false, false, false},
			{false, false, false, false, false, false, false},
			{false, false, false, true, false, false, false},
			{false, true, true, false, false, false, false},
			{false, false, false, false, false, false, false},
		};

	public Graph()
	{
		knoten  = new Knoten[KNOTENZAHL];
		knoten[0] = new Knoten("A");
		knoten[1] = new Knoten("B");
		knoten[2] = new Knoten("C");
		knoten[3] = new Knoten("D");
		knoten[4] = new Knoten("E");
		knoten[5] = new Knoten("F");
		knoten[6] = new Knoten("G");
	}

	private boolean isKante(int k1, int k2)
	{
		return matrix[k1][k2] || matrix[k2][k1];
		//  ja alles klar :thumbsup:, erste beiden versucht und drittes angefang, wusste dann nur nicht mehr weiter
		// 👍
	}
	
	// Tiefensuche
	private void rekDfs(final int k)
	{
		// TODO (eigentlich so fertig)
		besucht[k] = true;
		for (int i = 0; i < KNOTENZAHL; i++) {
			if (isKante(k, i) && !besucht[i]) {
				rekDfs(i);
			}
		}
	}

	public void zusammenhangskomponenten()
	{
		besucht = new boolean[KNOTENZAHL];
		int komponentenNr = 1;

		for (int i = 0; i < KNOTENZAHL; i++) {
			if (!besucht[i]) {
				System.out.print("Zusammenhangskomponente " + komponentenNr + ": ");
				rekDfsMitAusgabe(i);
				System.out.println();
				komponentenNr++;
			}
		}
	}

	// Hilfsmethode zur Ausgabe der Knoten während DFS
	private void rekDfsMitAusgabe(final int k)
	{
		besucht[k] = true;
		System.out.print(knoten[k].getName() + " ");
		for (int i = 0; i < KNOTENZAHL; i++) {
			if (isKante(k, i) && !besucht[i]) {
				rekDfsMitAusgabe(i);
			}
		}
	}


	public void bfsIterativ(final int start)
	{
		besucht = new boolean[KNOTENZAHL];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		besucht[start] = true;
		while (!queue.isEmpty()) {
			int k = queue.poll();
			System.out.println(knoten[k].getName());
			for (int i = 0; i < KNOTENZAHL; i++) {
				if (isKante(k, i) && !besucht[i]) {
					queue.add(i);
					besucht[i] = true;
				}
			}
		}

	}

	public static void main(String[] args)
	{
		Graph g = new Graph();
		System.out.println("Bestimmung der Zusammenhangskomponenten");
		g.zusammenhangskomponenten();
		System.out.println();
		
		System.out.println("Start Breitendurchlauf mit " + g.knoten[0].getName());
		g.bfsIterativ(0);
	}
}