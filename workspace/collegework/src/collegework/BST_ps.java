package collegework;

public class BST_ps {
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

	private int size;
	private Node root;

	public void insert(int key) {
		Node root = insert(this.root, key);
		if (this.root == null) {
			this.root = root;
		}
		this.size++;
	}

	private Node insert(Node node, int key) {
		if (node == null) {
			node = new Node(key, null, null);
			return node;
		}
		if (key < node.data) {
			node.left = insert(node.left, key);
		} else if (key > node.data) {
			node.right = insert(node.right, key);
		}
		return node;
	}

	public void display() {
		display(this.root);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}

	private void display(Node node) {
		if (node == null) {
			return;
		}
		if (node.left != null) {
			System.out.print(node.left.data + "=>");
		} else {
			System.out.print("END =>");
		}
		System.out.print(node.data);
		if (node.right != null) {
			System.out.println("<=" + node.right.data);
		} else {
			System.out.println("<=END");
		}
		if (node.left != null) {
			display(node.left);
		}
		if (node.right != null) {
			display(node.right);
		}

	}

	public void delete(int key) {
		delete(null, this.root, key, true);
	}

	private void delete(Node parent, Node child, int key, boolean ilc) {
		// TODO Auto-generated method stub
		if (child == null) {
			return;
		}
		if (key < child.data) {
			delete(child, child.left, key, true);
		} else if (key > child.data) {
			delete(child, child.right, key, false);
		} else if (key == child.data) {
			this.size--;
			if (child.left == null && child.right == null) {
				if (ilc) {
					parent.left = null;
				} else {
					parent.right = null;
				}
			} else if (child.left != null && child.right == null) {
				if (ilc) {
					parent.left = child.left;
					;
				} else {
					parent.right = child.left;
					;
				}
			} else if (child.left == null && child.right != null) {
				if (ilc) {
					parent.left = child.right;
				} else {
					parent.right = child.right;
				}
			} else {
				Node temp = max(child.left);
				temp.data = child.data ^ temp.data;
				child.data = child.data ^ temp.data;
				temp.data = child.data ^ temp.data;
				delete(child, child.left, temp.data, true);
			}
		}
	}
	public void max(){
		System.out.println(max(this.root).data);
	}
	private Node max(Node node) {
		if (node.right == null) {
			return node;
		}
		return max(node.right);
	}
}
