import java.util.*;
public class rev {

	public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
       int[] arr = takeinput();
       rev(arr);
       display(arr);
       //Call the ReverseArray Function
       //Print the Array.
        
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
    public static void display(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
   public static void rev(int[] arr) {

		int right = arr.length-1, left = 0, t =0;
       //System.out.println("i am here");
		while(left <= right) {
            //System.out.println("i am here");
			t = arr[left];
			arr[left] = arr[right];
			arr[right] = t;
			right--;
			left++;
			//t =a[i];
			//arr[i] = arr[arr.length-1 - i];
//			 arr[arr.length - i] = t;
            // System.out.println("i am here");
            //System.out.println(arr[i]);
             
		}

	}

}
