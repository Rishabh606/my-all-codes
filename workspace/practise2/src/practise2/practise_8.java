package practise2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class practise_8 {
	public static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	String s1 = scn.nextLine();
	//	int[] arr = takeinput();
		// ArrayList<Integer> br =  uniSS(s1);
		// searcher(arr,br);
		//Arrays.sort(arr);
		//int key = scn.nextInt();
		//getSS(arr, 0, 0, "", key);
		//grader();
		//countQmoves();
		System.out.println((int)((double)1/(double)0));
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
	public static int[][] takeinput2d(int rows) {
		int[][] rv = null;
		rv = new int[rows][];

		for (int i = 0; i < rows; i++) {
			rv[i] = new int[2];
		}
		for(int i = 0; i<rv.length;i++)
		{
			for(int j = 0; j<2;j++)
			{
				 rv[i][j] = scn.nextInt();
			}
		}
		
		return rv;
	}
	
	public static void countQmoves(){
		int bsize = scn.nextInt();
		int obsno = scn.nextInt();
		int Qh = scn .nextInt();
		int Qv = scn.nextInt();
		int sum = 0;
		int [][] obspos = takeinput2d(obsno);
		int flag1 = 0, flag2=0;
		int closest1 = 0,closest2 = bsize+1; 
		for(int i = 0; i <obsno;i++){
			if(Qh==obspos[i][0]){
				if(obspos[i][1]> closest1 && Qv>obspos[i][1]){
					sum = 0;
					flag1 =0;
				}
				else if(obspos[i][1]< closest2 && Qv<obspos[i][1]){
					sum = 0;
					flag2 =0;
				}
				if(Qv>obspos[i][1]&&flag1==0){
					closest1 = obspos[i][1];
					sum = sum + Qv-obspos[i][1]-1;
					flag1 = 1;
				}
				else if(Qv<obspos[i][1]&&flag2==0){
					closest2 = obspos[i][1];
					sum = sum + obspos[i][1]-Qv-1; 
					flag2=1;
				}
			}
			/*if(Qv==obspos[i][1]){
				if(Qh>obspos[i][0]){
					sum = sum + Qh-obspos[i][0]-1; 
				}
				else{
					sum = sum + obspos[i][0]-Qh-1; 
				}*/
			System.out.println(sum);
			}
		}
	public static  ArrayList<Integer> uniSS(String s){
		ArrayList<Integer> br = new ArrayList<>();
		for(int i = 0; i<s.length();i++){
			//br.add((int)s.charAt(i)-'a'+1);
			int sum = 0;
		//	int flag = 0;
			sum = (int)s.charAt(i)-'a'+1;
			/*if(i==s.length()-1){
				br.add(sum);
			}*/
			while(i<=s.length()-1){
				br.add(sum);
				if(i==s.length()-1){
					break;
				}
				if(s.charAt(i)!=s.charAt(i+1)){
					break;
				}
				else{
					sum = sum + (int)s.charAt(i)-'a'+1;
					i++;
					//flag =1;
				}
			}
			/*if(flag!=0){
			br.add(sum);
			}*/
		}
		return br;
	}
	public static void searcher(int[] arr, ArrayList<Integer> br){
		int []arr2 = new int[br.size()];
		for(int i = 0; i<arr2.length;i++){
			arr2[i] = br.get(i);
		}
		Arrays.sort(arr2);
		for(int i = 0; i<arr.length;i++){
			if(Arrays.binarySearch(arr2, arr[i])>=0){
				System.out.println("Yes");
			}
			else{
				System.out.println("No");
			}
		}
	}
	public static void grader(){
		int[] rv = null;
		int n = scn.nextInt();
		rv = new int[n];
		int[] arr = new int [n];
		for (int i = 0; i < n; i++) {
			rv[i] = scn.nextInt();
			if(rv[i]<38){
				arr[i] = rv[i];
			}
			else{
				if(rv[i]%5>=3){
					arr[i] = rv[i]-(rv[i]%5)+5;
				}
				else{
					arr[i] = rv[i];
				}
			}
		}
		for(int i = 0; i<arr.length;i++){
			System.out.println(arr[i]);
		}
	}
	
	/*public static void getSS(int[] arr, int hi, int lo , int key) {
		 ArrayList<Integer> br = new ArrayList<Integer>();
		int high = arr[hi],  low = 0;
		if(br.isEmpty()){
			br.add(high);
		}
		
		if(lo>=hi){
			return;
		}
		if(lo>-1){
			 low = arr[lo];
			br.add(low);
		}
		if (sum_arr(br) == key) {
			hi--;
			lo++;
			System.out.println(br);
			while(br.size()!=0){
			br.remove(0);
			}
			 getSS(arr, hi-1, 0 ,key);
		}
		if (sum_arr(br) > key) {
			br.remove(br.size()-1);
			 getSS(arr, hi, lo+1 ,key);
		}
		if (sum_arr(br) < key) {
			 getSS(arr, hi, lo+1 ,key);
		}
		
	}*/
	public static int sum_arr(ArrayList<Integer>list){
		int sum = 0;
		for(int i = 0; i<list.size();i++){
			sum = sum + list.get(i);
		}
		return sum;
	}
	public static void getSS(int[] arr, int sum, int i, String osf, int key){
		if (sum == key) {
			System.out.println(osf+"END");
			return;
		}
		if (sum > key) {
			return;
		}
		for (int dice = i; dice <= arr.length; dice++) {
			getSS(arr,sum+arr[i],dice,  arr[dice] + "," + osf, key);
		}
	}
	public static void stacks(){
		LinkedList ll = new LinkedList();
		
	}
}
