package stacks;

public class Client {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		linklist list=new linklist();
		list.addfirst(10);
		//list.display();
		list.addfirst(20);
		list.addAtend(30);
		list.addAt(100, 2);
		//list.display();
		//list.removeAt(3);
		list.display();
		//list.getdataAt(2);
		
		list.reverseDI();
		list.display();
	}

}
