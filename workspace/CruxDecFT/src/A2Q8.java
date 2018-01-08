import java.util.Scanner;

public class A2Q8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int n = scn.nextInt();
		
		int row = 1;
		while(row <= n){
			int col = 1;
			
			while(col <= row){
				if(col == 1 || col == row){
					System.out.print(row + "\t");
				} else {
					System.out.print(0 + "\t");
				}
				
				
				col++;
			}
			
			System.out.println();
			row++;
		}
		
	}

}
