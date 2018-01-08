import java.util.Scanner;

public class A2Q9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		int n = scn.nextInt();
		
		int row = 0;
		while(row < n){
			int col = 0, val = 1;
			
			while(col <= row){
				if(col == 0){
					System.out.print(val + "\t");
				} else {
					int nv = (val * (row - col + 1)) / col;
					System.out.print(nv + "\t");
					val = nv;
				}
				
				col++;
			}
			
			System.out.println();
			row++;
		}
	}

}
