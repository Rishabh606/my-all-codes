import java.util.*;
public class calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
	       
        while(true){
             int flag = 0, N2 = 0, N1 = 0,N3=0;
 char ch = scn.next().charAt(0);
        if (ch == 'x'|| ch == 'X')
        {
            System.out.println(ch);
             return;
        }
          else  if(ch== '+') flag = 1;
          else if (ch =='-')flag = 1;
          else if (ch =='*')flag = 1;
          else if(ch =='%')flag = 1;
          else if(ch =='/')flag = 1;
              
          if(flag!=1)System.out.println("Invalid operation. Try again.");
          else
              {
               N1 = scn.nextInt();
               N2 = scn.nextInt();
               if(ch == '+') N3 = N2+ N1;
          else if (ch =='-')N3 =N2-N1;
          else if (ch =='*')N3 = N2*N1;
          else if(ch =='%')N3 = N2%N1;
          else if(ch =='/')N3 = N2/N1;
            System.out.println(N3);
          }
    }
	}

}
