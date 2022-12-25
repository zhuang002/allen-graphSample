import java.util.ArrayList;

public class TreeNode extends GraphNode {

	public TreeNode(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<TreeNode> getChildren() {
		return (ArrayList<TreeNode>)(ArrayList<?>)this.getNeighbours();
	}
	
	

}
