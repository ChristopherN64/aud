package Praktikum_7;

class BBaum<T extends Comparable<T>>
{
	public BKnoten<T> wurzel;

	public BBaum(BKnoten<T> wurzel)
	{
		assert(wurzel != null);

		this.wurzel = wurzel;
	}

	// Wrapper-Methode
	public void traversieren()
	{
		traversieren(wurzel);
	}

	// Eigentliche Implementierung
	private void traversieren(BKnoten<T> knoten)
	{
		for(int il=0;il<knoten.elemente.length;il++)
		{
		System.out.print(knoten.elemente[il]+" | ");
		}
		System.out.println();
		for(int il=0;il<knoten.kinder.length;il++)
		{

			if(knoten.kinder!=null && knoten.kinder[il]!=null)
			{
				if(il>knoten.kinder.length-2)
				{
					System.out.print("Rechts von "+knoten.elemente[il-1]+": ");
				}
				else System.out.print(knoten.elemente[il]+": ");

				traversieren(knoten.kinder[il]);
			}

		}


	}

	// Wrapper-Methode
	public boolean suchen(final T daten)
	{
		assert(daten != null);

		return suchen(daten, wurzel);
	}

	// Eigentliche Implementierung
	private boolean suchen(final T daten, BKnoten<T> knoten)
	{
		//Durchgehen aller Elemente des Knotens
			for(int il = 0; il< knoten.elemente.length; il++)
			{
				//Wenn das Gesuchte Element unter den Knotenelementen ist wird true zurpckgegeben
				if(knoten.elemente[il].compareTo(daten)==0)
				{
					return true;
				}
				//Wenn man bei dem Element angekommen ist, das größer ist als das gesuchte wird in diesen Teilbaum gesprngen (Rekursiver aufruf)
				else if(knoten.elemente[il].compareTo(daten)>0)
				{
					if(knoten.kinder[il]==null)return false; 		//Wenn es das Kind (den Teilbaum) welches das Element enthalten müsste nicht gibt wird false zurückgegeben
					return suchen(daten,knoten.kinder[il]);			//Es wird in dem Kind (dem Teilbaum) welches das Element enthalten müsste weitergesucht
				}
			}
			if(knoten.kinder[knoten.kinder.length-1]==null) return false;
			return suchen(daten,knoten.kinder[knoten.kinder.length-1]);		//Wenn es kein Element im Knoten gibt das größer ist als das gesuchte muss das Element im letzten Teilbaum sein also wird in diesem weirte gesucht
	}
}