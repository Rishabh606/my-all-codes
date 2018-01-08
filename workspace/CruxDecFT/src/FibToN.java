import java.util.Scanner;

public class FibToN {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int n = scn.nextInt();
		
		int fn = 0, sn = 1;
		int i = 0;
		while(i <= n){
			System.out.println(fn);
			
			int next = fn + sn;
			fn = sn;
			sn = next;
			i++;
		}
	}

}
