import java.math.BigInteger;
import java.util.Scanner;

public class contest1 {

	public static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int n = scn.nextInt();
//		System.out.println(fact(n));
		//comb();
		//pascaltriangle();
		//GCD();
		mindigitconv();
		/*int a = scn.nextInt();
		int b= scn.nextInt();
		System.out.println(gcd(a,b));*/
	//	factsumer();
	}
	public static void pascaltriangle(){
		int n = scn.nextInt();
		for(int r = 0;r<=n;r++){
			for(int sc = n; sc>=r;sc--){
				System.out.print("	");
			}
			int k = 1;
			for(int nc = 0; nc <=r;nc++){
				if(nc==0){
					System.out.print(1+" ");
				}else{
					 k = (int)(((double)(r-nc+1)/(double)(nc))*k);
				System.out.print(k+" ");
				}
			}
			System.out.println();
		}
	}
	public static BigInteger fact(int n, int m){
		if(n==0||n==1){
			return BigInteger.ONE;
		}
		BigInteger N = BigInteger.valueOf(n);
		for(int i = n;i>1;i--){
			N = N.multiply(BigInteger.valueOf(i-1));
		}
//		System.out.println(N);
		return N;
	}
	public static void Bigcomb(){
		int n = scn.nextInt();
		int r = scn.nextInt();
		BigInteger N = BigInteger.valueOf(n);
		if(n==0||n==1){
			N = BigInteger.ONE;
		}
		for(int i = n;i>n-r+1;i--){
			N = N.multiply(BigInteger.valueOf(i-1));
		}
		BigInteger R = fact(r);
		BigInteger C = N.divide(R);
		System.out.println(C.mod(BigInteger.valueOf(1000000007)));
	}
	public static void comb(){
		int n = scn.nextInt();
		int r = scn.nextInt();
		double N = 1;
		int j = r;
		if(r==0){
			j = 1;
		}
		int i = n;
		while(i>n-r|| j>1){
			if(j==0){
				j=1;
			}
			if(i==0){
				i =1;
			}
			N = (double)(N*(double)(i))/(double)j;
			if(j>1){
				j--;
			}
			if(i>n-r){
				i--;
			}
		}
		System.out.println((long)N%(1000000007));
		//986867079
	}
	public static void GCD(){
		BigInteger N = scn.nextBigInteger();
		BigInteger M = scn.nextBigInteger();
		System.out.println(N.gcd(M));
	}
	public static void mindigitconv(){
		String str = scn.next();
		char[] s = str.toCharArray();
		int i = 0;
		if(s[0]=='9'){
			i =1;
		}
		for(i = i; i<str.length();i++){
			int k = Integer.parseInt(""+s[i]);
			if(k>(9-k)){
				k = 9-k;
				s[i] =  (char)('0'+k);
			}
		}
		String m = String.valueOf(s);		
				System.out.println(m);
	}
	public static int gcd(int a, int b)
	{
	    if (a == 0)
	        return b;
	    return gcd(b%a, a);
	}
	public static long fact (int n){
		if(n==0||n==1){
			return 1;
		}
		long N = 1;
		for(int i = n;i>0;i--){
			N = N*i;
		}
//		System.out.println(N);
		return N;
	}
	public static void factsumer(){
		int n = scn.nextInt();
		long sum = 0;
		for(int i = 0; i<n; i++){
			sum+=fact(scn.nextInt());	
		}
		System.out.println(sum%107);
	}
	
}
