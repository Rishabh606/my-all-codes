package Lecture9;

import java.util.ArrayList;

public class RecursionDemo {

	public static void main(String[] args) {
		// System.out.println(cbp(10, 0));
		// pbp(10, 0, "0");

		// System.out.println(cmp(2, 2, 0, 0));
		// pmp(2, 2, 0, 0, "");
		// System.out.println(gmp(2, 2, 0, 0));
		// System.out.println(gmpwd(2, 2, 0, 0));

		boolean[][] board = new boolean[4][4];
//		System.out.println(countNQueens(0, board));
		printNQueens(0, board, "");
	}

	public static int cbp(int end, int curr) {
		if (curr == end) {
			return 1;
		}

		if (curr > end) {
			return 0;
		}

		int rv = 0;

		for (int dice = 1; dice <= 6; dice++) {
			rv += cbp(end, curr + dice);
		}

		return rv;
	}

	public static void pbp(int end, int curr, String osf) {
		if (curr == end) {
			System.out.println(osf);
			return;
		}

		if (curr > end) {
			return;
		}

		for (int dice = 1; dice <= 6; dice++) {
			pbp(end, curr + dice, osf + "-" + dice);
		}
	}

	public static void printLexico(int end, int curr) {

	}

	public static int cmp(int er, int ec, int cr, int cc) {
		if (cr == er && cc == ec) {
			return 1;
		}

		if (cc > ec || cr > er) {
			return 0;
		}

		int rv = 0;

		rv += cmp(er, ec, cr, cc + 1);
		rv += cmp(er, ec, cr + 1, cc);

		return rv;
	}

	public static void pmp(int er, int ec, int cr, int cc, String osf) {
		if (cr == er && cc == ec) {
			System.out.println(osf);
			return;
		}

		if (cc > ec || cr > er) {
			return;
		}

		pmp(er, ec, cr + 1, cc, osf + "V");
		pmp(er, ec, cr, cc + 1, osf + "H");
	}

	public static ArrayList<String> gmp(int er, int ec, int cr, int cc) {
		if (cr == er && cc == ec) {
			ArrayList<String> baseResult = new ArrayList<>();

			baseResult.add("");

			return baseResult;
		}

		if (cc > ec || cr > er) {
			ArrayList<String> baseResult = new ArrayList<>();

			return baseResult;
		}

		ArrayList<String> myResult = new ArrayList<>();

		ArrayList<String> hResult = gmp(er, ec, cr, cc + 1);
		for (int i = 0; i < hResult.size(); i++) {
			myResult.add("H" + hResult.get(i));
		}

		ArrayList<String> vResult = gmp(er, ec, cr + 1, cc);
		for (String res : vResult) {
			myResult.add("V" + res);
		}

		return myResult;
	}

	public static ArrayList<String> gmpwd(int er, int ec, int cr, int cc) {
		if (cr == er && cc == ec) {
			ArrayList<String> baseResult = new ArrayList<>();

			baseResult.add("");

			return baseResult;
		}

		if (cc > ec || cr > er) {
			ArrayList<String> baseResult = new ArrayList<>();

			return baseResult;
		}

		ArrayList<String> myResult = new ArrayList<>();

		ArrayList<String> hResult = gmpwd(er, ec, cr, cc + 1);
		for (int i = 0; i < hResult.size(); i++) {
			myResult.add("H" + hResult.get(i));
		}

		ArrayList<String> vResult = gmpwd(er, ec, cr + 1, cc);
		for (String res : vResult) {
			myResult.add("V" + res);
		}

		ArrayList<String> dResult = gmpwd(er, ec, cr + 1, cc + 1);
		for (String res : dResult) {
			myResult.add("D" + res);
		}

		return myResult;
	}

	public static int countNQueens(int row, boolean[][] board) {
		if (row == board.length) {
			return 1;
		}

		int count = 0;

		for (int col = 0; col < board.length; col++) {
			if (isItSafeTPQ(board, row, col)) {
				board[row][col] = true;
				count += countNQueens(row + 1, board);
				board[row][col] = false;
			}
		}

		return count;
	}

	public static boolean isItSafeTPQ(boolean[][] board, int row, int col) {
		// check vertically
		for (int i = row - 1; i >= 0; i--) {
			if (board[i][col] == true) {
				return false;
			}
		}

		// check on diagonal 1
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == true) {
				return false;
			}
		}

		// check on diagonal 2
		for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
			if (board[i][j] == true) {
				return false;
			}
		}

		return true;
	}

	public static void printNQueens(int row, boolean[][] board, String psf) {
		if(row == board.length){
			System.out.println(psf + "END");
			return;
		}
		
		
		for (int col = 0; col < board.length; col++) {
			if (isItSafeTPQ(board, row, col)) {
				board[row][col] = true;
				printNQueens(row + 1, board, psf + "{" + row + "-" + col + "}, ");
				board[row][col] = false;
			}
		}

	}

}
