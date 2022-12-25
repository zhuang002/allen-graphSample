
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Graph graph1 = new Graph2DArray();
		graph1.loadGraph();
		System.out.println("Here is the loaded graph");
		graph1.print();*/
		
		/*Graph graph2 = new GraphNodes();
		graph2.loadGraph();
		System.out.println("Here is the loaded graph");
		graph2.print();*/
		
		/*Graph graph3 = new Graph2DArrayIndirectional();
		graph3.loadGraph();
		System.out.println("Here is the loaded graph");
		graph3.print();*/
		
		/*Tree tree1 = new Tree2DArray();
		tree1.loadTree();
		tree1.changeRoot(0);
		tree1.listAllNodesBFS();
		System.out.println();
		tree1.listAllNodesDFS();*/
		
		/*Tree tree2 = new TreeNodes();
		tree2.loadTree();
		tree2.listAllNodesBFS();
		System.out.println();
		tree2.listAllNodesDFS();*/
		
		Graph2DArrayIndirectional graph3 = new Graph2DArrayIndirectional();
		graph3.loadGraph();
		
		System.out.println(graph3.isConnected());
		System.out.println(graph3.containsRing());
	}
	

}
