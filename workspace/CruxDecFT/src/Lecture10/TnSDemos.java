package Lecture10;

import java.util.Arrays;

public class TnSDemos {
	public static long start = 0;
	public static long end = 0;

	public static void startTimer() {
		TnSDemos.start = System.currentTimeMillis();
	}

	public static long endTimer() {
		TnSDemos.end = System.currentTimeMillis();
		return TnSDemos.end - TnSDemos.start;
	}

	public static void main(String[] args) {
//		 int N = 1000000;
//		 int[] arr = new int[N];
//		
//		 for(int i = 0; i < arr.length; i++){
//			 arr[i] = N - i;
//		 }
//		
//		
//		 TnSDemos.startTimer();
//		 Lecture5.ArrayOps.bubbleSort(arr);
//		 System.out.println("Bubble Sort for " + N + " items took " + TnSDemos.endTimer());
//		 
//		 for(int i = 0; i < arr.length; i++){
//			 arr[i] = N - i;
//		 }
//		 
//		 TnSDemos.startTimer();
//		 arr = mergeSort(arr, 0, arr.length - 1);
//		 System.out.println("Merge Sort for " + N + " items took " + TnSDemos.endTimer());
		
		/*TnSDemos.startTimer();
		System.out.println(Power(2, 16));
		System.out.println(TnSDemos.endTimer());
		
		TnSDemos.startTimer();
		System.out.println(PowerBtr(2, 16));
		System.out.println(TnSDemos.endTimer());*/

		// int[] one = {1, 5, 11, 14, 19};
		// int[] two = {4, 8, 15, 25, 50, 100};
		//
		// int[] three = merge(one, two);
		// Lecture4.ArraysOps.display(three);

//		int[] arr = { 9, 5, 12, 8, 6, 1 };
//		arr = mergeSort(arr, 0, arr.length - 1);
//		quickSort(arr, 0, arr.length - 1);
//		Lecture4.ArraysOps.display(arr);
		
		int n = 200000;
		
		TnSDemos.startTimer();
		printPrimes(n);
		System.out.println(TnSDemos.endTimer());
	}

	public static int[] merge(int[] one, int[] two) {
		int[] rv = new int[one.length + two.length];

		int i = 0, j = 0, k = 0;
		while (i < one.length && j < two.length) {
			if (one[i] < two[j]) {
				rv[k] = one[i];

				i++;
				k++;
			} else {
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

	public static int[] mergeSort(int[] arr, int lo, int hi) {
		if (lo == hi) {
			int[] br = new int[1];

			br[0] = arr[lo];

			return br;
		}

		int mid = (lo + hi) / 2;

		int[] fhalf = mergeSort(arr, lo, mid);
		int[] shalf = mergeSort(arr, mid + 1, hi);

		int[] sorted = merge(fhalf, shalf);
		return sorted;
	}

	public static void quickSort(int[] arr, int lo, int hi) {
		if(lo >= hi){
			return;
		}
		
		int mid = (lo + hi) / 2;
		int pivot = arr[mid];

		int left = lo, right = hi;
		while (left <= right) {
			while (arr[left] < pivot) {
				left++;
			}

			while (arr[right] > pivot) {
				right--;
			}

			if (left <= right) {
				Lecture4.ArrayDemos.Swap(arr, left, right);
				left++;
				right--;
			}
		}

		quickSort(arr, lo, right); // smaller half
		quickSort(arr, left, hi); // larger half
	}

	public static int Power(int x, int n){
		if(n == 0){
			return 1;
		}
		
		int xpnm1 = Power(x, n - 1);
		int xpn = x * xpnm1;
		
		return xpn;
		
	}
	
	public static int PowerBtr(int x, int n){
		if(n == 0){
			return 1;
		}
		
		int xpnb2 = PowerBtr(x, n / 2);
		int xpn = 1;
		
		if(n % 2 == 0){
			xpn = xpnb2 * xpnb2;
		} else {
			xpn = xpnb2 * xpnb2 * x;
		}
		
		return xpn;
	}
	
	public static int getPolyVal(int x, int n){
		int rv = 0;
		
		int powX = PowerBtr(x, n);
		for(int i = 1; i <= n; i++){
			rv += i * powX;
			powX = powX / x;
		}
		
		return rv;
	}

	public static int countPalindromicSubs(String s){
		return 0;
	}

	public static void modifyStrings(int n){
		String s = "";
		
		for(int i = 0; i <= n; i++){
			s = s + i + "\n";
		}
		
		System.out.println(s);
	}
	
	public static void modifyStringsBtr(int n){
		StringBuilder s = new StringBuilder();
		
		for(int i = 0; i <= n; i++){
			s.insert(0, i);
			s.insert(0, '\n');
		}
		
		System.out.println(s);
	}

	public static void printPrimesSOE(int num){
		boolean[] primes = new boolean[num + 1];
		
		for(int i = 2; i < primes.length; i++){
			primes[i] = true;
		}
		
		for(int i = 2; i * i < primes.length; i++){
			if(primes[i] == false){
				continue;
			}
			
			for(int mult = 2; i * mult < primes.length; mult++){
				primes[i * mult] = false;
			}
		}
		
		for(int i = 2; i < primes.length; i++){
			if(primes[i] == true){
//				System.out.println(i);
			}
		}
	}

	public static void printPrimes(int num){
		for(int i = 2; i <= num; i++){
			if(IsPrime(i)){
//				System.out.println(i);
			}
		}
	}
	
	public static boolean IsPrime(int num){
		int counter = 2;
		while (counter < num) {
			if (num % counter == 0) {
				return false;
			}

			counter = counter + 1;
		}
		
		return true;
	}

	public static int FactorialIterative(int num){
		int rv = 1;
		
		while(num != 0){
			rv = rv * num;
			num--;
		}
		
		return rv;
	}
}
