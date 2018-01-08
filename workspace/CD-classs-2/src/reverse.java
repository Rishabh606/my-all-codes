import java.util.Scanner;

public class reverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("enter a number");
		Scanner Scn = new Scanner(System.in);
		int n = Scn.nextInt();
		int rev = 0;

		while (n != 0) {
			int rem = n % 10;
			rev = 10 * rev + rem;
			n = n / 10;
		}
		System.out.println(rev);
	}

}
