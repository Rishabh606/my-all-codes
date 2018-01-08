package collegework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Assign2_Aug12_convexhull {

	public static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t = scn.nextInt();
		for(int i = 0; i<t;i++){
			int n = scn.nextInt();
			int[][] arr = takeinput2d(n);
			convexhull(arr);
		}
	}
	public static int[][] takeinput2d(int rows) {
		int[][] rv = null;
		rv = new int[rows][2];
		for(int i = 0; i<rv.length;i++)
		{
			for(int j = 0; j<2;j++)
			{
				 rv[i][j] = scn.nextInt();
			}
		}
		
		return rv;
	}
	public static void convexhull(int[][]arr){
		int  min = Integer.MAX_VALUE;
		int pos = 0;
		for(int i = 0;i<arr.length;i++){
			if(min>arr[i][1]){
				min= arr[i][1];
				pos = i;
			}
			else if(min==arr[i][1]){
				if(arr[i][0]< arr[pos][0]){
					pos = i;
				}
			}
		}
		
		/*ArrayList<Double>nslope = new ArrayList<Double>();
		ArrayList<Double>pslope = new ArrayList<Double>();
		for(int i = 0; i<arr.length;i++){
			Double temp =  (Double)((double)(arr[i][1]-arr[pos][1])/(double)(arr[i][0]-arr[pos][0]));
			if(temp>=0){
				pslope.add(temp) ;	
			}else{
				nslope.add(temp);
			}
		}
		Collections.sort(pslope);
		Collections.sort(nslope);
		Collections.reverse(nslope);*/
	}
	public static void quicksort(int[] arr, int lo, int hi) {
		int left = lo, right = hi, pivot = (right + left) / 2;
		if (lo >= hi) {
			return;
		}
		while (left <= right) {
			while (arr[left] < arr[pivot]) {
				left++;
			}
			while (arr[right] > arr[pivot]) {
				right--;
			}

			if (left <= right) {
				int t = arr[left];
				arr[left] = arr[right];
				arr[right] = t;
				left++;
				right--;
			}
		}
		quicksort(arr, lo, right);
		quicksort(arr, left, hi);
	}

}
