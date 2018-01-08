import java.util.Scanner;

public class A2Q11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();

		int row = 1, numS = n / 2, numA = 1;

		while (row <= n) {
			int col = 1;

			while (col <= numS) {
				System.out.print("\t");
				col++;
			}

			col = 1;
			while (col <= numA) {
				System.out.print("*\t");
				col++;
			}

			if (row <= n / 2) {
				numS--;
				numA += 2;
			} else {
				numS++;
				numA -= 2;
			}

			System.out.println();
			row++;
		}
	}

}
