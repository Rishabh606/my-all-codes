import java.util.Scanner;

public class basicpatt {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr = arr2dpatt.takeinput();
		// arr2dpatt.display(arr);
		revspiral(arr);
	}

	public static void wavy(int[][] arr) {
		int counter = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {

				System.out.print(arr[counter][i] + "");
				if (i % 2 == 0)
					counter++;
				else
					counter--;
			}
			if (i % 2 == 0)
				counter--;
			else
				counter++;
		}
	}

	public static void spiral(int[][] arr) {

		int counter = 0, mincol = 0, minrow = 0, maxrow = arr.length - 1, maxcol = arr[0].length - 1, i = 0;
		while (maxcol >= mincol && maxrow >= minrow) {
			for (int j = minrow; j <= maxrow; j++) {

				System.out.print(arr[j][mincol] + "	");
			}
			

			for (int j = mincol + 1; j <= maxcol; j++) {

				System.out.print(arr[maxrow][j] + "	");
			}
			for (int j = maxrow - 1; j >= minrow; j--) {

				System.out.print(arr[j][maxcol] + "	");
			}
			for (int j = maxcol - 1; j > mincol; j--) {

				System.out.print(arr[minrow][j] + "	");
			}
			// counter++;
			mincol++;
			minrow++;
			maxrow--;
			maxcol--;
		}
	}
	public static void revspiral(int[][] arr) {

		int counter = 1, mincol = 0, minrow = 0, maxrow = arr.length - 1, maxcol = arr[0].length - 1, i = arr.length*arr[0].length;
		while (maxcol >= mincol && maxrow >= minrow) {
            for (int j = mincol; j <= maxcol && counter<=i; j++, counter++) {

				System.out.print(arr[minrow][j] + ", ");
			}
			for (int j = minrow+1; j <= maxrow&& counter<=i; j++, counter++) {

				System.out.print(arr[j][maxcol] + ", ");
			}
			for (int j = maxcol - 1; j >= mincol&& counter<=i; j--, counter++) {

				System.out.print(arr[maxrow][j] + ", ");
			}		
			for (int j = maxrow - 1; j > minrow&& counter<=i; j--, counter++) {

				System.out.print(arr[j][mincol] + ", ");
			}
			
			
			mincol++;
			minrow++;
			maxrow--;
			maxcol--;
		}
        System.out.print("END");
		}
        
}
