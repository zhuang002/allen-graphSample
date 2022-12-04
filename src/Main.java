
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
		
		Graph graph3 = new Graph2DArrayIndirectional();
		graph3.loadGraph();
		System.out.println("Here is the loaded graph");
		graph3.print();
	}

}
