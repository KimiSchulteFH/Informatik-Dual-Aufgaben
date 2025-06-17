package dual.info.aud.sortieren;

public class HeapSort {

	// Versickere das Element mit Index pos im Bereich von links bis rechts
	public static void versickere(int[] array, final int links, int pos, final int rechts) {
		while (true) {
			int leftChild = 2 * (pos - links) + 1 + links;
			int rightChild = 2 * (pos - links) + 2 + links;
			int largest = pos;

			if (leftChild <= rechts && array[leftChild] > array[largest]) {
				largest = leftChild;
			}

			if (rightChild <= rechts && array[rightChild] > array[largest]) {
				largest = rightChild;
			}

			if (largest == pos) break;

			vertausche(array, pos, largest);
			pos = largest;
		}
	}

	public static void heapsort(int[] array, final int links, final int rechts) {
		// ERSTE PHASE: Heap aufbauen
		for (int i = (rechts + links - 1) / 2; i >= links; i--) {
			versickere(array, links, i, rechts);
		}

		// ZWEITE PHASE: Sortieren
		for (int i = rechts; i > links; i--) {
			vertausche(array, links, i); // Max-Element an das Ende
			versickere(array, links, links, i - 1); // Heap wiederherstellen
		}
	}

	private static void vertausche(int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
}
