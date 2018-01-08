package contest;

import java.util.ArrayList;
import java.util.Scanner;

public class WeekOfCode30 {
	public static Scanner scn = new Scanner(System.in);
	static int very_min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// candyfiller();
		/*
		 * int n = scn.nextInt(); // no_of_minfun(n); long t1=0,t2=0;
		 * t1=System.nanoTime(); password_gener(n, 0, 2, "");
		 * t2=System.nanoTime(); System.out.println(t2-t1);
		 */
		/*int n = scn.nextInt();
		char[] arr = {'b', 'c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','z'};
		password_gener2(n, 0, 2, "",arr);*/
		poles();

		// RMQ();

	}

	public static int[] takeinput(int n) {
		int[] rv = null;

		rv = new int[n];

		for (int i = 0; i < n; i++) {
			rv[i] = scn.nextInt();
		}
		return rv;
	}

	public static void candyfiller() {
		int n = scn.nextInt();
		int t = scn.nextInt();
		int[] arr = takeinput(t);
		int temp = n;
		int sum = 0;
		for (int i = 1; i < t; i++) {
			temp = temp - arr[i - 1];
			if (temp < 5) {
				if (temp < 0) {
					temp = 0;
				}
				sum = sum + n - temp;
				temp = n;
			}
		}
		System.out.println(sum);
	}

	public static void no_of_minfun(int n) {
		if (n == 2) {
			System.out.print("min(int, int)");
			return;
		}
		System.out.print("min(int,");
		no_of_minfun(n - 1);
		System.out.print(")");
	}

	public static void password_gener(int n, int i, int flag, String osf) {

		if (i >= n) {
			System.out.println(osf);
			return;
		}
		if (flag != 1) {
			password_gener(n, i + 1, 1, osf + "a");
			password_gener(n, i + 1, 1, osf + "e");
			password_gener(n, i + 1, 1, osf + "i");
			password_gener(n, i + 1, 1, osf + "o");
			password_gener(n, i + 1, 1, osf + "u");
		}
		if (flag != 0) {
			password_gener(n, i + 1, 0, osf + "b");
			password_gener(n, i + 1, 0, osf + "c");
			password_gener(n, i + 1, 0, osf + "d");
			password_gener(n, i + 1, 0, osf + "f");
			password_gener(n, i + 1, 0, osf + "g");
			password_gener(n, i + 1, 0, osf + "h");
			password_gener(n, i + 1, 0, osf + "j");
			password_gener(n, i + 1, 0, osf + "k");
			password_gener(n, i + 1, 0, osf + "l");
			password_gener(n, i + 1, 0, osf + "m");
			password_gener(n, i + 1, 0, osf + "n");
			password_gener(n, i + 1, 0, osf + "p");
			password_gener(n, i + 1, 0, osf + "q");
			password_gener(n, i + 1, 0, osf + "r");
			password_gener(n, i + 1, 0, osf + "s");
			password_gener(n, i + 1, 0, osf + "t");
			password_gener(n, i + 1, 0, osf + "v");
			password_gener(n, i + 1, 0, osf + "w");
			password_gener(n, i + 1, 0, osf + "x");
			password_gener(n, i + 1, 0, osf + "z");
		}
	}
	public static void password_gener2(int n, int i, int flag, String osf,char[] arr) {

		if (i >= n) {
			System.out.println(osf);
			return;
		}
		if (flag != 1) {
			password_gener(n, i + 1, 1, osf + "a");
			password_gener(n, i + 1, 1, osf + "e");
			password_gener(n, i + 1, 1, osf + "i");
			password_gener(n, i + 1, 1, osf + "o");
			password_gener(n, i + 1, 1, osf + "u");
		}
		if (flag != 0) {
			password_gener(n, i + 1, 0, osf + "b");
			password_gener(n, i + 1, 0, osf + "c");
			password_gener(n, i + 1, 0, osf + "d");
			password_gener(n, i + 1, 0, osf + "f");
			password_gener(n, i + 1, 0, osf + "g");
			password_gener(n, i + 1, 0, osf + "h");
			password_gener(n, i + 1, 0, osf + "j");
			password_gener(n, i + 1, 0, osf + "k");
			password_gener(n, i + 1, 0, osf + "l");
			password_gener(n, i + 1, 0, osf + "m");
			password_gener(n, i + 1, 0, osf + "n");
			password_gener(n, i + 1, 0, osf + "p");
			password_gener(n, i + 1, 0, osf + "q");
			password_gener(n, i + 1, 0, osf + "r");
			password_gener(n, i + 1, 0, osf + "s");
			password_gener(n, i + 1, 0, osf + "t");
			password_gener(n, i + 1, 0, osf + "v");
			password_gener(n, i + 1, 0, osf + "w");
			password_gener(n, i + 1, 0, osf + "x");
			password_gener(n, i + 1, 0, osf + "z");
		}
	}
	public static int[][] takeinput2d(int rows) {
		int[][] rv = null;
		// int rows = scn.nextInt();
		rv = new int[rows][2];

		for (int i = 0; i < rv.length; i++) {
			for (int j = 0; j < rv[i].length; j++) {
				rv[i][j] = scn.nextInt();
			}
		}

		return rv;
	}

	public static void quicksort(int[][] arr, int lo, int hi) {
		int left = lo, right = hi, pivot = (right + left) / 2;
		if (lo >= hi) {
			return;
		}
		while (left <= right) {
			while (arr[left][0] < arr[pivot][0]) {
				left++;
			}
			while (arr[right][0] > arr[pivot][0]) {
				right--;
			}

			if (left <= right) {
				int t = arr[left][0];
				int m = arr[left][1];
				arr[left][0] = arr[right][0];
				arr[left][1] = arr[right][1];
				arr[right][0] = t;
				arr[right][1] = m;
				left++;
				right--;
			}
		}
		quicksort(arr, lo, right);
		quicksort(arr, left, hi);
	}

	public static void display(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void poles() {
		int n = scn.nextInt();
		int stacks = scn.nextInt();
		int[][] arr = takeinput2d(n);
		quicksort(arr, 0, arr.length - 1);
		ArrayList<Integer> nodes = new ArrayList<Integer>();
		nodes.add(0);
		nodes.add(arr.length - 1);
		int i = 0;
		int counter = 0;
		int key = -1;
		int p = -1;
		// int check = 0;
		int t = -1;
		int pos = -1;
		int temp_sum = 0;
	
		for (counter = 1; counter < stacks; counter++) {
			int temp1 = Integer.MAX_VALUE;
			i = 0;
			while (i < nodes.size() - 1) {
				t = nodepos(arr, nodes.get(i), nodes.get(i + 1));
				if (t > 0) {
					p = i;
					nodes.add(p + 1, t);
					nodes.remove(nodes.size()-1);
					temp_sum = sumfinder(nodes, arr, n);
					nodes.remove(p + 1);
					nodes.add(arr.length - 1);
					if (temp1 > temp_sum) {
						temp1 = temp_sum;
						key = t;
						pos = i;
					}
				}
				i++;
			}
			nodes.add(pos + 1, key);
		}
		nodes.remove(nodes.size() - 1);
		int sum = sumfinder(nodes, arr, n);
		
		System.out.println(sum);
	}

	public static int sumfinder(ArrayList<Integer> nodes, int[][] arr, int n) {
		int sum = 0;
		int a = nodes.size() - 1;
		for (int k = n - 1; k >= 0; k--) {
			if (k > nodes.get(a)) {
				sum = sum + (arr[k][0] - arr[nodes.get(a)][0]) * arr[k][1];
			} else {
				a--;
			}
		}
		return sum;
	}

	public static int nodepos(int[][] rods, int init, int end) {
		// rods is sorted
		if (end != rods.length - 1) {
			end--;
		}
		int pos = end - init;
		int[] sums = new int[end - init + 1];
		for (int i = end; i >= init; i--) {
			int temp_sum = 0;
			for (int j = i - 1; j >= init; j--) {
				temp_sum = temp_sum + (rods[j][0] - rods[init][0]) * rods[j][1];
			}
			for (int j = i + 1; j <= end; j++) {
				temp_sum = temp_sum + (rods[j][0] - rods[i][0]) * rods[j][1];
			}
			sums[i - init] = temp_sum;
		}
		int p = -1;
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < sums.length; i++) {
			if (sums[i] < min) {
				min = sums[i];
				p = i;
			}
			if (sums[i] == min) {
				if (p > i) {
					min = sums[i];
					p = i;
				}
			}
		}
		very_min = min;
		pos = p;
		return pos + init;
	}

	public static void RMQ() {
		int n = scn.nextInt();
		int q = scn.nextInt();
		int[] a = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = scn.nextInt();
		}
		for (int a0 = 0; a0 < q; a0++) {
			int left = scn.nextInt();
			int right = scn.nextInt();
			int x = scn.nextInt();
			int y = scn.nextInt();
			int count = 0;
			for (int i = left; i <= right; i++) {
				if (a[i] % x == y) {
					count++;
				}
			}
			System.out.println(count);
		}
	}
}
