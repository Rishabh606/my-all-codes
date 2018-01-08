package stacks;

import java.util.Scanner;

public class binary_tree {
	private class Node {
		int data;
		Node left;
		Node right;

		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	private Node root;
	private int size;

	public binary_tree() {
		Scanner scn = new Scanner(System.in);
		this.root = this.takeInput(scn, null, false);
	}
	private Node takeInput(Scanner scn, Node parent, boolean leftOrRight){
		if(parent==null){
			System.out.println("enter a number");
		}
		else{
			if(leftOrRight){
				System.out.println("enter data of left child"+ parent.data);
			}
			else{
				System.out.println("enter data of right child" + parent.right);
			}
		}
		int cdata = scn.nextInt();
		Node child = new Node(cdata,null,null);
		this.size++;
		boolean choice = false;
		System.out.println("is there a left child");
		parent.left =  takeinput();
	}
	
}
