import java.util.Scanner;

public class timecomplex {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// int[] one = {2,4,5,7,9};
		 int[]arr = {17,234,543,2354,123};
		// int[] two = {3,6,8,9,10,12};
		// int[] three=merge(one,two);
		// int[] three = mergesort(arr,0,arr.length-1);
		 quicksort(arr,0,arr.length-1);
		 display(arr);
		// System.out.println(power(2,4));
	//	System.out.println(polynomial(2, 3));
	//	String s2 ="abbaa";
		//subpalindrome(s2);
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

	public static void quicksort(int[] arr, int lo, int hi) {
		int left = lo, right = hi, pivot = (right + left) / 2;
		if (lo >= hi) {
			return;
		}
		while (left <= right) {
			while (arr[left] < arr[pivot]) {
				left++;
			}
			while (arr[right] > arr[pivot]) {
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

	public static void display(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static int power(int b, int n) {
		if (n == 0)
			return 1;
		int t = power(b, n / 2);
		if (n % 2 == 0) {

			return t * t;
		}

		else {
			return b * t * t;
		}
	}

	public static int polynomial(int x, int n) {
		int sum = 0;
		int pow = power(x, n);
		for (int i = 1; i <= n; i++) {
			sum = sum + i * pow;
			pow = pow / x;
		}
		return sum;
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
		int count =0;
		for (int j = 0; j < s2.length(); j++) {
			for (int i = j + 1; i <= s2.length(); i++) {
				if (palindrome(s2.substring(j, i))) {	
					
					count++;
					if(j!=i+1){
						j++;
						i = j+1;
					}
				}
			}
		}
		System.out.println(count);
	}
}
