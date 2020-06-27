package Praktikum_12;

import javax.swing.*;
import java.util.*;

public class Graph
{
	private static final int KNOTENZAHL = 7;
	private static boolean[] besucht;
	private KnotenTyp[] knoten;
	private boolean[][] matrix = {
			{false, true, false, false, false, false, false},
			{false, false, true, false, false, false, false},
			{false, true, false, false, false, false, false},
			{false, false, false, false, false, false, false},
			{false, false, false, true, false, false, false},
			{false, true, true, false, false, false, false},
			{false, false, false, false, false, false, false},
		};

	public Graph()
	{
		knoten  = new KnotenTyp[KNOTENZAHL];
		knoten[0] = new KnotenTyp("A");
		knoten[1] = new KnotenTyp("B");
		knoten[2] = new KnotenTyp("C");
		knoten[3] = new KnotenTyp("D");
		knoten[4] = new KnotenTyp("E");
		knoten[5] = new KnotenTyp("F");
		knoten[6] = new KnotenTyp("G");
	}

	private boolean isKante(int k1, int k2)
	{
		//Wenn eine verbindung von k1 nach k2 oder k2 nach k1 besteht, besteht eine Kante zwischen den Knoten und es wird True returnt ansonsten False
		//System.out.printf("Prüfe: %d %d und %d %d\n",k1,k2,k2,k1);
		return  this.matrix[k1][k2] || this.matrix[k2][k1];
	}
	
	// Tiefensuche
	private void rekDfs(final int k)
	{
		//Knoten als besucht markieren
		besucht[k]=true;

		//Alle Knoten Durchgehen
		for(int il=0; il< KNOTENZAHL;il++)
		{
			//Wenn zwischen dem Betrachteten Knoten k und einem der anderen Knoten eine Verbindung besteht, wird mit diesem Knoten rekDfs rekursiv aufgerufen
			if(k!=il && isKante(k,il) && besucht[il]==false)
			{
				rekDfs(il);
			}
		}
	}

	public void zusammenhangskomponenten()
	{
		boolean zusammenhängend[];
		zusammenhängend = new boolean [KNOTENZAHL];

		//Durchgehen aller Knoten
		for(int il=0; il<KNOTENZAHL;il++)
		{
			//Wenn der betrachtete Knoten noch nicht als im Zusammenhang mit anderen markiert wurde (also noch keiner Gruppe angehört) wird er auf zusammenhänge geprüft
			if(!zusammenhängend[il])
			{
				besucht = new boolean [KNOTENZAHL];
				//Besuchen aller Knoten die vom betrachteten Knoten erreichbar sind
				rekDfs(il);

				System.out.println("Zusammenhängend:");
				//Alle knoten die vom betrachteten Knoten erreichbar sind (Die durch das besucht Array markierten Knoten) bilden eine zusammenhangskomponente und  werden als teil einer Komponente markieren
				//Diese markierten knoten werden nicht weiter geprüft
				for(int il2 =0; il2<KNOTENZAHL;il2++)
				{
					if(besucht[il2])
					{
						zusammenhängend[il2]=true;
						System.out.println(knoten[il2].getName());
					}
				}
			}
			System.out.println();
		}

	}

	public static void main(String[] args)
	{
		new Graph().zusammenhangskomponenten();
	}
}