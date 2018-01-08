package practise2;

import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class practise20 {

	// public static Scanner scn = new Scanner(System.in);

	

	static class FastScanner {
		BufferedReader reader;
		StringTokenizer st;

		FastScanner(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream));
			st = null;
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					String line = reader.readLine();
					if (line == null) {
						return null;
					}
					st = new StringTokenizer(line);
				} catch (Exception e) {
					throw new RuntimeException();
				}
			}
			return st.nextToken();
		}

		String nextLine() {
			String s = null;
			try {
				s = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return s;
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		char nextChar() {
			return next().charAt(0);
		}

		int[] nextIntArray(int n) {
			int[] a = new int[n];
			int i = 0;
			while (i < n) {
				a[i++] = nextInt();
			}
			return a;
		}

		long[] nextLongArray(int n) {
			long[] a = new long[n];
			int i = 0;
			while (i < n) {
				a[i++] = nextLong();
			}
			return a;
		}

		int[] nextIntArrayOneBased(int n) {
			int[] a = new int[n + 1];
			int i = 1;
			while (i <= n) {
				a[i++] = nextInt();
			}
			return a;
		}

		long[] nextLongArrayOneBased(int n) {
			long[] a = new long[n + 1];
			int i = 1;
			while (i <= n) {
				a[i++] = nextLong();
			}
			return a;
		}

		void close() {
			try {
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static FastScanner scn = new FastScanner(System.in);
	
	public static void main(String[] args) {

		KnightL();
	}

	public static int min_val = 5000;

	public static void KnightL() {
		int n = scn.nextInt();
		int[][] sol = new int[n][n];
		int trow = 1, tcol = 1;
		for (trow = 1; trow < n; trow++) {
			for (tcol = trow; tcol < n; tcol++) {
				int[][] board = new int[25][25];
				min_val = 5000;
				minmoves(n, tcol, trow, 0, 0, 0, 0, board);
				int moves = min_val;
				if (moves != 5000) {
					// System.out.print(" "+path.get(moves)+" ");
					sol[trow][tcol] = min_val;
					sol[tcol][trow] = min_val;
				} else {
					// System.out.print(" -1 ");
					sol[trow][tcol] = -1;
					sol[tcol][trow] = -1;
				}

			}
			// System.out.println();
		}
		display(sol);
	}

	public static void display(int[][] arr) {
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void minmoves(int n, int tcol, int trow, int row, int col, int sum1, int last, int[][] board) {
		// int sum = 0;
		if (board[row][col] != 0 && board[row][col] < sum1) {
			return;
		} else {
			board[row][col] = sum1;
		}
		if (min_val != 5000) {
			if (sum1 >= min_val) {
				return;
			}
		}

		if (row == n - 1 && col == n - 1) {
			if (sum1 < min_val) {
				min_val = sum1;
			}
			return;
		}
		/*
		 * if((row==n-1&&col>=n-2)||(col==n-1 && row>=n-2)){ return; }
		 */
		if (row > n - 1 || col > n - 1) {
			return;
		}
		if (row < 0 || col < 0) {
			return;
		}

		if (row + trow < n && col + tcol < n) {
			minmoves(n, tcol, trow, row + trow, col + tcol, sum1 + 1, 1, board);
		}
		if (row + tcol < n && col + trow < n) {
			minmoves(n, tcol, trow, row + tcol, col + trow, sum1 + 1, 4, board);
		}

		if (row >= trow && col + tcol < n && last != 3) {
			minmoves(n, tcol, trow, row - trow, col + tcol, sum1 + 1, 2, board);
		}
		if (col >= tcol && row + trow < n && last != 2) {
			minmoves(n, tcol, trow, row + trow, col - tcol, sum1 + 1, 3, board);
		}
		if (row >= tcol && col + trow < n && last != 6) {
			minmoves(n, tcol, trow, row - tcol, col + trow, sum1 + 1, 5, board);
		}
		if (col >= trow && row + tcol < n && last != 5) {
			minmoves(n, tcol, trow, row + tcol, col - trow, sum1 + 1, 6, board);
		}
		if (row - trow >= 0 && col - tcol >= 0 && last != 1) {
			minmoves(n, tcol, trow, row - trow, col - tcol, sum1 + 1, 7, board);
		}
		if (row - tcol >= 0 && col - trow >= 0 && last != 4) {
			minmoves(n, tcol, trow, row - tcol, col - trow, sum1 + 1, 8, board);
		}
	}

}