package stacks;

public class linklist {

	private class Node {
		int data;
		Node next;

		Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	private Node head;
	private Node tail;
	private int size;

	public linklist() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void addfirst(int data) {
		Node node = new Node(data, this.head);
		this.head = node;
		if (isEmpty()) {
			this.tail = this.head;
		}
		this.size++;
	}

	public void addAtend(int data) {

		if (isEmpty()) {
			this.addfirst(data);
		} else {
			Node node = new Node(data, null);
			this.tail.next = node;
			this.tail = node;
			this.size++;
		}
	}

	public Node getnodeAt(int idx) {
		int count = 0;
		Node rv = this.head;
		while (count < idx) {
			rv = rv.next;
			count++;
		}
		return rv;
	}

	public void addAt(int data, int idx) throws Exception {
		if (idx < 0 || idx > this.size) {
			throw new Exception("Argument invalid");
		}
		if (idx == 0) {
			this.addfirst(data);
		} else if (idx == this.size) {
			this.addAtend(data);
		} else {
			Node nm1 = this.getnodeAt(idx - 1);
			Node n = nm1.next;
			Node node = new Node(data, n);
			nm1.next = node;
			this.size++;
		}
	}

	public void display() {
		Node node = this.head;
		while (node != null) {
			System.out.print(node.data + "->");
			node = node.next;
		}
		System.out.println("End");
		System.out.println("***********************************");
	}

	public void removeAt(int idx) {
		if (isEmpty()) {
			System.out.println("list is empty");
		} else if (idx == 1) {
			this.head = this.tail = null;
		} else if (idx == this.size - 2) {
			this.tail = this.getnodeAt(idx - 1);
		} else {
			Node n = this.getnodeAt(idx - 1);
			Node nm1 = n.next.next;
			n.next = nm1;
		}
		this.size--;
	}

	public void getdataAt(int idx) {
		if (isEmpty()) {
			System.out.println("list is empty");
		} else if (idx == 1) {
			System.out.println(this.head.data);
		} else if (idx == this.size - 2) {
			System.out.println(this.tail.data);
		} else {
			System.out.println(this.getnodeAt(idx).data);
		}
	}

	public void removeAtlast() {
		if (isEmpty()) {
			System.out.println("list is empty");
		} else if (size == 1) {
			this.head = this.tail = null;
		} else {
			this.tail = this.getnodeAt(this.size - 1);
		}
	}

	public void reverseDIarr() {
		if (isEmpty()) {
			System.out.println("list is empty");
		} else if (size == 1) {
			return;
		} else {
			int count = 0;
			int arr[] = new int[this.size];
			Node rv = this.head;
			while (count < this.size) {
				arr[size - 1 - count] = rv.data;
				rv = rv.next;
				count++;
			}
			count = 0;
			rv = this.head;
			while (count < this.size) {
				rv.data = arr[count];
				rv = rv.next;
				count++;
			}
		}
	}

	public void reverseDI() {
		int count = 0;
		if (isEmpty()) {
			System.out.println("list is empty");
		} else if (size == 1) {
			return;
		} else {
			while (count < this.size/2) {
				int temp = this.getnodeAt(count).data;
				this.getnodeAt(count).data = this.getnodeAt(this.size-1-count).data;
				this.getnodeAt(this.size-1-count).data = temp;
				count++;
			}
		}
	}
	public void reversePI(){
		
	}
}
