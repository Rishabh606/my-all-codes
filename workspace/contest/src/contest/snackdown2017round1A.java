package contest;

import java.util.Scanner;

public class snackdown2017round1A {

	public static Scanner scn = new Scanner(System.in);
	
	static int hashes = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t = scn.nextInt();

		for (int i = 0; i < t; i++) {
			// team_member();
		/*	int[] heights = takeinput();
			templesnakes2(heights);*/
			hashes = 0;
			isitsnake();
		}
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

	public static int[][] takeinput(int rows, int cols) {
		int[][] rv = new int[rows+2][cols+2];

		for (int i = 1; i < 3; i++) {
			String t = scn.next();
			int count = 0;
			for (int j = 1; j < cols+1; j++) {
				if (t.charAt(count) == '#') {
					rv[i][j] = 1;
					hashes++;
				}
				count++;
			}
		}

		return rv;
	}

	public static void team_member() {
		int n = scn.nextInt();
		int m = scn.nextInt();
		int[][] arr = takeinput(m, 2);
		if ((n - 2 * m) % 2 == 0) {
			System.out.println("yes");
		} else {
			System.out.println("no");
		}
	}

	public static void templesnakes(int[] h) {
		int op = 0;
		int l = h.length;
		int count = 0;
		for (int i = 0; i < l; i++) {

			op = op + h[i] - count - 1;
			if (h[i] - 1 - count < 0) {
				if ((-h[i] + 1 + count) % 2 == 0 || ((-h[i] + 1 + count) % 2 != 0 && l % 2 == 0)) {
					op = op + ((count + 1) * (count + 2) - (h[i]) * (h[i] + 1)) / 2;
					count = h[i] - 1;
					l = l - count - 1;
				} else {
					op = op + 1 + ((count + 1) * (count + 2) - (h[i]) * (h[i] + 1)) / 2;
					count = h[i];

					l = l - count - 1;
				}
			}
			if (count >= l / 2) {
				count--;
			} else {
				count++;
			}
		}
		System.out.println(op);
	}

	public static void templesnakes2(int[] h) {
		// int[] temple = new int[h.length];
		int op = 0;
		int l = h.length;
		// int hilltop1 = 0;
		int count = 1;
		int flag = 0;
		for (int i = 0; i < h.length; i++) {
			// handle initial zeroes
			if (count < 0) {
				count = 0;
			}
			int m = h[i] - count;
			op = op + m;
			if (m < 0) {
				// op = 0;
				// i = i+1-h[i];
					op = op + ((count) * (count + 1) - (h[i]) * (h[i] + 1)) / 2;
					// i = h[i]-1;
					count = h[i];
					// count = i;
					l = l - count+1;
			}
			if (i-(h.length-l) >= l / 2 ) {
				count--;
			} else {
				count++;
			}
			/*if (l % 2 == 0) {
				if (i-(h.length-l) >= l / 2 ) {
					count--;
				} else {
					count++;
				}
			}else{
				if (i-(h.length-l) > l / 2 ) {
					count--;

				} else {
					count++;
				}
			}*/
		}
		System.out.println(op);
		/*
		 * int op2 = 0; int l2 = h.length; int hilltop2 = 0; for (int i = l2-1;
		 * i>= l2 / 2; i--) { // handle initial zeroes op = op + h[i] - (l2-i-1)
		 * - 1; if (h[i] - 1 - (l2-i-1) < 0) { // op = 0; // i = i+1-h[i]; if
		 * ((-h[i] + 1 + (l2-i)) % 2 == 0) { op = op + (((l2-i-1) + 1) *
		 * ((l2-i-1) + 2) - (h[i]) * (h[i] + 1)) / 2; i = h[i]; l2 = l2 -
		 * (l2-i-1); } else { op = op + 1 + (((l2-i-1) + 1) * ((l2-i-1) + 2) -
		 * (h[i]) * (h[i] + 1)) / 2; i = h[i] + 1; l2 = l2 - (l2-i-1); } }
		 * hilltop2 = h[i]; } if(hilltop1<=hilltop2){ int count = l/2-1; for(int
		 * i = l/2+1;i<l;i++){ op = op + h[i] - count; count--; } }else{
		 * 
		 * } }
		 */
	}

	public static void isitsnake(){
		int n = scn.nextInt();
		int[][] arr = takeinput(2, n);
		boolean rv = false;
		int I =0;
		int J = 0;
		int flag =1;
		for(int i= 1; i<3;i++){
			for(int j = 1; j<n;j++){
				if(arr[i][j]==1){
					rv = true;
					I = i;
					J = j;
					flag =0;
					break;
				}
			}
			if(flag==0){
				break;
			}
		}
		rv = is_snake(arr, I, J, 1,0);
		if(rv==false){
			System.out.println("no");
		}else{
			System.out.println("yes");
		}
		hashes = 0;
	}

	public static boolean is_snake(int[][] arr, int i, int j, int count, int flag){
		if(count==hashes){
			return true;
		}
		if(arr[i][j]==0){
			return false;
		}
		boolean rv1 = false;
		boolean rv2 = false;
		boolean rv3 = false;
		int flag1 = 0;
		int flag2 =0;
		int flag3 =0;
		if(arr[i+1][j]==1){
			rv1 = is_snake(arr, i+1, j, count+1,1);
			flag1 =1;
		}
		if(arr[i][j+1]==1){
			rv2 = is_snake(arr, i, j+1, count+1,0);
			flag2=1;
		}
		if(arr[i-1][j]==1 && flag==0){
			rv3 = is_snake(arr, i-1, j, count+1,0);
			flag3 =1;
		}
		boolean rv = false;
		if(flag1==1&&flag2==0&&flag3==0){
			rv = rv1;
		}
		else if(flag1==0&&flag2==1&&flag3==0){
			rv = rv2;
		}
		else if(flag1==0&&flag2==0&&flag3==1){
			rv = rv3;
		}
		
		else if(flag1==0&&flag2==1&&flag3==1){
			rv = rv3&&rv2;
		}
		else if(flag1==1&&flag2==1&&flag3==0){
			rv = rv1&&rv2;
		}
		else if(flag1==1&&flag2==0&&flag3==1){
			rv = rv3&&rv1;
		}
		
		else{
			rv = rv1&&rv2&&rv3;
		}
		return rv;
	}
}
