package Praktikum_11.Aufgabe6;

import java.util.Random;

public class HashTableTest
{
	private static String[][] Profs =
	{
		{"Achilles", "1"},
		{"Balzert", "2"},
		{"Böckmann", "3"},
		{"Cleven", "4"},
		{"Ecke-Schüth", "5"},
		{"Engels", "6"},
		{"Eren", "7"},
		{"Haake", "8"},
		{"Haas", "9"},
		{"Hennekemper", "10"},
		{"Hesseler", "11"},
		{"Koll", "12"},
		{"Kraegeloh", "13"},
		{"Lenze", "14"},
		{"Lipinski", "15"},
		{"Meyer", "16"},
		{"Patzelt", "17"},
		{"Peters", "18"},
		{"Rietmann", "19"},
		{"Röhrig", "20"},
		{"Sachweh", "21"},
		{"Schaefer-Richter", "22"},
		{"Schmidtmann", "23"},
		{"Schoenberg", "24"},
		{"Stark", "25"},
		{"Swik", "26"},
		{"Wilmes", "27"},
		{"Wolff", "28"},
		{"Zeppenfeld", "29"}
	};

	public static void main(String[] args)
	{
		HashTable h = new HashTable(10);

		System.out.println("Hashtablle mit " + Profs.length + " Objekten anlegen:");

		// Professorendaten in Hashtabelle eintragen
		for (int a = 0; a < Profs.length; a++)
			h.insert(new Professor(Profs[a][0], Integer.parseInt(Profs[a][1])));

		// Gespeicherte Professorendaten nacheinander aus der Tabelle
		// auslesen und den jeweils zugehörigen Namen ausgeben
		System.out.println("\nHash-Tabelle:");
		for (int a = 0; a < h.getSize(); a++)
		{
			final Professor p = (Professor)h.getEntry(a);
			if (p != null)
				System.out.println(a + " " + p.getName());
		}

		System.out.println("\nZuordnung per Roundtrip über den Hashwert testen:");
		for (int a = 0; a < h.getSize(); a++)
			if ((Professor)h.getEntry(a) != null)
				System.out.println("" + a + " <---> " + h.findePosition(h.getEntry(a)));
	}
}
