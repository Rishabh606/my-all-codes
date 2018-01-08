import java.util.Scanner;

public class primeidentifier {

	public static void main(String[] args) {
		// TODO Auto-generated method stubSystem.out.println("enter a number");
		//System.out.println("enter a number");
		Scanner Scn = new Scanner(System.in);
		int n = Scn.nextInt();
		if(n<=1)
		{
			System.out.println("Not Prime");
		}
		int flag = 0;
			for (int i = 2; i < n; i++) {
				if (n % i == 0) {
					flag = 1;
					System.out.println("Not Prime");
					break;
				}

			}
			if (flag == 0) {
				System.out.println("Prime");
			}
		}
	}

	


