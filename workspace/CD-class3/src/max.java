import java.util.Scanner;

public class max {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = takeinput();
		display(arr);
		//int max = max1(arr);
		//int key = scn.nextInt();
		//int position = linearsearch(arr, key);
		//rev(arr);
	//	display(arr);
		inverse(arr);
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

	public static int max1(int[] arr) {
		int max = arr[0];
		int retval = 0;
		for (int i = 0; i < arr.length; i++) {
			if (max <= arr[i]) {
				max = arr[i];
				retval = i;
			}

		}

		return retval;
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
//				 arr[arr.length - i] = t;
	            // System.out.println("i am here");
	            //System.out.println(arr[i]);
	             
		}

	}

public static int binarysearch (int[] arr, int key)
{
	int retval = -1, left = 0, right = arr.length-1 ;
	int middle = 0;
	while(left<=right) {
		middle = (left+right)/2;
		if (key==arr[middle]) {
			retval = middle;
			break;
		}
		else if (arr[middle]>key)
		{
			right = middle - 1;
		}
		else
		{
			left = middle + 1;
		}

	}

	return retval;
}

public static void inverse(int[] arr)
{
	int[] arr2 = null;
	arr2 = new int[arr.length];
	int t = 0;
	for(int i=0; i < arr.length; i++)
	{
		t = arr[i];
		arr2[t] = i;
	}
	for(int i=0; i < arr2.length; i++)
	{
		System.out.println(arr2[i]);
	}
}

}
