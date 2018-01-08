import java.util.Scanner;

public class linklist {

	// TODO Auto-generated method stub
	private class Node {
		int data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	public linklist() {
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

	public void addLast(int data) {
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

	public void addNodeAt(int idx, int data) throws Exception {
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

	public void addFirst(int data) {
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

	public int getfirst() throws Exception {
		if (isEmpty()) {
			throw new Exception("list is Empty");
		}
		return this.head.data;
	}

	public int getlast() throws Exception {
		if (isEmpty()) {
			throw new Exception("list is Empty");
		}
		return this.tail.data;
	}

	public int getAt(int idx) throws Exception {
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

	public int removefirst() throws Exception {
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

	public int removelast() throws Exception {
		if (isEmpty()) {
			throw new Exception("list is Empty");
		}
		int dy = tail.data;
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

	public int removeNodeAt(int idx) throws Exception {
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

	public void reverse_data_iteravtive() throws Exception {
		Node left = head;
		Node right = tail;
		for (int i = 0; i < size / 2; i++) {
			right = getNodeAt(size - 1 - i);
			int t = left.data;
			left.data = right.data;
			right.data = t;
			left = left.next;
		}
	}

	public void reverse_pointer_iteravtive() {
		Node prev = null;
		Node curr = head;
		Node nt = head.next;
		while (nt != null) {
			curr.next = prev;
			prev = curr;
			curr = nt;
			nt = nt.next;
		}
		Node node = tail;
		tail = head;
		head = node;
		this.head.next = prev;
	}

	public void displayreverse() {
		// display_reverse(this.head, 0);
		// reverse_PR(0, this.head.next, this.head);
		// reverse_PR2(0, this.head.next, this.head);
		HeapMover left = new HeapMover();
		left.node = this.head;

		// System.out.println(isPalindrome(left, this.head, 0, true));
		// reverse_DR(left, this.head, 0);
		fold_R(left, this.head, 0);
	}

	private void display_reverse(Node nd, int i) {
		if (nd == null) {
			return;
		}
		display_reverse(nd.next, i + 1);
		System.out.print(nd.data + ", ");
		if (i == 0) {
			System.out.println("END");
		}
	}

	public void reverse_DR_arr(int i, int[] arr, Node nd) {
		if (nd == null) {
			return;
		}
		arr[size - 1 - i] = nd.data;
		reverse_DR_arr(i + 1, arr, nd.next);
		nd.data = arr[i];
	}

	public void reverse_PR(int i, Node curr, Node prev) {
		if (curr == null) {
			Node node = tail;
			tail = head;
			head = node;
			tail.next = null;
			return;
		}
		Node nt = curr.next;
		curr.next = prev;
		prev = curr;
		curr = nt;
		reverse_PR(i + 1, curr, prev);
	}

	public void reverse_PR2(int i, Node curr, Node prev) {
		if (curr == null) {
			return;
		}
		reverse_PR(i + 1, curr, prev);
		curr.next = prev;
		if (i == 0) {
			Node node = tail;
			tail = head;
			head = node;
			tail.next = null;
		}
	}

	public void reverse_DR(HeapMover left, Node right, int floor) {
		if (right == null) {
			return;
		}
		reverse_DR(left, right.next, floor + 1);
		if (floor >= size / 2) {
			int t = left.node.data;
			left.node.data = right.data;
			right.data = t;
			left.node = left.node.next;
		}
	}

	public boolean isPalindrome(HeapMover left, Node right, int floor, boolean flag) {
		if (right == null) {
			return true;
		}
		flag = isPalindrome(left, right.next, floor + 1, flag);
		if (floor >= size / 2 && flag == true) {
			if (left.node.data == right.data) {
				left.node = left.node.next;
			} else {
				flag = false;
			}
		}
		return flag;
	}

	public void fold_R(HeapMover left, Node right, int floor) {
		if (right == null) {
			return;
		}
		fold_R(left, right.next, floor + 1);
		if (floor >= size / 2) {
			Node temp = left.node.next;
			left.node.next = right;
			left.node = temp;
			right.next = temp;
			if (floor == size / 2) {
				if (floor % 2 == 0) {
					this.tail = right;
					this.tail.next = null;
				} else {
					this.tail = left.node;
					this.tail.next = null;
				}
			}
		}
	}

	public void remove_duplicates() {
		Node prev = this.head;
		Node curr = this.head.next;
		while (curr != null) {
			if (prev.data == curr.data) {
				Node nt = curr.next;
				prev.next = nt;
				curr = nt;
				this.size--;
				if (curr == null) {
					this.tail = prev;
				}
			} else {
				curr = curr.next;
				prev = prev.next;
			}
		}
	}

	public void remove_duplicate_2() throws Exception {
		linklist helper = new linklist();
		while (!isEmpty()) {
			int temp = this.removefirst();
			if (helper.tail == null || helper.tail.data != temp) {
				helper.addLast(temp);
			}
		}
		this.head = helper.head;
		this.tail = helper.tail;
		this.size = helper.size;
	}

	public void k_reverse(int k) throws Exception {
		linklist helper = new linklist();
		Node nd = this.head;
		while (!isEmpty()) {
			linklist br = new linklist ();
			for (int i = 0; i < k; i++) {
//				br.addFirst();
			}
		}
		this.head = helper.head;
		this.tail = helper.tail;
		this.size = helper.size;
	}

	public void k_from_last() throws Exception {
		Node kfront = this.head;
		int k = scn.nextInt();
		for (int i = 1; i < k; i++) {
			kfront = kfront.next;
		}
		Node point = this.head;
		while (kfront != null) {
			point = point.next;
			kfront = kfront.next;
		}
		System.out.println(point.data);
	}

	public Node getMidNode() {
		Node fast = this.head;
		Node slow = this.head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public void append_k_from_end(int k) throws Exception {
		Node prev = getNodeAt(size - k - 1);
		Node end = this.tail;
		end.next = head;
		head = prev.next;
		this.tail = prev;
		this.tail.next = null;
	}

	public void LinkListMerge() throws Exception {
		/*
		 * linklist list2 = new linklist(); list2.addFirst(1); list2.addLast(2);
		 * list2.addLast(6); list2.addLast(9); list2.addLast(11);
		 * list2.addLast(14); list2.display(); linklist_merge(list2);
		 */
	}

	public void even_before_odd() throws Exception {
		Node prev = null;
		Node curr = this.head;
		while (curr != null) {
			if (curr.data % 2 == 0) {
				addFirst(curr.data);
				prev.next = curr.next;
				prev = prev.next;
				if (curr.next == null) {
					curr = null;
				} else {
					curr = curr.next.next;
				}
			} else {
				prev = curr;
				curr = curr.next;
			}
		}
	}

	public linklist linklist_merge(linklist list, linklist list2) throws Exception {
		Node first = list.head;
		Node second = list2.head;
		linklist newlist = new linklist();
		while (first != null && second != null) {
			if (first.data <= second.data) {
				newlist.addLast(first.data);
				first = first.next;
			} else {
				newlist.addLast(second.data);
				second = second.next;
			}
		}
		if (first == null) {
			while (second != null) {
				newlist.addLast(second.data);
				second = second.next;
			}
		} else if (second == null) {
			while (first != null) {
				newlist.addLast(first.data);
				first = first.next;
			}
		}
		// newlist.display();
		return newlist;
	}

	public void linklist_merge_sort() throws Exception {

	}

	public linklist mergesort() throws Exception {
		if (this.size == 1) {
			linklist br = new linklist();
			br.addLast(this.head.data);
			return br;
		}

		Node mid = getMidNode();
		Node mn = mid.next;

		linklist fhalf = new linklist();
		fhalf.head = this.head;
		fhalf.tail = mid;
		fhalf.tail.next = null;
		fhalf.size = (this.size + 1) / 2;

		linklist lhalf = new linklist();
		lhalf.head = mn;
		lhalf.tail = this.tail;
		lhalf.tail.next = null;
		lhalf.size = this.size / 2;

		fhalf = fhalf.mergesort();
		lhalf = lhalf.mergesort();

		linklist rev = linklist_merge(fhalf, lhalf);
		return rev;
	}

	public int search_recursive(int data){
		return search_recursive(this.head, data, 0);
	}
	
	private int search_recursive(Node temp, int data, int i){
		if(data==temp.data){
			return i;
		}
		return search_recursive(temp.next, data, i+1);
	}
	
	public boolean contain_a_loop() throws Exception{
		Node temp = new Node();
		HashMap <Node, Boolean> hm = new HashMap<>(6);
		while(temp!=null){
			if(hm.containskey(temp)){
				return true;
			}else{
				hm.put(temp, true);
				temp = temp.next;
			}
		}
		return false;
	}
	
	private class HeapMover {
		Node node;
	}

}
