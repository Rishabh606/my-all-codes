package practise2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class practise_3 {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * int[] arr = takeinput(); int key = scn.nextInt(); Arrays.sort(arr);
		 * triplesum(arr,key);
		 */
		//System.out.println(PermSS("abc"));
		System.out.println(keypadcomb("258"));
		
		
	}

	public static int[] takeinput() {
		int[] rv = null;
		int n = scn.nextInt();
		rv = new int[n];
		for (int i = 0; i < n; i++) {
			rv[i] = scn.nextInt();
		}
		return rv;
	}

	public static void sumpair(int[] arr, int key, int curr) {

		int left = curr, right = arr.length - 1, orgkey = arr[curr - 1];
		while (left < right) {
			int middle = (arr[left] + arr[right]);
			if (key == middle) {
				System.out.println(orgkey + ", " + arr[left] + " and " + arr[right]);
				left++;
				right--;
			} else if (key < middle) {
				right--;
			} else {
				left++;
			}
		}
	}

	public static void triplesum(int[] arr, int key) {
		for (int i = 0; i < arr.length; i++) {
			sumpair(arr, key - arr[i], i + 1);
		}
	}

	public static ArrayList<String> PermSS(String s1) {
		if (s1.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		char ch = s1.charAt(0);
		ArrayList<String> recres = PermSS(s1.substring(1));
		ArrayList<String> myres = new ArrayList<>();
		for (int i = 0; i < recres.size(); i++) {
			String mystr = recres.get(i);
			for (int j = 0; j <= mystr.length(); j++) {
				myres.add(mystr.substring(0, j) + ch + mystr.substring(j));
			}
		}
		return myres;
	}

	public static ArrayList<String> keypadcomb(String s1) {
		if (s1.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		char ch = s1.charAt(0);
		ArrayList<String> recres = keypadcomb(s1.substring(1));
		ArrayList<String> myres = new ArrayList<>();
		String lts = getCode(ch);
		for (int i = 0; i < recres.size(); i++) {
			String mystr = recres.get(i);
			for (int k = 0; k < lts.length(); k++) {
				char kplts = lts.charAt(k); 
				myres.add(kplts + mystr);
			}
		}
		return myres;
	}

	public static String getCode(char ch) {
		String[] codes = { ",;", "abc", "def", "ghi", "jkl", "mno", "pqr", "stu", "vwx", "yz" };
		return codes[ch - '0'];
	}
}
