package Praktikum_4;

public class Aufgaben {
    public static void main(String[] args) {
        //System.out.println(rev1(5678));
        UlamRek(3);
    }

    public static int rev1(int n)
    {
        while (n>9)
        {
            System.out.println(n%10);
            n=n/10;
        }
        return n;
    }

    public static int rev2(int n)
    {
        int logn,zehnHochLogn;
        int iRet=0;
        while(n>9)
        {
            logn=(int)Math.log10(n);
            zehnHochLogn=(int) Math.pow(10,logn);
            iRet+=(n%10)*zehnHochLogn;
        }
        return iRet;
    }

    public static int UlamRek(int n)
    {
        if((n%2)==0 && n>1)
        {
            System.out.println("Ulam("+n+"/2)");
            return UlamRek(n/2);
        }
        else if((n%2)==1 && n>1)
        {
            System.out.println("Ulam(3*"+n+"+1)");
            return UlamRek(3*n+1);
        }
        else return 1;
    }

    public static void UlamIt(int n)
    {
        while (n>1)
        {
            if((n%2)==0 && n>1)
            {
                System.out.println("Ulam("+n+"/2)");
                n=n/2;
            }
            else if((n%2)==1 && n>1)
            {
                System.out.println("Ulam(3*"+n+"+1)");
                n=(3*n+1);
            }
        }
    }


}
