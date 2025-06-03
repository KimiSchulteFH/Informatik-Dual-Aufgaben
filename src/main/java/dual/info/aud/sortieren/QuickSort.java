package dual.info.aud.sortieren;

public class QuickSort
{
	public static void quicksort(int[] array, int links, int rechts) {
		if (links >= rechts) {
			return;
		}

		int pivotIndex = (links + rechts) / 2;
		int pivot = array[pivotIndex];
		int linksPointer = links, rechtsPointer = rechts;

		while (linksPointer <= rechtsPointer) {
			while (array[linksPointer] < pivot) {
				linksPointer++;
			}
			while (array[rechtsPointer] > pivot) {
				rechtsPointer--;
			}

			if (linksPointer <= rechtsPointer) {
				tausche(array, linksPointer, rechtsPointer);
				linksPointer++;
				rechtsPointer--;
			}
		}

		if (links < rechtsPointer) {
			quicksort(array, links, rechtsPointer);
		}
		if (linksPointer < rechts) {
			quicksort(array, linksPointer, rechts);
		}
	}


	private static void tausche(int[] array, final int links, final int rechts) {
		int temp = array[links];
		array[links] = array[rechts];
		array[rechts] = temp;
	}
}

