package Stacks;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class stock_span_problem {
	
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = scn.nextInt();
		int[] arr = takeinput(n);
		SSP1(arr);
	}
	public static int[] takeinput(int n) {
		int[] rv = null;
		rv = new int[n];
		for (int i = 0; i < n; i++) {
			rv[i] = scn.nextInt();
		}
		return rv;
	}
	private static class diapair{
		int data;
		int count;
	}
	//my method
	public static void SSP1(int[] arr){
		LinkedList<diapair> stack = new LinkedList<>();
		HashMap<Integer, Integer> sol = new HashMap<>();
		for(int i = 0; i<arr.length;i++){
			int counter  = 1;
			while (!stack.isEmpty() && arr[i] > stack.get(0).data) {
				diapair nd = stack.pop();
				counter+=nd.count;
				sol.put(nd.data, nd.count);
			}
			diapair nd = new diapair();
			nd.data=arr[i];
			nd.count = counter;
		stack.addFirst(nd);
		}
		while(!stack.isEmpty()){
			diapair nd = stack.pop();
			sol.put(nd.data, nd.count);
		}
		for(int key:arr){
			System.out.println(key+" ---> "+ sol.get(key));
		}
	}

}
