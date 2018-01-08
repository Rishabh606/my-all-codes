
import java.util.*;

public class ismirrorinv {

	public static void main(String[] args) {
	      Scanner scn = new Scanner(System.in);
	      
	      int N = scn.nextInt();
	      
	      System.out.println(inverse(N));
	   }
	    public static int tenpower(int n)
	        {
	        int retVal = 1;
	        for(int j = 0; j<n;j++)
	            {
	            retVal = retVal*10;
	        }
	        return retVal;
	    }
	   
	   public static int inverse(int num){
	      int retVal = 0,counter =1, i = 0;
	      while(num!=0)
	          {
	          i = num%10;
	          retVal = retVal + counter*tenpower(i-1);
	          num = num/10;
	          counter++;
	      }
	      return retVal;
	   }

}
