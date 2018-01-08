package contest;

import java.util.Arrays;
import java.util.Scanner;

public class snackdownQf2017 {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t = scn.nextInt();
		for (int i = 0; i < t; i++) {
			int n = scn.nextInt();
			int q = scn.nextInt();
			int[] L = takeinput(n);
			Arrays.sort(L);
			for (int j = 0; j < q; j++) {
				snake_eating(L);
			}

		}
	}

	public static int[] takeinput(int n) {
		int[] rv = null;
		rv = new int[n];
		for (int i = 0; i < n; i++) {
			rv[i] = scn.nextInt();
		}
		return rv;
	}

	public static int binarysearch(int[] arr, int key) {
		int retval = -1, left = 0, right = arr.length - 1;
		int middle = 0;
		if (arr.length == 1) {
			if (arr[0] > key) {
				return 0;
			} else {
				return 1;
			}
		}
		while (left <= right) {
			middle = (left + right) / 2;
			if (key > arr[middle - 1] && key < arr[middle]) {
				retval = middle;
				break;
			}
			if (key > arr[middle] && key < arr[middle + 1]) {
				retval = middle + 1;
				break;
			}

			if (key == arr[middle]) {
				retval = middle;
				break;
			} else if (arr[middle] > key) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}

		}

		return retval;
	}

	public static void snake_eating(int[] L) {
		int k1 = scn.nextInt();
		int k2 = scn.nextInt();

		int pos1 = binarysearch(L, k1);
		int pos2 = binarysearch(L, k1);
		int count1 = L.length - 1 - pos1;
		int count2 = L.length - 1 - pos1;
		
		int[] L1 = new int[pos1];
		int[] Ldupli = new int[L.length];
		for (int i = 0; i < L.length; i++) {
			Ldupli[i]= L[i];
		}
		count1 = count1+maxsnakes(L,Ldupli,pos1,k1,pos1);
	}
	public static int maxsnakes(int[] L,int[] Ld, int pos1, int k, int len,int avl){
		if(len>=k){
			return 1;
		}
		int count = 0;
		for(int i = 0; i<pos1;i++){
			
		}
	}
}
