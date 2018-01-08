package Lecture7;

public class RecursionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// PrintDecreasing(5);
		// PrintIncreasing(5);
		// PrintDI(5);

		System.out.println(Factorial(5));
		System.out.println(Power(2, 10));
		System.out.println(Fibonnaci(10));

		printPattern(5, 1, 1);
		
		int[] arr = {2, 8, 2, 2, 3, 9, 2, 7};
		int[] ai = allIndices(arr, 2, 0, 0);
		
		for(int val: ai){
			System.out.println(val);
		}
	}

	public static void PrintDecreasing(int num) {
		if (num == 0) {
			return;
		}

		System.out.println(num);
		PrintDecreasing(num - 1);
	}

	public static void PrintIncreasing(int num) {
		if (num == 0) {
			return;
		}

		PrintIncreasing(num - 1);
		System.out.println(num);
	}

	public static void PrintDI(int num) {
		if (num == 0) {
			return;
		}

		System.out.println(num);
		PrintDI(num - 1);
		System.out.println(num);
	}

	public static void PrintDISkip(int num) {
		if (num == 0) {
			return;
		}

		if (num % 2 == 1) {
			System.out.println(num);
		}

		PrintDISkip(num - 1);

		if (num % 2 == 0) {
			System.out.println(num);
		}
	}

	public static int Factorial(int num) {
		if (num == 0) {
			return 1;
		}

		int fnm1 = Factorial(num - 1);
		int fn = num * fnm1;

		return fn;
	}

	public static int Power(int x, int n) {
		if (n == 0) {
			return 1;
		}

		int nm1 = n - 1;
		int xnm1 = Power(x, nm1);
		int xn = x * xnm1;

		return xn;
	}

	public static int Fibonnaci(int num) {
		if (num == 0 || num == 1) {
			return num;
		}

		int fibnm1 = Fibonnaci(num - 1);
		int fibnm2 = Fibonnaci(num - 2);

		int fibn = fibnm1 + fibnm2;

		return fibn;
	}

	public static void printPattern(int n, int r, int c) {
		if (r > n) {
			return;
		}

		if (c > r) {
			System.out.println();
			printPattern(n, r + 1, 1);
			
			return;
		}

		System.out.print("*\t");
		printPattern(n, r, c + 1);
	}

	public static boolean isSorted(int[] arr){
		if(arr.length == 1){
			return true;
		}
		
		int[] sa = new int[arr.length - 1];
		for(int i = 1; i < arr.length; i++){
			sa[i - 1] = arr[i];
		}
		
		boolean isSaSorted = isSorted(sa);
		if(isSaSorted == false){
			return false;
		} else {
			if(arr[0] < arr[1]){
				return true;
			} else {
				return false;
			}
		}
	}
	
	public static boolean isSortedA1(int[] arr){
		if(arr.length == 1){
			return true;
		}
		
		if(arr[0] < arr[1]){
			int[] sa = new int[arr.length - 1];
			for(int i = 1; i < arr.length; i++){
				sa[i - 1] = arr[i];
			}
			
			boolean isSaSorted = isSorted(sa);
			return isSaSorted;
		} else {
			return false;
		}
	}
	
	public static boolean isSortedSmarter(int[] arr, int si){
		if(si == arr.length - 1){
			return true;
		}
		
		if(arr[si] < arr[si + 1]){
			boolean isSaSorted = isSortedSmarter(arr, si + 1);
			return isSaSorted;
		} else {
			return false;
		}
	}
	
	public static boolean contains(int[] arr, int data, int si){
		if(si == arr.length){
			return false;
		}
		
		if(arr[si] == data){
			return true;
		} else {
			boolean isContainedInSa = contains(arr, data, si + 1);
			return isContainedInSa;
		}
	}
	
	public static int firstIndex(int[] arr, int data, int si){
		if(si == arr.length){
			return -1;
		}
		
		if(arr[si] == data){
			return si;
		} else {
			int foundAtInSa = firstIndex(arr, data, si + 1);
			return foundAtInSa;
		}
	}
	
	public static int lastIndex(int[] arr, int data){
		return -1;
	}
	
	public static int[] allIndices(int[] arr, int data, int si, int fsf){
		if(si == arr.length){
			return new int[fsf];
		}
		
		
		int[] rv = null;
		
		if(arr[si] == data){
			rv = allIndices(arr, data, si + 1, fsf + 1);
		} else {
			rv = allIndices(arr, data, si + 1, fsf);
		}
		
		if(arr[si] == data){
			rv[fsf] = si;
		}
		
		return rv;
	}
	
}
