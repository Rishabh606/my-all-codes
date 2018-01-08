package Lecture3;

import java.util.Scanner;

public class Conversions {

	public static void main(String[] args) {
		/*Scanner scn = new Scanner(System.in);
		
		int decimal = scn.nextInt();
		
		int binary = dectoBin(decimal);
		System.out.println(binary);
		
		int decimalAgain = bintoDec(binary);
		System.out.println(decimalAgain);
		
		int numIn5base = dectoany(decimal, 5);
		System.out.println(numIn5base);
		
		decimalAgain = anytodec(numIn5base, 5);
		System.out.println(decimalAgain);*/
		
		System.out.println(anytoany(20110, 3, 8));
	}
	
	public static int dectoBin(int dec){
		int bin = 0;
		int tenPowers = 1;
		
		while(dec != 0){
			int rem = dec % 2;
			
			bin = bin + tenPowers * rem;
			
			tenPowers = tenPowers * 10;
			dec = dec / 2;
		}
		
		return bin;
	}

	public static int dectoany(int dec, int db){
		int rv = 0;
		int tenPowers = 1;
		
		while(dec != 0){
			int rem = dec % db;
			
			rv = rv + tenPowers * rem;
			
			tenPowers = tenPowers * 10;
			dec = dec / db;
		}
		
		return rv;
	}
	
	public static int bintoDec(int bin){
		int rv = 0, twoPowers = 1;
		
		while(bin != 0){
			int rem = bin % 10;
			
			rv = rv + twoPowers * rem;
			
			twoPowers = twoPowers * 2;
			bin /= 10;
		}
		
		return rv;
	}
	
	public static int anytodec(int num, int sb){
		int rv = 0, sbPowers = 1;
		
		while(num != 0){
			int rem = num % 10;
			
			rv = rv + sbPowers * rem;
			
			sbPowers = sbPowers * sb;
			num /= 10;
		}
		
		return rv;
	}
	
	public static int anytoany(int num, int sb, int db){
		int rv = 0;
		
		int decEq = anytodec(num, sb);
		rv = dectoany(decEq, db);
		
		return rv;
	}
}
