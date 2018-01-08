package Lecture5;

import java.util.Scanner;

public class TwoDArraysOps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] arr = takeInput();
//		display(arr);
		
		int[][] anotherArr = {
				{11, 12, 13, 14},
				{21, 22, 23, 24},
				{31, 32, 33, 34},
				{41, 42, 43, 44}
				
		};
		
		spiralDisplay(anotherArr);
				
	}
	
	public static int[][] takeInput(){
		int[][] rv = null;
		
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Rows? ");
		int rows = scn.nextInt();
		
		rv = new int[rows][];
		
		for(int row = 0; row < rv.length; row++){
			System.out.println("Columns for row " + (row + 1));
			int cols = scn.nextInt();
			
			rv[row] = new int[cols];
			
			for(int col = 0; col < rv[row].length; col++){
				System.out.println("Value for cell [" + (row + 1) + ", " + (col + 1) + "] cell");
				rv[row][col] = scn.nextInt();
			}
		}
		
		return rv;
	}
	
	public static void display(int[][] arr){
		for(int row = 0; row < arr.length; row++){
			for(int col = 0; col < arr[row].length; col++){
				System.out.print(arr[row][col] + "\t");
			}
			
			System.out.println();
		}
	}

	public static void waveDisplay(int[][] arr){
		for(int col = 0; col < arr[0].length; col++){
			if(col % 2 == 0){ // even
				for(int row = 0; row < arr.length; row++){
					System.out.println(arr[row][col]);
				}
			} else { // odd
				for(int row = arr.length - 1; row >= 0; row--){
					System.out.println(arr[row][col]);
				}
			}
		}
	}

	public static void spiralDisplay(int[][] arr){
		int colmin = 0, colmax = arr[0].length - 1, rowmin = 0, rowmax = arr.length - 1;
		int total = arr.length * arr[0].length;
		
		int counter = 1;
		
		while(counter <= total){
			// colmin
			for(int row = rowmin; counter <= total && row <= rowmax; row++){
				System.out.println(arr[row][colmin]);
				counter++;
			}
			colmin++;
			
			// rowmax
			for(int col = colmin; counter <= total && col <= colmax; col++){
				System.out.println(arr[rowmax][col]);
				counter++;
			}
			rowmax--;
			
			// colmax
			for(int row = rowmax; counter <= total && row >= rowmin; row--){
				System.out.println(arr[row][colmax]);
				counter++;
			}
			colmax--;
			
			// rowmin
			for(int col = colmax; counter <= total && col >= colmin; col--){
				System.out.println(arr[rowmin][col]);
				counter++;
			}
			rowmin++;
		}
		
	}
}
