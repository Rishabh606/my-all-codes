import java.util.Scanner;

public class sorting {
	public static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = max.takeinput();
		selectionsort(arr);
		max.display(arr);
	}
public static void bubblesort(int[] arr)
{
	int counter = 1;
			for(counter =1 ; counter<arr.length ; counter++ ){
				for(int i =0; i<arr.length-counter; i++){
					if(arr[i]>arr[i+1]){
						swap(arr, i, i+1);
					}
				}
			}
}
public static void selectionsort(int[] arr)
{	
	int counter = 1;
	for(counter = 1 ; counter<arr.length ; counter++ ){ 
		for(int i =counter; i<arr.length; i++){
			if(arr[counter-1]>arr[i]){
				swap(arr, counter-1, i);
			}
		}
		
	}
}
public static void insertionsort(int[] arr)
{
	int counter = 1;
	for(counter = 1; counter<arr.length; counter++ ){
		for(int i = counter; i>0; i--){
			if(arr[i-1]>arr[i]){
				swap(arr, i-1, i);
			}
			else
			{
				break;
			}
		}
	}
}

public static void swap(int[] arr, int a, int b)
{
	int t = arr[a];
	arr[a] = arr[b];
	arr[b] = t;
}
}
