import java.util.Scanner;

public class SumOddEven {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int n = scn.nextInt();
		int so = 0, se = 0;
		
		int counter = 1;
		while(n != 0){
			int rem = n % 10;
			
			if(counter % 2 == 1){
				so = so + rem;
			} else {
				se = se + rem;
			}
			
			counter = counter + 1;
			n = n / 10;
		}
		
		System.out.println(so + " " + se);
	}

}
