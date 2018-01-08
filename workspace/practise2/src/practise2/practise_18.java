package practise2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class practise_18 {
	
	public static Scanner scn = new Scanner(System.in);
	
	static int count = 0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr =takeinput();
		System.out.println(count_split_array(arr, 0,0, 0));
		split_array(arr, 0,0,0,"Start", "Start");
		System.out.println("[");
		split_array2(arr, 0,0,0,"Start", "Start");
		System.out.println("]");
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

	public static int count_split_array(int[] arr ,int si,int sum_group1, int sum_group2){
		if(si==arr.length){
			if(sum_group1==sum_group2){
				return 1;
			}
			return 0;
		}
		int total = count_split_array(arr, si+1, sum_group1+arr[si], sum_group2);
		total = total + count_split_array(arr, si+1, sum_group1, sum_group2+arr[si]);
		return total;
	}
	public static void split_array(int[] arr ,int si,int sum_group1, int sum_group2,String contents_group1,String contents_group2){
		if(si==arr.length){
			if(sum_group1==sum_group2){
				System.out.println(contents_group1+ " and " + contents_group2);
			}
			return;
		}
		split_array(arr, si+1, sum_group1+arr[si], sum_group2, contents_group1+", "+ arr[si], contents_group2);
		split_array(arr, si+1, sum_group1, sum_group2+arr[si], contents_group1, contents_group2+", "+arr[si]);
	}
	public static void split_array2(int[] arr ,int si,int sum_group1, int sum_group2,String contents_group1,String contents_group2){
		if(si==arr.length){
			if(sum_group1==sum_group2){
				if(count!=0){
					System.out.println(",");
				}
				System.out.println(contents_group1+ " and " + contents_group2);
				count++;
			}
			return;
		}
		split_array2(arr, si+1, sum_group1+arr[si], sum_group2, contents_group1+", "+ arr[si], contents_group2);
		split_array2(arr, si+1, sum_group1, sum_group2+arr[si], contents_group1, contents_group2+", "+arr[si]);
	}
	/*public static ArrayList<String> SplitarrSS(int[] arr ,int si,int sum_group1, int sum_group2,ArrayList<Integer> contents_group1,String contents_group2) {
		if (si == arr.length) {
			if(sum_group1==sum_group2){
				ArrayList<Integer> br = new ArrayList<>();
				return br;
			}
			ArrayList<Integer> br = new ArrayList<>();
			return br;
		}
		char ch = ;
		ArrayList<String> recres = PermSS(s1.substring(1));
		ArrayList<String> myres = new ArrayList<>();
		for (int i = 0; i < recres.size(); i++) {
			String mystr = recres.get(i);
			for (int j = 0; j <= mystr.length(); j++) {
				myres.add(mystr.substring(0, j) + ch + mystr.substring(j));
			}
		}
		return myres;
	}*/
	
}
