package Praktikum_8;

public class QuickSort
{
	public static void quicksort(int[] array, final int links, final int rechts)
	{
		int li=links;
		int re=rechts;
		int iPiv=array[links+(rechts-links)/2];
		int iTemp;

		//Es wird solange getauscht bis li und re aneinander vorbei laufen
		while(li<=re)
		{
			for(;array[li]<iPiv; li++);
			for(;array[re]>iPiv; re--);
			
			//Es wird nur getauscht wenn re und li noch nicht aneinander vorbei gelaufen sind
			if(li<=re)
			{
				iTemp=array[re];
				array[re]=array[li];
				array[li]=iTemp;

				li++;
				re--;
			}

		}

		if(links < re) quicksort(array,links,re);
		if(rechts > li) quicksort(array,li,rechts);

	}
}