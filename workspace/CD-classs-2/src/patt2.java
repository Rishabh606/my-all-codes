import java.util.Scanner;

public class patt2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("enter a number");
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int i =0;
		int counter = 1;
		for(i = 1; i<=n;i=i+2)
		{
			for(int j = (n+1)/2-counter;j>0;j--)
			{
				System.out.print("	");
			}
			for(int p = 1; p<=i;p++)
			{
				System.out.print("*	");
			}
			System.out.println();
			counter++;
		}
		i = i-4;
		counter = counter-2;
		for(i = i ;i>=0;i = i-2)
		{
			for(int j = (n+1)/2 -counter;j>0;j--)
			{
				System.out.print("	");
			}
			for(int p = 1; p<=i;p++)
			{
				System.out.print("*	");
			}
			System.out.println();
			 counter--;
		}
	}

}

