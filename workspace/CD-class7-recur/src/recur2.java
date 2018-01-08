import java.util.Scanner;

public class recur2 {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		int[] arr = takeinput();
		//System.out.println(ispalin(arr,0));
		int[] arr2 = revarr(arr,0);
		for(int i = 0; i<arr.length; i++){
		System.out.print(arr2[i]+" ");
	}
		int[] arr3 =  invertarr(arr, 0);
		for(int i = 0; i<arr.length; i++){
			System.out.print(arr2[i]+" ");
		}
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

	public static boolean ispalin(int[] arr, int i) {
		if(arr.length-1 == i){
			return true;
		}
		if(arr[i]==arr[arr.length-1-i]){
			return ispalin(arr,i+1);
		}
		else{
			return false;
		}

	}
	public static int[] revarr(int[] arr, int i) {
		if((arr.length-1)/2 < i){
			return arr;
		}
        int t =arr[arr.length-1-i];
		arr[arr.length-1-i]=arr[i];
        arr[i] = t;
		 revarr(arr,i+1);
		 return arr;
		
	}
	
	public static int[] invertarr(int[] arr, int i) {
		if((arr.length-1) <i){
			return arr;
		}
        int t =arr[i+1];
		arr[i+1]=arr[i];
        arr[i] = t;
		 revarr(arr,i+2);
		 return arr;
		
	}
}
