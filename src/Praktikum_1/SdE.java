package Praktikum_1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.math.*;

public class SdE {

    public static void main(String args[])
    {
        int n = 10000000;
        int iCount=0;
        int[] a = new int[n];
        for(int il=0;il<n-2;il++)
        {
            a[il]=il+2;
        }

        //Sieb-Algorithmus
        for(int i=0; (a[i]*a[i])<=n;i++) {
               // System.out.println("Durchlauf: "+i+"  Wert: "+a[i]);
                for (int il = i + 1; a[i]!=0  &&  il < a.length; il++) {
                    if (a[il]!=0 && a[il] % a[i] == 0) {
                        //System.out.println("remove in dl"+i+"  Zahl: " +a[il]);
                        a[il]=0;
                    }
                }
            }

        for(int il=0;il<a.length;il++)
        {
            if(a[il]!=0) {
                System.out.print(a[il] + "|");
            }
        }



        /*
        for(int i=0; (l.get(i)*l.get(i))<=n;i++)
        {

           // System.out.println(l);
            for(int il=i+1;il<l.size();il++)
            {
                if(l.get(il)%l.get(i) == 0)
                {
                   // System.out.println("remove "+l.get(il));
                    l.remove(il);
                }

            }
        }
      //  System.out.println(l);


         */
    }



}
