
public class client_gp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph gp = new Graph();
		gp.addVertex("A");
		gp.addVertex("B");
		gp.addVertex("C");
		gp.addVertex("D");
		gp.addVertex("E");
		gp.addVertex("F");
		gp.addVertex("G");
	//	gp.addVertex("H");
	//	gp.addVertex("I");
		
		gp.addEdge("A", "B", 10);
		gp.addEdge("A", "D", 40);
		gp.addEdge("B", "C", 10);
		gp.addEdge("C", "D", 10);
		gp.addEdge("D", "E", 2);
		gp.addEdge("E", "F", 3);
		gp.addEdge("E", "G", 8);
		gp.addEdge("F", "G", 3);
//		gp.addEdge("H", "I", 3);
		gp.display();
		
		
		//System.out.println(gp.hasPath("A", "G"));
		/*gp.PrinthasPath_shortest("A", "G");
		gp.PrinthasPath_BFST("A");
		
		System.out.println(gp.isconnect("A"));
		System.out.println(gp.isTree("A"));
		System.out.println(gp.isbipartite());
		gp.getConnectedComponenets("A");*/
		System.out.println(gp.dijkstraPair("A"));
		
	}

}
