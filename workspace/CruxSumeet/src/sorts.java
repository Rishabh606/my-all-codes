import java.util.Scanner;

public class sorts {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = scn.nextInt();
		int[] arr = takeinput(n);
		countSort2(arr);
		//radixsort(arr);
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

	public static void countSort(int[] arr) {
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[max] < arr[i]) {
				max = i;
			}
		}
		int[] inp = new int[arr[max] + 1];
		for (int i = 0; i < arr.length; i++) {
			inp[arr[i]]++;
		}
		for (int i = 1; i < inp.length; i++) {
			inp[i] += inp[i - 1];
		}
		int[] output = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			output[inp[arr[i]] - 1] = arr[i];
			inp[arr[i]]--;
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i] = output[i];
			//System.out.print(arr[i] + " ");
		}
	}

	public static void countSort2(int[] arr) {
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[max] < arr[i]) {
				max = i;
			}
		}
		int[] inp = new int[arr[max] + 1];
		for (int i = 0; i < arr.length; i++) {
			inp[arr[i]]++;
		}
		int[] output = new int[arr.length];
		int count = 0;
		for (int i = 0; i < arr[max] + 1; i++) {
			
				for (int j = 0; j < inp[i]; j++) {
					output[count++] = i;
				}
		
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i] = output[i];
			System.out.print(arr[i] + " ");
		}
	}
	public static void radixsort(int[] arr){
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[max] < arr[i]) {
				max = i;
			}
		}
		for(int i = 1; arr[max]/i > 0; i = i*10){
			countSort(arr);
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
