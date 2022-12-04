import java.util.ArrayList;

public class GraphNode {
	private int id;
	private ArrayList<GraphNode> neighbours = null;
	
	public GraphNode(int id) {
		this.id = id;
		neighbours = new ArrayList<>();
	}

	public ArrayList<GraphNode> getNeighbours() {
		return neighbours;
	}

	public int getId() {
		// TODO Auto-generated method stub
		return id;
	}
	
}
