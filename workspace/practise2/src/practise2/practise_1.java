package practise2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class practise_1 {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayList<Integer> br = new ArrayList<Integer>();
		ArrayList<String> br2 = new ArrayList<String>();
		br.add(1);
		br.add(7);
		br.add(3);
		// snakeladder(15, 3, "3");
		// System.out.println(cmp(3, 3, 0, 0));
		// pmp(3, 3, 0, 0, "0");
		// System.out.println( gmp(3, 3, 0, 0));
	//	 printperm("abc","");
		printSS("abc", "");
	//	br2 = snakeladder(15, 3);
		//System.out.println(br2);
	}

	public static void snakeladder(int end, int curr, String osf) {
		if (curr == end) {
			System.out.println(osf);
			return;
		}
		if (curr > end) {
			return;
		}
		for (int dice = 1; dice <= 6; dice++) {
			snakeladder(end, curr + dice, osf + "-" + dice);
		}
	}

	public static int cmp(int er, int ec, int cr, int cc) {
		if (er == cr && ec == cc) {
			return 1;
		}
		if (cc > ec) {
			return 0;
		}
		if (cr > er) {
			return 0;
		}
		int sum = 0;
		sum = sum + cmp(er, ec, cr, cc + 1);
		sum = sum + cmp(er, ec, cr + 1, cc);
		return sum;
	}

	public static void pmp(int er, int ec, int cr, int cc, String osf) {
		if (er == cr && ec == cc) {
			System.out.println(osf);
			return;
		}
		if (cc > ec) {
			return;
		}
		if (cr > er) {
			return;
		}
		pmp(er, ec, cr, cc + 1, osf + "-H");
		pmp(er, ec, cr + 1, cc, osf + "-V");
	}

	/*
	 * public static ArrayList<String> gmp(int er, int ec, int cr, int cc){
	 * if(er==cr&& ec==cc){ ArrayList<String> br = new ArrayList<>();
	 * br.add("0"); return br; } if(cc>ec){ ArrayList<String> br = new
	 * ArrayList<>(); return br; } if(cr>er){ ArrayList<String> br = new
	 * ArrayList<>(); return br; } ArrayList<String> myres = new ArrayList<>();
	 * ArrayList<String> recres = gmp(er, ec, cr, cc+1); recres.add("H");
	 * ArrayList<String> recres2 = gmp(er, ec, cr+1, cc); recres2.add("V");
	 * for(int i = 0; i<recres.size();i++){ myres.add(recres.get(i)); } for(int
	 * i = 0; i<recres2.size();i++){ myres.add(recres2.get(i)); } return myres;
	 * }
	 */
	public static void printperm(String str, String osf) {
		if (str.length() == 0) {
			System.out.println(osf);
			return;
		}
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			String ros = null;
			ros = str.substring(0, i) + "" + str.substring(i + 1);
			printperm(ros, ch + osf);

		}

	}

	public static void printSS(String str, String osf) {
		if (str.length() == 0) {
			if (osf.length() != 0) {
				System.out.println(osf);
			}
			return;
		}
		char ch = str.charAt(0);
		String ros = str.substring(1);
		printSS(ros, osf);
		printSS(ros, ch + osf);
	}
}
