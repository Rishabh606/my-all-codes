import java.util.Scanner;

public class NthFibonnaci {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		System.out.println("Enter the number");
		int n = scn.nextInt();
		
		int fn = 0, sn = 1;
		int counter = 1;
		
		while(counter <= n){
			int next = fn + sn;
			
			fn = sn;
			sn = next;
			
			counter++;
		}
		
		System.out.println(fn);
	}

}
