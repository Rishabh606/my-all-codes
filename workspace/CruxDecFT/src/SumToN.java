import java.util.Scanner;

public class SumToN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Please enter a number ");
		int n = scn.nextInt();
		
		int counter = 1, sum = 0;
		
		while(counter <= n){
			sum = sum + counter;
			counter = counter + 1;
		}
		
		System.out.println("Sum = " + sum);
	}

}
