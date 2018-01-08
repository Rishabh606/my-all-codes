import java.util.Scanner;

public class sumoden {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("enter a number");
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int rem = 0;
		int sumodd =0 ;
		int sumeven = 0;
		int i =1;
		while(n>0)
		{
			rem = n % 10;
			if(i%2==0)
			{
				sumodd = sumodd + rem;
			}
			else
			{
				sumeven = sumeven + rem;
			}
			n = n/10;
			i++;
		}
		System.out.println(sumodd);
		System.out.println(sumeven);
	}

}
