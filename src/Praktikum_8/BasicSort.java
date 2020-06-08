package Praktikum_8;

public class BasicSort
{
	// Selectionsort:
	// Sortiere das Teilfeld von array beginnend mit Index links bis einschlie�lich Index rechts
	public static void selectionsort(int[] array, final int links, final int rechts)
	{
		for (int i = links; i < rechts; i++)
		{
			// Kleinstes Element im unsortierten Teil finden
			int min = i;

			for (int j = i + 1; j <= rechts; j++)
				if (array[min] > array[j])
					min = j;

			// Elemente tauschen
			int temp = array[min];
			array[min] = array[i];
			array[i] = temp;
		}
	}

	// Insertionsort:
	// Sortiere das Teilfeld von array beginnend mit Index links bis einschlie�lich Index rechts
	public static void insertionsort(int[] array, final int links, final int rechts)
	{
		int iTemp;
		int iSchranke = links;		//Die Schranke ist der Letzte Index des Zielbereiches

		while((iSchranke+1)<=rechts)
		{
			iTemp = array[iSchranke+1];
			int il;
			for(il = iSchranke; il>=links && iTemp<array[il]; il--)
			{
				array[il+1] = array[il];
			}
			array[il+1]=iTemp;
			iSchranke++;
		}
	}

	// Bubblesort:
	// Sortiere das Teilfeld von array beginnend mit Index links bis einschlie�lich Index rechts
	public static void bubblesort(int[] array, final int links, final int rechts)
	{
		int iSchranke;		//Die Schranke ist der Letzte index des noch nicht Sortierten bereichs
		int iTemp;

		for(iSchranke=rechts+1;iSchranke!=links;iSchranke--)
		{
			for(int il=links; il<iSchranke-1; il++)
			{
				if(array[il]>array[il+1])
				{
					iTemp=array[il];
					array[il]=array[il+1];
					array[il+1]=iTemp;
				}
			}
		}
	}
}