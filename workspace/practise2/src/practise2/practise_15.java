package practise2;

import java.util.Scanner;

public class practise_15 {
	
	 public static Scanner scn = new Scanner(System.in);
	 
	  public static void main(String[] args) {
		  int q = scn.nextInt();
		  for(int i = 0; i<q; i++){
			  plane();
		  }
	    }
	  public static void plane(){
		  
		  int[] a = new int[4];
		  int[] b = new int[4];
		  int[] c = new int[4];
		  
		  int[] ab = new int[3];
		  int[] ac = new int[3];
		  int[] ad = new int[3];
		  
		  for(int i = 0; i<4; i++){
			  a[i] = scn.nextInt();
			  b[i] = scn.nextInt();
			  c[i] = scn.nextInt();
		  }
		 
		  ab[0] = a[0] - a[1];
		  ab[1] = b[0] - b[1];
		  ab[2] = c[0] - c[1];
		  
		  ac[0] = a[0] - a[2];
		  ac[1] = b[0] - b[2];
		  ac[2] = c[0] - c[2];
		  
		  ad[0] = a[0] - a[3];
		  ad[1] = b[0] - b[3];
		  ad[2] = c[0] - c[3];
		  
		//  int t= ad[0]*ab[1]*ac[2] + ac[0]*ad[1]*ab[2] + ac[1]*ad[2]*ab[0] - ab[2]*ad[0]*ac[1] - ad[2]*ab[2]*ac[0] - ab[0]*ac[2]*ad[1];
		  int t = ad[0]*(ab[1]*ac[2]-ab[2]*ac[1])-ad[1]*(ab[0]*ac[2]-ab[2]*ac[0])+ad[2]*(ac[1]*ab[0]-ac[0]*ab[1]);
		  
		  if(t==0){
			  System.out.println("YES");
		  }
		  else{
			  System.out.println("NO");
		  }
	  }
	  
	  public static void sherlock_count(){
		  long n = scn.nextInt();
		  long k = scn.nextInt();
		  if(4*k>n){
			  System.out.println(n-1);
			  return;
		  }
		  else if (4*k==n){
			  System.out.println(n-1);
			  return;
		  }
		  else{
			  double t = Math.floor((n+Math.pow(n*n-4*n*k, 0.5))/2);
			  double s = Math.ceil((n-Math.pow(n*n-4*n*k, 0.5))/2);
			  long m = n- (long)(Math.ceil((n+Math.pow(n*n-4*n*k, 0.5))/2)-Math.floor((n-Math.pow(n*n-4*n*k, 0.5))/2));
			  System.out.println(m);
			  return;
		  }
	  }
	  public static void rectangular_game(){
		  int n = scn.nextInt();
		  int[] x = new int[n];
		  int[] y = new int[n];
		  int mx = Integer.MAX_VALUE;
		  int my = Integer.MAX_VALUE;
		  for(int i = 0; i<n; i++){
			  x[i]= scn.nextInt();
			  y[i]= scn.nextInt();
			  mx = Math.min(mx, x[i]);
			  my = Math.min(my, y[i]);
		  }
		  long m = (long)mx*(long)my;
		  System.out.println(m);
	  }
	  public static void on_per_line(){
		  int n = scn.nextInt();
	        int x0 = scn.nextInt();
	         int y0 = scn.nextInt();
	        int flag= -1;
	        for(int a0 = 1; a0 < n; a0++){
	            int x = scn.nextInt();
	            int y = scn.nextInt();
	            if(a0==1){
	                if(x == x0){
	                    flag = 0; 
	                }
	                else if(y == y0){
	                    flag = 1;
	                }
	                else{
	                    flag = -1;
	                    System.out.println("NO");
	                    return;
	                }
	            }
	            if(flag==0){
	                if(x!=x0){
	                    System.out.println("NO");
	                    return;
	                }
	            }
	            else {
	                if(y!=y0){
	                    System.out.println("NO");
	                    return;
	                }
	            }
	        }
	         System.out.println("YES");
	  }
}
