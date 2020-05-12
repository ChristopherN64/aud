package Praktikum_4;

public class Fibonacci {
    public static void main(String[] args) {
        StopUhr.start();
        System.out.println(fibIt(50));
        StopUhr.stop();
        System.out.println(StopUhr.getDuration()/1000+"microSek");
        StopUhr.start();
        System.out.println(fibRek(50));
        StopUhr.stop();
        System.out.println(StopUhr.getDuration()/1000000+"MilliSeks");
    }

    public static int fibRek(int n)
    {
        if(n==0) return 0;
        else if(n==1) return 1;
        else {
            return fibRek(n-1)+fibRek(n-2);
        }
    }

    public static int fibIt(int n)
    {
        int iNm1=1,iNm2=0,iAktuell=0;
        for(int il=0;il<n-1;il++)
        {
            iAktuell=iNm1+iNm2;
            iNm2=iNm1;
            iNm1=iAktuell;
        }
        return iAktuell;
    }



}
