package Praktikum_11.Aufgabe6;

public class HashTable
{
	private static final int START_TABELLENGROESSE = 10;	// Standardgr��e

	private IHashable[] table;								// Array f�r Hash-Objekte
	private int currentSize;								// Die Anzahl der belegten Slots

	public HashTable()
	{
		this(START_TABELLENGROESSE);
	}

	// Konstruktor mit expliziter Gr��enangabe
	public HashTable(final int groesse)
	{
		assert(groesse > 0);

		table = new IHashable[groesse];
		clear();
	}

	// F�gt ein Objekt in die Hashtabelle ein.
	// Falls der Eintrag bereits existiert passiert NICHTS!
	public void insert(final IHashable o)
	{
		assert(o != null);

		final int currentPos = findePosition(o);

		if (table[currentPos] == null)
		{
			table[currentPos] = o;

			if (++currentSize > table.length / 2)
				rehash();
		}
	}

	// Erweiterung der Hashtabelle
	private void rehash()
	{
		// Debug-Ausgabe
		System.out.println("rehash(" + table.length+ ")");

		// Kopie der alten Hashtabelle anlegen
		IHashable[] oldTable = table;

		// Erzeuge table mit mindestens der doppelten Gr��e
		// (f�hrt zu O(log n) Vergr��erungs-Operationen f�r n Objekte)
		table = new IHashable[nextPrime(2 * oldTable.length)];

		currentSize = 0;

		// Einsortieren der Elemente ins neue Array
		for (int a = 0; a < oldTable.length; a++)
			if (oldTable[a] != null)
				insert(oldTable[a]);
	}

	// Quadratisches Sondieren
	public int findePosition(IHashable o)
	{
		// Suche Index, an der das Objekt o in table eingetragen ist bzw. eingetragen werden kann
		// Kollisionaufl�sung durch quadratisches Sondieren
		int iTableSize = table.length;

		//Wenn die Stelle an dem der Wert stehen müsste leer ist, ist der Wert nicht enthalten
		if(table[o.hash(iTableSize)]==null) return o.hash(iTableSize);
		//Wenn die Stelle an dem der Wert stehen müsste gleich dem gesuchtem Wert ist wird der errechnete Index returnt
		else if(table[o.hash(iTableSize)].equals(o))
		{
			return o.hash(iTableSize);
		}
		//Wenn die Stelle an dem der Wert stehen müsste belegt ist, aber nicht mit dem gesuchten wert ist Vielleicht eine Kollision aufgetreten und es wird der nächsten
		//Quadratischen Kollisionsindex überprüft
		else
		{
			int iNeuerSuchIndex=o.hash(iTableSize)+1;
			//System.out.println(iNeuerSuchIndex);
			for(int il=2;table[iNeuerSuchIndex]!=null;il++)
			{
				if(table[iNeuerSuchIndex].equals(o)) return iNeuerSuchIndex;
				else
				{
					iNeuerSuchIndex =(o.hash(iTableSize)+(il*il))%iTableSize;
				}
			}
			return iNeuerSuchIndex;
		}
	}

	// Findet ein Objekt in der Hashtabelle
	public IHashable find(IHashable o)
	{
		return table[findePosition(o)];
	}

	// L�schen der gesamten Hashtabelle
	public void clear()
	{
		for (int a = 0; a < table.length; a++)
			table[a] = null;

		currentSize = 0;
	}

	// Interne Test-Methode
	public IHashable getEntry(final int pos)
	{
		return table[pos];
	}

	// Interne Test-Methode
	public int getSize()
	{
		return table.length;
	}

	// Private Funktion, die zu einer vorgegebenen Zahl n die n�chsth�here Primzahl findet
	private static int nextPrime(int n)
	{
		assert(n >= 0);

		// N�chste ungerade Zahl
		n |= 1;

		while (!isPrime(n))
			n += 2;

		return n;
	}

	// Testet, ob eine Zahl eine Primzahl ist (einfache, aber ineffiziente Implementierung)
	private static boolean isPrime(final int n)
	{
		if ((n == 2) || (n == 3))
			return true;

		if ((n == 1) || ((n & 1) == 0))
			return false;

		for (int a = 3; a * a <= n; a += 2)
			if ((n % a) == 0)
				return false;

		return true;
	}
}