package Extra23Dec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int[] arr = {1, 2, 3};
		// System.out.println(getPermutations(arr, 0));
		//

		Scanner scn = new Scanner(System.in);
		
		Integer[] arr = { scn.nextInt(), scn.nextInt(), scn.nextInt() };
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(arr));
		printPermutations(list, new ArrayList<>());
		//
		// System.out.println(addAsterik("abbbc"));
		//
		// printCode("1123", "");
		//
		boolean[][] board = new boolean[4][4];
		// printNQueens(board, 0, "");

		System.out.println(getNQueens(board, 0));

	}

	public static ArrayList<ArrayList<Integer>> getPermutations(int[] arr, int si) {
		if (si == arr.length) {
			ArrayList<ArrayList<Integer>> br = new ArrayList<>();

			br.add(new ArrayList<>());

			return br;
		}

		ArrayList<ArrayList<Integer>> recResult = getPermutations(arr, si + 1);
		ArrayList<ArrayList<Integer>> myResult = new ArrayList<>();

		for (ArrayList<Integer> recResultInner : recResult) {
			for (int i = 0; i <= recResultInner.size(); i++) {
				ArrayList<Integer> myResultInner = new ArrayList<>();

				myResultInner.addAll(recResultInner);
				myResultInner.add(i, arr[si]);

				myResult.add(myResultInner);
			}
		}

		return myResult;
	}

	public static void printPermutations(List<Integer> orig, ArrayList<Integer> osf) {
		if (orig.isEmpty()) {
			System.out.println(osf);
			return;
		}

		for (int i = orig.size() - 1; i >= 0; i--) {
			int item = orig.get(i);

			osf.add(item);
			orig.remove(i);

			printPermutations(orig, osf);

			osf.remove(osf.size() - 1);
			orig.add(i, item);
		}

	}

	public static String addAsterik(String str) {
		if (str.length() == 1) {
			return str;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		String recResult = addAsterik(ros);
		String myResult;

		if (ch == recResult.charAt(0)) {
			myResult = ch + "*" + recResult;
		} else {
			myResult = ch + recResult;
		}

		return myResult;
	}

	public static void printCode(String str, String osf) {
		if (str.length() == 0) {
			System.out.println(osf);
			return;
		}

		char ch1 = str.charAt(0);
		String ros1 = str.substring(1);

		printCode(ros1, osf + (char) ('a' + (ch1 - '1')));

		if (str.length() >= 2) {
			String ch2 = str.substring(0, 2);
			String ros2 = str.substring(2);

			int ch2I = Integer.parseInt(ch2, 10);
			if (ch2I <= 26) {
				printCode(ros2, osf + (char) ('a' + ch2I - 1));
			}
		}
	}

	public static ArrayList<String> getNQueens(boolean[][] board, int row) {
		if (row == board.length) {
			ArrayList<String> br = new ArrayList<>();

			br.add("END\n");

			return br;
		}

		ArrayList<String> myResult = new ArrayList<>();

		for (int col = 0; col < board.length; col++) {
			if (isItSafeTPQ(board, row, col)) {
				board[row][col] = true;
				ArrayList<String> recResult = getNQueens(board, row + 1);
				board[row][col] = false;

				for (int i = 0; i < recResult.size(); i++) {
					myResult.add("{" + row + "-" + col + "}, " + recResult.get(i));
				}
			}
		}

		return myResult;
	}

	public static void printNQueens(boolean[][] board, int row, String osf) {
		if (row == board.length) {
			System.out.println(osf + "END");
			return;
		}

		for (int col = 0; col < board.length; col++) {
			if (isItSafeTPQ(board, row, col)) {
				board[row][col] = true;
				printNQueens(board, row + 1, osf + "{" + row + "-" + col + "}, ");
				board[row][col] = false;
			}
		}
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

}
