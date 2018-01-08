package contest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class snackdow2017round1B {

	public static Scanner scn = new Scanner(System.in);

	// static int last1 = 0;
	// static int last2 = 0;
	static int stars1 = 0;
	static int stars2 = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t = scn.nextInt();

		for (int i = 0; i < t; i++) {
			// election();
			coup();
			stars1 = 0;
			stars2 = 0;
		}
	}

	public static void election() {
		String s = scn.next();
		char[] ch = new char[s.length()];
		char[] ch2 = new char[s.length()];
		for (int i = 0; i < s.length(); i++) {
			ch[i] = s.charAt(i);
			ch2[i] = s.charAt(i);
		}
		int mcount = 0;
		int scount = 0;
		for (int i = 0; i < ch.length - 1; i++) {
			if (ch[i] == 's' && ch[i + 1] == 'm') {
				ch[i] = 'u';
				ch[i + 1] = 'u';
				i++;
				mcount++;
			}
		}
		for (int i = 0; i < ch.length - 1; i++) {
			if (ch[i] == 'm' && ch[i + 1] == 's') {
				ch[i] = 'u';
				ch[i + 1] = 'u';
				i++;
				mcount++;
			}
		}
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] == 'm') {
				ch[i] = 'u';
				mcount++;
			}
		}
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] == 's') {
				ch[i] = 'u';
				scount++;
			}
		}
		int mcount2 = 0;
		int scount2 = 0;
		for (int i = 0; i < ch2.length - 1; i++) {
			if (ch2[i] == 'm' && ch2[i + 1] == 's') {
				ch2[i] = 'u';
				ch2[i + 1] = 'u';
				i++;
				mcount2++;
			}
		}
		for (int i = 0; i < ch2.length - 1; i++) {
			if (ch2[i] == 's' && ch2[i + 1] == 'm') {
				ch2[i] = 'u';
				ch2[i + 1] = 'u';
				i++;
				mcount2++;
			}
		}

		for (int i = 0; i < ch2.length; i++) {
			if (ch2[i] == 'm') {
				ch2[i] = 'u';
				mcount2++;
			}
		}
		for (int i = 0; i < ch2.length; i++) {
			if (ch2[i] == 's') {
				ch2[i] = 'u';
				scount2++;
			}
		}
		if (mcount > scount || mcount2 > scount2) {
			System.out.println("mongooses");
		} else if (mcount == scount || mcount2 == scount2) {
			System.out.println("tie");
		} else {
			System.out.println("snakes");
		}
	}

	public static void capital() {
		int n = scn.nextInt();
		int m = scn.nextInt();

	}

	public static int[][] takeinput(int rows, int cols) {
		int[][] rv = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			String t = scn.next();
			int count = 0;
			for (int j = 0; j < cols; j++) {
				if (t.charAt(count) == '*') {
					rv[i][j] = 1;
					if (i == 0) {
						// last1 = j;
						stars1++;
					} else {
						// last2 = j;
						stars2++;
					}
				}
				count++;
			}
		}
		return rv;
	}
	public static void coup() {
		int cols = scn.nextInt();
		int[][] cp = takeinput(2, cols);
		if (stars1 != 0 && stars2 == 0) {
			System.out.println(stars1 - 1);
		} else if (stars2 != 0 && stars1 == 0) {
			System.out.println(stars2 - 1);
		} else {
			if (stars1 > stars2) {
				System.out.println(stars1);
			} else {
				System.out.println(stars2);
			}
		}
	}
	
}