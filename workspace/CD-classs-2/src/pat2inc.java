import java.util.Scanner;

public class pat2inc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				System.out.println("enter a number");
				Scanner scn = new Scanner(System.in);
				int n = scn.nextInt();
				int c = 1;
				int t = 1;
				int b =0;
				int a = 1;
				for(int i =1;i<=n;i++)
				{
					for(int j =1;j<=i;j++)
					{
						System.out.print(b+"\t");
						//System.out.println(b);
						t = a + b;
						b = a;
						a = t;
					}
					System.out.println();
				}
	}

}
