import java.util.ArrayList;
import java.util.Scanner;

public class recur4 {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[] arr = takeinput();
		// inverse(arr, 0);
		// display(arr);
		// System.out.println(snakeladder(15,3));
		// snakeladder2(10, 0, "0");
		 System.out.println(cmp(2,2,1, 1));
		// pmp(2, 2, 0, 0,"0");
		 //ArrayList<String> br = gmp(2, 2, 0, 0);
		 //System.out.println(br);
		// System.out.println(gmpdia(2, 2, 0, 0));
		//boolean[][] board = new boolean[4][4];
		//System.out.println(countNQueens(0, board));
		//countNQueens2(0,  board, "");
	}

	public static int[] takeinput() {
		int[] rv = null;
		int n = scn.nextInt();
		rv = new int[n];
		for (int i = 0; i < n; i++) {
			rv[i] = scn.nextInt();
		}
		return rv;
	}

	public static void inverse(int[] arr, int si) {
		if (si == arr.length) {
			return;
		}
		int temp = arr[si];
		inverse(arr, si + 1);
		arr[temp] = si;
		// System.out.println(arr[temp]);
	}

	public static void display(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static int snakeladder(int end, int curr) {
		if (curr == end) {
			return 1;
		}
		if (curr > end) {
			return 0;
		}
		int sum = 0;
		for (int dice = 1; dice <= 6; dice++) {
			sum = sum + snakeladder(end, curr + dice);
		}
		return sum;
	}

	public static void snakeladder2(int end, int curr, String osf) {
		if (curr == end) {
			System.out.println(osf);
			return;
		}
		if (curr > end) {
			return;
		}
		for (int dice = 1; dice <= 6; dice++) {
			snakeladder2(end, curr + dice, osf + "-" + dice);
		}
	}

	public static int cmp(int er, int ec, int cr, int cc) {
		if (er == cr && ec == cc) {
			return 1;
		}

		if (er < cr) {
			return 0;
		}
		if (ec < cc) {
			return 0;
		}
		int sum = 0;
		sum = sum + cmp(er, ec, cr + 1, cc);
		sum = sum + cmp(er, ec, cr, cc + 1);
		return sum;

	}

	public static void pmp(int er, int ec, int cr, int cc, String osf) {
		if (er == cr && ec == cc) {
			System.out.println(osf);
			return;
		}

		if (er < cr) {
			return;
		}
		if (ec < cc) {
			return;
		}
		pmp(er, ec, cr + 1, cc, osf + "-V");
		pmp(er, ec, cr, cc + 1, osf + "-H");

	}

	public static ArrayList<String> gmp(int er, int ec, int cr, int cc) {
		if (er == cr && ec == cc) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		if (er < cr || ec < cc) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}
		ArrayList<String> myres = new ArrayList<>();

		ArrayList<String> recres = gmp(er, ec, cr + 1, cc);
		for (int i = 0; i < recres.size(); i++)
			myres.add("V" + recres.get(i));
		ArrayList<String> recres2 = gmp(er, ec, cr, cc + 1);
		for (int i = 0; i < recres2.size(); i++)
			myres.add("H" + recres2.get(i));
		return myres;

	}

	public static ArrayList<String> gmpdia(int er, int ec, int cr, int cc) {
		if (er == cr && ec == cc) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		if (er < cr || ec < cc) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}
		ArrayList<String> myres = new ArrayList<>();

		ArrayList<String> recres = gmpdia(er, ec, cr + 1, cc);
		for (int i = 0; i < recres.size(); i++)
			myres.add("V" + recres.get(i));
		ArrayList<String> recres2 = gmpdia(er, ec, cr, cc + 1);
		for (int i = 0; i < recres2.size(); i++)
			myres.add("H" + recres2.get(i));
		ArrayList<String> recres3 = gmpdia(er, ec, cr + 1, cc + 1);
		for (int i = 0; i < recres3.size(); i++)
			myres.add("D" + recres3.get(i));
		return myres;

	}

	public static ArrayList<String> permutSS(String s1) {
		if (s1.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;

		}
		char ch = s1.charAt(0);
		String ros = s1.substring(1);

		ArrayList<String> recres = permutSS(ros);
		ArrayList<String> myres = new ArrayList<>();

		for (int i = 0; i < recres.size(); i++) {
			String mystr = recres.get(i);
			for (int j = 0; j <= mystr.length(); j++) {
				myres.add(mystr.substring(0, j) + ch + mystr.substring(j));
			}
		}

		return myres;
	}

	public static int countNQueens(int row, boolean[][] board) {
		if (row == board.length) {
			return 1;
		}
		int sum = 0;
		for (int col = 0; col < board.length; col++) {
			if (IsitSafeTPQ(board, row, col)) {
				board[row][col] = true;
				sum = sum + countNQueens(row + 1, board);
				board[row][col] = false;
			}
		}
		return sum;
	}

	public static boolean IsitSafeTPQ(boolean[][] board, int row, int col) {
		for (int crow = row - 1; crow >= 0; crow--) {
			if (board[crow][col] == true)
				return false;
		}
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == true)
				return false;
		}
		for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
			if (board[i][j] == true)
				return false;
		}
		return true;
	}
	public static void countNQueens2(int row, boolean[][] board, String psf) {
		if (row == board.length) {
			System.out.println(psf);
			return;
		}
		for (int col = 0; col < board.length; col++) {
			if (IsitSafeTPQ(board, row, col)) {
				board[row][col] = true;
				countNQueens2(row + 1, board,psf+"{"+col+","+row+"}");
				board[row][col] = false;
			}
		}
	}


}
