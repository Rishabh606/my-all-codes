package contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class weekofcode30_2 {

	public static Scanner scn = new Scanner(System.in);
	static int very_min = Integer.MAX_VALUE;
	static double max_ratio = Integer.MIN_VALUE;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 poles();
	//	AGP();
		/*int n = scn.nextInt();
        int q = scn.nextInt();
        String[] s = new String[n];
        for(int s_i=0; s_i < n; s_i++){
            s[s_i] = scn.next();
        }
        for(int a0 = 0; a0 < q; a0++){
            int x = scn.nextInt();
            int y = scn.nextInt();
            // your code goes here
            lcstringI(s[x],s[y]);
        }*/
	}

	public static int[][] takeinput2d(int rows) {
		int[][] rv = null;
		// int rows = scn.nextInt();
		rv = new int[rows][2];

		for (int i = 0; i < rv.length; i++) {
			for (int j = 0; j < rv[i].length; j++) {
				rv[i][j] = scn.nextInt();
			}
		}

		return rv;
	}

	public static void poles() {
		int n = scn.nextInt();
		int stacks = scn.nextInt();
		int[][] arr = takeinput2d(n);
		quicksort(arr, 0, arr.length - 1);
		int[] nodes = new int[stacks];
		int min = Integer.MAX_VALUE;
		int temp_sum = 0;
		int counter = 1;
		int[] strg = new int[stacks];
		for (int i = 0; i < stacks; i++) {
			nodes[i] = i;
			strg[i] = i;
		}
		if (stacks == 1) {
			System.out.println(sumfinder(nodes, arr, n));
			return;
		}
		while (nodes[nodes.length - 1] < arr.length) {
			move(nodes, arr);
			if (min >= very_min) {
				min = very_min;
			}
			for (int i = 0; i < nodes.length; i++) {
				nodes[i] = strg[i];
			}
			nodes[nodes.length - 1] = strg[nodes.length - 1] + counter;
			counter++;
		}
		System.out.println(min);
	}

	public static void quicksort(int[][] arr, int lo, int hi) {
		int left = lo, right = hi, pivot = (right + left) / 2;
		if (lo >= hi) {
			return;
		}
		while (left <= right) {
			while (arr[left][0] < arr[pivot][0]) {
				left++;
			}
			while (arr[right][0] > arr[pivot][0]) {
				right--;
			}

			if (left <= right) {
				int t = arr[left][0];
				int m = arr[left][1];
				arr[left][0] = arr[right][0];
				arr[left][1] = arr[right][1];
				arr[right][0] = t;
				arr[right][1] = m;
				left++;
				right--;
			}
		}
		quicksort(arr, lo, right);
		quicksort(arr, left, hi);
	}

	public static void move(int[] nodes, int[][] arr) {
		int temp = sumfinder(nodes, arr, arr.length);
		if (very_min > temp) {
			very_min = temp;
		}
		if (nodes[nodes.length - 1] - nodes[1] == nodes.length - 2) {
			return;
		}
		for (int i = 1; i < nodes.length - 1; i++) {
			if (nodes[i] > nodes[i + 1]) {
				return;
			}
		}

		for (int i = 1; i < nodes.length - 1; i++) {
			nodes[i] = nodes[i] + 1;
			move(nodes, arr);
		}
		return;

	}

	public static int sumfinder(int[] nodes, int[][] arr, int n) {
		int sum = 0;
		int a = nodes.length - 1;
		for (int k = n - 1; k >= 0; k--) {
			if (k > nodes[a]) {
				sum = sum + (arr[k][0] - arr[nodes[a]][0]) * arr[k][1];
			} else {
				a--;
			}
		}
		return sum;
	}

	public static void display(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void AGP() {
		int n = scn.nextInt();
		int[][] g = new int[n][n];
		for (int g_i = 0; g_i < n; g_i++) {
			for (int g_j = 0; g_j < n; g_j++) {
				g[g_i][g_j] = scn.nextInt();
			}
		}
		// check for duplicate triangles also
		int[][] triangle = new int[n][3];
		// int[] strg = new int [n];
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {

				if (g[i][j] == 1) {
					for (int k = 0; k < n; k++) {
						// strg[k] = g[i][k];
						if (g[j][k] == g[i][k] && g[j][k] == 1) {
							triangle[count][0] = i + 1;
							triangle[count][1] = j + 1;
							triangle[count][2] = k + 1;
							g[i][k] = 0;
							count++;
						}
					}
					g[j][i] = 0;
				}
			}
		}
		 //display(triangle);
		 for(int i = 0; i<count;i++){
			 Arrays.sort(triangle[i]);
		 }
		// display(triangle);
		 for(int i = 0;i<count;i++){
			 for(int j = i+1;j<count;j++)
			 if(triangle[i][0]==triangle[j][0]&&triangle[i][1]==triangle[j][1]&&triangle[i][2]==triangle[j][2]){
				 triangle[j][0]=triangle[count-1][0]; 
				 triangle[j][1]=triangle[count-1][1];
				 triangle[j][2]=triangle[count-1][2];
				 
				 triangle[count-1][0] = 0; 
				 triangle[count-1][1] = 0;
				 triangle[count-1][2]=  0;
				 count--;
			 }
		 }
		 String s = "";
		ArrayList<Integer[]> allpossible = maxratio(triangle, 0, count);
		ArrayList<Integer> strg = new ArrayList<Integer>();
		/*for(int p = 0; p<allpossible.size();p++){
			for(int j = 0; j<allpossible.get(p).length;j++){
				System.out.print(allpossible.get(p)[j]+" ");
			}
		System.out.println();
		}*/
		int counter = 0;
		for (int k = 0; k < allpossible.size(); k++) {

			
			int nodes = nonrepeatednodes(allpossible.get(k));
			
			if (nodes >=3) {
				int t =  allpossible.get(k).length;
				int no_triangles = allpossible.get(k).length / 3;
				
				double temp =(double) no_triangles/(double)nodes;
				if (max_ratio < temp) {
					max_ratio = temp;
					s = "";
					s = s+allpossible.get(k)[0];
					counter =1;
					for (int m = 1; m < allpossible.get(k).length; m++) {
						if (allpossible.get(k)[m] != allpossible.get(k)[m - 1]) {
							s = s+" "+allpossible.get(k)[m];
							counter++;
						}
					
					}
					
				}
			}
		}
		System.out.println(counter);
		System.out.println(s);
	}

	public static ArrayList<Integer[]> maxratio(int[][] triangle, int start, int end) {
		if (start == end) {
			ArrayList<Integer[]> br = new ArrayList<Integer[]>();
			br.add(new Integer[0]);
			return br;
		}
		int[] ch = triangle[start];
		ArrayList<Integer[]> myres = new ArrayList<>();
		ArrayList<Integer[]> recres = maxratio(triangle, start + 1, end);
		for (int i = 0; i < recres.size(); i++) {
			/*if(recres.size()==1&&recres.get(0).length==0){
				recres.remove(0);
			}
			*/
			int j = 0;
			if(recres.size()!=0){
				Integer[] john = recres.get(i);
			myres.add(recres.get(i));
			Integer[] arr = new Integer[recres.get(i).length + ch.length];
			for ( j = 0; j < ch.length;j++) {
				arr[j] = ch[j];
			}
			for (int k = 0; k < recres.get(i).length;k++, j++) {
				arr[j] = recres.get(i)[k];
			}
			
			myres.add(arr);
			}
			else{
				Integer[] arr = new Integer[ ch.length];
				for (int k = 0; k < ch.length; k++,j++) {
					arr[j] = ch[k];
				}
				myres.add(arr);
			}
			
		
		}
		return myres;
	}

	public static int nonrepeatednodes(Integer[] arr) {
		int rv = 1;
		Arrays.sort(arr);
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != arr[i - 1]) {
				rv++;
			}
		}
		return rv;
	}
	public static void lcstringI(String s1,String s2){
		int l1=s1.length(),l2=s2.length();
		int l=(l1>l2)?l2:l1;
		 for(int i = l; i>0; i--){
			 
			 for(int j = 0; j<=l1-i;j++){
				 
				 String str1 = s1.substring(j,j+i);
				 
				for(int k = 0;k<=l2-i;k++){
				    String str2=s2.substring(k,k+i);
					if(str1.equals(str2)){
						System.out.println(i);
						return;
							}
						}
					}
				}
		 
	}
}
