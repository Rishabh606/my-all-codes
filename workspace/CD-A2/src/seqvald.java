import java.io.*;
import java.util.*;
public class seqvald {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
        Scanner scn = new Scanner(System.in);
        int N1 = scn.nextInt();
        int Nc=0, Np = -1,p1=0,p2=0;
        for(int i = 1; i<=N1;i++)
            {
            Nc = scn.nextInt();
            if(i == 1)Nc=Np;
            if(Nc>=Np)
            {
                p1++;
                System.out.println("p1 = " + p1 + " i = "+ i);
            }
            else if (Nc<=Np)
                {
                p2++;
               System.out.println("p2 = "+ p2);
            }
            Np= Nc;
              
        }
        if(p1>1&&p2>2) System.out.println("false");
         else if((p1<=2 && p2>=2)||(p2<=2 && p1>=2))
                System.out.println("true");
                else
                System.out.println("false");
	}

}
