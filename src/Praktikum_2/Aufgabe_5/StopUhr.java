package Praktikum_2.Aufgabe_5;

public class StopUhr
{
	private static long startTime, stopTime;

	public static void start()
	{
		startTime = System.nanoTime();
	}

	public static  void stop()
	{
		stopTime = System.nanoTime();
	}

	public static long getDuration()
	{
		return stopTime - startTime;
	}
}