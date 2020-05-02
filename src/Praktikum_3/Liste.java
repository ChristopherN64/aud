package Praktikum_3;

import sun.font.DelegatingShape;

import java.util.*;

public class Liste<T>
{
	protected Link<T> anfang;
	protected Link<T> ende;

	public Liste()
	{
		// Leere Liste: alle Zeiger sind null (Standardwerte)
	}

	// Einfachster Fall und gleichzeitig Sonderfall:
	// Element am Anfang einf�gen
	public void einfuegen(final T daten)
	{
		// Funktioniert immer
		anfang = new Link<T>(daten, anfang);

		// Bei einer leeren Liste muss auch ende gesetzt werden
		if (ende == null)
			ende = anfang;
	}

	// Einfachster Fall und gleichzeitig Sonderfall:
	// Element am Anfang entfernen
	public T entfernen()
	{
		T opfer = null;

		// Clowns k�nnten diese Methode bei leerer Liste aufrufen
		if (!istLeer())
		{
			// Bei einer Liste mit nur noch einem Element muss
			// auch ende gel�scht werden
			if (anfang == ende)
				ende = null;

			opfer = anfang.daten;
			anfang = anfang.naechster;
		}

		return opfer;
	}

	// Einfacher Fall: Anf�gen am Ende der Liste
	public void anfuegen(final T daten)
	{
		// Neuen Link anlegen
		Link<T> neu = new Link<T>(daten, null);

		// Wenn die Liste leer ist, m�ssen anfang und ende gesetzt werden
		if (istLeer())
		{
			// Neuen Link als anfang der Liste
			anfang = ende = neu;
		}
		else
		{
			// Anf�gen des Elements an das bisherige ende
			ende = ende.naechster = neu;
		}
	}

	// EINF�GEN AN EINER BESTIMMTEN STELLE
	// Der Programmcode ist so gestaltet, dass er fehlerhafte Eingaben
	// (z.B. eine negative oder zu hohe Position) elegant verarbeitet
	// ohne abzust�rzen.
	public void einfuegen(final T daten, int position)
	{
		// Wenn die Liste leer oder die Position 0 ist, entspricht dies
		// einem Einf�gen am Anfang
		if (istLeer() || (position <= 0))
		{
			einfuegen(daten);

			return;
		}

		// VORG�NGER ZUR POSITION FINDEN
		// Dessen Vorg�nger muss es geben: lediglich bei einer leeren
		// Liste oder f�r position==0 gibt es keinen. Genau diese F�lle
		// wurden aber oben bereits behandelt! Wird eine zu hohe position
		// �bergeben, wird automatisch das letzte Element zum Vorg�nger.
		Link<T> vorgaenger = anfang;

		while ((--position > 0) && (vorgaenger.naechster != null))
			vorgaenger = vorgaenger.naechster;

		// Neues Element erzeugen
		vorgaenger.naechster = new Link<T>(daten, vorgaenger.naechster);

		// Beim Einf�gen als letztes Element muss auch ende gesetzt werden
		if (vorgaenger == ende)
			ende = vorgaenger.naechster;
	}

	public T entfernen(int position)
	{
		// Wenn die Liste leer oder die position < 0 ist, wird kein Element
		// entfernt
		if (istLeer() || (position < 0))
			return null;

		// Wenn die position 0 ist, wird am Anfang der Liste gel�scht
		if (position == 0)
			return entfernen();

		// VORG�NGER ZUR POSITION FINDEN
		// Bei einer leeren Liste oder f�r position==0 gibt es keinen Vorg�nger;
		// genau diese F�lle wurden oben bereits behandelt. Es gibt aber auch
		// keinen Vorg�ner, wenn position zu gro� ist! In diesem Fall wird das
		// letzte Element NICHT Vorg�nger, damit nur tats�chlich existierende
		// Elemente aus der Liste entfernt werden.
		Link<T> vorgaenger = anfang;

		while ((--position > 0) && (vorgaenger != null))
			vorgaenger = vorgaenger.naechster;

		// Gibt es ein Element zum l�schen?
		if ((vorgaenger == null) || (vorgaenger.naechster == null))
			return null;

		final T opfer = vorgaenger.naechster.daten;

		// Element l�schen und ggf. ende anpassen beim L�schen des letzten
		// Listen-Elements
		if ((vorgaenger.naechster = vorgaenger.naechster.naechster) == null)
			ende = vorgaenger;

		return opfer;
	}

	// Liefert die Position eines bestimmten Elements oder -1 zur�ck.
	// Existiert ein Element mehrfach, wird die Position des ersten Vorkommens
	// zur�ckgegeben.
	public int suchen(final T daten)
	{
		// Liste leer?
		if (istLeer())
			return -1;

		Link<T> zeiger = anfang;
		int position = 0;

		// Abfrage auf Gleichheit ist m�glich mit equals (Operation von der Klasse Object)
		while ((zeiger != null) && !zeiger.daten.equals(daten))
		{
			position++;
			zeiger = zeiger.naechster;
		}

		return (zeiger == null) ? -1 : position;
	}

	public ListeIterator<T> iterator()
	{
		return new ListeIterator<T>(anfang, ende);
	}

	// Pr�fen, ob Liste leer ist
	public boolean istLeer()
	{
		return (anfang==null);
	}

	public void verketten(Liste<T> zweiteListe)
	{
		assert(zweiteListe != null);
		this.ende.naechster=zweiteListe.anfang;
	}

	public int entferneWerte(final T opfer)
	{
		int anzGeloeschte = 0;
		if(this.anfang!=null && opfer!=null)
		{
			Link<T>tempElement =  anfang;
			Link<T>vorherigesElement = null;
			//Durchgehen der Liste
			while(tempElement!=null)
			{
				//löschen von gleichem Element
				if(tempElement.daten.equals(opfer))
				{
					//Wenn es sich bei dem zu löschenden Element um das erste Element der Liste handelt
					if(vorherigesElement==null)
					{
						this.anfang=tempElement.naechster;
						System.out.println("Lösche Erstes");
					}

					//Wenn es sich bei dem zu löschenden Element um das letzte Element der Liste handelt
					else if(tempElement.naechster==null)
					{
						vorherigesElement.naechster=null;
						this.ende=vorherigesElement;
						System.out.println("Lösche letztes");
					}
					//Wenn es sich bei dem zu löschenden Element weder um das letzte noch um das erste Element der Liste handelt
					else
					{
						//Löschen des Elements
						vorherigesElement.naechster=tempElement.naechster;
						System.out.println("Lösche: "+tempElement+" Nächses: "+tempElement.naechster);
					}
					anzGeloeschte++;
				}
				else
				{
					vorherigesElement = tempElement;
				}
				tempElement=tempElement.naechster;
				System.out.println("\n\nNeus Temp El: "+tempElement);
			}
		}
		return anzGeloeschte;
	}
}