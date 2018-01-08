import java.util.Scanner;

public class patt4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("enter a number");
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int row = 1;
		int space = 0;
		int counter =1;
		int a = 1;
		for(int i = 1; i<=n; i++)
		{
			counter = 1;
			for(int k= 1;k<=row;k++)
			{
				System.out.print(counter+"\t");
				counter++;
			}
			if(2*n-3-space<1)
			{
				counter-=2;
				row--;
			}
			else
			{
				counter--;
			}
			for(int j = 2*n-3-space;j>=1;j--)
			{
				System.out.print("\t");
			}
			for(int k=1;k<=row;k++)
			{
				System.out.print(counter+"\t");
				counter--;
			}
			System.out.println();
				row++;
				space+=2;
}

	}

}
