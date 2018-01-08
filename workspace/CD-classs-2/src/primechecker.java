import java.util.Scanner;

public class primechecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("enter a number");
		Scanner Scn = new Scanner(System.in);
		int n = Scn.nextInt();
		int flag = 0;
		for (int j = 2; j <= n; j++) {
			flag = 0;
			for (int i = 2; i < j; i++) {
				if (j % i == 0) {
					flag = 1;
					break;
				}

			}
			if (flag == 0) {
				System.out.println(j + " is prime number");
			}
		}

	}
}
