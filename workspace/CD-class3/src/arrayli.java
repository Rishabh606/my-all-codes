import java.util.ArrayList;
import java.util.Scanner;

public class arrayli {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> al;
		al = new ArrayList<>();
		String s1 = "abc";
		String s2 = "nitin";
		String s3 = "RAmiT";
		// printchars(s1);
		// subsprinter(s1);
		// palindrome(s2);
		// subpalindrome(s2);
		//String s4 = toggleon1(s3);
		//String s5 = toggleon2(s3);
		// System.out.println(s4);
		// System.out.println(s5);
		//decincstr(s1);
		asciidiff(s1);
	}

	public static void printchars(String s1) {
		for (int i = 0; i < s1.length(); i++) {
			System.out.println(s1.charAt(i));
		}
	}

	public static void subsprinter(String s1) {
		for (int j = 0; j < s1.length(); j++) {
			for (int i = j + 1; i <= s1.length(); i++) {
				System.out.println(s1.substring(j, i));
			}
		}
	}

	public static boolean palindrome(String s2) {
		int left = 0;
		int right = s2.length() - 1;
		// System.out.println("i am here");
		while (left < right) {
			if (s2.charAt(left) != s2.charAt(right)) {
				// System.out.println("not a palindrome");
				return false;
			}
			left++;
			right--;

		}
		// System.out.println("palindrome");
		return true;
	}

	public static void subpalindrome(String s2) {
		for (int j = 0; j < s2.length(); j++) {
			for (int i = j + 1; i <= s2.length(); i++) {
				if (palindrome(s2.substring(j, i))) {
					System.out.println((s2.substring(j, i)));
				}
			}
		}
	}

	/*
	 * public static void freqchecker(String s3) { int counter = 0; int[] rv =
	 * null; int n = scn.nextInt(); rv = new int[s3.length()]; for(int j = 0;
	 * j<s3.length();j++) { counter = 0; for(int i = 0; i<=s3.length(); i++){
	 * if(s3.charAt(j)==s3.charAt(i)) { counter++; } rv[] } } }
	 */
	public static String toggleon1(String s3) {
		StringBuilder sb = new StringBuilder(s3);
		for (int i = 0; i < sb.length(); i++) {
			sb.setCharAt(i, (char) (s3.charAt(i) + 32));
		}
		// for(int i = 0; i<=s3.length())
		return sb.toString();
	}

	public static String toggleon2(String s3) {
		char ch = 'a';
		StringBuilder sb = new StringBuilder(s3);
		for (int i = 0; i < s3.length(); i++) {
			ch = s3.charAt(i);
			if (ch >= 'a' && ch <= 'z') {
				ch = (char) (ch - 'a' + 'A');
			} else if (ch >= 'A' && ch <= 'Z') {
				ch = (char) (ch - 'A' + 'a');
			}
			sb.setCharAt(i, ch);
		}

		return sb.toString();
	}

	public static void asciidiff(String s1) {
		StringBuilder sb = new StringBuilder();
		char prev = s1.charAt(0);
		for (int i = 1; i < s1.length(); i++) {
			char curr = s1.charAt(i);
			int diff = curr - prev;
			sb.append(prev);
			sb.append(diff);
			prev = curr;
		}
		System.out.println(sb.toString());
	}

	public static void decincstr(String s1) {
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < s1.length(); j++) {
			char ch = s1.charAt(j);
			
			if (j % 2 == 0) {
				ch = (char)(ch - 1);
			} else{
				ch = (char)(ch + 1);
			}
			
			sb.append(ch);
		}
		
		System.out.println(sb.toString());
	}

}