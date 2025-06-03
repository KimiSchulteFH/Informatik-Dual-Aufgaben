package dual.info.aud.sortieren;

public class BasicSort
{
	// Selectionsort:
	// Sortiere das Teilfeld von array beginnend mit Index links bis einschlie�lich Index rechts
	public static void selectionsort(int[] array, final int links, final int rechts)
	{
		for (int i = links; i < rechts; i++)
		{
			// Kleinstes Element im unsortierten Teil finden
			int min = i;

			for (int j = i + 1; j <= rechts; j++)
				if (array[min] > array[j])
					min = j;

			// Elemente tauschen
			int temp = array[min];
			array[min] = array[i];
			array[i] = temp;
		}
	}

	// Insertionsort:
	// Sortiere das Teilfeld von array beginnend mit Index links bis einschlie�lich Index rechts
	public static void insertionsort(int[] array, final int links, final int rechts)
	{
		if(links < 0 || rechts > array.length - 1)
			return;

		for (int i = links + 1; i <= rechts; i++)
		{
			int x = array[i];
			int j = i - 1;
			while (j >= links && array[j] > x)
			{
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = x;

		}
	}

	// Bubblesort:
	// Sortiere das Teilfeld von array beginnend mit Index links bis einschlie�lich Index rechts
	public static void bubblesort(int[] array, final int links, final int rechts)
	{
		if(links < 0 || rechts > array.length - 1)
			return;

		/*boolean swapped = true;
		while (swapped) {
			swapped = false;
			for (int i = links + 1; i <= rechts; i++) {
				if (array[i] < array[i - 1]) {
					int temp = array[i];
					array[i] = array[i - 1];
					array[i - 1] = temp;
					swapped = true;
				}
			}
		}*/
		int i = array.length - 1;
		boolean getauscht = true;
		while (i > 0 && getauscht) {
			getauscht = false;
			// Durchlaufe das Array und tausche benachbarte Elemente falls nötig
			for (int j = 0; j < i; j++) {
				if (array[j] > array[j + 1]) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
					getauscht = true;
				}
			}
			i--;
		}
	}
}