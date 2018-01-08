import java.util.Scanner;

public class Test2_16CS01018 {

	public static Scanner scn = new Scanner (System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//please note that is there a left/ right child has to answered with true or false
		int[] pre = {2,8,3,5,9,4};
		int[] in = {8,3,2,9,5,4};
		BinaryTree_test tree = new BinaryTree_test(pre,in);
		System.out.println("Q1- preorder followed by inorder");
		tree.preorderDisplay();
		tree.inorderDisplay();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Q2");
		tree.postorder();
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Q3");
		tree.printkfar(8,3);
		/*Input for given sample test case (copy paste in input, to check output)
		 * 2
		true
		8
		false
		true
		3
		false
		false
		true
		5
		true
		9
		false
		false
		true
		4
		false
		false
		*/
	}

}
