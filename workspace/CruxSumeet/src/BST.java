import java.util.LinkedList;
import java.util.Scanner;

public class BST {
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
		this.root = this.takeInput(sa, 0, sa.length - 1);
	}

	public Node takeInput(int[] sa, int lo, int hi) {
		if (lo > hi) {
			return null;
		}
		int middle = (lo + hi) / 2;
		Node node = new Node(sa[middle], null, null);
		this.size++;
		node.left = takeInput(sa, lo, middle - 1);
		node.right = takeInput(sa, middle + 1, hi);
		return node;
	}

	public void printumbersbw(int lkey, int hkey) {
		printnumberbw(root, lkey, hkey);
		System.out.println("END");
	}

	private void printnumberbw(Node node, int lkey, int hkey) {
		if (node == null) {
			return;
		}
		if (node.data > hkey) {
			printnumberbw(node.left, lkey, hkey);

		} else if (node.data < lkey) {
			printnumberbw(node.right, lkey, hkey);

		} else {
			System.out.print(node.data + ", ");
			printnumberbw(node.left, lkey, hkey);
			printnumberbw(node.right, lkey, hkey);

		}
	}

	public void sumreplacer() {
		heapmover hm = new heapmover();
		sumreplacer(root, hm);
	}

	private class heapmover {
		int sum = 0;
	}

	private void sumreplacer(Node node, heapmover hm) {
		if (node == null) {
			return;
		}
		sumreplacer(node.right, hm);
		hm.sum = hm.sum + node.data;
		node.data = hm.sum - node.data;
		sumreplacer(node.left, hm);
	}

	public void leafadder(int data) {
		leafadder(root, data);
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

	public void dataremover(int data) {
		dataremover(null, root, false, data);
	}

	private void dataremover(Node parent, Node node, boolean ilc, int data) {
		if (node == null) {
			return;
		}
		if (node.data > data) {
			dataremover(node, node.left, true, data);
		} else if (node.data < data) {
			dataremover(node, node.right, false, data);
		} else {
			if (node.right != null && node.left != null) {
				int temp = max(node.left);
				node.data = temp;
				dataremover(node, node.left, true, temp);
			} else {
				if (ilc) {
					parent.left = node.left != null ? node.left : node.right;
					this.size--;
				} else {
					parent.right = node.left != null ? node.left : node.right;
					this.size--;
				}
			}
		}
	}

	public void printkfar(int data, int k) {
		disflag df = new disflag();
		printkfar(root, data, k, df);
	}

	private class disflag {
		boolean flag = false;
		int kfar = 0;
		int crossed = 0;
	}

	private void printkfar(Node node, int data, int k, disflag df) {
		if (node == null) {
			return;
		}
		if (data < node.data && df.crossed > -1) {
			printkfar(node.left, data, k, df);

			if (df.flag == true && df.kfar <= k) {
				df.kfar++;

				if (df.kfar == k) {
					System.out.println(node.data);
					df.kfar--;
					return;
				}

				printkfar(node.right, data, k, df);
				df.kfar--;
			}

		} else if (data > node.data && df.crossed > -1) {
			printkfar(node.right, data, k, df);

			if (df.flag == true && df.kfar <= k) {
				df.kfar++;

				if (df.kfar == k) {
					System.out.println(node.data);
					df.kfar--;
					return;
				}

				printkfar(node.left, data, k, df);
				df.kfar--;
			}
		} else if (node.data == data) {
			df.flag = true;
			df.kfar = 0;
			df.crossed = -1;
			printkfar(node.left, data, k, df);
			printkfar(node.right, data, k, df);
			df.crossed = 1;
		} else {
			if (df.flag == true && df.kfar <= k && df.crossed == -1) {
				df.kfar++;
				if (df.kfar == k) {
					System.out.println(node.data);
					df.kfar--;
					return;
				}
				printkfar(node.left, data, k, df);
				printkfar(node.right, data, k, df);
				df.kfar--;

			} else {
				return;
			}
		}
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
			System.out.println(" <= " + node.right.data);
		} else {
			System.out.println(" <= END");
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
		boolean rv = false;
		if (node.data == data) {
			return true;
		} else if (node.data > data) {
			rv = find2(node.left, data);
			return rv;
		} else {
			rv = find2(node.right, data);
			return rv;
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
		if (node.left != null) {
			return min(node.left);
		} else {
			return node.data;
		}
	}

	public int max() {
		return this.max(this.root);
	}

	private int max(Node node) {
		if (node.right != null) {
			return max(node.right);
		} else {
			return node.data;
		}
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
	
}
