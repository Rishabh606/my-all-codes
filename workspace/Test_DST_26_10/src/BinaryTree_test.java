import java.util.Scanner;
import java.util.LinkedList;

public class BinaryTree_test {
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

	public BinaryTree_test() {
		Scanner scn = new Scanner(System.in);
		this.root = this.takeInput(scn, null, false);
	}
	public BinaryTree_test(int[] pre, int[] in){
		this.root = constructor(pre,0,pre.length-1,in,0,in.length-1);
	}
	private Node constructor(int[] pre, int psi, int pei, int[] in, int isi, int iei) {
		// TODO Auto-generated method stub
		if(psi>pei){
			return null;
		}
		int si = -1;
		for(int i = isi;i<=iei;i++){
			if(pre[psi]==in[i]){
				si = i;
				break;
			}
		}
		Node left = constructor(pre, psi+1, psi+si-isi, in, isi, si-1);
		Node right = constructor(pre, psi+si-isi+1, pei, in, si+1, iei);
		Node child = new Node(pre[psi],left,right);
		this.size++;
		return child;
	}
	private Node takeInput(Scanner scn, Node parent, boolean lor) {
		if (parent == null) {
			System.out.println("Enter the data for root ");
		} else {
			if (lor) {
				System.out.println("Enter the data for left child of " + parent.data);
			} else {
				System.out.println("Enter the data for right child of " + parent.data);
			}
		}
		int cdata = scn.nextInt();
		Node child = new Node(cdata, null, null);
		this.size++;
		boolean choice = false;
		System.out.println("Do you have a left child for (true/false) " + child.data);
		choice = scn.nextBoolean();
		if (choice) {
			child.left = this.takeInput(scn, child, true);
		}
		System.out.println("Do you have a right child for (true/false) " + child.data);
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
		return this.size == 0;
	}

	public void preorderDisplay() {
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

	public void inorderDisplay() {
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

	private class strg {
		Node nd;
		boolean used;

		strg(Node parent, Boolean isused) {
			this.nd = parent;
			this.used = isused;
		}
	}

	public void postorder() {
		LinkedList<strg> stack = new LinkedList<>();
		strg ft = new strg(this.root, false);
		stack.add(ft);
		while (!stack.isEmpty()) {
			strg temp = stack.getFirst();
			if (temp.used == true) {
				System.out.print(temp.nd.data + ", ");
				stack.removeFirst();
				continue;
			}
			if (temp.nd.right != null) {
				strg rt = new strg(temp.nd.right, false);
				stack.addFirst(rt);
			}
			if (temp.nd.left != null) {
				strg lt = new strg(temp.nd.left, false);
				stack.addFirst(lt);
			}
			if (temp.nd.left == null && temp.nd.right == null) {
				System.out.print(temp.nd.data + ", ");
				stack.removeFirst();
			}
			temp.used = true;
		}
		System.out.println("End.");
	}

	public boolean find(Node nd, int key) {
		if (nd == null) {
			return false;
		}
		boolean rv = false;
		if (nd.data == key) {
			return true;
		} else {
			boolean rv1 = find(nd.left, key);
			boolean rv2 = find(nd.right, key);
			rv = rv1 || rv2;
		}
		return rv;
	}

	private class disflag {
		boolean flag = false;
		int kfar = 0;
		int crossed = 0;
		boolean dr = false;
	}

	public void printkfar(int data, int k) {
		/*
		 * disflag df = new disflag(); printkfar(root, data, k, df);
		 * System.out.println();
		 */
		disflag mf = new disflag();
		printkfar2(root, data, k, mf);
		System.out.println();

	}

	/*avoid this
	 * private void printkfar(Node node, int data, int k, disflag df) { if (node
	 * == null) { return; } if (node.data!=data && df.crossed > -1) { int fl =
	 * 0; if(df.flag==false){ printkfar(node.left, data, k, df); fl =1; } int tl
	 * = 0; if(df.flag==false){ printkfar(node.right, data, k, df); tl = 1; } //
	 * if (df.flag == true && df.kfar <= k) { df.kfar++; if (df.kfar == k) {
	 * System.out.print(node.data+" "); df.kfar--; return; } if(fl!=1 || tl==1){
	 * printkfar(node.left, data, k, df); } if(tl!=1 ){ printkfar(node.right,
	 * data, k, df); } // df.kfar--; } } else if (node.data == data) { df.flag =
	 * true; df.kfar = 0; df.crossed = -1; printkfar(node.left, data, k, df);
	 * printkfar(node.right, data, k, df); df.crossed = 1; } else { if (df.flag
	 * == true && df.kfar <= k && df.crossed == -1) { df.kfar++; if (df.kfar ==
	 * k) { System.out.print(node.data+" "); df.kfar--; return; }
	 * printkfar(node.left, data, k, df); printkfar(node.right, data, k, df);
	 * df.kfar--; } else { return; } } }
	 */
	
	/*
	 * idea is to find the data then go down the k steps and print data
	 * now while it is going up print the node which is k steps away for that we need to travel paths
	 * we need to see that whenever we go from inside of a branch towards parent branch the kfar needs to reduce
	 * we need to differentiate between this and the case when we are going up the parent branch. 
	 * for this we check the direction of movement and accordingly see if distance is reducing or increasing
	 * kfar = distance travelled 
	 */
	
	private void printkfar2(Node node, int data, int k, disflag df) {
		if (node == null) {
			return;
		}

		if (node.data != data && df.crossed > -1) {
			int fl = 0;
			if (df.flag == false) {
				printkfar2(node.left, data, k, df);
				fl = 1;
			}
			int tl = 0;
			if (df.flag == false) {
				printkfar2(node.right, data, k, df);
				tl = 1;
			}
			//
			if (df.flag == true && df.kfar <= k) {
				df.kfar++;
				if (df.kfar == k) {
					System.out.print(node.data + " ");
					if (!df.dr) {
						df.kfar--;
						df.dr = true;
					}
					return;
				}
				df.dr = false;
				if (node.left == null && node.right == null && node.data != data) {
					df.dr = !df.dr;
					df.kfar--;
				}
				if (fl != 1 || tl == 1) {
					printkfar2(node.left, data, k, df);
				}
				if (tl != 1) {
					printkfar2(node.right, data, k, df);
				}
				// df.kfar--;
			}
		} else if (node.data == data) {
			df.flag = true;
			df.kfar = 0;
			df.crossed = -1;
			printkfar2(node.left, data, k, df);
			printkfar2(node.right, data, k, df);
			df.crossed = 1;
			df.dr = true;
		} else {
			if (df.flag == true && df.kfar <= k && df.crossed == -1) {
				df.kfar++;
				if (df.kfar == k) {
					System.out.print(node.data + " ");
					df.kfar--;
					return;
				}
				printkfar2(node.left, data, k, df);
				printkfar2(node.right, data, k, df);
				df.kfar--;
			} else {
				return;
			}
		}
	}

}
