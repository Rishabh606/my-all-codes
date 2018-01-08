import java.util.Scanner;

public class binary_tree_copied {
	private class node {
		int data;
		node left;
		node right;
	}

	private int size;
	private node root;

	public binary_tree_copied() {
		Scanner scn = new Scanner(System.in);
		this.root = this.takeinput(null, false, scn);
	}

	public binary_tree_copied(int[] pre, int[] in) {
		this.construct(pre,0,pre.length);
	}
	private node construct(int[] pre,0,pre.length-1)

	private node takeinput(node parent, boolean ilc, Scanner scn) {
		// prompt
		if (parent == null) {
			System.out.println("enter the data for the root");
		} else {
			if (ilc) {
				System.out.println("enter the data for the left child of " + parent.data);
			} else {
				System.out.println("enter the data for the right child of " + parent.data);
			}
		}
		// take data
		int data = scn.nextInt();
		// create node
		node node = new node();
		this.size++;
		node.data = data;
		// ask for lc and create lc
		System.out.println("does" + node.data + "has a left child");
		boolean hlc = scn.nextBoolean();
		if (hlc == true) {
			node.left = this.takeinput(node, true, scn);
		}
		// ask for rc and create rc
		System.out.println("does" + node.data + "has a right child");
		boolean hrc = scn.nextBoolean();
		if (hrc == true) {
			node.right = this.takeinput(node, false, scn);
		}
		// return node
		return node;
	}

	public void display() {
		this.display(this.root);
	}

	private void display(node node) {
		if (node == null) {
			return;
		}
		// serve node
		String str = "";
		if (node.left != null) {
			str += node.left.data;
		} else {
			str += "end";
		}

		str += "<=" + node.data + "=>";
		if (node.right != null) {
			str += node.right.data;
		} else {
			str += "end";
		}
		System.out.println(str);
		this.display(node.left);
		this.display(node.right);
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public int max() {
		return this.max(this.root);
	}

	private int max(node node) {
		if (node == null) {
			return Integer.MIN_VALUE;
		}
		int rv = node.data;
		int lm = this.max(node.left);
		int rm = this.max(node.right);
		rv = Math.max(rv, Math.max(lm, rm));
		return rv;
	}

	public int min() {
		return this.min(this.root);
	}

	private int min(node node) {
		if (node == null) {
			return Integer.MAX_VALUE;
		}
		int rv = node.data;
		int lm = this.min(node.left);
		int rm = this.min(node.right);
		rv = Math.min(rv, Math.min(lm, rm));
		return rv;
	}

	public int size2() {
		return this.size2(this.root);
	}

	private int size2(node node) {
		if (node == null) {
			return 0;
		}
		int rv = 0;
		int ls = this.size2(node.left);
		int rs = this.size2(node.right);
		rv = ls + rs;
		rv = rv + 1;
		return rv;
	}

	public int height() {
		return this.height(this.root);
	}

	private int height(node node) {
		if (node == null) {
			return -1;
		}
		int rv;
		int lh = this.height(node.left);
		int rh = this.height(node.right);
		rv = 1 + Math.max(lh, rh);

		return rv;
	}

	public boolean find(int data) {
		return this.find(this.root, data);
	}

	private boolean find(node node, int data) {
		if (node == null) {
			return false;
		}
		if (node.data == data) {
			return true;
		}

		boolean fil = this.find(node.left, data);
		if (fil) {
			return true;
		}
		boolean fir = this.find(node.right, data);
		if (fir) {
			return true;
		}
		return false;
	}

	public void preorder() {
		this.preorder(this.root);
		System.out.println("END");
	}

	private void preorder(node node) {
		if (node == null) {
			return;
		}
		System.out.print(node.data + ",");
		this.preorder(node.left);
		this.preorder(node.right);
	}

	public void postorder() {
		this.postorder(this.root);
		System.out.println("END");
	}

	private void postorder(node node) {
		if (node == null) {
			return;
		}

		this.postorder(node.left);
		this.postorder(node.right);
		System.out.print(node.data + ",");
	}

	public void inorder() {
		this.inorder(this.root);
		System.out.println("END");
	}

	private void inorder(node node) {
		if (node == null) {
			return;
		}
		this.inorder(node.left);
		System.out.print(node.data + ",");
		this.inorder(node.right);

	}
}
