package Lecture5;

public class TwoDArraysDemo {

	public static void main(String[] args) {
		int[][] arr = null;
		
		// both dimensions provided
		System.out.println("***************************");
		arr = new int[3][4];
		
		System.out.println(arr);
		System.out.println(arr[1]);
		
		display(arr);
		
		arr[2][2] = 100;
		
		display(arr);
		
		// jagged array
		arr = new int[4][];
		System.out.println(arr);
		System.out.println(arr[0]);
		
		arr[0] = new int[3];
		arr[1] = new int[2];
		arr[2] = new int[5];
		arr[3] = new int[1];
		
		display(arr);
	}
	
	public static void display(int[][] arr){
		System.out.println("***************************");
		for(int row = 0; row < arr.length; row++){
			for(int col = 0; col < arr[row].length; col++){
				System.out.print(arr[row][col] + ", ");
			}
			
			System.out.println("END");
		}
		System.out.println("***************************");
	}

}
