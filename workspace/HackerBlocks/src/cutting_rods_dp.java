import java.util.Scanner;

public class cutting_rods_dp {
	
	public static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = scn.nextInt();
		int[] arr = takeinput(n+1);
		/*System.out.println(rods(arr,n,n,0));*/
		System.out.println(cuttingrods(arr,n));
	}
	private static long cuttingrods(int[] rods, int n) {
		long[] sum =new long[n+1];
		sum[0] = 0;
		for(int i = 1;i<=n;i++){
			for(int j = 1; j<=i;j++){
				sum[i] = Math.max(sum[i-j]+rods[j], sum[i]);
			}
		}
		return sum[n];
	}
	private static long rods(int[] arr, int n, int si,long sum) {
		if(si<=0||n<0){
			return 0;
		}
		if(n==0){
			return sum;
		}
		long lf = rods(arr,n-si,si,sum+arr[si]);
		long rf = rods(arr, n, si-1,sum);
		return Math.max(lf, rf);
	}
	public static int[] takeinput(int n) {
//		int n = scn.nextInt();
		int[] rv = null;
		// long n = scn.nextInt();
		rv = new int[n];
		for (int i = 1; i < n; i++) {
			rv[i] = scn.nextInt();
		}
		return rv;
	}
}
