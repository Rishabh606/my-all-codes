package Lecture5;

import java.util.Scanner;

public class ArrayOps {

	public static void main(String[] args) {
//		int[] arr = Lecture4.ArraysOps.takeInput();
//
//		insertionSort(arr);
//
//		Lecture4.ArraysOps.display(arr);
		
		int[] arr = {2, 5, 8, 7};
		
		printSubsets(arr);
	}

	public static void bubbleSort(int[] arr) {
		int counter = 1;

		while (counter <= arr.length - 1) {
			for (int i = 0; i < arr.length - counter; i++) {
				if (arr[i] > arr[i + 1]) {
					Lecture4.ArrayDemos.Swap(arr, i, i + 1);
				}
			}

			counter++;
		}
	}

	public static void selectionSort(int[] arr) {
		int counter = 1;

		while (counter <= arr.length - 1) {
			for (int i = counter; i < arr.length; i++) {
				if (arr[counter - 1] > arr[i]) {
					Lecture4.ArrayDemos.Swap(arr, counter - 1, i);
				}
			}

			counter++;
		}
	}

	public static void insertionSort(int[] arr) {
		int counter = 1;

		while (counter <= arr.length - 1) {
			for(int i = counter; i > 0; i--){
				if(arr[i - 1] > arr[i]){
					Lecture4.ArrayDemos.Swap(arr, i - 1, i);
				} else {
					break;
				}
			}
			
			counter++;
		}
	}

	public static int[] takeInput() {
		Scanner scn = new Scanner(System.in);

		System.out.println("Enter the size");
		int n = scn.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Enter the value for " + (i + 1) + "th item");
			arr[i] = scn.nextInt();
		}

		return arr;
	}

	public static void display(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println();
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static int[] getInverse(int[] arr){
		int[] rv = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++){
			rv[arr[i]] = i;
		}
		
		return rv;
	}
	
	public static boolean checkInverse(int[] one, int[] two){
		for(int i = 0; i < one.length; i++){
			if(two[one[i]] == i){
				// nothing to do
			} else {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean isMirrorInverse(int[] arr){
		for(int i = 0; i < arr.length; i++){
			if(arr[arr[i]] == i){
				// good
			} else {
				return false;
			}
		}
		
		return true;
	}

	public static void printSubsets(int[] arr){
		int limit = 1;
		
		int counter = 0;
		while(counter < arr.length){
			limit = limit * 2;
			counter++;
		}
		
		counter = 0;
		while(counter < limit){
			int dec = counter;
			int ic = 0;
			
			while(ic < arr.length){
				int rem = dec % 2;
				
				if(rem == 1){
					System.out.print(arr[ic] + ", ");
				}
				
				dec = dec / 2;
				ic++;
			}
			
			System.out.println("END");
			
			counter++;
		}
		
	}
}
