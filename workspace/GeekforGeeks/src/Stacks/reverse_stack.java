package Stacks;
import java.util.LinkedList;
import java.util.Scanner;
public class reverse_stack {
	public static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> stack = new LinkedList<>();
		stack.addLast(1);
		stack.addLast(2);
		stack.addLast(3);
		stack.addLast(4);
		for(int key: stack){
			System.out.println(key);
		}
		revrse(stack);
		/*for(int i = 0;i<stack.size();i++){
			int temp = stack.removeFirst();
			System.out.println(temp);
			stack.addLast(temp);
		}*/
		for(int key: stack){
			System.out.println(key);
		}
	}
	public static void revrse(LinkedList<Integer> stack){
		if(stack.isEmpty()){
			return;
		}
		int r = stack.pop();
		revrse(stack);
		stack.addLast(r);
	}
}
