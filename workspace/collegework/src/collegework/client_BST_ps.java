package collegework;

public class client_BST_ps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*BST_ps tree = new BST_ps();
		tree.insert(5);
		tree.insert(4);
		tree.insert(7);
		tree.insert(6);
		tree.insert(8);
		tree.insert(3);
		tree.display();
		tree.max();
		tree.delete(3);
		tree.display();
		tree.delete(7);
		tree.display();*/
		BST_ps tree = new BST_ps();
		tree.insert(50);
		tree.insert(20);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);
		tree.insert(65);
		tree.insert(20);
		tree.insert(45);
		tree.insert(30);
		tree.insert(10);
		tree.insert(15);
		tree.insert(1);
		tree.display();
		tree.max();
		tree.delete(65);
		tree.display();
		tree.delete(20);
		tree.display();
		tree.delete(45);
		tree.display();
	}

}
