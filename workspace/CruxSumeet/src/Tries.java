import java.util.HashMap;
import java.util.Set;

public class Tries {
	private class Node {
		Character ch;
		boolean eow;
		HashMap<Character, Node> children;

		Node(Character ch) {
			this.ch = ch;
			this.children = new HashMap<>();
			this.eow = false;
		}
	}

	private Node root;
	private int size;
	private int numWords;

	public Tries() {
		this.root = new Node(' ');
		this.numWords = 0;
		this.size = 1;
	}

	public void addWord(String Word) {
		addWord(this.root, Word);
	}

	private void addWord(Node parent, String Word) {
		if (Word.length() == 0) {
			if (parent.eow == false) {
				parent.eow = true;
				numWords++;
			}
			return;
		}
		char ch = Word.charAt(0);
		String ros = Word.substring(1);
		//Node node = parent.children.get(ch);
		if (parent.children.containsKey(ch) == true) {
			addWord(parent.children.get(ch), ros);
		} else {
			// if(node==null){
			Node nw = new Node(ch);
			this.size++;
			parent.children.put(ch, nw);
			addWord(parent.children.get(ch), ros);

		}
		

	}

	public void removeWord(String Word) {
		removeWord(root, Word);
	}

	private void removeWord(Node parent, String Word) {
		if (Word.length() == 0) {
			if (parent.eow == true) {
				parent.eow = false;
				numWords--;
			}
			return;
		}
		char ch = Word.charAt(0);
		String ros = Word.substring(1);
		if (parent.children.containsKey(ch)) {
			removeWord(parent.children.get(ch), ros);
			Node child = parent.children.get(ch);
			if (child.eow == false && child.children.size() == 0) {
				parent.children.remove(child);
				size--;
			}
		} else {
			return;
		}
	}

	public void display() {
		display(this.root, "");
	}

	private void display(Node parent, String osf) {
		if (parent.eow) {
			System.out.println(osf);
		}
		Set<Character> keys = parent.children.keySet();
		for (char key : keys) {
			display(parent.children.get(key), osf + key);
		}
	}

	public int numWords() {
		return numWords;
	}
	
	public int size(){
		return this.size;
	}

	public boolean isEmpty() {
		return numWords == 0;
	}

	public void displayastree() {
		displayastree(root);
	}

	private void displayastree(Node parent) {
		Set<Character> keys = parent.children.keySet();
		System.out.print(parent.ch + "=> ");
		for (char key : keys) {
			System.out.print(key + ", ");
		}
		System.out.println("END");
		for (char key : keys) {
			displayastree(parent.children.get(key));
		}
	}

	public boolean find(String Word) {
		return find(root, Word);
	}

	private boolean find(Node parent, String Word) {
		if (Word.length() == 0) {
			if(parent.eow==true){
				return true;
			}
			return false;
		}
		char ch = Word.charAt(0);
		String ros = Word.substring(1);
		boolean rv = false;
		if (parent.children.containsKey(ch)) {
			rv = find(parent.children.get(ch), ros);
		}
		return rv;
	}
}
