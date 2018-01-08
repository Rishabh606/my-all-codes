package practise2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;

public class practise_17 {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// array_sum();
		int[] arr = takeinput();
		int target = scn.nextInt();
		Arrays.sort(arr);
		
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
		}
		ArrayList<ArrayList<Integer>> myres = split_array(arr, 0, sum);
		ArrayList<ArrayList<Integer>> sol_arr = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i<myres.size();i++){
			int temp_sum = 0;
			for(int j = 0; j<myres.get(i).size();j++){
				temp_sum+=myres.get(i).get(j);
			}
			if(temp_sum==target){
				sol_arr.add(myres.get(i));
			}
		}
		System.out.println(sol_arr);
		/*if (sum % 2 == 0) {
			ArrayList<ArrayList<Integer>> myres = split_array(arr, 0, sum);
			ArrayList<Integer> sum_arr = new ArrayList<Integer>(myres.size());
			int total = 0;
			for (int i = 0; i < myres.size(); i++) {
				total = 0;
				for (int j = 0; j < myres.get(i).size(); j++) {
					total = total + myres.get(i).get(j);
				}
				if (2*total==sum) {
					sum_arr.add( total);
				} else {
					sum_arr.add(-1);
				}
			}
			for (int i = 0; i < myres.size(); i++) {
				int[] res = new int[arr.length - myres.get(i).size()];
				int count = 0;
				if (sum_arr.get(i) != -1) {
					for (int j = 0; j < arr.length; j++) {
						int key = binarysearch(myres.get(i), arr[j]);
						if (key == -1) {
							res[count] = arr[j];
							count++;
						}
					}
					System.out.print("Start");

					for (int j = 0; j < myres.get(i).size(); j++) {
						System.out.print(", " + myres.get(i).get(j));
					}
					System.out.print(" and Start");
					for (int j = 0; j <res.length; j++) {
						System.out.print(", " + res[j]);
					}
					System.out.println();
				}
			}
		} else {
			System.out.println("-1");
		}*/
	}

	public static void quicksort(ArrayList<Integer> arr, int lo, int hi) {
		int left = lo, right = hi, pivot = (right + left) / 2;
		if (lo >= hi) {
			return;
		}
		while (left <= right) {
			while (arr.get(left) < arr.get(pivot)) {
				left++;
			}
			while (arr.get(right) > arr.get(pivot)) {
				right--;
			}

			if (left <= right) {
				int t = arr.get(left);
				arr.set(left, arr.get(right));
				arr.set(right, t);
				left++;
				right--;
			}
		}
		quicksort(arr, lo, right);
		quicksort(arr, left, hi);
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

	public static void array_sum() {
		int n = scn.nextInt();
		// int[] an = new int[n];
		int num1 = 0;
		int num2 = 0;
		for (int i = 0; i < n; i++) {
			// an[i] = scn.nextInt();
			num1 = 10 * num1 + scn.nextInt();
		}
		int m = scn.nextInt();
		// int[] am = new int[n];
		for (int i = 0; i < m; i++) {
			// am[i] = scn.nextInt();
			num2 = 10 * num2 + scn.nextInt();
		}
		int num = num1 + num2;
		String str = String.valueOf(num);
		for (int i = 0; i < str.length(); i++) {
			System.out.print(str.charAt(i) + ", ");
		}
		System.out.print("END");
	}

	public static ArrayList<ArrayList<Integer>> split_array(int[] arr, int count, int total) {
		if (count == arr.length) {
			ArrayList<ArrayList<Integer>> br = new ArrayList<ArrayList<Integer>>();
			br.add(new ArrayList<Integer>());
			return br;
		}
		int key = arr[count];
		ArrayList<ArrayList<Integer>> recres = split_array(arr, count + 1, total);
		ArrayList<ArrayList<Integer>> myres = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < recres.size(); i++) {
			myres.add(recres.get(i));
			ArrayList<Integer> res = new ArrayList<Integer>(recres.get(i).size());
			for (int j = 0; j < recres.get(i).size(); j++) {
				res.add(recres.get(i).get(j));
			}
			myres.add(res);
			recres.get(i).add(0, key);
		}
		return myres;
	}

	public static int binarysearch(ArrayList<Integer> arr, int key) {
		int retval = -1, left = 0, right = arr.size() - 1;
		int middle = 0;
		if (arr.size() == 1) {
			if (arr.get(0) > key) {
				return 0;
			} else {
				return 1;
			}
		}
		while (left <= right) {
			middle = (left + right) / 2;
			if (key == arr.get(middle)) {
				retval = middle;
				break;
			} else if (arr.get(middle) > key) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}

		}

		return retval;
	}
}