package dual.info.aud.komplexitaet;

import java.util.Scanner;
import java.util.concurrent.Callable;

public class Zeitmessung
{
	private static int counter = 0;
	// Zeitkomplexit�t O(1)
	private static double tuwas()
	{
		counter++;
		return Math.random();
	}

	// Zeitkomplexit�t O(n)
	public static double func1(int n)
	{
		double summe = 0;

		for (int a=0; a<n; a++)
			summe += tuwas();
			
		for (int b=0; b<n; b++)
			summe += tuwas();

		return summe;
	}

	// Zeitkomplexit�t O(n^2)
	public static double func2(int n)
	{
		double summe = 0;

		for (int a = 0; a < n; a++)
			for(int b = 0; b < n; b++)
				summe += tuwas();

		return summe;
	}

	// Zeitkomplexit�t O(log2(n))
	public static double func6(int n)
	{
		double summe = 0;

		for (int a=n; a>=1; a/=2)
		{
			summe += tuwas();
		}

		return summe;
	}

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Geben Sie die Problemgröße (n) ein: ");
		int n = in.nextInt();
		System.out.println("Geben Sie die Anzahl der Messdurchläufe ein:");
		int d = in.nextInt();

		System.out.println("		 Laufzeit in msec | Anzahl der Aufrufe");

		/*measureTime(() -> func1(n), "func1");
		measureTime(() -> func2(n), "func2");
		measureTime(() -> func6(n), "func6");*/

		double timeFunc1 = 0;
		double timeFunc2 = 0;
		double timeFunc6 = 0;
		int counterFunc1 = 0;
		int counterFunc2 = 0;
		int counterFunc6 = 0;

		StopUhr stopUhr = new StopUhr();

		for (int i = 0; i < d; i++) {
			counter = 0;
			stopUhr.start();
			func1(n);
			stopUhr.stop();
			timeFunc1 += stopUhr.getDuration();
			counterFunc1 += counter;

			counter = 0;
			stopUhr.start();
			func2(n);
			stopUhr.stop();
			timeFunc2 += stopUhr.getDuration();
			counterFunc2 += counter;

			counter = 0;
			stopUhr.start();
			func6(n);
			stopUhr.stop();
			timeFunc6 += stopUhr.getDuration();
			counterFunc6 += counter;
		}

		timeFunc1 /= d;
		timeFunc2 /= d;
		timeFunc6 /= d;

		counterFunc1 /= d;
		counterFunc2 /= d;
		counterFunc6 /= d;

		System.out.printf("Func1:		%10.3f    | %10d \n", (float) timeFunc1 / 1_000_000, counterFunc1);
		System.out.printf("Func2:		%10.3f    | %10d \n", (float) timeFunc2 / 1_000_000, counterFunc2);
		System.out.printf("Func6:		%10.3f    | %10d \n", (float) timeFunc6 / 1_000_000, counterFunc6);
	}

	/*public static void measureTime(Callable<Double> func, String functionName) {
		StopUhr stopUhr = new StopUhr();
		stopUhr.start();
		counter = 0;

		try {
			func.call();  // Call the function
			stopUhr.stop();

			System.out.printf(functionName + ":		%10.3f    | %10d \n", (float) stopUhr.getDuration() / 1_000_000, counter);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
}
