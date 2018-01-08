import java.util.Scanner;

public class patt5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("enter a number");
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int counter =1;
		for(int i = 1; i<=n; i++)
		{
			counter = i;
			for(int j =n-i;j>=1;j--)
			{
				System.out.print("\t");
			}
			for(int k=1;k<=2*i-1;k++)
			{
				System.out.print(counter+"\t");
				if(k>=i)
				{
					counter--;
				}
				else
				{
					counter++;
				}
			}
			
			System.out.println();
			
}
}
}
