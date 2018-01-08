import java.util.Scanner;

public class binaryconv {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("enter a number");
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int rev =0;
		int c =1;
		int rem=0;
		while(n!=0)
		{
			rem = n%2;
			rev = rev+ c*rem;
			c = c*10;
			n = n/2;
		}
		System.out.println(rev);
	}

}
