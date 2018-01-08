import java.util.Scanner;

public class febunaci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("enter a number");
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int a =1;
		int b =0;
		int t=0;
		
		for(int i=0;i<=n;i++)
		{
			System.out.println(b);
			t = a + b;
			b = a;
			a = t;
		}
		//System.out.println(b);
	}

}
