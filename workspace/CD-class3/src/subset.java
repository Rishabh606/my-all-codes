import java.util.Scanner;

public class subset {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = max.takeinput();
		subsetprint(arr);
		System.out.println();
		//subsetprint(arr);
	}

	public static void subsetprint(int[] arr) {
		int rem = 0,t = 0;
		for (int i = 0; i < Math.pow(2, arr.length); i++) {
			int mi = i, counter = 0;
			t=0;
			System.out.print("[");
			while (counter < arr.length) {
				rem = mi % 2;
				//if(t>0)System.out.print("");
				mi = mi / 2;
				
				if (rem == 1) {
					System.out.print(arr[counter]);
					t++;
				}
				if(mi%2==1&& t!=0)System.out.print(", ");
				counter++;
				
			}
			System.out.println("]");
			//t = 0;
		}
	}

//	public static void permut(int[] arr) {
//		for(int i = 0;i<Math(2, arr.length); i++){
//		any2any.anytoany(arr.length, 10, i)
//		
//	}
}
