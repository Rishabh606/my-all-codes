import java.util.Scanner;

public class contest5_2 {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scn.nextInt();
		int k = scn.nextInt();
		int[] arr = takeinput(n);
		pair pr = OneCount(k, arr);
		int j = pr.start;
		int k2 = k;
		while (k2 > 0) {
			if (arr[j] != 1) {
				arr[j] = 1;
				k2--;
			}
			j++;
		}
		System.out.println(pr.onecount);
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	public static int[] takeinput(int n) {
		// int n = scn.nextInt();
		int[] rv = null;
		// long n = scn.nextInt();
		rv = new int[n];
		for (int i = 0; i < n; i++) {
			rv[i] = scn.nextInt();
		}
		return rv;
	}

	public static pair OneCount(int k, int[] arr) {
		pair cmpr = new pair();
		cmpr.onecount = 0;
		cmpr.start = 0;
		// we can also store location of zeroes
		for (int i = 0; i < arr.length; i++) {
			int j = i;
			int k2 = k;
			int counter = 0;
			int flag = -1;
			while (k2 > 0) {
				if (j > arr.length - 1) {
					flag = 1;
					break;
				}
				if (arr[j++] != 1) {
					k2--;
				}
				counter++;
			}
			while ((j < arr.length) && (arr[j] != 0)) {
				counter++;
				j++;
			}
			if (flag == 1)
				break;
			j = i - 1;
			if (i >= 1) {
				while ((j >= 0) && (arr[j] == 1)) {
					counter++;
					j--;
				}
			}
			if (cmpr.onecount < counter) {
				cmpr.onecount = counter;
				cmpr.start = i;
			}
		}
		return cmpr;
	}

	public static int CountOne(int[] arr, int start) {
		int count = 0;
		for (int i = start; i < arr.length; i++) {
			if (arr[i] != 1) {
				break;
			} else {
				count++;
			}
		}
		for (int i = start - 1; i >= 0; i--) {
			if (arr[i] != 1) {
				break;
			} else {
				count++;
			}
		}
		return count;
	}
}

class pair {
	int onecount = 0;
	int start = 0;
}