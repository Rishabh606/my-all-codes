import java.util.Scanner;

public class recur1 {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int b = scn.nextInt();
		// int n = scn.nextInt();
		// integerprinter(n);
		/*
		 * int pw = power(b,n); System.out.println(pw); int fact = factorial(n);
		 * System.out.println(fact); int feb = febunaci(n);
		 * System.out.println(feb);
		 */
		// printstair(5, 1, 1);
		// printstairrev2(5, 1, 1);
		// pascal(5, 1, 1);
		int[] arr = { 3, 5, 7, 8 };
		// System.out.println(isSorted(arr));
		System.out.println(isSorted2(arr, 0));
		System.out.println(contains(arr, 7, 0));
	}

	public static void integerprinter(int n) {
		if (n == 0) {
			return;
		}
		if (n % 2 != 0)
			System.out.println(n);
		integerprinter(n - 1);
		if (n % 2 == 0)
			System.out.println(n);
	}

	public static int power(int b, int n) {
		if (n == 0)
			return 1;
		int pw = power(b, n - 1);
		return b * pw;
	}

	public static int factorial(int n) {
		if (n == 0) {
			return 1;
		}
		return n * factorial(n - 1);
	}

	public static int febunaci(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		return febunaci(n - 1) + febunaci(n - 2);
	}

	public static void printstair(int n, int r, int c) {
		if (r > n) {
			return;
		}
		if (c > r) {
			System.out.println();
			// for morew efficent uncode below lines instead of return and call;
			c = 1;
			r = r + 1;
			// printstair(n, r+1, 1);
			// return;
		}

		if (n >= r) {
			System.out.print("*\t");
			printstair(n, r, c + 1);
		}
	}

	public static void printstairrev(int n, int r, int c) {
		if (r > n) {
			return;
		}
		if (c > r) {

			// for morew efficent uncode below lines instead of return and call;
			c = 1;
			r = r + 1;
			// printstairrev(n, r + 1, 1);
			// System.out.println();
			// return;
		}
		printstairrev(n, r, c + 1);

		if (c == 1) {
			if (r != 1) {
				System.out.println();
				System.out.print("*\t");
			}
		} else {
			System.out.print("*\t");
		}
	}

	public static void printstair2(int n, int r, int c) {
		if (r > n) {
			return;
		}
		if (c > r) {
			System.out.println();
			// for morew efficent uncode below lines instead of return and call;
			/*
			 * c = 1; r = r + 1;
			 */
			printstair(n, r + 1, 1);
			return;
		}

		System.out.print("*\t");
		printstair(n, r, c + 1);

	}

	public static void printstairrev2(int n, int r, int c) {
		if (r > n) {
			return;
		}
		if (c > r) {

			// for morew efficent uncode below lines instead of return and call;
			/*
			 * c = 1; r = r + 1;
			 */
			printstairrev2(n, r + 1, 1);
			System.out.println();
			return;
		}
		printstairrev2(n, r, c + 1);
		System.out.print("*\t");
	}

	public static void pascal(int n, int r, int c, int val) {
		if (r > n) {
			return;
		}
		if (c > r) {
			System.out.println();
			// for morew efficent uncode belowlines instead of return and call;
			// c = 1;
			// r = r + 1;
			pascal(n, r + 1, 1,1);
			return;
		}

		System.out.print(val + "\t");
		val = (val*(r-c+1))/c;
		pascal(n, r, c + 1, val);

	}

	public static boolean isSorted(int[] arr) {
		if (arr.length == 1) {
			return true;
		}
		if (arr[0] < arr[1]) {
			int[] arr2 = new int[arr.length - 1];
			for (int i = 1; i < arr.length; i++) {

				arr2[i - 1] = arr[i];
			}
			return isSorted(arr2);
		} else {
			return false;
		}
	}

	public static boolean isSorted2(int[] arr, int si) {
		if (si == arr.length - 1) {
			return true;
		}
		if (arr[si] < arr[si + 1]) {
			boolean sorted = isSorted2(arr, si + 1);
			return sorted;
		} else {
			return false;
		}
	}

	public static boolean contains(int[] arr, int key, int si) {
		if (arr.length == si) {
			return false;
		}
		if (key == arr[si]) {
			return true;
		} else {
			boolean doesit = contains(arr, key, si + 1);
			return doesit;
		}
	}

}
