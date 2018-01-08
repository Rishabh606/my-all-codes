import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class contest2_2 {

	public static Scanner scn = new Scanner(System.in);

	public static boolean flag_SE = false;

	public static void main(String[] args) {
		/*
		 * int n = scn.nextInt(); for(int i = 0 ; i<n; i++){ String str =
		 * scn.next(); TreeSet<String>sb = new TreeSet<>(); subset(str,"",sb);
		 * for(String j:sb){ System.out.println(j); } }
		 */
		// ans_simpleE_B();
		/*
		 * String s1 = scn.next(); String s2 = scn.next(); if(s1.equals(s2)){
		 * System.out.println("true"); }else{ System.out.println("False"); }
		 */
		int t = scn.nextInt();
		for (int i = 0; i < t; i++) {
			int n = scn.nextInt();
			int[] arr = takeinput(n);
			System.out.println(MaxSubArSum(arr, 0, arr.length-1));
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

	public static void subset(String str, String res, TreeSet<String> sb) {
		if (str.length() == 0) {
			sb.add(res);
			return;
		}
		char ch = str.charAt(str.length() - 1);
		String ros = str.substring(0, str.length() - 1);
		subset(ros, res, sb);
		subset(ros, ch + res, sb);
		return;
	}

	public static void ans_simpleE() {
		long n = scn.nextLong();
		long l = scn.nextLong();
		long r = scn.nextLong();
		ArrayList<Long> br = new ArrayList<>();
		br.add(n);
		main_simpleE(br, 0, l, r);
	}

	private static void main_simpleE(ArrayList<Long> br, int idx, long l, long r) {
		long num = br.get(idx);
		if (idx < br.size()) {
			br.set(idx, num / 2);
			br.add(idx + 1, num % 2);
			br.add(idx + 2, num / 2);
		}
		for (int i = 0; i < br.size(); i++) {
			if (br.get(i) == 0 || br.get(i) == 1)
				continue;
			main_simpleE(br, i, l, r);
			if (flag_SE)
				return;
		}
		if (!flag_SE) {
			long count = 0;
			for (long i = l - 1; i < r; i++) {
				if ((br.get((int) i)) == 1) {
					count++;
				}
			}
			System.out.println(count);
			flag_SE = true;
		}
		return;
	}

	public static void ans_simpleE_B() {
		long n = scn.nextLong();
		long l = scn.nextLong();
		long r = scn.nextLong();
		if (n <= 1) {
			System.out.println(n);
			return;
		}
		long[] arr = new long[2];
		arr[0] = n / 2;
		arr[1] = n % 2;
		ArrayList<Long> sol = main_simpleE_B(arr);
		long count = 0;
		for (long i = l - 1; i < r; i++) {
			if (sol.get((int) i) == 1) {
				count++;
			}
		}
		System.out.println(count);
	}

	private static ArrayList<Long> main_simpleE_B(long[] br) {
		ArrayList<Long> left = new ArrayList<>();
		ArrayList<Long> right = new ArrayList<>();
		ArrayList<Long> sol = new ArrayList<>();
		if (br[0] > 1) {
			long[] arr = new long[2];
			arr[0] = br[0] / 2;
			arr[1] = br[0] % 2;
			left = main_simpleE_B(arr);
		}
		if (br[1] > 1) {
			long[] arr = new long[2];
			arr[0] = br[1] / 2;
			arr[1] = br[1] % 2;
			right = main_simpleE_B(arr);
		}
		if (left.size() > 0) {
			for (long i : left) {
				sol.add(i);
			}
		} else {
			sol.add(br[0]);
		}
		if (right.size() > 0) {
			for (long i : right) {
				sol.add(i);
			}
		} else {
			sol.add(br[1]);
		}
		if (left.size() > 0) {
			for (long i = left.size() - 1; i >= 0; i--) {
				sol.add(left.get((int) i));
			}
		} else {
			sol.add(br[0]);
		}
		return sol;
	}

	public static long MaxSubArSum(int[] sum, int si, int ei) {
		if (si > ei) {
			return Long.MIN_VALUE;
		}
		if (si == ei) {
			return sum[si];
		}
		int mid = (si + ei) / 2;
		if(si+1==ei){
			return Math.max(sum[si], Math.max(sum[ei], sum[ei]+sum[si]));
		}
		long[] suff = new long[mid - si];
		long[] pre = new long[ei - mid + 1];
		pre[0] = sum[mid];
		suff[0] = sum[mid - 1];
		long premax = sum[mid];
		long suffmax = 0;
		suffmax = sum[mid - 1];
		for (int i = mid - 2, j = 1; i >= si; i--, j++) {
			suff[j] = sum[i] + suff[j - 1];
			suffmax = Math.max(suffmax, suff[j]);
		}
		for (int i = mid + 1; i <= ei; i++) {
			pre[i - mid] = sum[i] + pre[i - mid - 1];
			premax = Math.max(premax, pre[i-mid]);
		}
		long lhalf = MaxSubArSum(sum, si, mid - 1);
		long rhalf = MaxSubArSum(sum, mid, ei);
		return Math.max(lhalf, Math.max(rhalf, (premax + suffmax)));
	}

	private static long midmaxcal(int[] sum, int si, int ei, long[] pre, long[] suff) {
		int mid = (si + ei) / 2;
		for (int i = si; i < mid; i++) {

		}
		return 0;
	}
}
