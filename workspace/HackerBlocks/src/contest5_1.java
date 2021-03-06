import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class contest5_1 {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		/*
		 * int t = scn.nextInt(); for(int i =0; i<t;i++){ String s = scn.next();
		 * System.out.println(IntrEnc(s, new int[s.length()],0)); }
		 */
		/*
		 * int n = scn.nextInt(); int m = scn.nextInt(); ArrayList<Integer> list
		 * = takeinput(n); long sum = 0; for(int i =0; i<list.size();i++){
		 * sum+=list.get(i); } if(modsum(list, new long[list.size()],m,sum)){
		 * System.out.println("YES"); }else{ System.out.println("NO"); }
		 */
		int t = scn.nextInt();
		long mod = 1000000000 + 7;
		for (int i = 0; i < t; i++) {
			int[] arr = takeinput();
			Arrays.sort(arr);
			int N = scn.nextInt();
			// System.out.println(AliceBob(arr));
			System.out.println(MoneyChange(arr, mod, N, arr.length, new long[N + 1][arr.length + 1]));
			// System.out.println(MoneyChange(arr, mod, N));
		}
	}

	public static int[] takeinput() {
		int n = scn.nextInt();
		int[] rv = null;
		// long n = scn.nextInt();
		rv = new int[n];
		for (int i = 0; i < n; i++) {
			rv[i] = scn.nextInt();
		}
		return rv;
	}

	private static ArrayList<Integer> takeinput(int n) {
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			arr.add(scn.nextInt());
		}
		return arr;
	}

	public static int IntrEnc(String s, int[] is, int idx) {
		if (s.length() == 0) {
			return 1;
		}
		if (is[idx] != 0) {
			return is[idx];
		}
		int count = 0;
		if (s.charAt(0) != '0') { // to not take 0 as current element to decrypt
			count += IntrEnc(s.substring(1), is, idx + 1);
		}
		is[idx] = count;
		if (s.length() < 2)
			return count;

		int si = Integer.parseInt(s.substring(0, 2));

		if (si > 26 || si < 1)
			return count;

		count += IntrEnc(s.substring(2), is, idx + 2);
		is[idx] = count;
		return count;
	}

	public static boolean modsum(ArrayList<Integer> list, long[] strg, int m, long sum) {
		boolean isdiv = false;
		if (list.size() == 0) {
			return false;
		}
		if (sum % m == 0) {
			return true;
		}
		for (int i = 0; i < list.size(); i++) {
			int temp = list.remove(i);
			isdiv = modsum(list, strg, m, sum - temp);
			list.add(i, temp);
			if (isdiv) {
				return isdiv;
			}
		}
		return isdiv;
	}

	public static long AliceBob(int[] arr) {
		Arrays.sort(arr);
		long[] strg = new long[arr[arr.length - 1] - arr[0] + 1];
		HashMap<Integer, Integer> repmap = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (repmap.containsKey(arr[i])) {
				repmap.put(arr[i], repmap.get(arr[i]) + 1);
			} else {
				repmap.put(arr[i], 1);
			}
		}

		int[] keys = new int[arr[arr.length - 1] - arr[0] + 1];
		int k = 0;
		for (int i = arr[0]; i <= arr[arr.length - 1]; i++) {
			keys[k++] = i;
		}
		strg[0] = repmap.get(arr[0]) * arr[0];
		if (repmap.containsKey(arr[0] + 1)) {
			strg[1] = repmap.get(arr[0] + 1) * (arr[0] + 1);
		} else {
			strg[1] = strg[0];
		}
		for (int i = 2; i < strg.length; i++) {
			if (!repmap.containsKey(keys[i])) {
				strg[i] = strg[i - 1];
			} else {
				strg[i] = Math.max(strg[i - 1], keys[i] * repmap.get(keys[i]) + strg[i - 2]);
			}
		}
		return strg[strg.length - 1];
	}

	public static long MoneyChange(int[] arr, long mod, int n, int si, long[][] ks) {
		// this question's correct solution is done separately in the same
		// folder
		if (n == 0) {
			return 1;
		}
		if (n < 0) {
			return 0;
		}
		if (si <= 0) {
			return 0;
		}
		if (ks[n][si] != 0) {
			return ks[n][si];
		}
		long count = 0;
		for (int i = si - 1, j = 0; i >= 0 && j <= si - 1; i--, j++) {
			// count+=MoneyChange(arr, mod, n-arr[i], si-j, ks);
			count = (count + MoneyChange(arr, mod, n - arr[i], si - j, ks)) % mod;
			// count%=mod;
		}
		count = count % mod;
		ks[n][si] = count;
		return count;
	}
}


