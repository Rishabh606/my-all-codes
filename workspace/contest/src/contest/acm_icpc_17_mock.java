package contest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class acm_icpc_17_mock {

	public static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t = scn.nextInt();
		for(int i=0;i<t;i++)MCAPC();//chef_laptop();
	}
	public static void chef_laptop(){
		int n = scn.nextInt();
		int[] arr = takeinput(n);
		Arrays.sort(arr);
		HashMap <Integer,Integer>map = new HashMap<Integer,Integer>();
		for(int i = 0; i<arr.length-1;i++){
			if(arr[i]!=arr[i+1]){
				if(!map.containsKey(arr[i])){
					System.out.println(arr[i]);
					return;
				}
			}
				map.put(arr[i], 1);
		}
		if(!map.containsKey(arr[n-1])){
			System.out.println(arr[n-1]);
			return;
		}
		return;
	}
	public static void chefsubarrays(){
		int n = scn.nextInt();
		int[] arr = takeinput(n);
		int count = 0;
		for(int i = 0; i<arr.length;i++){
			int sum = 0;
			int prod = 1;
			for(int j = i;j<n;j++){
				sum+=arr[j];
				prod*=arr[j];
				if(sum==prod){
					count++;
				}
			}
		}
		System.out.println(count);
		return;
	}
	public static void MCAPC(){
		int n = scn.nextInt();
		int m = scn.nextInt();
		if(n==2){
			System.out.println(m);
			return;
		}
		if(n==1){
			System.out.println(0);
		}
		int p = (n-1)+(2*(m-1));
		System.out.println(p);
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
}
