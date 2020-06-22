package Praktikum_11.Aufgabe5;

public class binaereSuche {
    public static void main(String[] args) {
        String [] worte = {"Test","Baum","Wald","Huhn","Lampe","auf"};
        System.out.println(binaereSuche.binaereSuche(worte,"Bau"));
    }


    public static boolean binaereSuche(String[] worte, String begriff)
    {
        int iLinks,iRechts,m;
        iLinks=0;
        iRechts=worte.length;
        while(iLinks<=iRechts)
        {
            m=(iRechts+iLinks)/2;
            if(worte[m].compareTo(begriff)<0)
            {
                iLinks=m+1;
            }
            else if(worte[m].compareTo(begriff)>0)
            {
                iRechts=m-1;
            }
            else return true;
        }
        return false;
    }
}
