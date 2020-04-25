package Praktikum_2.Aufgabe_4;
import java.math.*;

public class BesterAlgorithmus
{
	// 1000n
	public static double g1(int n)
	{
		return  1000*n;
	}

	// 100n * log2(n+1)
	public static double g2(int n)
	{
		return 100 * n * (Math.log( (n+1) ) / Math.log( 2 ));
	}

	// 10 * n * n
	public static double g3(int n)
	{
		return 10*n*n;
	}

	// n * n * n
	public static double g4(int n)
	{
		return n*n*n;
	}

	// 2 hoch n
	public static double g5(int n)
	{
		return Math.pow(2,n);
	}

	// n!
	public static double g6(int n)
	{
		double dFakultät=1;
		for(int il=1;il<=n;il++)
		{
			dFakultät=dFakultät*il;
		}
		return dFakultät;
	}

	// Bestimmt fuer alle 6 Funktionen den Wert von
	// gi(n) und gibt den Index der Funktion mit
	// dem minimalen Wert zurueck
	public static int gewinnerFuerN(int n)
	{
		int iMin=1;
		double dMintime=0;

		dMintime=g1(n);

		if(g2(n)<dMintime) iMin=2;
		if(g3(n)<dMintime) iMin=3;
		if(g4(n)<dMintime) iMin=4;
		if(g5(n)<dMintime) iMin=5;
		if(g6(n)<dMintime) iMin=6;

		return iMin;

	}

	// Gibt f�r jede Zahl n zwischen 1 und 2000 aus, welcher der
	// 6 Algorithmen (A1 .. A6) f�r das betrachtete n der Beste ist
	public static void main(String[] args)
	{
		System.out.println(g6(3));

		int i[]= new int[2001];
		for (int il=1;il<=2000;il++)
		{
			i[il]=gewinnerFuerN(il);
			System.out.println("Für N = "+il+" Agl: "+i[il]);
		}
	}
}