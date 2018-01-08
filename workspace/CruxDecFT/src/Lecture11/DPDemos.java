package Lecture11;

import java.util.ArrayList;

import Lecture10.TnSDemos;

public class DPDemos {

	public static void main(String[] args) {
		int N = 16;

		/*
		 * TnSDemos.startTimer(); System.out.println(Fib(N));
		 * System.out.println(TnSDemos.endTimer());
		 * 
		 * TnSDemos.startTimer(); System.out.println(FibRS(N, new int[N + 1]));
		 * System.out.println(TnSDemos.endTimer());
		 * 
		 * TnSDemos.startTimer(); System.out.println(FibI(N));
		 * System.out.println(TnSDemos.endTimer());
		 * 
		 * TnSDemos.startTimer(); System.out.println(FibIS(N));
		 * System.out.println(TnSDemos.endTimer());
		 */

		/*
		 * TnSDemos.startTimer(); System.out.println(cbp(N, 0));
		 * System.out.println(TnSDemos.endTimer());
		 * 
		 * TnSDemos.startTimer(); System.out.println(cbpRS(N, 0, new int[N +
		 * 1])); System.out.println(TnSDemos.endTimer());
		 * 
		 * TnSDemos.startTimer(); System.out.println(cbpI(N));
		 * System.out.println(TnSDemos.endTimer());
		 * 
		 * TnSDemos.startTimer(); System.out.println(cbpIS(N));
		 * System.out.println(TnSDemos.endTimer());
		 */

		/*
		 * TnSDemos.startTimer(); System.out.println(cmp(N, N, 0, 0));
		 * System.out.println(TnSDemos.endTimer());
		 * 
		 * TnSDemos.startTimer(); System.out.println(cmpRS(N, N, 0, 0, new int[N
		 * + 1][N + 1])); System.out.println(TnSDemos.endTimer());
		 * 
		 * TnSDemos.startTimer(); System.out.println(cmpI(N, N));
		 * System.out.println(TnSDemos.endTimer());
		 * 
		 * TnSDemos.startTimer(); System.out.println(cmpIS(N, N));
		 * System.out.println(TnSDemos.endTimer());
		 */

		// int[] vals = { 18, 2, 16, 4, 5, 7, 17, 9, 15, 8, 12, 6, 14, 11, 18,
		// 2, 16, 4, 5, 2, 16, 4, 5, 7, 17, 9, 15, 8,
		// 12 };
		// int[] wts = { 16, 7, 12, 15, 4, 16, 9, 15, 10, 5, 10, 8, 16, 7, 12,
		// 15, 4, 16, 9, 9, 15, 10, 5, 10, 8, 16, 7,
		// 12, 15 };
		// int cap = 400;

		/*
		 * int[] vals = {8, 4, 6, 3, 2, 1, 9, 5}; int[] wts = {8, 4, 1, 6, 7, 3,
		 * 2, 5}; int cap = 15;
		 * 
		 * TnSDemos.startTimer(); System.out.println(ks(vals, wts, 0, cap));
		 * System.out.println(TnSDemos.endTimer());
		 * 
		 * TnSDemos.startTimer(); System.out.println(ksRS(vals, wts, 0, cap, new
		 * int[vals.length + 1][cap + 1]));
		 * System.out.println(TnSDemos.endTimer());
		 */

		/*
		 * String s1 = "acacbgbgaabgbeacbegg"; String s2 =
		 * "ageaagegbeegbeeggbeeg";
		 * 
		 * TnSDemos.startTimer(); System.out.println(lcs(s1, s2));
		 * System.out.println(TnSDemos.endTimer());
		 * 
		 * TnSDemos.startTimer(); System.out.println(lcsI(s1, s2));
		 * System.out.println(TnSDemos.endTimer());
		 */

		/*
		 * String s1 = "acacbggbeacbegg"; String s2 = "ageaageggbeeggbeeg";
		 * 
		 * TnSDemos.startTimer(); System.out.println(editDistance(s1, s2));
		 * System.out.println(TnSDemos.endTimer());
		 * 
		 * TnSDemos.startTimer(); System.out.println(editDistanceI(s1, s2));
		 * System.out.println(TnSDemos.endTimer());
		 */

		/*
		 * System.out.println(isBalancedBrackets("[(a + b + {c + d})]", ""));
		 * printCode("3211", "");
		 * 
		 * countSubsetTarget(new int[] { 4, 2, 11, 13, 9, 8, 11 }, 0, 11, "");
		 */

		// int[] arr = {1, 2, 3, 4, 5, 6, 7};
		// System.out.println(getTargetSS(arr, 0, 7));

		// System.out.println(toh("Source", "Destination", "Helper", 3, 0));

		printLG("bcad", "", false);
		printLexico(1000, 0);
	}

