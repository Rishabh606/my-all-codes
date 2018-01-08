package contest;

import java.util.Scanner;

public class google_jam_practise {
	public static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t = scn.nextInt();
		for(int i = 0; i<t; i++){
			int c =i+1;
			System.out.println("Case #" + c + ": " + qual2015_Q1_stand_ovation());
		}
	}
	public static int qual2015_Q1_stand_ovation(){
		int type = scn.nextInt();
		String key = scn.next();
		int [] audi = new int [type+1];  
		int sum =0;
		int count = 0;
		for(int i = 0; i<=type; i++){
			audi[i] = Integer.parseInt(key.substring(i, i+1));
		}
		int k =0;
		while(k<=type){
			if(k>sum){
			count  = count + k-sum;
			sum = sum+audi[k]+k-sum;
			}
			else{
			sum = sum+audi[k];
			}
			k++;
		}
		return count;
	}
}