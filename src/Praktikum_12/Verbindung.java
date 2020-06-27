public class Verbindung
{
	private int laenge;
	private int ziel;
	public Verbindung next;

	public Verbindung (int l, int w, Verbindung v)
	{
		laenge = l;
		ziel = w;
		next = v;
	}

	public int getLaenge()
	{
		return laenge;
	}

	public int getZiel()
	{
		return ziel;
	}
}