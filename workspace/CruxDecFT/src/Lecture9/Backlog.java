package Lecture9;

public class Backlog {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10, 20, 30, 40, 50, 60};
		reverse(arr, 0);
		
		Lecture4.ArraysOps.display(arr);
		
		arr = new int[] {4, 0, 1, 3, 2};
		
		Lecture4.ArraysOps.display(arr);
		inverse(arr, 0);
		Lecture4.ArraysOps.display(arr);
	}
	
	public static void reverse(int[] arr, int si){
		if(si >= arr.length / 2){
			return;
		}
		
		Lecture4.ArrayDemos.Swap(arr, si, arr.length - 1 - si);
		reverse(arr, si + 1);
	}
	
	public static boolean IsPalindrome(int[] arr, int si){
		if(si >= arr.length / 2){
			return true;
		}
		
		if(arr[si] != arr[arr.length - 1 - si]){
			return false;
		}
		
		return IsPalindrome(arr, si + 1);
	}
	
	public static void inverse(int[] arr, int si){
		if(si == arr.length){
			return;
		}
		
		int item = arr[si];
		inverse(arr, si + 1);
		arr[item] = si;
	}

	public static void bubbleSort(int[] arr, int si, int ei){
		if(ei == 0){
			return;
		}
		
		
		if(si == ei){
			bubbleSort(arr, 0, ei - 1);
			return;
		}
		
		if(arr[si] > arr[si + 1]){
			Lecture4.ArrayDemos.Swap(arr, si, si + 1);
		}
		
		bubbleSort(arr, si + 1, ei);
	}
}
