package Lecture12.storystacks;

import java.util.ArrayList;

public class StackClient {

	public static void main(String[] args) throws Exception {
		Stack st = new Stack(7);
		
		for(int i = 0; i < 7; i++){
			st.push(i);
			displayStackInfo(st);
		}
		
//		st.push(10);
		
		while(!st.isEmpty()){
			System.out.println(st.top());
			System.out.println(st.pop());
			displayStackInfo(st);
		}
		
//		System.out.println(st.pop());
//		displayStackInfo(st);
		
		System.out.println("Thanks for using");
	}
	
	public static void displayStackInfo(Stack st){
		System.out.println("Size = " + st.size());
		System.out.println("Empty = " + st.isEmpty());
		st.display();
	}

	public static void insertInStack(Stack st){
		
		
	}
}
