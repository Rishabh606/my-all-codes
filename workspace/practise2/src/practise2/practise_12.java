package practise2;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class practise_12 {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// migratory_birds();
		// absoulute_diff();
		/*
		 * int q = scn.nextInt(); String[] arr = new String[q]; for (int a0 = 0;
		 * a0 < q; a0++) { arr[a0] = scn.next(); } for (int a0 = 0; a0 < q;
		 * a0++) { is_hackerrank_present(arr[a0]); }
		 */
		// prefix_neighbours();
		//KnightL();
		/*int t = scn.nextInt();
		int[] r = new int[t];
		int[] c = new int[t];
		for(int i = 0; i<t; i++){
			int cols = scn.nextInt();
			int rows = scn.nextInt();
			c[i] = cols;
			r[i] = rows;
		}
		for(int i = 0; i<t; i++){
			// manthan.learner@gmail.com
			 // .swillconnect
			dynamicboard(c[i], r[i]);
		}*/
		 Big_sort();
	}

	public static ArrayList<Integer> path = new ArrayList<Integer>();

	// public static int[][] board = new int[25][25];
	public static void migratory_birds() {
		int n = scn.nextInt();
		int[] types = new int[n];
		for (int types_i = 0; types_i < n; types_i++) {
			types[types_i] = scn.nextInt();
		}
		int[] typecount = new int[200001];
		for (int i = 0; i < types.length; i++) {
			typecount[types[i]]++;
		}
		int max = max1(typecount);
		System.out.println(max);
	}

	public static int max1(int[] arr) {
		int max = arr[0];
		int retval = 0;
		for (int i = 0; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
				retval = i;
			}

		}

		return retval;
	}

	public static void absoulute_diff() {

		int n = scn.nextInt();
		int[] a = new int[n];
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i] = scn.nextInt();
		}
		Arrays.sort(a);
		int t = 0;
		int[] arr_diff = new int[n - 1];
		for (int i = 0; i < a.length - 1; i++) {
			t = a[i + 1] - a[i];
			if (t >= 0) {
				arr_diff[i] = t;
			} else {
				arr_diff[i] = t * (-1);
			}
		}
		int min = min(arr_diff);
		System.out.println(arr_diff[min]);

	}

	public static int min(int[] arr) {
		int min = arr[0];
		int retval = 0;
		for (int i = 0; i < arr.length; i++) {
			if (min > arr[i]) {
				min = arr[i];
				retval = i;
			}

		}

		return retval;
	}

	public static void is_hackerrank_present(String s) {
		String key = "hackerrank";
		int position = 0;
		for (int i = 0; i < s.length(); i++) {
			if (position >= key.length()) {
				break;
			}
			if (s.charAt(i) == key.charAt(position)) {
				position++;
			}
		}
		if (position == key.length()) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

	public static void prefix_neighbours() {
		int n = scn.nextInt();
		String[] s = new String[n];
		for (int s_i = 0; s_i < n; s_i++) {
			s[s_i] = scn.next();
		}
		int sum = 0;
		quicksort(s, 0, s.length - 1);
		int flag = 0;
		ArrayList<String> br = new ArrayList<String>();
		for (int i = 0; i < s.length; i++) {
			flag = 0;
			// String t = s[i];
			for (int j = i + 1; j < s.length && flag == 0; j++) {
				String k = s[j];
				int p = s[i].length();
				if (s[i].length() <= s[j].length()) {
					String m = s[j].substring(0, s[i].length());
					if (s[i].equals(s[j].substring(0, s[i].length()))) {
						flag = 1;
					}
				}
			}
			if (flag == 0) {
				br.add(s[i]);
				for (int j = 0; j < br.get(br.size() - 1).length(); j++) {
					// int o =br.get(i).length();
					sum = sum + (int) br.get(br.size() - 1).charAt(j);
				}
			}
		}

		/*
		 * for(int i = 0; i<br.size();i++){ // int t =br.get(i).length();
		 * for(int j = 0; j<br.get(i).length();j++){ // int o
		 * =br.get(i).length(); sum = sum + (int)br.get(i).charAt(j); } }
		 */
		System.out.println(sum);
	}

	public static void quicksort(String[] arr, int lo, int hi) {
		int left = lo, right = hi, pivot = (right + left) / 2;
		if (lo >= hi) {
			return;
		}
		while (left <= right) {
			while (arr[left].length() < arr[pivot].length()) {
				left++;
			}
			while (arr[right].length() > arr[pivot].length()) {
				right--;
			}

			if (left <= right) {
				String t = arr[left];
				arr[left] = arr[right];
				arr[right] = t;
				left++;
				right--;
			}
		}
		quicksort(arr, lo, right);
		quicksort(arr, left, hi);
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

	public static int min(ArrayList<Integer> path) {
		if (path.size() == 0) {
			return -1;
		}
		int min = path.get(0);
		int retval = -1;
		for (int i = 0; i < path.size(); i++) {
			if (min >= path.get(i)) {
				min = path.get(i);
				retval = i;
			}

		}

		return retval;
	}

	public static void dynamicboard(int cols, int rows) {
		
		int moves = 0;
		int total = 0;
		int totalr = 0;
		for (int currow = 0; currow < rows-currow; currow++) {
			totalr = 0;
			for (int currcol = 0; currcol < cols-currcol; currcol++) {
				moves =0;
				if ((currcol+1<cols && currow+2<rows) ){
					moves++;
				}
				if ((currcol-1<cols && currow+2<rows)&& (currcol-1>=0)){
					moves++;
				}
				if ((currcol-1<cols && currow-2<rows)&& (currcol-1>=0 && currow-2>=0)){
					moves++;
				}
				if ((currcol+1<cols && currow-2<rows)&& ( currow-2>=0)){
					moves++;
				}
				if ((currcol+2<cols && currow+1<rows)){
					moves++;
				}
				if ((currcol+2<cols && currow-1<rows)&& (currow-1>=0)){
					moves++;
				}
				if ((currcol-2<cols && currow+1<rows)&& (currcol-2>=0)){
					moves++;
				}
				if ((currcol-2<cols && currow-1<rows)&& (currcol-2>=0 && currow-1>=0)){
					moves++;
				}
					
					if(cols%2==0 ){
						totalr = totalr + 2*(cols * rows - moves-1);
						}
						else{
							if(cols-1-currcol-1<currcol+1){
								totalr = totalr + (cols * rows - moves-1);
							}
							else{
								totalr = totalr + 2*(cols * rows - moves-1);	
							}
						}
			}
			if(rows%2==0 ){
			total = total+2*totalr;
			}
			else{
				if(rows-1-currow-1<currow+1){
				total = total + totalr;
				}
				else{
					total = total + 2*totalr;	
				}
			}
		}
		System.out.println(total);
	}
	
	public static void Big_sort(){
		int n = scn.nextInt();
		BigInteger A;
		BigInteger[] unsort = new BigInteger[n];
		for(int i = 0; i<n;i++){
			String t =scn.next();
			A = new BigInteger (t);
			 unsort[i] = A;
		}
		//Arrays.sort(unsort);
		quicksort(unsort,0,n-1);
		for(int i = 0; i<n;i++){
			System.out.println(unsort[i]);
		}
	}
	
	public static void quicksort(BigInteger[] arr, int lo, int hi) {
		int left = lo, right = hi, pivot = (right + left) / 2;
		if (lo >= hi) {
			return;
		}
		while (left <= right) {
			while (arr[left].compareTo(arr[pivot]) < 0) {
				left++;
			}
			while (arr[right].compareTo(arr[pivot]) > 0) {
				right--;
			}

			if (left <= right) {
				BigInteger A;
				A = arr[left];
				arr[left] = arr[right];
				arr[right] = A;
				left++;
				right--;
			}
		}
		quicksort(arr, lo, right);
		quicksort(arr, left, hi);
	}
}