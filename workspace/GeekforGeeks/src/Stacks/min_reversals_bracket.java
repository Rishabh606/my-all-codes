package Stacks;

import java.util.Scanner;
import java.util.Stack;

public class min_reversals_bracket {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = scn.next();
		char[] arr = new char[str.length()];
		for (int i = 0; i < str.length(); i++) {
			arr[i] = str.charAt(i);
		}
		min_reversals(arr);
	}

	public static void min_reversals(char[] arr) {
		Stack<Character> st = new Stack<>();
		Stack<Character> nw = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			if (st.isEmpty() == false && arr[i] == '}' && st.peek() == '{') {
				st.pop();
			} else {
				st.push(arr[i]);
			}
		}
		int count1 = 0;
		int count2 = 0;
		int  pos1 = 0;
		int  pos2 = 0;
		int i = 0;
		while (!st.isEmpty()) {
			char temp = st.pop();
			if (temp == '{') {
				count1++;
				 pos1=i;
			} else {
				count2++;
				 pos2 = i;
			}
			nw.push(temp);
			i++;
		}
		if (count1 == 0) {
			if (nw.size() % 2 == 1) {
				System.out.println("-1");
				return;
			} else {
				System.out.println(count2 / 2);
			}
		} else if (count2 == 0) {
			if (nw.size() % 2 == 1) {
				System.out.println("-1");
				return;
			} else {
				System.out.println(count1 / 2);
			}
		} else {
			if (nw.size() % 2 == 1) {
				System.out.println("-1");
				return;
			} else {
				System.out.println(pos2+(nw.size()-2*pos2)/2);
			}
		}
	}
}
