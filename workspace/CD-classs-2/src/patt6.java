import java.util.Scanner;

public class patt6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("enter a number");
				Scanner scn = new Scanner(System.in);
				int n = scn.nextInt();
				int counter =1;
				int row =1;
				for(int i = 1; i<2*n; i++)
				{
					counter = row;
					for(int j =n-row;j>=1;j--)
					{
						System.out.print("\t");
					}
					for(int k=1;k<=2*row-1;k++)
					{
						System.out.print(counter+"\t");
						if(k>=row)
						{
							counter--;
						}
						else
						{
							counter++;
						}
					}
					
					System.out.println();
					if(i>=n)
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
