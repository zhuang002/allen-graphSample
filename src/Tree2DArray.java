import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Tree2DArray extends Graph2DArray implements Tree {
	int root;

	@Override
	public Object getRoot() {
		// TODO Auto-generated method stub
		return root;
	}

	@Override
	public void listAllNodesDFS() {
		// TODO Auto-generated method stub
		listAllNodesRecursive(this.root);
		
	}

	private void listAllNodesRecursive(int subNode) {
		// TODO Auto-generated method stub
		System.out.print(subNode+" ");
		ArrayList<Integer> children = getChildren(subNode);
		for (Object child:children) {
			listAllNodesRecursive((int)child);
		}
	}

	@Override
	public void listAllNodesBFS() {
		// TODO Auto-generated method stub
		ArrayList<Integer> current = new ArrayList<>();
		current.add(this.root);
		ArrayList<Integer> next = new ArrayList<>();
		
		while (!current.isEmpty()) {
			for (Integer node:current) {
				System.out.print(node+" ");
				next.addAll(getChildren(node));
			}
			current = next;
			next=new ArrayList<>();
		}
		
	}

	@Override
	public Object[] getAllLeaves() {
		// TODO Auto-generated method stub
		ArrayList<Integer> leaves = new ArrayList<>(); 
		ArrayList<Integer> current = new ArrayList<>();
		current.add(this.root);
		ArrayList<Integer> next = new ArrayList<>();
		
		while (!current.isEmpty()) {
			for (Integer node:current) {
				ArrayList<Integer> children = getChildren(node);
				if (children.isEmpty()) {
					leaves.add(node);
				} else {
					next.addAll(children);
				}
			}
			current = next;
			next=new ArrayList<>();
		}
		return leaves.toArray();
	}

	@Override
	public int getDepth() {
		// TODO Auto-generated method stub
		return getDepthRecursive(root);
	}

	private int getDepthRecursive(int subTree) {
		// TODO Auto-generated method stub
		ArrayList<Integer> children = getChildren(subTree);

		int depth = -1;
		for (int child:children) {
			int childDepth = getDepthRecursive(child);
			if (childDepth>depth) {
				depth = childDepth; 
			}
		}
		return depth+1;
	}

	@Override
	public Tree changeRoot(Object newRoot) {
		// TODO Auto-generated method stub
		this.root = (Integer)newRoot;
		return this;
	}


	public ArrayList<Integer> getChildren(Integer node) {
		// TODO Auto-generated method stub
		ArrayList<Integer> children = new ArrayList<>();
		for (int col=0;col<this.graphArray[0].length;col++) {
			if (col!=(int)node && this.graphArray[(int)node][col]!=0) {
				children.add(col);
			}
		}
		return children;
	}

	@Override
	public void loadTree() {
		// TODO Auto-generated method stub
		super.loadGraph();
	}

	
	
}
