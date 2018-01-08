package practise2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class practise_11 {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Q2_subset_div();

		int t = scn.nextInt();
		for (int i = 1; i <= t; i++) {
		//	replacetochain();
			chainchecker();
		}

	}

	public static int[] takeinput(int n) {
		int[] rv = null;
		rv = new int[n];
		for (int i = 0; i < n; i++) {
			rv[i] = scn.nextInt();
		}
		return rv;
	}

	public static int max1(ArrayList<Integer> br) {
		int max = br.get(0);
		int retval = 0;
		for (int i = 0; i < br.size(); i++) {
			if (max <= br.get(i)) {
				max = br.get(i);
				retval = i;
			}

		}

		return retval;
	}

	public static void Q2_subset_div() {
		int n = scn.nextInt();
		int key = scn.nextInt();
		int[] arr = takeinput(n);
		ArrayList<Integer> arrli = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			arrli.add(arr[i]);
		}
		// int high = arr.length-1,low = 0;
		// int sum =(high+low);
		ArrayList<Integer> br = new ArrayList<Integer>();
		// int[] arr2 = new int[n];
		int count = 0;
		while (divchecker(key, arrli)) {
			for (int i = 0; i < arrli.size(); i++) {
				count = 0;
				for (int j = 0; j < arrli.size(); j++) {
					if (i != j) {
						if ((arrli.get(i) + arrli.get(j)) % key == 0) {
							if (count == 0) {
								count++;
								br.add(i, count);
							} else {
								count++;
								br.set(i, count);
							}
						}

					}

				}
				if (count == 0) {
					br.add(i, 0);
				}
			}
			int maxpos = max1(br);
			if (br.get(maxpos) == 0) {
				break;
			}
			if (arrli.get(maxpos) != 0) {
				arrli.remove(maxpos);
			}
			while (br.size() != 0) {
				br.remove(0);
			}
		}
		System.out.println(arrli.size());
	}

	public static boolean divchecker(int key, ArrayList<Integer> arrli) {
		// boolean isdiv = false;
		for (int i = 0; i < arrli.size(); i++) {
			for (int j = 0; j < arrli.size(); j++) {
				if ((arrli.get(i) + arrli.get(j)) % key == 0) {
					return true;
				}

			}
		}
		return false;
	}

	public static boolean sqfree(int n) {
		for (int i = 2; (i * i) <= n / 2; i++) {
			if (n % (i * i) == 0) {
				return false;
			}
		}
		return true;
	}

	public static boolean isnice(int n) {
		int s = 0;
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				s = s + i;
			}
		}
		int c = 0;
		for (int i = 2; i <= s / 2; i++) {
			if (s % i == 0 && isprime(i)) {
				c++;
			}
		}
		if (isprime(c)) {
			return true;
		}
		return false;
	}

	public static boolean isprime(int n) {
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void goodnumbers() {
		int L = scn.nextInt();
		int R = scn.nextInt();
		int sum = 0;
		for (int i = L; i <= R; i++) {
			if (isnice(i) && sqfree(i)) {
				// sum =sum +i;
				for (int j = 1; j <= i; j++) {
					if (i % j == 0) {
						sum = sum + j;
					}
				}
			}
		}
		System.out.println(sum);
	}

	public static void replacetochain() {
		String s = scn.next();
		StringBuilder sb = new StringBuilder(s);
		int sum = 0;
		for (int i = 0; i < sb.length() - 2; i++) {
			char l = sb.charAt(i);
			if (sb.length() == 1) {
				System.out.println("0");
				return;
			}
			char m = sb.charAt(i+1);
			if (sb.length() == 2) {
				if (l == m) {
					System.out.println("1");
				} else {
					System.out.println("0");
				}
				return;
			}
			char h = sb.charAt(i+2);
			if(h==l&& l!=m){
				continue;
			}
			else{
				sum++;
				if(h==l&&l==m){
					if(h=='+'){
						sb.setCharAt(i+1,'-');
					}
					else{
						sb.setCharAt(i+1,'+');
					}
				}
				else if(h==m && h!=l){
					if(h=='+'){
						sb.setCharAt(i+2,'-');
					}
					else{
						sb.setCharAt(i+2,'+');
					}
				}
				else{
					if(h=='-'){
						sb.setCharAt(i,'-');
					}
					else{
						sb.setCharAt(i,'+');
					}
				}
			}
		}
		System.out.println(sum);
	}
	public static void chainchecker(){
		String s = scn.next();
	//	StringBuilder sb = new StringBuilder(s);
		char[] arr1 = new char[s.length()];
		char[] arr2 = new char[s.length()];
		int sum1 = 0, sum2 = 0;
		for(int i = 0;i<=s.length()-1;i++){
			if((i+1)%2==0){
				arr1[i] = '-';
				arr2[i] = '+';
			}
			else{
				arr2[i] = '-';
				arr1[i] = '+';
			}
		
		}
		for(int i = 0; i<s.length();i++){
			if(arr1[i]!=s.charAt(i)){
				sum1++;
			}
			else{
				sum2++;
			}
		}
		if(sum1>sum2){
			System.out.println(sum2);
		}
		else{
			System.out.println(sum1);
		}
	}
}
