package collegework;

import java.util.LinkedList;
import java.util.Scanner;



public class Assign5_Aug24 {
	
//	Rishabh Gupta
//	16CS01018

	public static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("enter length of array");
		int n = scn.nextInt();
		System.out.println("enter space seperated "+n+" integers");
		int[] arr  = takeinput(n);
		BST bt = new BST(arr);
		bt.display();
		bt.preorder();
		bt.inorder();
		bt.postorder();
		bt.levelOrder();
		bt.Allpaths();
		System.out.println("enter a and b for lowest common ancestor problem");
		int a = scn.nextInt();
		int b= scn.nextInt();
		bt.LCA(a, b);
		System.out.println("enter integer for finding its inorder successor");
		int c = scn.nextInt();
		bt.IOsuccesor(c);
	}
	public static int[] takeinput(int n) {
		int[] rv = null;
		// long n = scn.nextInt();
		rv = new int[n];
		for (int i = 0; i < n; i++) {
			rv[i] = scn.nextInt();
		}
		return rv;
	}
}

class BST {
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

	public BST(int... sa) {
		this.root = this.takeInput(sa);
	}

	private Node takeInput(int[] sa) {
		this.root = new Node(sa[0], null, null);
		for(int i = 1; i<sa.length;i++){
			leafadder(this.root, sa[i]);
			this.size++;
		}
		return this.root;
	}
	
	private void leafadder(Node node, int data) {
		if (node.data == data) {
			return;
		}
		if (node.left == null && node.data > data) {
			// add left leaf
			Node Nw = new Node(data, null, null);
			node.left = Nw;
			return;
		}
		if (node.right == null && node.data < data) {
			// add right leaf
			Node Nw = new Node(data, null, null);
			node.right = Nw;
			return;
		}
		if (node.data > data) {
			leafadder(node.left, data);
		} else {
			leafadder(node.right, data);
		}
	}
	
	public void display() {
		this.display(this.root);
		System.out.println("****************");
	}

	private void display(Node node) {
		if (node.left != null) {
			System.out.print(node.left.data + " => ");
		} else {
			System.out.print("END => ");
		}

		System.out.print(node.data);

		if (node.right != null) {
			System.out.print(" <= " + node.right.data);
		} else {
			System.out.print(" <= END");
		}

		System.out.println();

		if (node.left != null) {
			this.display(node.left);
		}

		if (node.right != null) {
			this.display(node.right);
		}
	}
	
	public void preorder() {
		System.out.println("Pre Order");
		preorder(this.root);
		System.out.println("End");
	}

	private void preorder(Node parent) {
		if (parent == null) {
			return;
		}
		System.out.print(parent.data + ", ");
		preorder(parent.left);
		preorder(parent.right);
	}
	
	public void inorder() {
		System.out.println("In Order");
		inorder(this.root);
		System.out.println("End");
	}

	private void inorder(Node parent) {
		if (parent == null) {
			return;
		}
		inorder(parent.left);
		System.out.print(parent.data + ", ");
		inorder(parent.right);
	}
	
	public void postorder() {
		System.out.println("Post Order");
		postorder(this.root);
		System.out.println("End");
	}

	private void postorder(Node parent) {
		if (parent == null) {
			return;
		}
		postorder(parent.left);
		postorder(parent.right);
		System.out.print(parent.data + ", ");
	}

	public void levelOrder() {
		System.out.println("Level Order");
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(root);
		while (queue.isEmpty() == false) {
			Node temp = queue.removeFirst();
			System.out.print(temp.data + ", ");
			if (temp.left != null) {
				queue.addLast(temp.left);
			}
			if (temp.right != null) {
				queue.addLast(temp.right);
			}
		}
		System.out.println("End");
	}

	public void Allpaths() {
		System.out.println("All paths");
		Allpaths(this.root,"Start");
		System.out.println("End");
	}
	
	private void Allpaths(Node parent,String osf) {
		if (parent == null) {
			return;
		}
		if (parent.left == null && parent.right==null) {
			System.out.println(osf+", "+parent.data+", End");
			return;
		}
		Allpaths(parent.left,osf+", "+parent.data);
		Allpaths(parent.right,osf+", "+parent.data);
	}
	
	public void LCA(int a, int b) {
		System.out.println("Lowest common ancestor");
		LCA(this.root, Math.min(a, b), Math.max(a, b));
		System.out.println("End");
	}
	
	private void LCA(Node parent, int a , int b) {
		if (parent == null) {
			return;
		}
		if(parent.data>a && parent.data<b){
			System.out.println(parent.data);
		}
		else if(parent.data>a && parent.data>b){
			LCA(parent.left, a, b);
		}
		else if(parent.data<a && parent.data<b){
			LCA(parent.right, a, b);
		}
		else if(parent.data==a){
			System.out.println(a);
		}
		else if(parent.data==b){
			System.out.println(b);
		}
		return;
	}
	
	public void IOsuccesor(int key) {
		System.out.println("IOsuccesor");
//		IOsuccesor(this.root,new pair(), key); //O(n)
		IOsuccesor(root, key); //O(log(n))
		System.out.println("End");
	}
	
	private class pair{
		int flag = 0;
	}
	
	private void IOsuccesor(Node parent, pair ch, int key) {
		if (parent == null) {
			return;
		}
		if (ch.flag == 2) {
			return;
		}
		IOsuccesor(parent.left, ch,  key);
		if(key==parent.data){
			ch.flag=1;
		}
		else if(ch.flag==1){
			System.out.println(parent.data);
			ch.flag =2;
		}
		IOsuccesor(parent.right, ch, key);
	}
	private void IOsuccesor(Node parent,int key) {
		Node imp = find(parent, key);
		if(imp.right!=null){
			int rv = min(imp.right);
			System.out.println(rv);
			return;
		}else{
			Node start = parent;
			Node prevl = null;
			while(true){
				if (start.data == key) {
					System.out.println(prevl.data);
					break;
				} else if (start.data > key) {
					prevl = start;
					start = start.left;
				} else {
					start = start.right;
				}
			}
		}
	}
	private Node find(Node node, int data) {
		if (node == null) {
			return null;
		}
		Node rv  = null;
		if (node.data == data) {
			return node;
		} else if (node.data > data) {
			rv = find(node.left, data);
			return rv;
		} else {
			rv = find(node.right, data);
			return rv;
		}
	}
	private int min(Node node) {
		if (node.left != null) {
			return min(node.left);
		} else {
			return node.data;
		}
	}
}