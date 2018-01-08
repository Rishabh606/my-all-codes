package Lecture4;

import java.util.Scanner;

public class ArraysOps {

	public static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
		int[] arr = takeInput();
		display(arr);
		
		
		System.out.println(max(arr));
		
		System.out.println(linearSearch(arr, 55));
		System.out.println(binarySearch(arr, 55));
		
		display(arr);
		reverse(arr);
		display(arr);
	}
	
	public static int[] takeInput(){
		int[] rv = null;
		
		System.out.println("Enter the size ");
		
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		rv = new int[n];
		
		for(int i = 0; i < rv.length; i++){
			System.out.println("Enter the value for " + (i + 1) + "th item ");
			rv[i] = scn.nextInt();
		}
		
		return rv;
	}
	
	public static void display(int[] arr){
		for(int val: arr){
			System.out.print(val + ", ");
		}
		System.out.println("END");
	}
	
	public static int max(int[] arr){
		int rv = Integer.MIN_VALUE;
		
		for(int val: arr){
			if(val > rv){
				rv = val;
			}
		}
		
		return rv;
	}

	public static int linearSearch(int[] arr, int data){
		int rv = -1;
		
		for(int i = 0; i < arr.length; i++){
			if(arr[i] == data){
				rv = i;
				break;
			}
		}
		
		return rv;
	}
	
	// sorted arr required
	public static int binarySearch(int[] arr, int data){
		int left = 0, right  = arr.length - 1;
		
		while(left <= right){
			int mid = (left + right) / 2;
			
			if(data == arr[mid]){
				return mid;
			} else if(data > arr[mid]){
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		return -1;
	}
	
	public static void reverse(int[] arr){
		int left = 0, right = arr.length - 1;
		
		while(left <= right){
			ArrayDemos.Swap(arr, left, right);
			
			left++;
			right--;
		}
	}
}
