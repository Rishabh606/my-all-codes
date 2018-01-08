package collegework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

//Rishabh Gupta
//16CS01018

public class Assign4_Aug24 {

	public static Scanner scn = new Scanner(System.in);
	
	 /*kindly read the readme file attached in mail before opening this file.
	it explains why array is better DS to be used here rather than heap.
	In brief, all operation used here are required to use id. so using index of array as id 
	i store the votes in the array. so all operation will work in O(constant)
	But for correction purposes i have attached heap. 
	THE HEAP FILE ATTACHED IS NOT RELATED TO THIS CODE*/
	
	static ArrayList<Integer> arr;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		arr = new ArrayList<Integer>();
		System.out.println("enter the number of picture you want to put");
		takeinput();
		while(true){
			System.out.println("put 0,1,2,3,4 for insert, upvote, downvote,delete, quit respectively");
			int i = scn.nextInt();
			if(i==0){
				System.out.println("insert initial rating 0-9 inclusive");
			}else if (i==4){
				System.out.println("you have quit program");
				return;
			}else{
				System.out.println("insert id");
			}
			int id = scn.nextInt();
			switch(i){
			case 0 : 
				insert(id);
				break;
			case 1 : 
				upvote(id);
				break;
			case 2 : 
				downvote(id);
				break;
			case 3 : 
				delete(id);
				break;
			case 4: return ;
			}
		}
	}
	
	public static void insert(int ri){
		arr.add(ri);
		System.out.println("id is- "+ (arr.size()-1));
		display();
	}
	
	public static void upvote(int id){
		if(id>=0 && id<arr.size()){
			arr.set(id, arr.get(id)+1);
			display();
		}else{
			System.out.println("invalid input");
		}
	}
	
	public static void downvote(int id){
		if(id>=0 && id<arr.size()){
			arr.set(id, arr.get(id)-1);
			display();
		}else{
			System.out.println("invalid input");
		}
	}
	
	public static void delete(int id){
		if(id>=0 && id<arr.size()){
			arr.set(id, -1);
			display();
		}else{
			System.out.println("invalid input");
		}
	}
	
	public static void takeinput() {
		int n = scn.nextInt();
		for (int i = 0; i < n; i++) {
			arr.add(scn.nextInt());
		}
	}
	public static void display(){
		for(int i = 0; i<arr.size();i++){
			System.out.print("("+i+","+arr.get(i)+")"+" ");
		}
		System.out.println();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
}
