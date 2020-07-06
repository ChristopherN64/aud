package Praktikum_13;

public class Graph
{
	private static double[][] matrix1 =
	{
		{0.0, 5.0, 0.0, 0.0, 0.0, 0.0},
		{5.0, 0.0, 6.0, 5.0, 0.0, 0.0},
		{0.0, 6.0, 0.0, 5.0, 0.0, 0.0},
		{0.0, 5.0, 5.0, 0.0, 0.0, 0.0},
		{0.0, 0.0, 0.0, 0.0, 5.0, 0.0},
		{0.0, 0.0, 0.0, 0.0, 0.0, 5.0},
	};

	private static double[][] matrix2 =
	{
		{0.0, 5.0, 0.0, 0.0, 0.0, 0.0},
		{0.0, 0.0, 5.0, 5.0, 0.0, 0.0},
		{0.0, 5.0, 0.0, 5.0, 0.0, 0.0},
		{0.0, 5.0, 5.0, 0.0, 0.0, 0.0},
		{0.0, 0.0, 0.0, 0.0, 5.0, 0.0},
		{0.0, 0.0, 0.0, 0.0, 0.0, 5.0},
	};

	private static boolean isSymmetric(final double[][] matrix)
	{
		assert(matrix!=null);
		assert(matrix[0]!=null);
		assert(matrix.length==matrix[0].length);

		for(int il=0;il<matrix.length;il++)
		{
			for(int il2 = 0;il2 < (il+1/2)+1;il2++)
			{
				System.out.println("X: "+il+" Y: "+il2);
				if(matrix[il][il2]!=matrix[il2][il])
				{
					System.out.println("Nicht Symetisch!");
					return false;
				}
			}
		}
		return true;
	}

	private static boolean isTriviallyWeighted(final double[][] matrix)
	{
		assert(matrix!=null);
		assert(matrix[0]!=null);
		assert(matrix.length==matrix[0].length);

		double dGewicht=0;
		for(int il=0; il<matrix.length;il++)
		{
			for(int il2=0;il2<matrix[0].length;il2++)
			{
				//Wenn das Vergleichsgewicht noch nicht gesetzt ist
				if(dGewicht==0 && matrix[il][il2]!=0)
				{
					dGewicht=matrix[il][il2];
					System.out.println("Gewicht: "+dGewicht);
				}
				//aktuelles kantengewicht mit vergleichsgewicht vergleichen
				if(matrix[il][il2]!=0 && matrix[il][il2] != dGewicht)
				{
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args)
	{
		System.out.println("isSymmetric: " + isSymmetric(matrix1) + ", " + isSymmetric(matrix2));
		System.out.println("isTriviallyWeighted: " + isTriviallyWeighted(matrix1) + ", " + isTriviallyWeighted(matrix2));
	}
}