package Praktikum_2.Aufgabe_5;

public class Zeitmessung
{
	private static double tuwas()
	{
		return Math.random();
	}

	// Linear
	public static double func1(int n)
	{
		double summe = 0;

		for (int a = 0; a < n; a++)
			summe += tuwas();

		return summe;
	}

	// Quadratisch
	public static double func2(int n)
	{
		double summe = 0;

		for (int a = 0; a < n; a++)
			for(int b = 0; b < n; b++)
				summe += tuwas();

		return summe;
	}

	// log2(n)
	public static double func6(int n)
	{
		double summe = 0;

		while (n > 0)
		{
			summe += tuwas();
			n /= 2;
		}

		return summe;
	}

	public static void main(String[] args)
	{
		int  n=100;
		for(int il=0;il<5;il++)
		{
			StopUhr.start();
			func1(n);
			StopUhr.stop();
			System.out.println("Funktion 1 (linear) bei: "+n +" Benötigt: "+(double)StopUhr.getDuration()/1000000 +"ms");

			StopUhr.start();
			func2(n);
			StopUhr.stop();
			System.out.println("Funktion 2 (exponentiell) bei: "+n +" Benötigt: "+(double)StopUhr.getDuration()/1000000+"ms");

			StopUhr.start();
			func6(n);
			StopUhr.stop();
			System.out.println("Funktion 6 (logarithmisch) bei: "+n +" Benötigt: "+(double)StopUhr.getDuration()/1000000+"ms");
			System.out.println();
			n=n*10;
		}
	}
}
