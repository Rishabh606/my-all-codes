import java.util.Scanner;

public class Reverse {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter the number");
		
		int num = scn.nextInt();
		int rev = 0;
		
		while(num != 0){
			int rem = num % 10;
			rev = 10 * rev + rem;
			num = num / 10;
		}
		
		System.out.println(rev);
	}

}
