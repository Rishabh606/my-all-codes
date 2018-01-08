import java.util.Scanner;

public class patt3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("enter a number");
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int row = 1;
		int space = 2*row;
		int col =1;
		int a = 1;
		for(int i = 1; i<=n; i++)
		{
			
			for(int k=(n+1)/2 -row + 1;k>=1;k--)
			{
				System.out.print("*\t");
			}
			for(int j = 1;j<=2*row-1;j++)
			{
				System.out.print("\t");
			}
			for(int k=(n+1)/2 -row + 1;k>=1;k--)
			{
				System.out.print("*\t");
			}
			System.out.println();
			if(i>n/2)
			{
				row--;
			}
			else
			{
				row++;
			}
}
	}

}
