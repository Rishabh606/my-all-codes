package contest;

import java.util.ArrayList;
import java.util.Scanner;

public class google_jam_2017_1A {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t = scn.nextInt();
		for (int i = 1; i <= t; i++) {
			System.out.println("Case #" + i + ": ");
			Alphabet_cake();
		}
	}

	public static void display(char[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
	}

	public static int[][] takeinput(int rows, int cols) {
		int[][] rv = new int[rows][cols];
		for (int i = 0; i < rv.length; i++) {
			for (int j = 0; j < rv[i].length; j++) {
				rv[i][j] = scn.nextInt();
			}
		}

		return rv;
	}

	public static void Alphabet_cake() {
		int R = scn.nextInt();
		int C = scn.nextInt();
		char[][] cake = new char[R][C];
		int counter = 0;
		ArrayList<Character> br = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			String s = scn.next();
			for (int j = 0; j < C; j++) {
				cake[i][j] = s.charAt(j);
				if (cake[i][j] != '?') {
					br.add(cake[i][j]);
				}
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (cake[i][j] == '?') {
					if (counter >= br.size()) {
						cake[i][j] = br.get(0);
					} else {
						cake[i][j] = br.get(counter++);
					}
				}
			}
		}
		display(cake);
	}

	public static int Ratatouille() {
		int N = scn.nextInt();
		int P = scn.nextInt();
		int[] req_amt = new int[N];
		for (int i = 0; i < N; i++) {
			req_amt[i] = scn.nextInt();
		}
		int[][] packages = takeinput(N, P);
		int counter = 0;
		int min = -1;
		int flag = 1;
		// do this for every row. here only first row is done. therefore put
		// another loop
		for (int j = 0; j < P; j++) {
			int q = packages[0][j] / req_amt[j];
			if (j != 0 && min != q) {
				break;
			}
			if (q != 0) {
				int m = packages[0][j] - q * req_amt[j];
				double n = (double) packages[0][j] / (double)(q* req_amt[j]);
				if (n > 1.1) {
					 n = (double) packages[0][j] / (double)((q+1)* req_amt[j]);
					 if(n>1.1||n<0.9){
						 flag= 0;
						 break;
					 }
				}
				else{
					
				}
			}
			else{
				
			}
		}
		return counter;
	}
}
