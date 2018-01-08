
public class client_generic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//10 2 20 2 40 0 50 0 30 2 60 0 70 0
		//10 3 20 0 30 1 40 0 50 2 60 0 70 1 80 0
		//10 3 30 0 40 1 50 2 60 2 70 0 80 0 120 0 90 2 100 0 110 0
		GenericTree gt = new GenericTree();
		gt.TakeInput();
		gt.display();
		/*gt.linearlise();
		gt.display();
		System.out.println(gt.height());
		System.out.println(gt.max());
		System.out.println(gt.find(40));
		System.out.println(gt.justLarger(50));
		System.out.println(gt.size2());
		gt.mirror();
		gt.display();*/
		/*GenericTree other = new GenericTree();
		other.TakeInput();
		other.display();*/
		//System.out.println(gt.ismirrorIsomorphic(other));
		//gt.remove_all_leaves();
		gt.multisolver(30);
		//gt.display();
	}

}
