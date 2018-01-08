import java.util.Arrays;
import java.util.Scanner;

public class DP {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// System.out.println(Fib(43));
		// System.out.println(FibRS(2, new int[44]));
		// System.out.println(cbo(0, 10,new int[41]));
		// System.out.println(cmp(0, 0, 3, 3, new int[26][26]));
		// System.out.println(FibI(6));
		// System.out.println(FibIS(6));
		// System.out.println(cbpI(10));
		// System.out.println(cbpIS(10));
		// System.out.println(cmpDIS(3, 3));
		// System.out.println(cmp(100,100,0,0));
		// System.out.println(editDistanceI("food","monkey"));
		// System.out.println(editDistanceR("food","monkey"));
		// int[] arr = { 3, 4, -1, 0, 6, 2, 3 };
		// int[] strg = { 1, 1, 1, 1, 1, 1, 1 };
		// System.out.println(lisI(arr));
		// System.out.println(lisR(arr, 0, strg));
		// int[] vals = {1,4,5,7};
		// int[] wts = {1,3,4,5};
		// int [][] strg2 = new int[5][8];
		// ksR(vals,wts,1,1,7,strg2);
		// System.out.println(strg2[4][7]);
		// System.out.println(ksI(vals,wts,7));
		// currcomb(0,6,"");
		// System.out.println(lcsI("abcdaf", "acbcf"));
		//int[][] strg3 = new int[6][7];
		//lcsR(strg3, "abcdaf", "acbcf", 1, 1);
		// System.out.println(strg3[5][6]);
		//System.out.println(lcsStrI(strg3, "abcdaf", "acbcf"));
	//	System.out.println(lcsStrR(strg3, "abcdaf", "acbcf", 1, 1, ""));
		//lcsStrR(strg3, "abcdaf", "acbcf", 5, 6, "");
		int n = scn.nextInt();
        int q = scn.nextInt();
        String[] s = new String[n];
        for(int s_i=0; s_i < n; s_i++){
            s[s_i] = scn.next();
        }
        for(int a0 = 0; a0 < q; a0++){
            int x = scn.nextInt();
            int y = scn.nextInt();
            // your code goes here
            lcstringI(s,x,y);
        }
	}

	public static int Fib(int num) {
		System.out.println("Hi " + num);
		if (num == 0 || num == 1) {
			return num;
		}

		int rv = 0;

		int fnm1 = Fib(num - 1);
		int fnm2 = Fib(num - 2);
		rv = fnm1 + fnm2;

		return rv;
	}

	public static int FibRS(int num, int[] strg) {
		System.out.println("Hi " + num);
		if (num == 0 || num == 1) {
			return num;
		}

		if (strg[num] != 0) {
			return strg[num];
		}

		int rv = 0;

		int fnm1 = FibRS(num - 1, strg);
		int fnm2 = FibRS(num - 2, strg);
		rv = fnm1 + fnm2;

		strg[num] = rv;
		return rv;
	}

	public static int cbo(int curr, int end, int[] board) {
		if (curr == end) {
			return 1;
		}

		if (curr > end) {
			return 0;
		}

		if (board[curr] != 0) {
			return board[curr];
		}
		int rv = 0;

		for (int dice = 1; dice <= 6; dice++) {
			rv += cbo(curr + dice, end, board);
		}

		board[curr] = rv;
		return rv;
	}

	public static int cmp(int cc, int cr, int ec, int er, int[][] brd) {
		if (cc > ec || cr > er) {
			return 0;
		}

		if (cc == ec && cr == er) {
			return 1;
		}
		if (brd[cc][cr] != 0) {
			return brd[cc][cr];
		}
		int rv = 0;

		rv += cmp(cc + 1, cr, ec, er, brd);
		rv += cmp(cc, cr + 1, ec, er, brd);
		brd[cc][cr] = rv;
		return rv;
	}

	public static int FibI(int num) {
		int[] strg = new int[num + 1];

		strg[0] = 0;
		strg[1] = 1;

		for (int i = 2; i <= num; i++) {
			strg[i] = strg[i - 1] + strg[i - 2];
		}

		return strg[num];
	}

	public static int FibIS(int num) {
		int[] strg = new int[2];

		strg[0] = 0;
		strg[1] = 1;

		// window aligned to 0, the journey ends when 0 of window is aligned to
		// num

		for (int i = 1; i <= num; i++) {
			int third = strg[0] + strg[1];

			strg[0] = strg[1];
			strg[1] = third;
		}

		return strg[0];
	}

	public static int cbpI(int num) {
		int[] strg = new int[num + 1];

		strg[num] = 1;

		for (int i = num - 1; i >= 0; i--) {
			for (int dice = 1; dice <= 6 && i + dice < strg.length; dice++) {
				strg[i] += strg[i + dice];
			}
		}

		return strg[0];
	}

	public static int cbpIS(int num) {
		int[] strg = new int[6];

		// 0 aligned to num
		strg[0] = 1;

		for (int i = num - 1; i >= 0; i--) {
			int sum = 0; // preparing new value for strg[0]

			for (int j = 5; j >= 0; j--) {
				sum += strg[j];

				if (j == 0) {
					strg[j] = sum;
				} else {
					strg[j] = strg[j - 1];
				}
			}
		}

		return strg[0];
	}

	public static int cmpI(int ec, int er) {
		int[][] strg = new int[ec + 1][er + 1];

		strg[ec][er] = 1;

		for (int row = er; row >= 0; row--) {
			for (int col = ec; col >= 0; col--) {
				int nextRow = row + 1;
				int nextCol = col + 1;

				if (nextRow < strg.length) {
					strg[row][col] += strg[nextRow][col];
				}

				if (nextCol < strg.length) {
					strg[row][col] += strg[row][nextCol];
				}
			}
		}

		return strg[0][0];
	}

	public static int cmpIS(int ec, int er) {
		int[] strg = new int[ec + 1];

		Arrays.fill(strg, 1);

		for (int row = er - 1; row >= 0; row--) {
			for (int col = ec; col >= 0; col--) {
				if (col == ec) {
					continue;
				}

				strg[col] = strg[col] + strg[col + 1];
			}
		}

		return strg[0];
	}

	public static int cmpDI(int ec, int er) {
		int[][] strg = new int[ec + 1][er + 1];

		strg[ec][er] = 1;

		for (int row = er; row >= 0; row--) {
			for (int col = ec; col >= 0; col--) {
				int nextRow = row + 1;
				int nextCol = col + 1;

				if (nextRow < strg.length) {
					strg[row][col] += strg[nextRow][col];
				}

				if (nextCol < strg.length) {
					strg[row][col] += strg[row][nextCol];
				}
				if (nextCol < strg.length && nextRow < strg.length) {
					strg[row][col] += strg[nextRow][nextCol];
				}
			}
		}

		return strg[0][0];
	}

	public static int cmpDIS(int ec, int er) {
		int[] strg = new int[ec + 1];

		Arrays.fill(strg, 1);

		int diag = 0;
		for (int row = er - 1; row >= 0; row--) {
			for (int col = ec; col >= 0; col--) {
				if (col == ec) {
					diag = strg[col];
					continue;
				}

				int newDiag = strg[col];
				strg[col] = strg[col] + strg[col + 1] + diag;
				diag = newDiag;
			}
		}

		return strg[0];
	}

	public static int cmp(int er, int ec, int cr, int cc) {
		if (cr == er && cc == ec) {
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		int count = 0;

		count += cmp(er, ec, cr + 1, cc);
		count += cmp(er, ec, cr, cc + 1);

		return count;
	}

	public static int editDistanceI(String s1, String s2) {
		int[][] strg = new int[s2.length() + 1][s1.length() + 1];
		for (int r1col = 0; r1col < s1.length() + 1; r1col++) {
			strg[0][r1col] = r1col;
		}
		for (int c1row = 0; c1row < s2.length() + 1; c1row++) {
			strg[c1row][0] = c1row;
		}
		for (int row = 1; row < s2.length() + 1; row++) {
			for (int col = 1; col < s1.length() + 1; col++) {
				if (s1.charAt(col - 1) == s2.charAt(row - 1)) {
					strg[row][col] = strg[row - 1][col - 1];
				} else {
					strg[row][col] = Math.min(strg[row - 1][col - 1], Math.min(strg[row - 1][col], strg[row][col - 1]))
							+ 1;
				}
			}
		}

		return strg[s2.length()][s1.length()];
	}

	public static int editDistanceR(String s1, String s2) {
		if (s1.length() == 0) {
			return s2.length();
		}
		if (s2.length() == 0) {
			return s1.length();
		}
		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);
		if (s1.charAt(0) == s2.charAt(0)) {
			return editDistanceR(ros1, ros2);
		} else {
			int f1 = editDistanceR(s1, ros2);
			int f2 = editDistanceR(ros1, s2);
			int f3 = editDistanceR(ros1, ros2);
			return 1 + Math.min(f1, Math.min(f2, f3));
		}
	}

	public static int lisI(int[] arr) {
		int strg[] = new int[arr.length];
		Arrays.fill(strg, 1);
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					if (strg[i] < strg[j] + 1) {
						strg[i] = strg[j] + 1;
					}
				}
			}
		}
		int max = -1;
		for (int i = 0; i < arr.length; i++) {
			if (strg[i] > max) {
				max = strg[i];
			}
		}
		return max;
	}

	public static int lisR(int[] arr, int i, int[] strg) {
		if (i == arr.length) {
			int max = -1;
			for (int j = 0; j < arr.length; j++) {
				if (strg[j] > max) {
					max = strg[j];
				}
			}
			return max;
		}
		for (int j = 0; j < i; j++) {
			if (arr[j] < arr[i]) {
				if (strg[i] < strg[j] + 1) {
					strg[i] = strg[j] + 1;
				}
			}
		}
		int max = lisR(arr, i + 1, strg);
		return max;
	}

	public static int ksI(int[] vals, int[] wts, int key) {
		int[][] strg = new int[vals.length + 1][key + 1];
		for (int obj = 1; obj < vals.length + 1; obj++) {
			for (int wt = 1; wt < key + 1; wt++) {
				if (wts[obj - 1] > wt) {
					strg[obj][wt] = strg[obj - 1][wt];
				} else {
					strg[obj][wt] = Math.max(strg[obj - 1][wt], vals[obj - 1] + strg[obj - 1][wt - wts[obj - 1]]);
				}
			}
		}
		return strg[vals.length][key];
	}

	public static void ksR(int[] vals, int[] wts, int obj, int wt, int key, int[][] strg) {
		if (obj == vals.length + 1) {
			return;
		}

		if (wts[obj - 1] > wt) {
			strg[obj][wt] = strg[obj - 1][wt];
		} else {
			strg[obj][wt] = Math.max(strg[obj - 1][wt], vals[obj - 1] + strg[obj - 1][wt - wts[obj - 1]]);
		}
		if (wt < key) {
			ksR(vals, wts, obj, wt + 1, key, strg);
		}
		if (wt == key) {
			ksR(vals, wts, obj + 1, 1, key, strg);
		}

	}

	public static void currcomb(int curr, int amt, String osf) {
		if (curr == amt) {
			System.out.println(osf + "End");
			return;
		}
		if (curr > amt) {
			return;
		}
		currcomb(curr + 1, amt, "1-" + osf);
		currcomb(curr + 2, amt, "2-" + osf);
		currcomb(curr + 5, amt, "5-" + osf);
		currcomb(curr + 10, amt, "10-" + osf);
	}
	/*
	 * public static String currcomb(int curr,int amt, String osf,String[][]
	 * strg){ if(curr==amt){ System.out.println("Start"+osf+"End"); return
	 * "Start-"+osf+"End" ; } if(curr>amt){ return null; } for(int i =
	 * 0;i<4;i++){ if(strg[curr][i]!=null){ System.out.println(strg[curr][i]); }
	 * } String [] t = new String[4]; t[0] = currcomb(curr+1, amt,
	 * "1-"+osf,strg); t[1] = currcomb(curr+2, amt, "2-"+osf,strg); t[2] =
	 * currcomb(curr+5, amt, "5-"+osf,strg); t[3] = currcomb(curr+10,amt,
	 * "10-"+osf,strg); for(int i = 0;i<4;i++){ if(t[i].charAt(0)=='s'){
	 * strg[curr][i]=t[0]; } }
	 * 
	 * }
	 */

	public static int mcm(int[] dims, int si, int ei) {
		if (si == dims.length) {

		}
		for (int i = si + 1; i < ei; i++) {

		}
	}

	public static int lcsI(String s1, String s2) {
		int[][] strg = new int[s2.length() + 1][s1.length() + 1];
		for (int currow = 1; currow <= s2.length(); currow++) {
			for (int currcol = 1; currcol <= s1.length(); currcol++) {
				if (s1.charAt(currcol - 1) == s2.charAt(currow - 1)) {
					strg[currow][currcol] = strg[currow - 1][currcol - 1] + 1;
				} else {
					strg[currow][currcol] = Math.max(strg[currow - 1][currcol], strg[currow][currcol - 1]);
				}
			}
		}
		return strg[s2.length()][s1.length()];
	}

	public static void lcsR(int[][] strg, String s1, String s2, int currow, int currcol) {
		if (currow == s2.length() + 1) {
			return;
		}
		if (currcol == s1.length() + 1) {
			lcsR(strg, s1, s2, currow + 1, 1);
		} else {

			if (s1.charAt(currcol - 1) == s2.charAt(currow - 1)) {
				strg[currow][currcol] = strg[currow - 1][currcol - 1] + 1;
			} else {
				strg[currow][currcol] = Math.max(strg[currow - 1][currcol], strg[currow][currcol - 1]);
			}
			lcsR(strg, s1, s2, currow, currcol + 1);
		}
	}

	public static String lcsStrI(int[][] strg, String s1, String s2) {
		String s = "";
		int currow = s2.length();
		int currcol = s1.length();

		while (currow > 0 && currcol > 0) {
			if (s1.charAt(currcol - 1) == s2.charAt(currow - 1)) {
				// strg[currow][currcol] == strg[currow - 1][currcol - 1] + 1
				s = s1.charAt(currcol - 1) + s;
				currow--;
				currcol--;
			} else {
				if (strg[currow - 1][currcol] == strg[currow][currcol]) {
					// s = s2.charAt(currcol-1) + s;
					currow--;
				} else {
					// strg[currow][currcol] = strg[currow][currcol - 1];
					currcol--;
				}
			}
		}
		return s;
	}

	public static void lcsStrR(int[][] strg, String s1, String s2,int currow,	int currcol,String s) {
		if(currcol==0||currow==0){
			System.out.println(s);
			return;
		}
		char t = s1.charAt(currcol-1);
		char t2 = s2.charAt(currow-1);
		if (s1.charAt(currcol - 1) == s2.charAt(currow - 1)) {
			lcsStrR(strg, s1, s2, currow-1, currcol-1,s1.charAt(currcol - 1) + s);
		} else {
			if (strg[currow - 1][currcol] == strg[currow][currcol]) {
				lcsStrR(strg, s1, s2, currow-1, currcol, s);
			} else {
				lcsStrR(strg, s1, s2, currow, currcol-1, s);
			}
		}
		//return s;
	}
	public static void lcstringI(String [] s, int x, int y){
		 int[][] strg = new int[s[y].length()+1][s[x].length()+1];
		
		 int max =Integer.MIN_VALUE;
		 for(int i = 1; i<=s[y].length(); i++){
			 for(int j = 1; j<=s[x].length();j++){
				 if(s[x].charAt(j-1)==s[y].charAt(i-1)){
					 strg[i][j] = strg[i-1][j-1]+1;
					 if(strg[i][j]>max){
						 max = strg[i][j];
					 }
				 }
				 else{
					 strg[i][j] = 0;
				 }
			 }
		 }
		 System.out.println(max);
	}

}
