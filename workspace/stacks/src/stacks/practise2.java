package stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class practise2 {
	public static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = scn.nextInt();
		int[] arr1 = takeinput(n);
		int[] arr2 = takeinput(n);
		//ArrayList<Integer> br = new ArrayList<>();
		/*br.add(1);
		br.add(5);
		br.add(3);
		br.add(2);*/
		 //Bsort(br, 0,0);
		 
		 System.out.println(arrintersection(arr1, arr2));
	}
	 public static int[] takeinput(int n) {
			int[] rv = null;
			
			rv = new int[n];
	        
			for (int i = 0; i < n; i++) {
				rv[i] = scn.nextInt();
			}
			return rv;
		}
	public static void Bsort(ArrayList<Integer> arr, int i,int counter){
	    if(counter==arr.size()-1){
	        return;
	    }
	    if(i==arr.size()-counter-1){
	        i = 0;
	      counter++;
	       // Bsort(arr,  0,counter+1);
	        //return;
	    }
	         if(arr.get(i)>=arr.get(i+1)){
	            int t = arr.get(i);
	            arr.set(i, arr.get(i+1));
	            arr.set(i+1, t); 
	    }
	    Bsort(arr,  i+1,counter);
	}
	public static ArrayList<Integer> arrintersection(int[] arr1,int[] arr2){
		ArrayList<Integer> br = new ArrayList<>();
		for(int i = 0; i<=arr1.length-1;i++){
			int t = arr1[i];
		int position = 	linearsearch(arr2,arr1[i]);
		if(position>-1){
			br.add(arr1[i]);
			arr2[position]=-56;
		}
		}
		/*Integer[] arr3 = new Integer[br.size()];
		br.toArray(arr3);*/
		 Bsort(br, 0,0);
		return br;
	}
	public static int linearsearch(int[] arr, int key) {
		int retval = -1, i = 0;
		for (i = 0; i < arr.length; i++) {
			if (key == arr[i]) {
				retval = i;
				break;
			}

		}

		return retval;
	}
}
