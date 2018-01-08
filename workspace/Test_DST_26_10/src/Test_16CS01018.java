import java.util.Scanner;

public class Test_16CS01018 {

	public static Scanner scn = new Scanner (System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Please provide size of array");
		int n = scn.nextInt();
		int[] arr = new int[n];
		System.out.println("provide space seperated integers for next n inputs");
		for(int i = 0;i<n;i++){
			arr[i] = scn.nextInt();
		}
		//int[] tr = {95,53,32,35,84,68,73,23,94,70,23,54,46,86,24,23,48,24,38,18,6,78};
		Ternary_Heap tree = new Ternary_Heap(arr);
		tree.printHeap();
		/*System.out.println(tree.HP());
		tree.insert(2);
		System.out.println(tree.HP());*/
		System.out.println("Please provide k for Q2");
		int k = scn.nextInt();
		tree.ksmallest(k);
//		tree.deleteMin();
		tree.printHeap();
		System.out.println("Please provide a for Q3");
		int a = scn.nextInt();
		tree.PrintSmaller(a);
		tree.printHeap();
	}
}
