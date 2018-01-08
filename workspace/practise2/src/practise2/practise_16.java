package practise2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class practise_16 {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// staircase();
		// max_min();
		//grading();
		DSP();
	}

	public static void staircase() {
		int n = scn.nextInt();
		int row = 1, scol = n, col = 1;
		for (row = 1; row <= n; row++) {
			for (scol = n - row; scol > 0; scol--) {
				System.out.print(" ");
			}
			for (col = 1; col <= row; col++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void max_min() {

		long[] arr = new long[5];
		long sum = 0;
		long max = Long.MIN_VALUE;
		long min = Long.MAX_VALUE;
		for (int i = 0; i < 5; i++) {
			arr[i] = scn.nextLong();
			sum += arr[i];
		}
		for (int i = 0; i < 5; i++) {
			max = Math.max(sum - arr[i], max);
			min = Math.min(sum - arr[i], min);
		}
		System.out.print(min + " " + max);
	}

	public static void grading() {
		int n = scn.nextInt();
		for (int a0 = 0; a0 < n; a0++) {
			int grade = scn.nextInt();
			if (grade >= 38) {
				if (grade % 5 > 2) {
					System.out.println(grade - (grade % 5) + 5);
				} else {
					System.out.println(grade);
				}
			} else {
				System.out.println(grade);
			}
		}
	}
	public static int binarysearch(int[] arr, int key) {
		int retval = -1, left = 0, right = arr.length - 1;
		int middle = 0;
		if(arr.length==1){
			if(arr[0]>key){
				return 0;
			}
			else{
				return 1;
			}
		}
		while (left <= right) {
			middle = (left + right) / 2;
			if (key > arr[middle - 1] && key < arr[middle]) {
				retval = middle;
				break;
			}
			if (key > arr[middle] && key < arr[middle + 1]) {
				retval = middle+1;
				break;
			}

			if (key == arr[middle]) {
				retval = middle;
				break;
			} else if (arr[middle] > key) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}

		}

		return retval;
	}
	public static void DSP(){
		 int n = scn.nextInt();
		 int count = 0;
	        int k = scn.nextInt();
	        int a[] = new int[n];
	        for(int a_i=0; a_i < n; a_i++){
	            a[a_i] = scn.nextInt();
	        }
	        for(int i =0; i<a.length;i++){
	        	for(int j = i+1; j<a.length;j++){
	        		if((a[i]+a[j])%k==0){
	        			count++;
	        		}
	        	}
	        }
	        System.out.println(count);
	}
	public static void distributesweets(){
		int 
	}
}
