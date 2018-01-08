import java.util.Scanner;

public class CheckPrime {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter the number ");
		int n = scn.nextInt();

		int counter = 2;
		while (counter < n) {
			if (n % counter == 0) {
				System.out.println("Not prime");
				return;
			}

			counter = counter + 1;
		}

		System.out.println("Prime");
		
	}
	

}
