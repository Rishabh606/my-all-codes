package contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class weekofcode31 {
	public static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*if(beautiful_word()){
			System.out.println("Yes");
		}
		else{
			System.out.println("No");
		}*/
		  int g = scn.nextInt();
		 for(int a0 = 0; a0 < g; a0++){
	           
	            zero_one_game2();
		 }
	}
	public static boolean beautiful_word(){
		String str = scn.next();
		for(int i= 0; i<str.length()-1;i++){
			if(str.charAt(i)==str.charAt(i+1)){
				return false;
			}
			if(str.charAt(i)=='a'||str.charAt(i)=='e'||str.charAt(i)=='i'||str.charAt(i)=='o'||str.charAt(i)=='u'||str.charAt(i)=='y'){
				if(str.charAt(i+1)=='a'||str.charAt(i+1)=='e'||str.charAt(i+1)=='i'||str.charAt(i+1)=='o'||str.charAt(i+1)=='u'||str.charAt(i+1)=='y'){
					return false;
				}
			}
		}
		return true;
	}
	public static void zero_one_game(){
		 int n = scn.nextInt();
         ArrayList<Integer>br = new ArrayList<>();
         int counter = 0;
         for(int i=0; i < n; i++){
             br.add(scn.nextInt());
            	while(br.size()>=3 && br.get(br.size()-1)==br.get(br.size()-3) && br.get(br.size()-1)==0){
            		br.remove(br.size()-2);
            		counter++;
            	}
         }
         if(counter%2==0){
        	 System.out.println("Bob");
         }
         else{
        	 System.out.println("Alice");
         }
        
	}
	public static void zero_one_game2(){
		 int n = scn.nextInt();
         int[] arr = new int[n];
         Arrays.fill(arr, -1);
         int counter = 0;
         for(int i=0, t = 0; t < n; t++,i++){
             arr[i] = scn.nextInt();
             if(i>=2){
            	while(arr[i]==arr[i-2] && arr[i]==0){
            		arr[i-1]=arr[i];
            		arr[i] = -1;
            		i--;
            		counter++;
            		if(i<2){
            			break;
            		}
            	}
             }
         }
         if(counter%2==0){
        	 System.out.println("Bob");
         }
         else{
        	 System.out.println("Alice");
         }
	}
}
