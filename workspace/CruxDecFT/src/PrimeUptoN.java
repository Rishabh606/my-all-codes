import java.util.Scanner;

public class PrimeUptoN {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int n = scn.nextInt();
		
		int num2test = 2;
		while(num2test <= n){
			boolean isPrime = true;
			
			// prime logic
			int divs = 2;
			while(divs < num2test){
				if(num2test % divs == 0){
					isPrime = false;
					break;
				}
				
				divs++;
			}
			
			if(isPrime == true){
				System.out.println(num2test);
			}
			
			
			num2test++;
		}
	}

}
