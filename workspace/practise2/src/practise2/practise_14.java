package practise2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class practise_14 {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// encrypt();
		/*
		 * int [] arr = {3,1,6,8,4}; sel_sort_rec(arr, 0,0, 0); for(int i = 0;
		 * i<arr.length;i++){ System.out.println(arr[i]); }
		 */

		String s = scn.next();
		PrintPP_lex_dec(s,"",s);
		/*
		 * char[] chars = s.toCharArray(); Arrays.sort(chars); int[] arr = new
		 * int[chars.length];
		 */
		/*
		 * for(int i= 0; i<chars.length;i++){ arr[i] = i+1; }
		 */ // String sorted = new String(chars);
			// System.out.println(sorted);
		// ArrayList<String> br = getPP(sorted);
		// System.out.println(br);
		// Dict_ord_sm(br, s);

		// binarystr(2, 0, "");
	}

	public static void PrintPP_lex_dec(String str, String sol, String key) {
		if (str.length() == 0) {
			if (key.compareTo(sol) < 0) {
				System.out.println(sol);
			}
			return;
		}
		for (int i = 0; i < str.length(); i++) {
			PrintPP_lex_dec(str.substring(0,i)+str.substring(i+1),  sol+""+str.charAt(i),key);
		}
	}

	public static void encrypt() {
		String s = scn.next();
		int lf = 0, lc = 0;
		/*
		 * if(isperfect(s.length())){ lf = (int)Math.floor(Math.pow(s.length(),
		 * 0.5)); lc = lf; } else{ lf = (int)Math.floor(Math.pow(s.length(),
		 * 0.5)); lc = (int)Math.ceil(Math.pow(s.length(), 0.5)); } int Lf = lf;
		 * int Lc = lc;
		 */

		int Lf = (int) Math.floor(Math.pow(s.length(), 0.5));
		int Lc = (int) Math.ceil(Math.pow(s.length(), 0.5));
		if (Lc * Lf < s.length()) {
			Lf = Lc;
		}
		char[][] strg = new char[Lf][Lc];
		int t = 0;
		for (int i = 0; i < Lf && t < s.length(); i++) {
			for (int j = 0; j < Lc && t < s.length(); j++, t++) {
				strg[i][j] = s.charAt(t);
			}
		}
		// int flag = 1;
		for (int i = 0; i < Lc; i++) {
			for (int j = 0; j < Lf; j++) {
				if ((strg[j][i]) == '\u0000') {
					break;
				}
				System.out.print(strg[j][i]);
			}
			System.out.print(" ");
		}
	}

	public static boolean isperfect(int a) {
		for (int i = 1; i <= a / 2; i++) {
			if (i * i == a) {
				return true;
			}
		}
		return false;
	}

	public static int sqrt(int a) {
		for (int i = 1; i <= a / 2; i++) {
			if (i * i == a) {
				return i;
			}
		}
		return 0;
	}

	public static void sel_sort_rec(int[] arr, int i, int min, int j) {
		if (i == arr.length) {
			int a = arr[j];
			arr[j] = arr[min];
			arr[min] = a;
			min = j + 1;
			sel_sort_rec(arr, j + 1, j + 1, j + 1);
			return;
		}
		if (j == arr.length - 1) {
			return;
		}
		int temp = arr[i];
		if (arr[min] > arr[i]) {
			min = i;
		}
		sel_sort_rec(arr, i + 1, min, j);

	}

	public static ArrayList<String> getPP(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<String>();
			br.add("");
			return br;
		}

		ArrayList<String> myres = new ArrayList<String>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			String ros = str.substring(0, i) + str.substring(i + 1, str.length());
			ArrayList<String> recres = getPP(ros);
			for (int j = 0; j < recres.size(); j++) {
				myres.add(ch + recres.get(j)); // for increasing order

			}
		}
		return myres;
	}

	public static void Dict_ord_sm(ArrayList<String> br, String str) {
		String[] arr = new String[br.size()];
		br.toArray(arr);
		int p = Arrays.binarySearch(arr, str);
		/*
		 * for(int i = p+1;i<arr.length;i++){ System.out.println(arr[i]); }
		 */
		for (int i = 0; i < p; i++) {
			System.out.println(arr[i]);
		}
		// int key = 0;
		/*
		 * String key_s = ""; for (int j = 0; j < str.length(); j++) { int ch =
		 * str.charAt(j) - 'a' + 1; //key = 10 * key + ch; if(ch==) key_s =
		 * key_s + String.valueOf(ch); } int key = Integer.parseInt(key_s); for
		 * (int i = 0; i < br.size(); i++) { //int s = 0; String s = ""; for
		 * (int j = 0; j < br.get(i).length(); j++) { int ch =
		 * br.get(i).charAt(j) - 'a' + 1; //s = 10 * s + ch; s = s +
		 * String.valueOf(ch); } arr[i] = Integer.parseInt(s); }
		 * ArrayList<Integer> myres = new ArrayList<>(); for (int i = 0; i <
		 * br.size(); i++) { if (arr[i] > key) { myres.add(arr[i]); } }
		 * ArrayList<String> ans = new ArrayList<>(); for (int i = 0; i <
		 * myres.size(); i++) { String s = ""; for (int j = 0; j <
		 * br.get(i).length(); j++) { char ch = (char) (myres.get(i) % 10 - 1 +
		 * 'a'); s = ch + s; myres.set(i, myres.get(i) / 10); } ans.add(s); }
		 * for (int i = 0; i < ans.size(); i++) {
		 * System.out.println(ans.get(i)); }
		 */
	}

	public static void binarystr(int n, int i, String osf) {
		if (i > n) {
			System.out.println(osf);
			return;
		}

		binarystr(n, i + 1, osf + '0');
		binarystr(n, i + 1, osf + '1');
	}

	public static void spilt_arr(int n, int i, int[] org, ArrayList<Integer> arr1, ArrayList<Integer> arr2, int key,
			int sum) {
		if (i == n) {

		}
		if (key == sum) {
			for (int j = 0; j < arr1.size(); j++) {

			}
		}
	}

	public static void split_arr_print(int n, int i, int[] org, int sum, int key, String l1, String l2) {
		if (i == n && sum == key) {
			System.out.println("start "+l1+ " and " +l2);
		}
		for(int count = 0; i)
	}
}
