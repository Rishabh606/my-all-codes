package Lecture4;

import java.util.Scanner;

public class A3Q17 {

	public static void main(String[] args) {
//		
//		double exp = 5.1;
//		double expi = 0.1;
//		
//		exp = exp + expi;
//		
//		exp = Math.round(exp * 10) / 10.0;
//		
//		System.out.println(exp);
		
		Scanner scn = new Scanner(System.in);
		
		int n = scn.nextInt();
		int p = scn.nextInt();
		
		double sqrt = 1.0;
		double incr = 1.0;
		
		int ipower = 1;
		double dpower = 1.0;
		
		int counter = 0;
		while(counter <= p){
			
			while(sqrt * sqrt <= n){
				sqrt += incr;
				System.out.print(sqrt + "\t");
				System.out.println(Math.round(sqrt * ipower) / dpower);
			}
			
			sqrt -= incr;
			incr = incr * 0.1;
			
			System.out.print(sqrt + "\t");
			System.out.println(Math.round(sqrt * ipower) / dpower);
			
			ipower *= 10;
			dpower *= 10.0;
			counter++;
		}
		
		
		sqrt = sqrt - incr;
		ipower /= 10;
		dpower /= 10.0;
		
		sqrt = Math.round(sqrt * ipower) / dpower;
		
		System.out.println(sqrt);
	}

}
