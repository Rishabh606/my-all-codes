import java.util.Scanner;

public class KnightL {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		int n = scn.nextInt();
		
		for(int i = 1; i < n; i++){
			for(int j = 1; j < n; j++){
				int min = minMoves(0, 0, n - 1, n - 1, i, j);
				System.out.print(min + " ");
			}
			System.out.println();
		}
	}
	
	public static int minMoves(int cc, int cr, int ec, int er, int i, int j){
		int rv = 0;
		
		int
		
		return rv;
	}

}
