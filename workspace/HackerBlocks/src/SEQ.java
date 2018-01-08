import java.util.Scanner;

public class SEQ {
	
public static Scanner scn = new Scanner (System.in); 
	
	public static void main(String[] args) {
		int C = scn.nextInt();
		for(int i = 0; i<C;i++){
			int k =scn.nextInt();
			long[]b = takeinput(k);
			long[] c = takeinput(k);
			int n = scn.nextInt();
			System.out.println(SEQ(b, c, n, k));
		}

	}
	public static long[] takeinput(int n) {
		long[] rv = null;
		// long n = scn.nextInt();
		rv = new long[n];
		for (int i = 0; i < n; i++) {
			rv[i] = scn.nextLong();
		}
		return rv;
	}

	public static long SEQ(long[]b,long[]c,int n, int k){
		if(n==0){
			return 0;
		}
		if(n<=k){
			return b[n-1];
		}
		long [][] T = new long[k+1][k+1];
		for(int i =1;i<=k;i++){
			for(int j = 1;j<=k;j++){
				if(i<k){
					if((i+1)==j){
						T[i][j] = 1;
					}
				}
				if(i==k){
					T[i][j]=c[k-j];
				}
			}
		}
		T = pow(T,n-1);
		long res = 0;
		for(int i = 1;i<=k;i++){
			res += (T[1][i]*b[i-1])%1000000000;
			res = res%1000000000;
		}
		return res;
	}
	private static long[][] multiply(long[][] arr, long[][] t) {
		// TODO Auto-generated method stub
		long[][] ans = new long[t.length][t[0].length];
		for (int i = 1; i < t.length; i++) {
			for (int j = 1; j < t[0].length; j++) {
				for (int k = 1; k < t[0].length; k++) {
					ans[i][j] = ans[i][j]%1000000000;
					ans[i][j] += (t[i][k]%1000000000 * arr[k][j]%1000000000)%1000000000;
				//	ans[i][j] += (t[k][j]%1000000007 * arr[i][k]%1000000007)%1000000007;
				}
			}
		}
		return ans;
	}
	private static long[][] pow(long[][] arr, int n) {
		// TODO Auto-generated method stub
		if(n<=0){
			long[][] temp = { { 1, 0 ,0 }, { 0, 1 ,0 },{ 0, 0 ,1 }};
			return temp;
		}
		if (n == 1) {
			return arr;
		}
		if ((n & 1) == 0) {
			long[][] a = pow(arr, n / 2);
			return multiply(a, a);
		} else {
			long[][] a = pow(arr, n / 2);
			return multiply(multiply(a, a), arr);
		}
	}
}
