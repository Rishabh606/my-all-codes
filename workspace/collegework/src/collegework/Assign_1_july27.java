package collegework;

import java.util.Scanner;

//assignment1 :16cs01018 rishabh gupta
public class Assign_1_july27 {

	public static long start = 0;
	public static long end = 0;
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("enter no of testcases for Q1");
		int t1 = scn.nextInt();
		startTimer();
		for (int i = 0; i < t1; i++) {
			Q1();
		}
		System.out.println("Timetaken"+endTimer());
		startTimer();
		for (int i = 0; i < t1; i++) {
			Q1_improved();
		}
		System.out.println("Timetaken"+endTimer());
		
		System.out.println("enter no of testcases for Q2. NOTE- a[0][0] needs to be non zero");
		int t2 = scn.nextInt();
		for (int i = 0; i < t2; i++) {
			int[][] arr = takeinput2d();
			checker ch = new checker();
			Q2(arr, ch, "", arr.length - 1, 0);
		}
	}
	
	public static void startTimer() {
		start = System.currentTimeMillis();
	}

	public static long endTimer() {
		end = System.currentTimeMillis();
		return end-start;
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

	public static int[][] takeinput2d() {
		int[][] rv = null;
		int rows = scn.nextInt();
		int cols = scn.nextInt();
		rv = new int[rows + 1][cols + 1];
		for (int i = 1; i < rows + 1; i++) {
			for (int j = 0; j < cols; j++) {
				rv[i][j] = scn.nextInt();
			}
		}
		return rv;
	}

	/*
	 * idea is - takethe first number check its inequality with next consecutive
	 * number 1) if (a[i]>a[i+1]), call a reverse(arr,i) and again call
	 * reverse(arr,i+1) 2) if(a[i]<a[i+1]) i++ and check again check till array
	 * is sorted
	 */
	public static void Q1() {
		int[] arr = takeinput();
		for (int i = 0; i < arr.length; i++) {
			int count = 0;
			for (int j = 0; j < arr.length - i-1 ; j++) {
				if (arr[j] > arr[j + 1]) {
					reverse(arr, j);
					reverse(arr, j + 1);
					count++;
				}

			}
			// if no reverse functions have been called in entire checking then
			// array is sorted therefore if count==0 then-
			if (count == 0) {
				break;
			}
		}
		for (int key : arr) {
			System.out.print(key + ",");
		}
		System.out.println("END");
	}

	public static void Q1_improved() {
		int[] arr = takeinput();
		for (int i = 0; i < arr.length-1; i++) {
			int max = 0;
			for (int j = 0; j < arr.length - i; j++) {
				if (arr[max] < arr[j]) {
					max = j;
				}
			}
				reverse(arr, max);
				reverse(arr,arr.length-i-1);
				
				int flag= 0;
				for(int p = 0; p <arr.length-1; p++){
					if(arr[p+1]<arr[p]){
						flag =-1;
					}
				}
				if(flag==0){
					break;
				}
		}
		for (int key : arr) {
			System.out.print(key + ",");
		}
		System.out.println("END");
	}

	public static void reverse(int[] arr, int i) {
		int left = 0;
		int right = i;
		while (left <= right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
	}
	// a matrix is given we need to print a path so that i reach to CCD (THIS
	// SOLUTION IS WITHOUT DP)
	/*
	 * we create a matrix where topmost row and rightmost coloumn is noting but
	 * zero. we apply recurssion. recursion retuns when one path has been found.
	 * this is done by flag as it turn 1 when path is completed. h indicate rows
	 * and v indicate coloumns recursion returns when path is 0 but proceeds
	 * otherwise (this is why topmost row and rightmost coloumn is filled with 0
	 * since the state of flag has to be kept constat we store inside a seprate
	 * structure in dynamic memomry (private class checker) this functions in
	 * same way as global variable but it only gets called when used new, which
	 * is used while calling Q2, while global vaiable occupies space and can be
	 * confusing
	 */

	public static void Q2(int[][] arr, checker ch, String osf, int h, int v) {
		if (arr[h][v] == 0) {
			return;
		}
		if (ch.flag == 1) {
			return;
		}
		if (v == arr[1].length - 2 && h == 1) {
			ch.flag = 1;
			System.out.println(osf + "<" + (arr.length - 1 - h) + "," + v + ">");
			return;
		}
		Q2(arr, ch, osf + "<" + (arr.length - 1 - h) + "," + v + ">", h - 1, v);
		Q2(arr, ch, osf + "<" + (arr.length - 1 - h) + "," + v + ">", h, v + 1);
	}
}

class checker {
	public checker() {
		// TODO Auto-generated constructor stub
	}

	int flag = 0;
}
