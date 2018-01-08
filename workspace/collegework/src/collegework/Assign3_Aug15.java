package collegework;

import java.util.PriorityQueue;
import java.util.Scanner;

//Rishabh Gupta
//16CS01018
//Assignment-3
//DST taken by Dr.Joy Mukherjee

public class Assign3_Aug15 {

	public static Scanner scn = new Scanner(System.in);
	
	static int count = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t1 = scn.nextInt();
		// Q1 - mergersort, complexity nlogn
		for (int i = 0; i < t1; i++) {
			int n = scn.nextInt();
			int[] arr = takeinput(n);
			count = 0;
			mergesort(arr, 0, arr.length - 1);
			System.out.println(count);
		}
		//Q2 method 1 complexity nlogn
	/*	subtract X from array
		quick sort it with absolute values
		and take first k numbers*/
		int t21 = scn.nextInt();
		for (int i = 0; i < t21; i++) {
			int n = scn.nextInt();
			int[] arr = takeinput(n);
			int X = scn.nextInt();
			int K = scn.nextInt();
			Q2m1(arr,X,K);
		}
		//Q2 method 2 complexity nlogk
		/*subtract X from array
		create heap of k capacity
		add nos and remove least priority num
		print heap
		code is optimised form of above*/
		int t22 = scn.nextInt();
		for (int i = 0; i < t22; i++) {
			int n = scn.nextInt();
			int[] arr = takeinput(n);
			int X = scn.nextInt();
			int K = scn.nextInt();
			Q2m2(arr,X,K);
		}
		//Q2 method 3 use redix sort instead of quick sort- complexity- O(n)
	/*	variation of method 1
		subtract X from array
		counting sort it with absolute values
		and take first k numbers*/
	}

	public static int[] takeinput(int n) {
		int[] rv = null;
		// long n = scn.nextInt();
		rv = new int[n];
		for (int i = 0; i < n; i++) {
			rv[i] = scn.nextInt();
		}
		return rv;
	}

	public static int[] mergesort(int[] arr, int lo, int high) {

		int mid = (high + lo) / 2;
		if (mid == high) {
			int[] br = new int[1];
			br[0] = arr[lo];
			return br;
		}
		int[] fhalf = mergesort(arr, lo, mid);
		int[] lhalf = mergesort(arr, mid + 1, high);
		int[] rev = merge(fhalf, lhalf);
		return rev;
	}

	public static int[] merge(int[] one, int[] two) {
		int[] rv = new int[one.length + two.length];
		int i = 0, j = 0, k = 0;
		while (i < one.length && j < two.length) {
			if (one[i] <= two[j]) {
				rv[k] = one[i];
				i++;
				k++;
			} else {
				count += one.length - i;
				rv[k] = two[j];
				j++;
				k++;
			}
		}
		while (i < one.length) {
			rv[k] = one[i];
			i++;
			k++;
		}
		while (j < two.length) {
			rv[k] = two[j];
			j++;
			k++;
		}
		return rv;
	}
	
	public static void Q2m1(int[] arr, int X, int K){
		for(int i = 0; i<arr.length;i++){
			arr[i] = (arr[i]-X);
		}
		quicksort(arr, 0, arr.length-1);
		for(int i = 0; i<K;i++){
			arr[i] = arr[i]+X;
			System.out.print(arr[i]+", ");
		}
		System.out.println("END");
	}
	
	public static void quicksort(int[] arr, int lo, int hi) {
		int left = lo, right = hi, pivot = (right + left) / 2;
		if (lo >= hi) {
			return;
		}
		while (left <= right) {
			while (Math.abs(arr[left]) < Math.abs(arr[pivot])) {
				left++;
			}
			while (Math.abs(arr[right]) > Math.abs(arr[pivot])) {
				right--;
			}

			if (left <= right) {
				int t = arr[left];
				arr[left] = arr[right];
				arr[right] = t;
				left++;
				right--;
			}
		}
		quicksort(arr, lo, right);
		quicksort(arr, left, hi);
	}

	public static void Q2m2(int[] arr,int X, int K){
		//make a heap of number of k size
		PriorityQueue<diapair> pq = new PriorityQueue<>();
		
		for(int i = 0; i<K;i++){
			pq.add(new diapair(arr[i]-X));
		}
		for(int i = K;i<arr.length;i++){
			pq.add(new diapair(arr[i]-X));
			pq.remove();
		}
		for(int i = 0;i<K;i++){
			System.out.print(pq.remove().data+X+", ");
		}
		System.out.println("END");
	}

	private static class diapair implements Comparable<diapair> {
		int data;
		public diapair(int data) {
			// TODO Auto-generated constructor stub
			this.data = data;
		}
		@Override
		public int compareTo(diapair o) {
			// TODO Auto-generated method stub
			return Math.abs(o.data) - Math.abs(this.data);
		}
	}

}
