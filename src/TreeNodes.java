import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class TreeNodes extends GraphNodes implements Tree {
	TreeNode root = null;

	@Override
	public Object getRoot() {
		// TODO Auto-generated method stub
		return this.root;
	}

	@Override
	public void listAllNodesDFS() {
		// TODO Auto-generated method stub
		listAllNodesRecursive(root);
		
	}

	private void listAllNodesRecursive(TreeNode subNode) {
		// TODO Auto-generated method stub
		System.out.print(subNode.getId()+" ");
		for (TreeNode node:subNode.getChildren()) {
			listAllNodesRecursive(node);
		}
	}
	
	
	@Override
	public void loadGraph() {
		// Load graph data from input
		Scanner sc = new Scanner(System.in);
		
		int nNodes = sc.nextInt();
		int nPaths = sc.nextInt();
		nodes = new HashMap<>();
		for (int i=0;i<nNodes;i++) {
			nodes.put(i, new TreeNode(i));
		}
		
		for (int i=0;i<nPaths;i++) {
			int id1 = sc.nextInt();
			int id2 = sc.nextInt();
			nodes.get(id1).getNeighbours().add(nodes.get(id2));
		}
		
		sc.close();
		
	}
	

	@Override
	public void listAllNodesBFS() {
		// TODO Auto-generated method stub
		ArrayList<TreeNode> current = new ArrayList<>();
		ArrayList<TreeNode> next = new ArrayList<>();
		current.add(root);
		
		while (!current.isEmpty()) {
	
			for (TreeNode node:current) {
				System.out.print(node.getId()+" ");
				next.addAll(node.getChildren());
			}
			
			current= next;
			next = new ArrayList<>();
		}
		
	}

	@Override
	public Object[] getAllLeaves() {
		// TODO Auto-generated method stub
		return getAllLeavesRecursive(root).toArray();
	}

	private ArrayList<TreeNode> getAllLeavesRecursive(TreeNode subTree) {
		// TODO Auto-generated method stub
		ArrayList<TreeNode> leaves = new ArrayList<>();
		ArrayList<TreeNode> children = subTree.getChildren();
		for (TreeNode child:children) {
			leaves.addAll(getAllLeavesRecursive(child));
		}
		return leaves;
	}

	@Override
	public int getDepth() {
		// TODO Auto-generated method stub
		
		return 0;
	}

	@Override
	public Tree changeRoot(Object newRoot) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void loadTree() {
		// TODO Auto-generated method stub
		this.loadGraph();
		this.root = (TreeNode)this.nodes.get(0);
	}
	
	
}
