import java.util.Arrays;
import java.util.Scanner;

public class contest2hackerblocks {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// germanlotto();
		// birthdayparadox();
		/*
		 * int t = scn.nextInt(); for(int i = 0;i < t;i++){ xoring(); }
		 */
		// matrixsearcher();
		// searcher();
		// int t = scn.nextInt(); for(int i = 0;i < t;i++){ ats(); }
		// febH();
		// febq();
		int t = scn.nextInt();
		for (int i = 0; i < t; i++) {
			fibsum();
		}
	}

	public static long[] strgf = new long[1000000];

	private static void febq() {
		// TODO Auto-generated method stub
		Arrays.fill(strgf, -1);
		strgf[0] = 0;
		strgf[1] = 1;
		int n = scn.nextInt();
		int q = scn.nextInt();
		int[] arr = takeinput(n);
		int[] query = takeinput(q);
		long p = (long) Math.pow(10, 9) + 7;
		for (int i : query) {
			long sum = 0;
			for (int j = 1; j <= i; j++) {
				if (strgf[j] != -1) {
					sum += strgf[j];
					sum = sum % p;
				} else {
					sum += febU(i);
					sum = sum % p;
				}
			}
			System.out.println(sum % p);
		}
	}

	private static void fibsum() {
		int n = scn.nextInt();
		int m = scn.nextInt();
		long[][] t = { { 0, 1 }, { 1, 1 } };
		long[][] arr = new long[1][2];
		arr[0][0] = 0;
		arr[0][1] = 1;
		
		long sum = 0;
		long p = (long) Math.pow(10, 9) + 7;
		long[][] temp = pow(t, n-1);
		for(int i = n; i<=m;i++){
			if(i==0){
				continue;
			}
			long[][] summer = multiply(temp,arr);
			temp = multiply(temp, t);
			sum = sum%p;
			sum+=summer[0][1]%p;
		}
	//	long[][] ans = multiply(temp, arr);
		System.out.println(sum%p); 
	}

	private static void birthdayparadox() {
		// TODO Auto-generated method stub
		double p = scn.nextDouble();
		// p <= 1-r
		// r<=1-p
		// therefore condition is r>=1-p
		double r = 1;
		double denom = 365;
		double i = 365;
		int people = 0;
		if (p == 0) {
			System.out.println(1);
			return;
		}
		while (r >= (1.0 - p)) {
			r *= ((i--) / denom);
			people++;
		}
		System.out.println(people);
	}

	private static void germanlotto() {
		// TODO Auto-generated method stub
		int n = scn.nextInt();
		int[] arr = takeinput(n);
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					for (int m = k + 1; m < n; m++) {
						for (int p = m + 1; p < n; p++) {
							for (int q = p + 1; q < n; q++) {
								System.out.println(arr[i] + " " + arr[j] + " " + arr[k] + " " + arr[m] + " " + arr[p]
										+ " " + arr[q]);
							}
						}
					}
				}
			}
		}
	}

	public static int[] takeinput(int n) {
		int[] rv = null;
		// long n = scn.nextInt();
		rv = new int[n];
		for (int i = 0; i < n; i++) {
			rv[i] = scn.nextInt();
		}
		return rv;
	}

	public static void xoring() {
		int L = scn.nextInt();
		int R = scn.nextInt();
		int max = Integer.MIN_VALUE;
		for (int i = L; i <= R; i++) {
			for (int j = i + 1; j <= R; j++) {
				max = Math.max(max, (i ^ j));
			}
		}
		System.out.println(max);
	}

	public static void searcher() {
		int N = scn.nextInt();
		int M = scn.nextInt();
		int[] arr = takeinput(N * M);
		int key = scn.nextInt();
		Arrays.sort(arr);
		int rv = Arrays.binarySearch(arr, key);
		if (rv > -1) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

	public static boolean binarysearch(int[][] arr, int key, int si, int ei, int m, int n) {
		if (si > ei) {
			return false;
		}
		int mid = (si + ei) / 2;
		int mr = mid / m;
		int mc = mid % m;
		if (si == ei && key != arr[mr][mc]) {
			return false;
		}
		boolean rv = false;
		if (arr[mr][mc] == key) {
			return true;
		} else if (arr[mr][mc] > key) {
			rv = binarysearch(arr, key, si, mid, m, n);
		} else if (arr[mr][mc] < key) {
			rv = binarysearch(arr, key, mid + 1, ei, m, n);
		}
		return rv;
	}

	public static void matrixsearcher() {
		int N = scn.nextInt();
		int M = scn.nextInt();
		int[][] arr = takeinput(N, M);
		int key = scn.nextInt();
		boolean rv = binarysearch(arr, key, 0, N * M - 1, M, N);
		if (rv) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

	public static int[][] takeinput(int rows, int cols) {
		int[][] rv = null;
		rv = new int[rows][cols];
		for (int i = 0; i < rv.length; i++) {
			for (int j = 0; j < rv[i].length; j++) {
				rv[i][j] = scn.nextInt();
			}
		}

		return rv;
	}

	public static void seive() {
		int n = scn.nextInt();
		int[] arr = new int[n + 1];
		Arrays.fill(arr, 1);
		int count = 0;
		for (int i = 2; i <= n; i = i + 2) {
			count++;
			arr[i] = 0;
		}
		for (int i = 3; i <= Math.min(20, n); i += 2) {
			if (arr[i] != 0) {
				count++;
				for (int j = i * i; j <= n; j += i) {
					arr[i] = 0;
					count++;
				}
			}
		}
		System.out.println(count);
	}

	public static void incexc() {
		long n = scn.nextLong();
		long sum = 0;
		long[] arr = { 2, 3, 5, 7, 11, 13, 17, 19 };
		for (int i = 1; i < ((1 << 8) - 1); i++) {
			int bits = countbits(i);
			int mask = i;
			int pos = 0;
			long temp = 1;
			while (mask > 0) {
				if ((mask & 1) != 0) {
					temp *= arr[pos];
				}
				pos++;
				mask = mask >> 1;
			}
			if ((bits & 1) != 0) {
				sum += n / temp;
			} else {
				sum -= n / temp;
			}
		}
		System.out.println(sum);
	}

	private static int countbits(int i) {
		// TODO Auto-generated method stub
		int count = 0;
		while (i > 0) {
			if ((i & 1) != 0) {
				count++;
			}
			i = i >> 1;
		}
		return count;
	}

	private static void ats() {
		String s1 = scn.next();
		String s2 = scn.next();
		if (s1.length() != s2.length()) {
			System.out.println("NO");
			return;
		}
		if (s1.equals(s2)) {
			System.out.println("YES");
			return;
		}
		if ((s1.length() & 1) != 0) {
			System.out.println("NO");
			return;
		}
		if (aretheysame(s1, s2)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

	private static boolean aretheysame(String s1, String s2) {

		if (s1.length() != s2.length()) {
			return false;
		}
		if (s1.length() == 1 || s2.length() == 1) {
			if (s1.equals(s2)) {
				return true;
			}
			return false;
		}

		if (s1.equals(s2)) {
			return true;
		}
		if ((s1.length() & 1) != 0 && (s1.length()) != 1) {
			return false;
		}
		// TODO Auto-generated method stub
		String s11 = s1.substring(0, s1.length() / 2);
		String s12 = s1.substring(s1.length() / 2);

		String s21 = s2.substring(0, s2.length() / 2);
		String s22 = s2.substring(s2.length() / 2);
		boolean rv = false;
		// if(s11.equals(s21)&& s12.equals(s22)){
		// System.out.println("YES");
		boolean rv1 = aretheysame(s11, s21);
		boolean rv2 = aretheysame(s12, s22);
		rv = rv1 & rv2;
		if (rv) {
			return rv;
		}
		// }
		// if(s11.equals(s22)&& s12.equals(s21)){
		// System.out.println("YES");
		boolean rv3 = aretheysame(s11, s22);
		boolean rv4 = aretheysame(s12, s21);
		rv = rv3 & rv4;
		return rv;
		// }
		// System.out.println("NO");
	}

	private static void febH() {
		int n = scn.nextInt();
		long[][] t = { { 0, 1 }, { 1, 1 } };
		long[][] arr = new long[1][2];
		arr[0][0] = 0;
		arr[0][1] = 1;
		if (n == 0) {
			System.out.println(arr[0]);
			return;
		}
		if (n == 1) {
			System.out.println(arr[1]);
			return;
		}
		long[][] ans = multiply(pow(t, n - 1), arr);
		System.out.println(ans[0][1]);
	}

	private static long febU(int n) {
		long[][] t = { { 0, 1 }, { 1, 1 } };
		long[][] arr = new long[1][2];
		arr[0][0] = 0;
		arr[0][1] = 1;
		if (n == 0) {
			return arr[0][0];
		}
		if (n == 1) {
			return arr[0][1];
		}
		long[][] ans = multiply(pow(t, n - 1), arr);
		strgf[n - 1] = ans[0][0];
		strgf[n] = ans[0][1];
		return ans[0][1];
	}

	private static long[] multiplyx(long[][] t, long[] arr) {
		// TODO Auto-generated method stub
		long[] ans = new long[2];
		for (int i = 0; i < t.length; i++) {
			ans[i] = t[i][0] * arr[0] + t[i][1] * arr[1];
		}
		return ans;
	}

	private static long[][] multiply(long[][] arr, long[][] t) {
		// TODO Auto-generated method stub
		long[][] ans = new long[t.length][t[0].length];
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[0].length; j++) {
				for (int k = 0; k < t[0].length; k++) {
					ans[i][j] = ans[i][j]%1000000007;
					ans[i][j] += (t[i][k]%1000000007 * arr[k][j]%1000000007)%1000000007;
				}
			}
		}
		return ans;
	}

	private static long[][] pow(long[][] arr, int n) {
		// TODO Auto-generated method stub
		if(n<=0){
			long[][] temp = { { 1, 0 }, { 0, 1 } };
			return temp;
		}
		if (n == 1) {
			return arr;
		}
		if ((n & 1) == 0) {
			long[][] a = pow(arr, n / 2);
			return multiply(a, a);
		} else {
			long[][] a = pow(arr, n / 2);
			return multiply(multiply(a, a), arr);
		}
	}
}
