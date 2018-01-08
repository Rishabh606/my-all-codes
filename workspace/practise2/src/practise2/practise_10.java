package practise2;

import java.util.Arrays;
import java.util.Scanner;

public class practise_10 {
	public static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*int hurdles = scn.nextInt();
		int jump_height = scn.nextInt();
		int[] arr = takeinput(hurdles);
		drinks(arr, jump_height);*/
		//System.out.println(gcd(100,75));
		//GCDMatrix();
		MatrixRotation();
	}
	public static int[] takeinput(int n) {
		int[] rv = null;
		rv = new int[n];
		for (int i = 0; i < n; i++) {
			rv[i] = scn.nextInt();
		}
		return rv;
	}
	public static void drinks(int[] arr,int jump_height ){
		int max = -100;
		for(int i = 0; i<arr.length;i++){
			if(max<=arr[i]){
				max = arr[i];
			}
		}
		if(max<=jump_height){
			System.out.println(0);
		}
		else{
			System.out.println(max-jump_height);
		}
	}
	public static void GCDMatrix(){
		 int n = scn.nextInt();
	        int m = scn.nextInt();
	        int q = scn.nextInt();
	        int[] a = new int[n];
	        for(int a_i=0; a_i < n; a_i++){
	            a[a_i] = scn.nextInt();
	        }
	        int[] b = new int[m];
	        for(int b_i=0; b_i < m; b_i++){
	            b[b_i] = scn.nextInt();
	        }
	        int[][] rv = null;
			rv = new int[n][];

			for (int i = 0; i < n; i++) {
				rv[i] = new int[m];
			}
			for(int i = 0; i<rv.length;i++)
			{
				for(int j = 0; j<m;j++)
				{
					 rv[i][j] =  gcd(a[i],b[j]); 
				}
			}
	       
	        for(int a0 = 0; a0 < q; a0++){
	            int r1 = scn.nextInt();
	            int c1 = scn.nextInt();
	            int r2 = scn.nextInt();
	            int c2 = scn.nextInt();
	            // your code goes here
	            int total = (r2-r1+1)*(c2-c1+1);
	            int[] arr = new int[total];
	            int count = 0;
	            for(int i = r1; i<=r2;i++){
	            	for(int j = c1;j<=c2;j++){
	            		arr[count++] = rv[i][j];
	            	}
	            }
	            Arrays.sort(arr);
	            count =0;
	            
	            for(int i = 0; i<arr.length-1;i++){
	            	/*if(i==arr.length-1){
	            		if(arr[i-1]!=arr[i]){
	            		count++;
	            		}
	            		break;
	            	}*/
	            	if(arr[i]!=arr[i+1]){
	            		count++;
	            	}
	            }
	            System.out.println(count+1);
	        }
	}
	public static int gcd(int a, int b){
		int big = a, small = b, rem = 100;
		
		while(rem>0){
			rem = big%small;
			if(rem==0){
				break;
			}
			big = small;
			small = rem;
		}
		return small;
	}
	public static long[][] takeinput(int rows, int cols) {
		long[][] rv = new long[rows][cols];

		
		for(int i = 0; i<rv.length;i++)
		{
			for(int j = 0; j<rv[i].length;j++)
			{
				 rv[i][j] = scn.nextInt();
			}
		}
		
		return rv;
	}
	/*public static void MatrixRotation(){
		int Trows = scn.nextInt();
		int Tcols = scn.nextInt();
		int rot = scn.nextInt();
		int[][] arr=takeinput(Trows,Tcols);
		for(int c_rot = 1;c_rot<=rot;c_rot++){
			int mincol = 0, maxcol = arr[0].length-1,minrow = 0,maxrow = arr.length-1,count = 0,Total = Trows*Tcols+1;
			while(maxcol >= mincol && maxrow >= minrow && count<=Total){
				int t1 =arr[minrow][mincol];
				//int t2 = arr[maxrow][mincol],t3=arr[maxrow][maxcol],t4=arr[minrow][maxcol];
				int t=t1,t0 =t1;
				for(int j= minrow; j<=maxrow && count<=Total;j++,count++){
					 t = arr[j][mincol];
					arr[j][mincol] = t0;
					t0 = t;
				}
				
			//	arr[maxrow][mincol+1] = t2;
				
				for(int j = mincol+1;j<=maxcol&& count<=Total;j++,count++){
					 t = arr[maxrow][j];
						arr[maxrow][j] = t0;
						t0 = t;
					
				}
				
				//arr[maxrow-1][maxcol] = t3;
				
				for(int j = maxrow-1;j>=minrow&& count<=Total;j--,count++){
					t = arr[j][maxcol];
					arr[j][maxcol] = t0;
					t0 = t;
					
				}
				
				//arr[minrow][maxcol-1] = t4;
				
				for(int j= maxcol-1; j>=mincol && count<=Total;j--,count++){
					 t = arr[minrow][j];
						arr[minrow][j] = t0;
						t0 = t;
					
				}
				mincol++;
				minrow++;
				maxrow--;
				maxcol--;
			}
		}
		display(arr);
	}*/
	public static void MatrixRotation(){
		int Trows = scn.nextInt();
		int Tcols = scn.nextInt();
		long rot = scn.nextInt();
		long[][] arr=takeinput(Trows,Tcols);
		for(int c_rot = 1;c_rot<=rot;c_rot++){
			int mincol = 0, maxcol = arr[0].length-1,minrow = 0,maxrow = arr.length-1;
			while(maxcol >= mincol && maxrow >= minrow ){
				long t1 =arr[minrow][mincol];
				//int t2 = arr[maxrow][mincol],t3=arr[maxrow][maxcol],t4=arr[minrow][maxcol];
				long t=t1,t0 =t1;
				for(int j= minrow; j<=maxrow;j++){
					 t = arr[j][mincol];
					arr[j][mincol] = t0;
					t0 = t;
				}
				
			//	arr[maxrow][mincol+1] = t2;
				
				for(int j = mincol+1;j<=maxcol;j++){
					 t = arr[maxrow][j];
						arr[maxrow][j] = t0;
						t0 = t;
					
				}
				
				//arr[maxrow-1][maxcol] = t3;
				
				for(int j = maxrow-1;j>=minrow;j--){
					t = arr[j][maxcol];
					arr[j][maxcol] = t0;
					t0 = t;
					
				}
				
				//arr[minrow][maxcol-1] = t4;
				
				for(int j= maxcol-1; j>=mincol;j--){
					 t = arr[minrow][j];
						arr[minrow][j] = t0;
						t0 = t;
					
				}
				mincol++;
				minrow++;
				maxrow--;
				maxcol--;
			}
		}
		display(arr);
	}
	public static void display(long[][] arr)
	{
		for(int i = 0; i<arr.length;i++)
		{	
			for(int j = 0; j<arr[i].length;j++)
			{
				 System.out.print(arr[i][j]+" ");
			}
			System.out.println();
	}
}
}
