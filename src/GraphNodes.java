import java.util.HashMap;
import java.util.Scanner;

public class GraphNodes implements Graph {
	HashMap<Integer, GraphNode> nodes=null;

	@Override
	public void loadGraph() {
		// Load graph data from input
		Scanner sc = new Scanner(System.in);
		
		int nNodes = sc.nextInt();
		int nPaths = sc.nextInt();
		nodes = new HashMap<>();
		for (int i=0;i<nNodes;i++) {
			nodes.put(i, new GraphNode(i));
		}
		
		for (int i=0;i<nPaths;i++) {
			int id1 = sc.nextInt();
			int id2 = sc.nextInt();
			nodes.get(id1).getNeighbours().add(nodes.get(id2));
		}
		
		sc.close();
		
	}

	@Override
	public void print() {
		// print out the internal data
		int nNodes = nodes.size();
		int nPaths = 0;
		
		for (int key:nodes.keySet()) {
			nPaths += nodes.get(key).getNeighbours().size();
		}
		System.out.println(nNodes+" "+nPaths);
		
		for (int key:nodes.keySet()) {
			for (GraphNode node:nodes.get(key).getNeighbours()) {
				System.out.println(key + " " + node.getId());
			}
		}
		
	}
	
	
}
