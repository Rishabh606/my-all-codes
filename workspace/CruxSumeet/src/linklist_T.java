import java.util.Scanner;

public class linklist_T<T> {

	// TODO Auto-generated method stub
	private class Node {
		T data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	public linklist_T() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public int listsize() {
		return this.size;
	}

	public static Scanner scn = new Scanner(System.in);

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void addLast(T data) {
		Node newNode = new Node();
		if (size == 0) {
			this.tail = newNode;
			this.head = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		newNode.data = data;
		this.size++;
	}

	public Node getNodeAt(int idx) throws Exception {
		if (isEmpty()) {
			throw new Exception("list is Empty");
		}
		Node temp = this.head;
		for (int i = 0; i < idx; i++) {
			temp = temp.next;
		}
		return temp;
	}

	public void addNodeAt(int idx, T data) throws Exception {
		if (idx < 0 || idx > size) {
			throw new Exception("index out of bound");
		}
		if (idx == 0) {
			this.addFirst(data);
		} else if (idx == size) {
			this.addLast(data);
		} else {
			Node nm1 = getNodeAt(idx - 1);
			Node newNode = new Node();

			newNode.next = nm1.next;
			nm1.next = newNode;

			newNode.data = data;
			this.size++;
		}
	}

	public void addFirst(T data) {
		Node newNode = new Node();
		if (size == 0) {
			this.tail = newNode;
			this.head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		newNode.data = data;
		this.size++;
	}

	public void display() throws Exception {
		if (isEmpty()) {
			throw new Exception("list is Empty");
		}

		for (Node temp = this.head; temp != null; temp = temp.next) {
			System.out.print(temp.data + ", ");
		}
		System.out.println("END");
	}

	public T getfirst() throws Exception {
		if (isEmpty()) {
			throw new Exception("list is Empty");
		}
		return this.head.data;
	}

	public T getlast() throws Exception {
		if (isEmpty()) {
			throw new Exception("list is Empty");
		}
		return this.tail.data;
	}

	public T getAt(int idx) throws Exception {
		if (isEmpty()) {
			throw new Exception("list is Empty");
		}
		if (idx < 0 || idx >= size) {
			throw new Exception("index out of bound");
		}

		Node temp = this.head;
		for (int i = 0; i < idx; i++) {
			temp = temp.next;
		}
		return temp.data;
	}

	public T removefirst() throws Exception {
		if (isEmpty()) {
			throw new Exception("list is Empty");
		}
		Node newNode = this.head;
		Node newHead = head.next;

		head.next = null;
		if (size == 1) {
			this.head = this.tail = null;
		} else {
			head = newHead;
		}

		this.size--;
		return newNode.data;
	}

	public T removelast() throws Exception {
		if (isEmpty()) {
			throw new Exception("list is Empty");
		}
		T dy = tail.data;
		if (size > 1) {

			Node sc_lt = getNodeAt(size - 2);
			sc_lt.next = null;
			this.tail = sc_lt;
			this.size--;
		} else {
			removefirst();
		}
		return dy;
	}

	public T removeNodeAt(int idx) throws Exception {
		if (idx < 0 || idx >= size) {
			throw new Exception("index out of bound");
		}
		if (idx == 0) {
			return this.removefirst();
		} else if (idx == size - 1) {
			return this.removelast();
		} else {
			Node nm1 = getNodeAt(idx - 1);
			Node n = nm1.next;
			Node np1 = n.next;
			nm1.next = np1;
			n.next = null;
			this.size--;
			return n.data;
		}
	}

}
