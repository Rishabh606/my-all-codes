
import java.util.LinkedList;
import java.util.Scanner;

public class BinaryTree {
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

	public BinaryTree() {
		Scanner scn = new Scanner(System.in);
		this.root = this.takeInput(scn, null, false);
	}

	private Node takeInput(Scanner scn, Node parent, boolean leftOrRight) {
		if (parent == null) {
			System.out.println("Enter the data for root");
		} else {
			if (leftOrRight) {
				System.out.println("Enter the data for left child of " + parent.data);
			} else {
				System.out.println("Enter the data for right child of " + parent.data);
			}
		}

		int cdata = scn.nextInt();

		Node child = new Node(cdata, null, null);
		this.size++;

		boolean choice = false;

		System.out.println("Do you have a left child for " + child.data);
		choice = scn.nextBoolean();

		if (choice) {
			child.left = this.takeInput(scn, child, true);
		}

		System.out.println("Do you have a right child for " + child.data);
		choice = scn.nextBoolean();

		if (choice) {
			child.right = this.takeInput(scn, child, false);
		}

		return child;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size() == 0;
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

	public void constructor(int[] pre, int[] in) {
		this.root = constructor(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}

	private Node constructor(int[] pre, int psi, int pei, int[] in, int isi, int iei) {
		if (psi > pei) {
			return null;
		}
		int si = -1;
		for (int i = isi; i <= iei; i++) {
			if (pre[psi] == in[i]) {
				si = i;
				break;
			}
		}
		Node left = constructor(pre, psi + 1, psi + si - isi, in, isi, si - 1);
		Node right = constructor(pre, psi + si - isi + 1, pei, in, si + 1, iei);
		Node child = new Node(pre[psi], left, right);
		this.size++;
		return child;
	}

	public void constructor2(int[] post, int[] in) {
		this.root = constructor2(post, 0, post.length, in, 0, in.length);
	}

	private Node constructor2(int[] post, int psi, int pei, int[] in, int isi, int iei) {
		if (psi > pei) {
			return null;
		}
		int si = -1;
		for (int i = isi; i <= iei; i++) {
			if (post[pei] == in[i]) {
				si = i;
				break;
			}
		}
		Node left = constructor2(post, psi, psi + si - isi - 1, in, isi, si - 1);
		Node right = constructor2(post, psi + si - isi, pei - 1, in, si + 1, iei);
		Node child = new Node(post[pei], left, right);
		this.size++;
		return child;
	}

	public void constructor3(int[] post, int[] pre) {
		this.root = constructor3(pre, 0, pre.length, post, 0, post.length);
	}

	private Node constructor3(int[] pre, int psi, int pei, int[] post, int posi, int poei) {
		if (psi > pei) {
			return null;
		}
		int si = -1;
		for (int i = posi; i < poei; i++) {
			if (pre[psi + 1] == post[i]) {
				si = i;
				break;
			}
		}
		int cl = si - posi + 1;
		Node left = constructor3(pre, psi + 1, psi + cl, post, posi, si);
		Node right = constructor3(pre, psi + cl + 1, pei, post, si + 1, poei - 1);
		Node child = new Node(pre[psi], left, right);

		return child;
	}

	public void preorder() {
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

	public void postorder() {
		postorder(this.root);
		System.out.println("End");
	}

	private void postorder(Node parent) {
		if (parent == null) {
			return;
		}
		preorder(parent.left);
		preorder(parent.right);
		System.out.print(parent.data + ", ");
	}

	public void inorder() {
		inorder(this.root);
		System.out.println("End");
	}

	private void inorder(Node parent) {
		if (parent == null) {
			return;
		}
		preorder(parent.left);
		System.out.print(parent.data + ", ");
		preorder(parent.right);
	}

	public boolean find2(int data) {
		return this.find2(this.root, data);
	}

	private boolean find2(Node node, int data) {
		if (node == null) {
			return false;
		}

		if (node.data == data) {
			return true;
		} else if (find2(node.left, data)) {
			return true;
		} else if (find2(node.right, data)) {
			return true;
		} else {
			return false;
		}
	}

	public int diameter() {
		diapair mp = diameter(this.root);
		return mp.diameter;
	}

	private diapair diameter(Node node) {
		if (node == null) {
			diapair mp = new diapair();
			mp.height = -1;
			mp.diameter = 0;
		}
		diapair ld = diameter(node.left);
		diapair rd = diameter(node.right);
		diapair mp = new diapair();
		int f1 = ld.height + rd.height + 2;
		int f2 = ld.diameter;
		int f3 = rd.diameter;
		mp.height = Math.max(ld.height, rd.height) + 1;
		mp.diameter = Math.max(f1, Math.max(f2, f3));
		return mp;
	}

	private class diapair {
		int height;
		int diameter;
		boolean isbal = true;
	}

	public boolean isbalanced() {
		diapair mp = isbalance(this.root);
		return mp.isbal;
	}

	private diapair isbalance(Node node) {
		if (node == null) {
			diapair mp = new diapair();
			mp.isbal = true;
			mp.height = -1;
			return mp;
		}

		diapair ld = isbalance(node.left);
		diapair rd = isbalance(node.right);

		diapair mp = new diapair();

		int f1 = ld.height;
		int f2 = rd.height;
		mp.height = Math.max(ld.height, rd.height) + 1;
		int f = f1 - f2;
		if (Math.abs(f) <= 1 && ld.isbal == true && rd.isbal == true) {
			mp.isbal = true;
			return mp;
		} else {
			mp.isbal = false;
			return mp;
		}
	}

	private class balBST {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		boolean isbst = true;
		Node largest = null;
		int size = 0;
		int larg_size = 0;
	}

	public boolean isBST() {
		balBST mp = isBST(this.root);
		return mp.isbst;
	}

	private balBST isBST(Node node) {
		if (node == null) {
			balBST mp = new balBST();
			mp.isbst = true;
			return mp;
		}
		balBST ls = isBST(node.left);
		balBST rs = isBST(node.right);

		balBST mp = new balBST();
		mp.max = Math.max(node.data, Math.max(ls.max, rs.max));
		mp.min = Math.min(node.data, Math.min(ls.min, rs.min));
		if (ls.isbst == true && rs.isbst == true && ls.max < node.data && rs.min > node.data) {
			mp.isbst = true;
		} else {
			mp.isbst = false;
		}
		return mp;
	}

	public void largestBST() {
		balBST nd = largestBST(this.root);
		System.out.println(nd.largest.data);
	}

	private balBST largestBST(Node node) {
		if (node == null) {
			balBST mp = new balBST();
			mp.isbst = true;
			return mp;
		}

		balBST ls = largestBST(node.left);
		balBST rs = largestBST(node.right);

		balBST mp = new balBST();

		mp.max = Math.max(node.data, Math.max(ls.max, rs.max));
		mp.min = Math.min(node.data, Math.min(ls.min, rs.min));
		mp.size = ls.size + rs.size + 1;

		if (ls.isbst == true && rs.isbst == true && ls.max < node.data && rs.min > node.data) {
			mp.isbst = true;
		} else {
			mp.isbst = false;
		}

		if (mp.isbst) {
			mp.larg_size = mp.size;
			mp.largest = node;
		} else {
			mp.larg_size = Math.max(ls.larg_size, rs.larg_size);
			if (ls.larg_size >= rs.larg_size) {
				mp.largest = ls.largest;
			} else {
				mp.largest = rs.largest;
			}
		}

		return mp;
	}

	public int size2() {
		return this.size2(this.root);
	}

	private int size2(Node node) {
		if (node == null) {
			return 0;
		}

		int rv = 0;
		int lf = size2(node.left);
		int rf = size2(node.right);
		rv = lf + rf + 1;
		return rv;
	}

	public int min() {
		return this.min(this.root);
	}

	private int min(Node node) {
		if (node == null) {
			return Integer.MAX_VALUE;
		}

		int rv = node.data;

		int lmin = this.min(node.left);
		int rmin = this.min(node.right);

		rv = Math.min(rv, Math.min(lmin, rmin));

		return rv;
	}

	public int max() {
		return this.max(this.root);
	}

	private int max(Node node) {
		if (node == null) {
			return Integer.MIN_VALUE;
		}
		int lf = max(node.left);
		int rf = max(node.right);
		int rv = Math.max(node.data, Math.max(lf, rf));
		return rv;
	}

	public int height() {
		return this.height(this.root);
	}

	private int height(Node node) {
		if (node == null) {
			return -1;
		}

		int rv = 0;

		int lh = height(node.left);
		int rh = height(node.right);

		rv = Math.max(lh, rh) + 1;

		return rv;
	}

	private class HeapMover {
		Node node;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int size = 0;
		boolean find = false;
		int height = 0;
		Node jl = null;
		Node prev = null;
		// Node curr = null;
	}

	public void multisolver(int data) {
		HeapMover hm = new HeapMover();
		this.multisolver(this.root, hm, data, 0);
		System.out.println("max- " + hm.max);
		System.out.println("min- " + hm.min);
		System.out.println("size- " + hm.size);
		System.out.println("data available- " + hm.find);
		System.out.println("height-" + hm.height);
		System.out.println("data just larger available- " + hm.jl.data);
	}

	private void multisolver(Node node, HeapMover hm, int data, int depth) {
		if (node == null) {
			return;
		}
		if (node.data == data) {
			hm.find = true;
			if (hm.prev != null) {
				System.out.println("pred- " + hm.prev.data);
			}
			System.out.println("curr- " + node.data);
		}
		if (hm.find == true && hm.prev.data == data) {
			System.out.println("succ- " + node.data);
		}

		hm.size++;

		hm.max = Math.max(hm.max, node.data);

		hm.min = Math.min(hm.min, node.data);

		hm.height = Math.max(hm.height, depth);

		if (node.data > data) {
			if (hm.jl == null) {
				hm.jl = node;
			} else if (hm.jl.data > node.data) {
				hm.jl = node;
			}
		}
		hm.prev = node;
		/*
		 * for(Node child: node.children){ multisolver(child, hm, data,depth+1);
		 * }
		 */
		multisolver(node.left, hm, data, depth + 1);
		multisolver(node.right, hm, data, depth + 1);
	}

	public void removeallleaves() {
		removeleaves(root);
	}

	private void removeleaves(Node node) {
		if (node == null) {
			return;
		}
		if (node.left != null) {
			if (node.left.left == null & node.left.right == null) {
				node.left = null;
				this.size--;
			}
		}
		if (node.right != null) {
			if (node.right.left == null & node.right.right == null) {
				node.right = null;
				this.size--;
			}

			removeleaves(node.left);
			removeleaves(node.right);
		}
	}

	public void siblingless() {
		siblingless(this.root);
	}

	private void siblingless(Node node) {
		if (node == null) {
			return;
		}
		if (node.left == null && node.right != null) {
			System.out.println(node.right.data);
		}
		if (node.right == null && node.left != null) {
			System.out.println(node.left.data);
		}
		siblingless(node.left);
		siblingless(node.right);
	}

	public void levelOrder() {
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(root);
		while (queue.isEmpty() == false) {
			Node temp = queue.removeFirst();
			System.out.print(temp + ", ");
			if (temp.left != null) {
				queue.addLast(temp.left);
			}
			if (temp.right != null) {
				queue.addLast(temp.right);
			}
		}
		System.out.println("END");
	}

	public void preorderI() {
		LinkedList<Node> stack = new LinkedList<>();
		stack.addFirst(root);
		while (stack.isEmpty() == false) {
			Node temp = stack.removeFirst();
			System.out.print(temp + ", ");
			if (temp.right != null) {
				stack.addFirst(temp.right);
			}
			if (temp.left != null) {
				stack.addFirst(temp.left);
			}
		}
		System.out.println("END");
	}

	private class checker {
		int flag = 0;
	}

	public void directpath(int data) {
		checker fl = new checker();
		// directpath(root, data, fl);
		directpath(root, data, "");
		System.out.println("END");
	}

	/*
	 * private void directpath(Node node, int key, checker fl) { if (fl.flag ==
	 * 1) { return; } if (node == null) { return; } if (node.data == key) {
	 * fl.flag = 1; System.out.print(key+", "); return; } if (fl.flag == 0) {
	 * directpath(node.left, key, fl); } if (fl.flag == 0) {
	 * directpath(node.right, key, fl); } if(fl.flag==1){
	 * System.out.print(node.data+", "); } }
	 */
	private void directpath(Node node, int key, String osf) {
		if (node == null) {
			return;
		}
		if (node.data == key) {
			System.out.println(osf + node.data);
			return;
		}
		directpath(node.left, key, osf + node.data + ", ");
		directpath(node.right, key, osf + node.data + ", ");
	}

	public void sumpath(int data) {
		sumpath(root, data, "", 0);
	}

	private void sumpath(Node node, int key, String osf, int total) {
		if (node == null) {
			return;
		}
		if (node.left == null && node.right == null && total == key - node.data) {
			System.out.println(osf + node.data);
		}
		sumpath(node.left, key, osf + node.data + ", ", total + node.data);
		sumpath(node.right, key, osf + node.data + ", ", total + node.data);
	}
}
