import java.util.Scanner;

public class patt1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("enter a number");
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int c = 1;
		int t = n +1;
		int flag =1;
		int m = 1;
		for(int i = 1; i<=n;i++)
		{
			c =1;
			for(int j = 1; j<=i;j++)
			{
					System.out.print(c+"");
					c++;
			}
			c--;
			for(int p = t; p>0; p--) 
					{
						System.out.print("_");
					}
			if(i == n)
			{
				c--;
				//i--;
			}
			for(m = 1; m<=i;m++)
			{
					System.out.print(c+"");
					c--;
			}
			/*if(i == n)
			{
				//i++;
			}*/
			 System.out.println("");
			 t = t-2;
		}

	}

}
