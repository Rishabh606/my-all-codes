package Stacks;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;
import java.util.HashMap;

public class Next_Greater_Element {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = scn.nextInt();
		int[] arr = takeinput(n);
		NGE(arr);
	}

	public static int[] takeinput(int n) {
		int[] rv = null;
		rv = new int[n];
		for (int i = 0; i < n; i++) {
			rv[i] = scn.nextInt();
		}
		return rv;
	}

	public static void NGE(int[] arr) {
		LinkedList<Integer> stack = new LinkedList<>();
		HashMap<Integer, Integer> sol = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			
				while (!stack.isEmpty() && arr[i] > stack.get(0)) {
					sol.put(stack.pop(), arr[i]);
				}
			stack.addFirst(arr[i]);
		}
		while(!stack.isEmpty()){
			sol.put(stack.pop(), -1);
		}
		//Set<Integer> keys = sol.keySet();
		for(int key:arr){
			System.out.println(key+" ---> "+ sol.get(key));
		}
	}

}
