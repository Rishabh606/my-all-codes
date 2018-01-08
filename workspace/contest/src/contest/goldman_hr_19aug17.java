package contest;

import java.util.Arrays;
import java.util.Scanner;

public class goldman_hr_19aug17 {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		/*
		 * int q = scn.nextInt(); for(int a0 = 0; a0 < q; a0++){ int n =
		 * scn.nextInt(); int k = scn.nextInt(); int x = scn.nextInt(); int d =
		 * scn.nextInt(); int[] p = takeinput(n); String result =
		 * feeOrUpfront(n, k, x, d, p); System.out.println(result); }
		 */
		/*int n = scn.nextInt();
		pair[] arr = new pair[n];
		for (int arr_i = 0; arr_i < n; arr_i++) {
			arr[arr_i] = new pair();
			arr[arr_i].price = scn.nextInt();
			arr[arr_i].pos = arr_i+1;
		}
		long k = scn.nextLong();
		long result = buyMaximumProducts(n, k, arr);
		System.out.println(result);*/
	        int q = scn.nextInt();
	        for(int a0 = 0; a0 < q; a0++){
	            int k = scn.nextInt();
	            int n = scn.nextInt();
	            pair[] arr = new pair[n];
	    		for (int arr_i = 0; arr_i < n; arr_i++) {
	    			arr[arr_i] = new pair();
	    			arr[arr_i].price = scn.nextInt();
	    			arr[arr_i].pos = arr_i+1;
	    		}
	            int result = traderProfit(k, n, arr);
	            System.out.println(result);
	        }

	}

	public static int traderProfit(int k, int n, pair[] arr) {
		// TODO Auto-generated method stub
		Arrays.sort(arr);
		for(int i= 0; i<n && k>=0;i++){
			int left = i;
			int right = arr.length-1;
			
		}
		return 0;
	}

	public static int[] takeinput(int n) {
		int[] rv = null;
		// long n = scn.nextInt();
		rv = new int[n];
		for (int i = 0; i < n; i++) {
			rv[i] = scn.nextInt();
		}
		return rv;
	}

	public static String feeOrUpfront(int n, int k, int x, int d, int[] arr) {
		double sum = 0;

		for (int i = 0; i < n; i++) {
			sum += Math.max(k, arr[i] * 0.01 * x);
		}
		if (sum <= d) {
			return "fee";
		}
		return "upfront";
	}

	public static long buyMaximumProducts(int n, long k, pair[] arr) {
		// TODO Auto-generated method stub
		Arrays.sort(arr);
		long sum = 0;
		for (int i = 0; i < n; i++) {
			if ((long)arr[i].price * (long)arr[i].pos <= k) {
				k -= (long)arr[i].price * (long)arr[i].pos;
				if (k < 0) {
					break;
				}
				sum += arr[i].pos;
			}
			/* else if (k < arr[i].price) {
				break;
			}*/ 
			else {
				/*double q = (double)(arr[i].price * arr[i].pos) /(double) k;
				if(Math.floor(q)==q){
					k -= arr[i].price * arr[i].pos / q;
					if (k < 0) {
						break;
					}
					sum += arr[i].pos / q;
				}else{
					k -= arr[i].price * arr[i].pos / ((int)q+1);
					if (k < 0) {
						break;
					}
					sum += arr[i].pos / ((int)q+1);
				}*/
				for(int j =0; j<arr[i].pos && k>=arr[i].price;j++){
					sum++;
					k-=arr[i].price;
				}
			}
		}
		return sum;
	}
	
}

class pair implements Comparable<pair> {
	int price;
	int pos;

	@Override
	public int compareTo(pair o) {
		// TODO Auto-generated method stub
		return this.price - o.price;
	}
}