	public static int Fib(int n) {
		if (n == 0 || n == 1) {
			return n;
		}

		int fnm1 = Fib(n - 1);
		int fnm2 = Fib(n - 2);
		int fn = fnm1 + fnm2;

		return fn;
	}

	public static int FibRS(int n, int[] strg) {
		if (n == 0 || n == 1) {
			return n;
		}

		if (strg[n] != 0) {
			return strg[n];
		}

		int fnm1 = FibRS(n - 1, strg);
		int fnm2 = FibRS(n - 2, strg);
		int fn = fnm1 + fnm2;

		strg[n] = fn;
		return fn;
	}

	public static int FibI(int n) {
		int[] strg = new int[n + 1];

		// init
		strg[0] = 0;
		strg[1] = 1;

		for (int i = 2; i <= n; i++) {
			strg[i] = strg[i - 1] + strg[i - 2];
		}

		return strg[n];
	}

	public static int FibIS(int n) {
		int[] strg = new int[2];

		// init (fib of 0 and fib of 1)
		strg[0] = 0;
		strg[1] = 1;

		for (int i = 1; i <= n; i++) {
			int ofib = strg[0];
			strg[0] = strg[1];
			strg[1] = ofib + strg[0];
		}

		return strg[0];
	}

	public static int cbp(int end, int curr) {
		if (curr == end) {
			return 1;
		}

		if (curr > end) {
			return 0;
		}

		int count = 0;

		for (int dice = 1; dice <= 6; dice++) {
			count += cbp(end, curr + dice);
		}

		return count;
	}

	public static int cbpRS(int end, int curr, int[] strg) {
		if (curr == end) {
			return 1;
		}

		if (curr > end) {
			return 0;
		}

		if (strg[curr] != 0) {
			return strg[curr];
		}

		int count = 0;

		for (int dice = 1; dice <= 6; dice++) {
			count += cbpRS(end, curr + dice, strg);
		}

		strg[curr] = count;
		return count;
	}

	public static int cbpI(int end) {
		int[] strg = new int[end + 1];

		// init
		strg[end] = 1;

		for (int i = end - 1; i >= 0; i--) {
			int sum = 0;

			for (int dice = 1; dice <= 6 && (i + dice) < strg.length; dice++) {
				sum += strg[i + dice];
			}

			strg[i] = sum;
		}

		return strg[0];
	}

	public static int cbpIS(int end) {
		int[] strg = new int[6];

		// init , lets assume end = 100
		strg[0] = 1; // 0 is aligned with 100
		strg[1] = 0; // 1 is aligned with 101
		strg[2] = 0; // 2 is aligned with 102
		strg[3] = 0; // 3 is aligned with 103
		strg[4] = 0; // 4 is aligned with 104
		strg[5] = 0; // 5 is aligned with 105

		for (int i = end - 1; i >= 0; i--) {
			// shift left

			int sum = 0;
			for (int j = 5; j >= 0; j--) {
				sum += strg[j];

				if (j != 0) {
					strg[j] = strg[j - 1];
				} else {
					strg[0] = sum;
				}
			}
		}

		return strg[0];
	}

