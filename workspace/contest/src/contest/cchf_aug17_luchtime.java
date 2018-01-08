package contest;

import java.util.ArrayList;
import java.util.Scanner;

public class cchf_aug17_luchtime {

	public static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*int t1 = scn.nextInt();
		for(int i = 0; i<t1;i++){
			Q1();
		}*/
		int t2 = scn.nextInt();
		for(int i = 0; i<t2;i++){
			Q2();
		}
	}
	
	public static void Q2() {
		// TODO Auto-generated method stub
		int N = scn.nextInt();
		long K = scn.nextLong();
		long big = (long)Math.pow(2, N);
		long[] arr= new long[(int)big];
		for(int i = 0; i<big;i++){
			arr[i] = i; 
		}
		for(int i = 0; i<N;i++){
			
			long rem = big/(long)Math.pow(2, i);
			for(int j =0; j<=big-rem;j = j+(int)rem){
				evener(arr,j,j+(int)rem-1);
			}
		}
		for(int i =0;i<(int)big;i++){
			if(arr[i]==K){
				System.out.println(i);
			}
		}
	}

	public static void evener(long[] arr, int j, int l) {
		ArrayList<Long> even = new ArrayList<Long>();
		ArrayList<Long> odd = new ArrayList<Long>();
		long counter = 0;
		for(long i = j; i<=l;i++){
			if(counter%2==0){
				even.add(arr[(int)i ]);
			}else{
				odd.add(arr[(int)i ]);
			}
			counter++;
		}
		int count= 0;
		for(long i = j; i<=l;i++){
			if(count<even.size()){
				arr[(int)i] = even.get(count);
				count++;
			}else{
				arr[(int)i] = odd.get(count-even.size());
				count++;
			}
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
	
	public static void Q1() {
		long[] arr= takeinput(26);
		int[] strg = new int[26];
		String s = scn.next();
		long sum = 0;
		for(int i = 0;i<s.length();i++){
			strg[s.charAt(i)-'a']++;
		}
		for(int i = 0; i<26;i++){
			if(strg[i]==0){
				sum +=arr[i];
			}
		}
		System.out.println(sum);
	}
	
}
