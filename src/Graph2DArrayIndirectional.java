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

	public int shortestDistance(int start, int end) {
		// TODO Auto-generated method stub
		MarkState[] marks = new MarkState[this.nNodes];

		
		int current = start;
		marks[current]= new MarkState();
		marks[current].distance = 0;
		
		while (current != -1) {
			if (current==end) {
				return marks[current].distance;
			}
			markNeighbours(current, end, marks);
			int minDistance = Integer.MAX_VALUE;
			int nextId = -1;

			for (int i=0;i<marks.length;i++) {
				MarkState state = marks[i];
				if (state!=null && !state.processed) {
					if (state.distance<minDistance) {
						minDistance = state.distance;
						nextId = i;
					}
				}
			}
			marks[current].processed = true;
			current = nextId;
			
		} 
		return -1;
	}

	private void markNeighbours(int current, int end, MarkState[] marks) {
		// TODO Auto-generated method stub
		for (int i=0;i<this.nNodes;i++) {
			if (this.graphArray[current][i]>0) {
				// there is a path
				if (marks[i] == null) {
					marks[i] = new MarkState();
					marks[i].processed=false;
					marks[i].distance = this.graphArray[current][i] + marks[current].distance;
				} else {
					int newDistance = this.graphArray[current][i] + marks[current].distance;
					if (marks[i].distance > newDistance) {
						marks[i].distance = newDistance;
					}
				}
			}
		}
	}

	
}

class MarkState {
	boolean processed = false;
	int distance = -1;
}
