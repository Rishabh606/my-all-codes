package contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class WOC32 {

	public static Scanner scn = new Scanner(System.in);
	static int time = -1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * int q = scn.nextInt(); int[] x = new int[q]; int max_x =
		 * Integer.MIN_VALUE; for (int a0 = 0; a0 < q; a0++) { x[a0] =
		 * scn.nextInt(); max_x = Math.max(max_x, x[a0]); } String s =
		 * duplicate(max_x); for (int i = 0; i < q; i++) {
		 * System.out.println(s.charAt(x[i])); }
		 */
		/*
		 * int n = scn.nextInt(); int hit = scn.nextInt(); int t =
		 * scn.nextInt(); int[] h = new int[n]; for(int h_i=0; h_i < n; h_i++){
		 * h[h_i] = scn.nextInt(); } int result = getMaxMonsters(n, hit, t, h);
		 * System.out.println(result);
		 */
		/*
		 * int n = scn.nextInt(); int s = scn.nextInt(); int t = scn.nextInt();
		 * int r_0 = scn.nextInt(); int g = scn.nextInt(); int seed =
		 * scn.nextInt(); int p = scn.nextInt(); int[] r = new int[n]; int r_n =
		 * r_calculator(r_0, g, seed, p, n - 1, r); int[] strg = new int[n];
		 * circularWalkDP(n, s, t, 0, r, strg);
		 */
		/*
		 * if (time == Integer.MAX_VALUE) { time = -1; }
		 */
		/*
		 * int min = Integer.MAX_VALUE; for (int i = 0; i < strg.length; i++) {
		 * if (strg[i] != -1 && strg[i]!=0) { min = Math.min(min, strg[i]); } }
		 */
		// System.out.println(strg[0]-1);
		int n = scn.nextInt();
		String s = scn.next();
		int result = geometricTrick(s);
		System.out.println(result);
	}

	public static int geometricTrick(String s) {
		ArrayList<Integer> cont_a = new ArrayList<>();
		ArrayList<Integer> cont_b = new ArrayList<>();
		ArrayList<Integer> cont_c = new ArrayList<>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a') {
				cont_a.add(i);
			} else if (s.charAt(i) == 'b') {
				cont_b.add(i);
			} else if (s.charAt(i) == 'c') {
				cont_c.add(i);
			}
		}
		int[] arr = { cont_a.size(), cont_b.size(), cont_c.size() };
		ArrayList<Integer> first_short = new ArrayList<>();
		ArrayList<Integer> sec_short = new ArrayList<>();
		ArrayList<Integer> biggest = new ArrayList<>();
		int count = 0;
		int[] big = new int[s.length()];

		Arrays.sort(arr);
		if (cont_a.size() == arr[0]) {
			first_short = cont_a;
			if (cont_b.size() == arr[1]) {
				sec_short = cont_b;
				biggest = cont_c;
				for (int i = 0; i < biggest.size(); i++) {
					big[biggest.get(i)] = 1;
				}
				for (int i = 0; i < first_short.size(); i++) {
					for (int j = 0; j < sec_short.size(); j++) {
						double k = ((double) (cont_b.get(j) + 1) * (cont_b.get(j) + 1) / (double) (cont_a.get(i) + 1))
								- 1;
						if ((k == Math.floor(k)) && !Double.isInfinite(k)) {
							if (k >= 0 && k < big.length) {
								if (big[(int) k] == 1) {
									count++;
								}
							}
						}
					}
				}
			} else {
				sec_short = cont_c;
				biggest = cont_b;
				for (int i = 0; i < biggest.size(); i++) {
					big[biggest.get(i)] = 1;
				}
				for (int i = 0; i < first_short.size(); i++) {
					for (int k = 0; k < sec_short.size(); k++) {
						double j = -1 + Math.pow((cont_a.get(i) + 1) * (cont_c.get(k) + 1), 0.5);
						if ((j == Math.floor(j)) && !Double.isInfinite(j)) {
							if (j >= 0 && j < big.length) {
								if (big[(int) j] == 1) {
									count++;
								}
							}
						}
					}
				}
			}
		} else if (cont_b.size() == arr[0]) {
			first_short = cont_b;
			// fir_short = 'b';
			if (cont_c.size() == arr[1]) {
				sec_short = cont_c;
				biggest = cont_a;
				for (int i = 0; i < biggest.size(); i++) {
					big[biggest.get(i)] = 1;
				}
				for (int j = 0; j < first_short.size(); j++) {
					for (int k = 0; k < sec_short.size(); k++) {
						double i = ((double) (cont_b.get(j) + 1) * (cont_b.get(j) + 1) / (double) (cont_c.get(k) + 1))
								- 1;
						if ((i == Math.floor(i)) && !Double.isInfinite(i)) {
							if (i >= 0 && i < big.length) {
								if (big[(int) i] == 1) {
									count++;
								}
							}
						}
					}
				}
			} else {
				sec_short = cont_a;
				biggest = cont_c;
				for (int i = 0; i < biggest.size(); i++) {
					big[biggest.get(i)] = 1;
				}
				for (int j = 0; j < first_short.size(); j++) {
					for (int i = 0; i < sec_short.size(); i++) {
						double k = ((double) (cont_b.get(j) + 1) * (cont_b.get(j) + 1) / (double) (cont_a.get(i) + 1))
								- 1;
						if ((k == Math.floor(k)) && !Double.isInfinite(k)) {
							if (k >= 0 && k < big.length) {
								if (big[(int) k] == 1) {
									count++;
								}
							}
						}
					}
				}
			}
		} else if (cont_c.size() == arr[0]) {
			first_short = cont_c;
			if (cont_b.size() == arr[1]) {
				sec_short = cont_b;
				biggest = cont_a;
				for (int i = 0; i < biggest.size(); i++) {
					big[biggest.get(i)] = 1;
				}
				for (int k = 0; k < first_short.size(); k++) {
					for (int j = 0; j < sec_short.size(); j++) {
						double i = ((double) (cont_b.get(j) + 1) * (cont_b.get(j) + 1) / (double) (cont_c.get(k) + 1))
								- 1;
						if ((i == Math.floor(i)) && !Double.isInfinite(i)) {
							if (i >= 0 && i < big.length) {
								if (big[(int) i] == 1) {
									count++;
								}
							}
						}
					}
				}
			} else {
				sec_short = cont_a;
				biggest = cont_b;
				for (int i = 0; i < biggest.size(); i++) {
					big[biggest.get(i)] = 1;
				}
				for (int k = 0; k < first_short.size(); k++) {
					for (int i = 0; i < sec_short.size(); i++) {
						double j = -1 + Math.pow((cont_a.get(i) + 1) * (cont_c.get(k) + 1), 0.5);
						if ((j == Math.floor(j)) && !Double.isInfinite(j)) {
							if (j >= 0 && j < big.length) {
								if (big[(int) j] == 1) {
									count++;
								}
							}
						}
					}
				}
			}
		}
		return count;
	}

	static int getMaxMonsters(int n, int hit, int t, int[] h) {
		// Complete this function
		int count = 0;
		double log_n = Math.log10(n);
		if (log_n <= t) {
			Arrays.sort(h);
			for (int i = 0; i < t; i++) {
				h[count] = h[count] - hit;
				if (h[count] <= 0) {
					count++;
				} else {
					continue;
				}
			}
		} else {
			int[] new_h = new int[t];
			for (int i = 0; i < t; i++) {
				int min = Integer.MAX_VALUE;
				for (int j = i; j < n; j++) {
					if (h[j] <= min) {
						int x = h[j];
						h[j] = h[i];
						h[i] = x;
						min = h[j];
					}
				}
				new_h[i] = min;
			}
			for (int i = 0; i < t; i++) {
				new_h[count] = new_h[count] - hit;
				if (new_h[count] <= 0) {
					count++;
				} else {
					continue;
				}
			}
		}

		return count;
	}

	static void circularWalk(int n, int s, int t, int clock, int[] r) {
		// Complete this function
		if (clock == n) {
			return;
		}
		if (s % n == t) {
			time = Math.min(time, clock);
			return;
		}
		for (int i = -r[s]; i <= (r[s]); i++) {
			if (i != 0) {
				if ((s + i) < 0) {
					circularWalk(n, n + (s + i) % n, t, clock + 1, r);
				} else {
					circularWalk(n, (s + i) % n, t, clock + 1, r);
				}
			}
		}
		return;
	}

	static int circularWalkDP(int n, int s, int t, int clock, int[] r, int[] strg) {
		// Complete this function
		if (strg[s] != 0) {
			return strg[s];
		}
		if (clock == n) {
			return -1;
		}
		if (s % n == t) {
			return 1;
		}
		if (r[s] == 0) {
			strg[s] = -1;
			return -1;
		}
		for (int i = -r[s]; i <= (r[s]); i++) {
			if (i != 0) {
				int temp = 0;
				if ((s + i) < 0) {
					temp = circularWalkDP(n, n + (s + i) % n, t, clock + 1, r, strg);
				} else {
					temp = circularWalkDP(n, (s + i) % n, t, clock + 1, r, strg);
				}
				if (temp != 0 && temp != -1) {
					if (strg[s] == 0) {
						strg[s] = temp + 1;
					} else {
						strg[s] = Math.min(temp + 1, strg[s]);
					}
				}

			}
		}
		// time = Math.min(strg[s]+clock-1, time);
		return strg[s];
	}

	public static int r_calculator(int r_0, int g, int seed, int p, int n, int[] r) {
		if (n == 0) {
			r[0] = r_0;
			return r_0;
		}
		r[n] = (r_calculator(r_0, g, seed, p, n - 1, r) * g + seed) % p;
		return r[n];
	}

	public static String duplicate(int max_m) {
		String s = "0";
		while (s.length() < max_m) {
			String t = "";
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '0') {
					t = t + "1";
				} else {
					t = t + "0";
				}
			}
			s = s + t;
		}
		System.out.println();
		return s;
	}
}
