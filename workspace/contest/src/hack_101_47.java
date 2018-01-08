import java.util.Arrays;
import java.util.Scanner;

public class hack_101_47 {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Perm_poss();
		//MDN();
	   //    Scanner scn = new Scanner(System.in);
	       /* int T = scn.nextInt();
	        for(int a0 = 0; a0 < T; a0++){
	            int xHoop = scn.nextInt();
	            int yHoop = scn.nextInt();
	            int xC = scn.nextInt();
	            int yC = scn.nextInt();
	            int sC = scn.nextInt();
	            int[] x = new int[5];
	            int[] y = new int[5];
	            int[] s = new int[5];
	            for(int a1 = 0; a1 < 5; a1++){
	                x[a1] = scn.nextInt();
	                y[a1] = scn.nextInt();
	                s[a1] = scn.nextInt();
	            }
	            basketball_game(xHoop,yHoop,xC,yC,sC,x,y,s);*/
	        }
	}

	public static void Perm_poss() {
		int m = scn.nextInt();
		int[] s = new int[m];
		for (int s_i = 0; s_i < m; s_i++) {
			s[s_i] = scn.nextInt();
		}
		Arrays.sort(s);
		for (int i = 0; i < s.length - 1; i++) {
			if (s[i] == s[i + 1]) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}

	public static void MDN() {

		int n = scn.nextInt();
		int p = scn.nextInt();
		int q = scn.nextInt();
		int[] a = new int[p];
		for (int a_i = 0; a_i < p; a_i++) {
			a[a_i] = scn.nextInt();
		}
		int[] b = new int[q];
		for (int b_i = 0; b_i < q; b_i++) {
			b[b_i] = scn.nextInt();
		}
		int[] cases = new int[p * q];
		int count = 0;
		for (int i = 0; i < p; i++) {
			for (int j = 0; j < q; j++) {
				cases[count++] = a[i] + b[j];
			}

		}
		count = 1;

		Arrays.sort(cases);
		/*
		 * while (true) { for (int i = 0; i < cases.length; i++) { int t =
		 * cases[i] + count; if (t % n == 0) { break; } if(i==cases.length-1){
		 * System.out.println(count); return; } } count++; }
		 */
		int[] rem = new int[p * q];
		for (int i = 0; i < cases.length; i++) {
			rem[i] = cases[i] % n;
		}
		while (count <= n) {
			for (int i = 0; i < rem.length; i++) {
				int t = rem[i] + count;
				if 2(t % n == 0) {
					break;
				}
				if (i == cases.length - 1) {
					System.out.println(count);
					return;
				}
			}
			count++;
		}
	}

	public static void basketball_game(int xHoop, int yHoop,int xC,int yC,int sC,int[]x, int[]y,int[]s) {
		for(int i = 0; i<x.length;i++){
			x[i] = (x[i]-xHoop)*(x[i]-xHoop);
			y[i] = (y[i]-yHoop)*(y[i]-yHoop);
		}
		xC = (xC-xHoop)*(xC-xHoop);
		yC = (yC-yHoop)*(yC-yHoop);
		double ball = (double)(xC+yC)/(double)(sC*sC);
		double min = Integer.MAX_VALUE;
		double [] dist = new double[x.length];
		for(int i = 0; i<x.length;i++){
			dist[i] = (double)(x[i]+y[i])/(double)(s[i]*s[i]);
			min = Math.min(min, dist[i]);
		}
		//System.out.println(min);
		if(ball<=min){
			System.out.println("YES");
		}
		else{
			System.out.println("NO");
		}
	}
}