	public static int cmp(int er, int ec, int cr, int cc) {
		if (cr == er && cc == ec) {
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		int count = 0;

		count += cmp(er, ec, cr + 1, cc);
		count += cmp(er, ec, cr, cc + 1);

		return count;
	}

	public static int cmpRS(int er, int ec, int cr, int cc, int[][] strg) {
		if (cr == er && cc == ec) {
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		if (strg[cr][cc] != 0) {
			return strg[cr][cc];
		}

		int count = 0;

		count += cmpRS(er, ec, cr + 1, cc, strg);
		count += cmpRS(er, ec, cr, cc + 1, strg);

		strg[cr][cc] = count;
		return count;
	}

	public static int cmpI(int er, int ec) {
		int[][] strg = new int[er + 1][ec + 1];

		// init
		strg[er][ec] = 1;

		for (int row = er; row >= 0; row--) {
			for (int col = ec; col >= 0; col--) {
				if (row + 1 > er || col + 1 > ec) {
					strg[row][col] = 1;
				} else {
					strg[row][col] = strg[row + 1][col] + strg[row][col + 1];
				}
			}
		}

		return strg[0][0];
	}

	public static int cmpIS(int er, int ec) {
		int[] strg = new int[ec + 1];

		// init
		for (int i = 0; i < strg.length; i++) {
			strg[i] = 1;
		}

		for (int i = er - 1; i >= 0; i--) {
			// shift up
			for (int j = ec; j >= 0; j--) {
				if (j == ec) {
					strg[j] = 1;
				} else {
					strg[j] = strg[j] + strg[j + 1];
				}
			}
		}

		return strg[0];
	}

	public static int ks(int[] vals, int[] wts, int si, int rc) {
		if (si == vals.length) {
			return 0;
		}

		int f1 = 0, f2 = 0;

		f1 = ks(vals, wts, si + 1, rc);

		if (wts[si] <= rc) {
			f2 = vals[si] + ks(vals, wts, si + 1, rc - wts[si]);
		}

		return Math.max(f1, f2);
	}

	public static int ksRS(int[] vals, int[] wts, int si, int rc, int[][] strg) {
		if (si == vals.length) {
			return 0;
		}

		if (strg[si][rc] != 0) {
			return strg[si][rc];
		}

		int f1 = 0, f2 = 0;

		f1 = ks(vals, wts, si + 1, rc);

		if (wts[si] <= rc) {
			f2 = vals[si] + ks(vals, wts, si + 1, rc - wts[si]);
		}

		strg[si][rc] = Math.max(f1, f2);
		return strg[si][rc];
	}

	public static int lcs(String s1, String s2) {
		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		int rv = 0;

		if (ch1 == ch2) {
			rv = 1 + lcs(ros1, ros2);
		} else {
			int f1 = lcs(s1, ros2);
			int f2 = lcs(ros1, s2);

			rv = Math.max(f1, f2);
		}

		return rv;
	}

	public static int lcsI(String s1, String s2) {
		int[][] strg = new int[s1.length() + 1][s2.length() + 1];

		// init
		strg[0][0] = 0;

		for (int s1l = 0; s1l <= s1.length(); s1l++) {
			for (int s2l = 0; s2l <= s2.length(); s2l++) {
				if (s1l == 0 || s2l == 0) {
					strg[s1l][s2l] = 0;
					continue;
				}

				if (s1.charAt(s1l - 1) == s2.charAt(s2l - 1)) {
					strg[s1l][s2l] = 1 + strg[s1l - 1][s2l - 1];
				} else {
					strg[s1l][s2l] = Math.max(strg[s1l][s2l - 1], strg[s1l - 1][s2l]);
				}
			}
		}

		return strg[s1.length()][s2.length()];
	}

	public static int editDistance(String s1, String s2) {
		if (s1.length() == 0) {
			return s2.length(); // removals
		}

		if (s2.length() == 0) {
			return s1.length(); // insertions
		}

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);
		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		int rv = 0;

		if (ch1 == ch2) {
			rv = editDistance(ros1, ros2);
		} else {
			// replacement
			int f1 = 1 + editDistance(ros1, ros2);
			// removal
			int f2 = 1 + editDistance(s1, ros2);
			// insertion
			int f3 = 1 + editDistance(ros1, s2);

			rv = Math.min(f1, Math.min(f2, f3));
		}

		return rv;
	}

	public static int editDistanceI(String s1, String s2) {
		int[][] strg = new int[s1.length() + 1][s2.length() + 1];

		for (int s1l = 0; s1l <= s1.length(); s1l++) {
			for (int s2l = 0; s2l <= s2.length(); s2l++) {
				if (s1l == 0) {
					strg[s1l][s2l] = s2l;
					continue;
				}

				if (s2l == 0) {
					strg[s1l][s2l] = s1l;
					continue;
				}

				if (s1.charAt(s1l - 1) == s2.charAt(s2l - 1)) {
					strg[s1l][s2l] = strg[s1l - 1][s2l - 1];
				} else {
					int frp = 1 + strg[s1l - 1][s2l - 1];
					int fin = 1 + strg[s1l - 1][s2l];
					int fre = 1 + strg[s1l][s2l - 1];

					strg[s1l][s2l] = Math.min(fin, Math.min(frp, fre));
				}
			}
		}

		return strg[s1.length()][s2.length()];
	}

	public static boolean isBalancedBrackets(String exp, String bsf) {
		if (exp.length() == 0) {
			if (bsf.length() == 0) {
				return true;
			} else {
				return false; // more opening
			}
		}

		char ch = exp.charAt(0);
		String roe = exp.substring(1);

		if (ch == '(' || ch == '{' || ch == '[') {
			return isBalancedBrackets(roe, bsf + ch);
		} else if (ch == ')' || ch == '}' || ch == ']') {
			if (bsf.length() == 0) {
				return false; // closing more
			}

			// mismatch
			if (ch == ')') {
				if (bsf.charAt(bsf.length() - 1) != '(') {
					return false;
				} else {
					return isBalancedBrackets(roe, bsf.substring(0, bsf.length() - 1));
				}
			} else if (ch == '}') {
				if (bsf.charAt(bsf.length() - 1) != '{') {
					return false;
				} else {
					return isBalancedBrackets(roe, bsf.substring(0, bsf.length() - 1));
				}
			} else {
				if (bsf.charAt(bsf.length() - 1) != '[') {
					return false;
				} else {
					return isBalancedBrackets(roe, bsf.substring(0, bsf.length() - 1));
				}
			}
		} else {
			return isBalancedBrackets(roe, bsf);
		}
	}

	public static void printCode(String str, String osf) {
		if (str.length() == 0) {
			System.out.println(osf);
			return;
		}

		char ch1 = str.charAt(0);
		String ros1 = str.substring(1);

		printCode(ros1, osf + (char) (ch1 - '1' + 'a'));

		if (str.length() >= 2) {
			int val2 = Integer.parseInt(str.substring(0, 2));
			String ros2 = str.substring(2);

			if (val2 <= 26) {
				printCode(ros2, osf + (char) ('a' + val2 - 1));
			}
		}
	}

	public static int countSubsetTarget(int[] arr, int si, int tar, String osf) {
		if (si == arr.length) {
			if (tar == 0) {
				System.out.println(osf + "END");
				return 1;
			} else {
				return 0;
			}
		}

		int count = 0;

		count += countSubsetTarget(arr, si + 1, tar - arr[si], osf + arr[si] + ", ");
		count += countSubsetTarget(arr, si + 1, tar - 0, osf);

		return count;
	}

	public static void printEqualSS(int[] arr, int si, int sumISF, int sumESF, String itemISF, String itemESF) {
		if (si == arr.length) {
			if (sumISF == sumESF) {
				itemISF += "END";
				itemESF += "END";
				System.out.println(itemISF + " and " + itemESF);
			}

			return;
		}

		printEqualSS(arr, si + 1, sumISF + arr[si], sumESF, itemISF + arr[si] + ", ", itemESF);
		printEqualSS(arr, si + 1, sumISF, sumESF + arr[si], itemISF, itemESF + arr[si] + ", ");
	}

	public static ArrayList<ArrayList<Integer>> getTargetSS(int[] arr, int si, int tar) {
		if (si == arr.length) {
			if (tar == 0) {
				ArrayList<ArrayList<Integer>> br = new ArrayList<>();

				br.add(new ArrayList<>());

				return br;
			} else {
				ArrayList<ArrayList<Integer>> br = new ArrayList<>();

				return br;
			}
		}

		ArrayList<ArrayList<Integer>> myResult = new ArrayList<>();

		ArrayList<ArrayList<Integer>> recResultExcluders = getTargetSS(arr, si + 1, tar);
		myResult.addAll(recResultExcluders);
		/*
		 * for(ArrayList<Integer> recResultExcluder: recResultExcluders){
		 * myResult.add(recResultExcluder); }
		 */

		ArrayList<ArrayList<Integer>> recResultIncluders = getTargetSS(arr, si + 1, tar - arr[si]);
		for (ArrayList<Integer> recResultIncluder : recResultIncluders) {
			recResultIncluder.add(arr[si]);
			myResult.add(recResultIncluder);
		}

		return myResult;
	}

	public static int toh(String src, String dest, String aux, int discs, int csf) {
		if (discs == 0) {
			return csf;
		}

		csf = toh(src, aux, dest, discs - 1, csf);

		csf = csf + 1;
		System.out.println("Move disc number " + discs + " from " + src + " to " + dest);

		csf = toh(aux, dest, src, discs - 1, csf);

		return csf;
	}

	public static void printLG(String src, String osf, boolean flag) {
		if (src.length() == 0) {
			if (flag == true) {
				System.out.println(osf);
			}
			return;
		}

		for (int i = 0; i < src.length(); i++) {
			char ch = src.charAt(i);
			String ros = src.substring(0, i) + src.substring(i + 1);

			if (flag == true) {
				printLG(ros, osf + ch, true);
			} else {
				if (ch > src.charAt(0)) {
					printLG(ros, osf + ch, true);
				} else if (ch == src.charAt(0)) {
					printLG(ros, osf + ch, false);
				} else {

				}
			}
		}

	}

	public static void printLexico(int end, int curr){
		if(curr > end){
			return;
		}
		
		if(curr == end){
			System.out.println(curr);
			return;
		}
		
		System.out.println(curr);
		if(curr == 0){
			for(int i = 1; i <= 9; i++){
				printLexico(end, i);
			}
		} else {
			for(int i = 0; i <= 9; i++){
				printLexico(end, 10 * curr + i);
			}
		}
		
	}
}
