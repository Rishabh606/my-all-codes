import java.util.ArrayList;
import java.util.Scanner;

public class GenericTree {
	private class Node {
		int data;
		ArrayList<Node> children;

		Node(int data) {
			this.data = data;
			this.children = new ArrayList<>();
		}
	}

	private Node root;
	private int size;

	public void TakeInput() {
		Scanner scn = new Scanner(System.in);
		this.root = takeinput(scn, null, 0);
	}

	public Node takeinput(Scanner scn, Node parent, int i) {
		if (parent == null) {
			System.out.println("enter the root");
		} else {
			System.out.println("enter the child of" + i + " position");

		}

		int data = scn.nextInt();
		Node child = new Node(data);
		this.size++;
		System.out.println("enter no of children");
		int n = scn.nextInt();
		for (int j = 0; j < n; j++) {
			Node GC = takeinput(scn, child, j);
			child.children.add(GC);
		}
		return child;
	}

	public void display() {
		display(this.root);
	}

	private void display(Node parent) {
		System.out.print(parent.data + " => ");
		for (int j = 0; j < parent.children.size(); j++) {
			System.out.print(parent.children.get(j).data + ", ");
		}

		System.out.println("End");

		for (int j = 0; j < parent.children.size(); j++) {
			display(parent.children.get(j));
		}

	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public int max() {
		return Max(this.root);
	}

	private int Max(Node parent) {
		int max = Integer.MIN_VALUE;
		for (int j = 0; j < parent.children.size(); j++) {
			max = Math.max(max, Max(parent.children.get(j)));
		}
		max = Math.max(max, parent.data);
		return max;
	}

	public int min() {
		return min(this.root);
	}

	private int min(Node parent) {
		int min = Integer.MAX_VALUE;
		for (int j = 0; j < parent.children.size(); j++) {
			min = Math.min(min, min(parent.children.get(j)));
		}
		min = Math.min(min, parent.data);
		return min;
	}

	public int size2() {
		return this.size2(root);
	}

	private int size2(Node parent) {
		int rv = 0;
		for (Node child : parent.children) {
			rv += size2(child);
		}
		rv += 1;
		return rv;
	}

	public boolean find(int data) {
		return find(this.root, data);
	}

	private boolean find(Node parent, int data) {
		boolean rv = false;

		if (parent.data == data) {
			return true;
		}

		for (Node child : parent.children) {
			rv = find(child, data);
			if (rv == true) {
				return true;
			}
		}
		return false;
	}

	public int height() {
		return height(root);
	}

	private int height(Node parent) {
		int ht = -1;
		for (int j = 0; j < parent.children.size(); j++) {
			ht = Math.max(ht, height(parent.children.get(j)));
		}
		ht += 1;
		return ht;
	}

	public int justLarger(int data) {
		return data + justLarger(root, data);
	}

	private int justLarger(Node parent, int data) {
		int t = parent.data - data;
		int min = Integer.MAX_VALUE;
		for (int j = 0; j < parent.children.size(); j++) {
			int rv = justLarger(parent.children.get(j), data);
			if (rv > 0 && min > rv) {
				min = rv;
			}
		}
		if (t > 0 && min > t) {
			min = t;
		}
		return min;
	}

	public void linearlise() {
		linear(this.root);
	}

	private void linear(Node parent) {
		for (int i = 0; i < parent.children.size(); i++) {
			linear(parent.children.get(i));
		}

		while (parent.children.size() > 1) {
			Node nd = parent;
			while (nd.children.size() != 0) {
				nd = nd.children.get(0);
			}

			nd.children.add(parent.children.get(1));
			parent.children.remove(1);
		}
	}

	public void mirror() {
		mirror(this.root);
	}

	private void mirror(Node parent) {
		for (int i = 0; i < parent.children.size(); i++) {
			mirror(parent.children.get(i));
		}
		Node nd = parent;
		for (int i = 0; i < parent.children.size() / 2; i++) {
			Node temp = parent.children.get(i);
			parent.children.set(i, parent.children.get(parent.children.size() - 1 - i));
			parent.children.set(parent.children.size() - 1 - i, temp);
		}
	}

	public boolean isIsomorphic(GenericTree other) {
		return isIsomorphic(this.root, other.root);
	}

	private boolean isIsomorphic(Node parent, Node other_parent) {
		boolean rv = false;
		if (parent.children.size() != other_parent.children.size()) {
			return false;
		}
		for (int i = 0; i < parent.children.size(); i++) {
			rv = isIsomorphic(parent.children.get(i), other_parent.children.get(i));
			if (rv == false) {
				return false;
			}
		}

		return true;
	}

	public boolean ismirrorIsomorphic(GenericTree other) {
		/*
		 * mirror(); boolean rv = isIsomorphic(this.root, other.root); mirror();
		 * return rv;
		 */
		return ismirrorIsomorphic(root, other.root);
	}

	private boolean ismirrorIsomorphic(Node parent, Node other_parent) {
		boolean rv = false;
		if (parent.children.size() != other_parent.children.size()) {
			return false;
		}
		for (int i = 0; i < parent.children.size(); i++) {
			rv = ismirrorIsomorphic(parent.children.get(parent.children.size() - i - 1), other_parent.children.get(i));
			if (rv == false) {
				return false;
			}
		}

		return true;
	}

	public boolean ismirror_orignalIsomorphic() {
		/*
		 * mirror(); boolean rv = isIsomorphic(this.root, other.root); mirror();
		 * return rv;
		 */
		return ismirror_orignalIsomorphic(this.root, this.root);
	}

	private boolean ismirror_orignalIsomorphic(Node parent, Node other_parent) {
		boolean rv = false;
		if (parent.children.size() != other_parent.children.size()) {
			return false;
		}
		for (int i = 0; i < parent.children.size() / 2; i++) {
			rv = ismirror_orignalIsomorphic(parent.children.get(parent.children.size() - i - 1),
					other_parent.children.get(i));
			if (rv == false) {
				return false;
			}
		}

		return true;
	}

	public boolean isequalfromeveryside() {
		/*
		 * mirror(); boolean rv = isIsomorphic(this.root, other.root); mirror();
		 * return rv;
		 */
		return isequalfromeveryside(this.root, this.root);
	}

	private boolean isequalfromeveryside(Node parent, Node other_parent) {
		boolean rv = false;
		if (parent.children.size() != other_parent.children.size() && parent.data != other_parent.data) {
			return false;
		}
		for (int i = 0; i < parent.children.size() / 2; i++) {
			rv = isequalfromeveryside(parent.children.get(parent.children.size() - i - 1),
					other_parent.children.get(i));
			if (rv == false) {
				return false;
			}
		}

		return true;
	}

	public void remove_all_leaves() {
		remove_all_leaves(this.root);
	}

	private void remove_all_leaves(Node parent) {

		for (int i = 0; i < parent.children.size(); i++) {
			if (parent.children.get(i).children.size() == 0) {
				parent.children.remove(i);
				i--;
				this.size--;
			}
		}

		for (int i = 0; i < parent.children.size(); i++) {
			remove_all_leaves(parent.children.get(i));
		}
	}

	public int sumallnodes() {
		return sumallnodes(this.root);
	}

	private int sumallnodes(Node parent) {
		int rv = 0;
		for (int i = 0; i < parent.children.size(); i++) {
			rv += sumallnodes(parent.children.get(i));
		}
		rv = rv + parent.data;
		return rv;
	}

	public int kthsmallest(int k) {

		return kthsmallest(this.root, k);
	}

	private int kthsmallest(Node parent, int k) {
		int rv = min();
		for (int i = 0; i < k; i++) {

		}
		return rv;
	}

	public void multisolver(int data) {
		HeapMover hm = new HeapMover();
		this.multisolver(this.root, hm, data, 0);
		System.out.println("max- "+ hm.max);
		System.out.println("min- "+hm.min);
		System.out.println("size- "+ hm.size);
		System.out.println("data available- "+ hm.find);
		System.out.println("height-"+ hm.height);
		System.out.println("data just larger available- "+ hm.jl.data);
	}

	private void multisolver(Node node, HeapMover hm, int data, int depth) {
		if (node.data == data) {
			hm.find = true;
			if (hm.prev != null) {
				System.out.println("pred- " + hm.prev.data);
			}
			System.out.println("curr- " + node.data);
		}
		if(hm.find==true && hm.prev.data==data){
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
		for(Node child: node.children){
		multisolver(child, hm, data,depth+1);
		}
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
	//	Node curr = null;
	}
}
