import java.util.ArrayList;
import java.util.Scanner;

public class Graph2DArrayIndirectional extends Graph2DArray implements Graph {
	@Override
	public void loadGraph() {
		Scanner sc = new Scanner(System.in);
		nNodes = sc.nextInt();
		nPaths = sc.nextInt();
		graphArray = new int[nNodes][nNodes];
		for (int i=0;i<nNodes;i++) {
			for (int j=0;j<nNodes;j++) {
				graphArray[i][j] = 0;
			}
		}
		
		for (int i=0;i<nPaths;i++) {
			int node1 = sc.nextInt();
			int node2 = sc.nextInt();
			int length = sc.nextInt();
			graphArray[node1][node2] = length;
			graphArray[node2][node1] = length;
		}
		sc.close();
	}
	
	@Override
	public void print() {
		// print out the internal graph
		System.out.println(nNodes+" "+nPaths);
		for (int i=0;i<nNodes-1;i++) {
			for (int j=i+1;j<nNodes;j++) {
				if (graphArray[i][j] > 0) {
					System.out.println(i+" "+j+" "+graphArray[i][j]);
				}
			}
		}
	}

	public boolean isConnected() {
		// using DFS
		boolean[] marks = new boolean[this.nNodes];
		for (int i=0;i<this.nNodes;i++) {
			marks[i] = false;
		}
		
		int startNode = 0;
		updateMarksFrom(startNode, marks);
		
		for (int i=0;i<this.nNodes;i++) {
			if (!marks[i]) {
				return false;
			}
		}
		
		return true;
	}

	private void updateMarksFrom(int startNode, boolean[] marks) {
		// TODO Auto-generated method stub
		marks[startNode] = true;
		ArrayList<Integer> neighbours = getUnmakedNeighbours(startNode, marks);
		if (neighbours.isEmpty()) {
			return;
		}
		for (int node:neighbours) {
			updateMarksFrom(node, marks);
		}
	}

	private ArrayList<Integer> getUnmakedNeighbours(int node, boolean[] marks) {
		// TODO Auto-generated method stub
		ArrayList<Integer> al = new ArrayList<>();
		for (int i=0;i<this.nNodes;i++) {
			if (this.graphArray[node][i]>0) {
				// this is a path;
				if (!marks[i]) {
					al.add(i);
				}
			}
		}
		return al;
	}

	public boolean containsRing() {
		// using bfs
		boolean[] marks = new boolean[this.nNodes];
		for (int i=0;i<this.nNodes;i++) {
			marks[i] = false;
		}
		
		ArrayList<Integer> current=new ArrayList<>();
		current.add(0);
		marks[0] = true;
		
		ArrayList<Integer> next = new ArrayList<>();
		while (!current.isEmpty()) {
			for (int node:current) {
				for (int i=0;i<this.nNodes;i++) {
					if (this.graphArray[node][i]>0) {
						// there is a parth
						if (marks[i]) {
							return true;
						} else {
							marks[i] = true;
							next.add(i);
						}
					}
				}
			}
			current = next;
			next = new ArrayList<>();
		}
		return true;
	}
}
