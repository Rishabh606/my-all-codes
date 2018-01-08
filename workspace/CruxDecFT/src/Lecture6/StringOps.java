package Lecture6;

import java.util.ArrayList;
import java.util.Arrays;

public class StringOps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String str = "abcd";
//		printChars(str);
//		printSubs(str);
//
//		System.out.println(checkPalindrome("nitin"));
//		System.out.println(checkPalindrome("bhanu"));
//
//		printPalidromicSubs("nitin");
//
//		System.out.println(toggleCase("aBcD"));
//		System.out.println(modifyString1("zadkm"));
//		System.out.println(modifyString2("zadkm"));
		
		System.out.println(getSS("abcd"));
		
		System.out.println(maxFreqChar("dbacdada"));
	}

	public static void printChars(String str) {
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			System.out.println(ch);
		}
	}

	public static void printSubs(String str) {
		for (int bi = 0; bi < str.length(); bi++) {
			for (int ei = bi + 1; ei <= str.length(); ei++) {
				System.out.println(str.substring(bi, ei));
			}
		}
	}

	public static boolean checkPalindrome(String str) {
		int left = 0, right = str.length() - 1;

		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}

			left++;
			right--;
		}

		return true;
	}

	public static void printPalidromicSubs(String str) {
		for (int bi = 0; bi < str.length(); bi++) {
			for (int ei = bi + 1; ei <= str.length(); ei++) {
				String sub = str.substring(bi, ei);

				if (checkPalindrome(sub)) {
					System.out.println(sub);
				}
			}
		}
	}

	public static String toggleCase(String str) {
		String rv = "";

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (ch >= 'a' && ch <= 'z') {
				ch = (char) (ch - 'a' + 'A');
			} else if (ch >= 'A' && ch <= 'Z') {
				ch = (char) (ch - 'A' + 'a');
			}

			sb.append(ch);
		}

		rv = sb.toString();
		return rv;
	}

	public static String modifyString1(String str) {
		String rv = "";

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			if (i % 2 == 0) {
				ch = (char) (ch - 1);
			} else {
				ch = (char) (ch + 1);
			}

			sb.append(ch);
		}

		rv = sb.toString();
		return rv;
	}

	public static String modifyString2(String str) {
		String rv = "";

		StringBuilder sb = new StringBuilder();
		char prev = str.charAt(0);

		for (int i = 1; i < str.length(); i++) {
			char curr = str.charAt(i);

			// work area
			int diff = curr - prev;

			sb.append(prev);
			sb.append(diff);
			// work area

			prev = curr;
		}

		sb.append(prev);
		rv = sb.toString();

		return rv;
	}

	public static ArrayList<String> getSS(String str) {
		ArrayList<String> rv = new ArrayList<>();

		ArrayList<String[]> solver = new ArrayList<>();
		String[] init = { str, "" };
		solver.add(init);

		while (!solver.isEmpty()) {
			String[] sa = solver.remove(solver.size() - 1);

			if (sa[0].length() > 0) {
				String fc = sa[0].substring(0, 1);
				String ros = sa[0].substring(1);
				
				String[] posDa = { ros, sa[1] + fc };
				String[] negDa = { ros, sa[1] + "" };

				solver.add(posDa);
				solver.add(negDa);
			} else {
				rv.add(sa[1]);
			}
		}
		
		return rv;
	}

	public static ArrayList<String> getPerm(String str) {
		return null;
	}

	public static char maxFreqChar(String str){
		char rv = '\0';
		
		int[] freqMap = new int[256];
		
		for(int i = 0; i < str.length(); i++){
			char ch = str.charAt(i);
			freqMap[ch]++;
		}
		
		int mfi = 0, mf = 0;
		for(int i = 0; i < freqMap.length; i++){
			if(freqMap[i] > mf){
				mf = freqMap[i];
				mfi = i;
			}
		}
		
		rv = (char)mfi;
		
		return rv;
	}
}
