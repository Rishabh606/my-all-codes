package contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

 class acm_17_mock_TwinsTact {
	 public static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = scn.nextInt();
		int m = scn.nextInt();
		int[] arr = takeinput(n);
		Generic_Tree tree= new Generic_Tree();
		for(int i = 1;i<n;i++){
			int u = scn.nextInt();
			int v= scn.nextInt();
			tree.insert(arr, u, v);
		}
		for(int i = 0; i<m;i++){
			char ch = scn.next().charAt(0);
			if(ch=='Q'){
				int u = scn.nextInt();
				tree.sumQ(u);
			}else{
				int u = scn.nextInt();
				int x= scn.nextInt();
				tree.USx(u, x, arr);
			}
		}
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
  class Generic_Tree {
	  public static Scanner scn = new Scanner(System.in);
	private class Node {
		int data;
		ArrayList<Node> children;
		int sumB;
		Node(int data) {
			this.data = data;
			this.children = new ArrayList<>();
			this.sumB =data;
		}
	}

	private Node root;
	private int size;
	private HashMap<Integer,Node>map;

	public Generic_Tree() {
		Node lanny  =new Node(1);
		this.root = lanny;
		this.size=0;
		map = new HashMap<>();
		map.put(1, lanny);
		}

	public int size() {
		return this.size;
	}
	public void insert(int[] arr, int u, int v){
		if(map.containsKey(u)){
			Node parent = map.get(u);
			Node nd = new Node(v);
			parent.children.add(nd);
			map.put(v, nd);
		}else{
			Node nd = new Node(u);
			map.put(u,nd);
			Node child = new Node(v);
			map.put(v, child);
			nd.children.add(child);
		}
		Node gd = map.get(v);
		gd.sumB = sumbelowLtd(this.root,arr,gd.data);
	}

	private int sumbelow(Node gd,int[] arr) {
		int sum = arr[gd.data-1];
		for(Node i:gd.children){
			sum+=sumbelow(i,arr);
		}
		return sum;
	}
	private int sumbelowLtd(Node gd,int[] arr,int key) {
		if(map.get(gd.data).data==key){
			return gd.sumB;
		}
		int sum = arr[gd.data-1];
		for(Node i:gd.children){
			sum+=sumbelowLtd(i,arr,key);
		}
		gd.sumB = sum;
		return sum;
	}
	public void sumQ(int u){
		System.out.println(map.get(u).sumB);
	}
	
	public void USx(int u, int x, int[] arr){
		int prev = arr[map.get(u).data-1];
		arr[map.get(u).data-1] =x;
		Node nd = map.get(u);
		nd.sumB = nd.sumB - prev +x;
		sumbelowLtd(this.root, arr, u);
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

}
