package practise2;

import java.util.Scanner;

public class practise_4 {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = scn.nextLine();
		countHi_not_hit(s);
	}

	public static int[] takeinput(int n) {
		int[] rv = null;

		rv = new int[n];

		for (int i = 0; i < n; i++) {
			rv[i] = scn.nextInt();
		}
		return rv;
	}

	public static void countHi(String str) {
		int count = 0;
		String s1 = null;
		String s2 = null;
		// int[] rv = new int[str.length()/2];
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'h') {
				if (str.charAt(i + 1) == 'i') {
					// rv[count++]=i;

					if (count == 0) {
						s1 = removeHi(str, i);
						s2 = replaceHiWBye(str, i);
					} else {
						s1 = removeHi(s1, i - 2 * count);
						s2 = replaceHiWBye(s2, i + count);
					}
				}
				count++;
			}
		}
		System.out.println(count);
		System.out.println(s1);
		System.out.println(s2);
	}

	public static String removeHi(String str, int j) {
		/* Enter the code here and do not forget the base case */
		String s = str.substring(0, j) + str.substring(j + 2);
		return s;
	}

	public static String replaceHiWBye(String str, int j) {
		/* Enter the code here and do not forget the base case */
		String s = str.substring(0, j) + "bye" + str.substring(j + 2);
		return s;
	}

	public static void countHi_not_hit(String str) {
		int count = 0;
		String s1 = null;
		String s2 = null;
		// int[] rv = new int[str.length()/2];
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'h') {
				if (i < str.length() - 1) {
					if (str.charAt(i + 1) == 'i') {
						// rv[count++]=i;
						if (i >= str.length() - 2) {
							if (count == 0) {
								s1 = removeHi(str, i);
								s2 = replaceHiWBye(str, i);
							} else {
								s1 = removeHi(s1, i - 2 * count);
								s2 = replaceHiWBye(s2, i + count);
							}
							count++;

						} else {
							if (str.charAt(i + 2) != 't') {
								if (count == 0) {
									s1 = removeHi(str, i);
									s2 = replaceHiWBye(str, i);
								} else {
									s1 = removeHi(s1, i - 2 * count);
									s2 = replaceHiWBye(s2, i + count);
								}
								count++;
							}
						}
					}

				}
			}
		}
		System.out.println(count);
		System.out.println(s1);
		System.out.println(s2);
	}
}
