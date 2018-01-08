package Lecture4;

import java.util.Scanner;

public class A3Q19 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int n = scn.nextInt();
		
		int prev = scn.nextInt(), curr = 0;
		int counter = 2;
		
		boolean goingDown = true;
		
		while(counter <= n){
			curr = scn.nextInt();
			
			// work area starts
			
			if(goingDown){
				if(curr < prev){
					// all is well
				} else {
					goingDown = false;
				}
			} else {
				if(curr > prev){
					// all is well
				} else {
					System.out.println(false);
					return;
				}
			}
			
			// work area ends
			
			
			prev = curr;
			counter++;
		}
		
		System.out.println(true);
	}

}
