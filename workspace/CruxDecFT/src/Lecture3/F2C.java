package Lecture3;

import java.util.Scanner;

public class F2C {

	public static void main(String[] args) {
//		System.out.println(5 / 9);
//		System.out.println(5.0 / 9);
		Scanner scn = new Scanner(System.in);
		
		int fmin = scn.nextInt();
		int fmax = scn.nextInt();
		int step = scn.nextInt();
		
		int far = fmin, cel = 0;
		while(far <= fmax){
			cel = (int)(5.0 / 9 * (far - 32));
			
			System.out.println(far + "\t" + cel);
			far += step;
		}
	}

}
