import java.util.Scanner;

public class arr2dpatt {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = takeinput();
		display(arr);
	}

	public static int[][] takeinput() {
		int[][] rv = null;
		System.out.println("enter rows");
		int rows = scn.nextInt();
		rv = new int[rows][];

		for (int i = 0; i < rows; i++) {
			System.out.println("enter coloums");
			int cols = scn.nextInt();
			rv[i] = new int[cols];
		}
		for (int i = 0; i < rv.length; i++) {
			for (int j = 0; j < rv[i].length; j++) {
				rv[i][j] = scn.nextInt();
			}
		}

		return rv;
		/*int sum = 0;
		int a = nodes.size() - 1;
		for (int k = stacks - 1; k >= 0; k--) {
			if (k > nodes.get(a)) {
				sum = sum + (arr[k][0] - arr[nodes.get(a)][0]) * arr[k][1];
			} else {
				a--;
			}
		}
		System.out.println(sum);*/
	}

	public static void display(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.println(arr[i][j]);
			}
		}
	}
}