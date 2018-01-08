package contest;

import java.util.Scanner;

public class google_jam_2017_1B {

	public static Scanner scn = new Scanner(System.in);

	static int flag = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t = scn.nextInt();
		for (int i = 1; i <= t; i++) {
			// System.out.print("Case #" + i + ": ");
			// CruiseControl();
			Unicorn(i);
		}
	}

	public static void CruiseControl() {
		int D = scn.nextInt();
		int N = scn.nextInt();
		double T = 0;
		for (int i = 0; i < N; i++) {
			int K = scn.nextInt();
			int S = scn.nextInt();
			double temp = (double) (D - K) / (double) S;
			T = Math.max(T, temp);
		}
		System.out.println((double) D / T);
	}

	public static void Unicorn(int j) {
		int[] num = new int[6];
		int N = scn.nextInt();
		for (int i = 0; i < 6; i++) {
			num[i] = scn.nextInt();
		}
		int[] RYB = new int[3];
		RYB[0] = num[0];
		RYB[1] = num[2];
		RYB[2] = num[4];
		flag = 0;
		System.out.print("Case #" + j + ": ");
		Stable(N, RYB, 0, "", -1);
		if (flag == 0) {
			System.out.println("IMPOSSIBLE");
		}
	}

	public static void Stable(int N, int[] RYB, int count, String osf, int index) {
		if (flag == 1) {
			return;
		}
		if (count == N) {
			if (osf.charAt(0) != osf.charAt(N - 1)) {
				System.out.println(osf);
				flag = 1;
			}
			return;
		}
		if (index == 0 || index == -1) {
			if (RYB[1] != 0) {
				RYB[1]--;
				Stable(N, RYB, count + 1, osf + "Y", 1);
				RYB[1]++;
			}
			if (RYB[2] != 0) {
				RYB[2]--;
				Stable(N, RYB, count + 1, osf + "B", 2);
				RYB[2]++;
			}
		}
		if (index == 1 || index == -1) {
			if (RYB[0] != 0) {
				RYB[0]--;
				Stable(N, RYB, count + 1, osf + "R", 0);
				RYB[0]++;
			}
			if (RYB[2] != 0) {
				RYB[2]--;
				Stable(N, RYB, count + 1, osf + "B", 2);
				RYB[2]++;
			}
		}
		if (index == 2 || index == -1) {
			if (RYB[1] != 0) {
				RYB[1]--;
				Stable(N, RYB, count + 1, osf + "Y", 1);
				RYB[1]++;
			}
			if (RYB[0] != 0) {
				RYB[0]--;
				Stable(N, RYB, count + 1, osf + "R", 0);
				RYB[0]++;
			}
		}

	}
}
