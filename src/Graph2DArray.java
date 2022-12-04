import java.util.Scanner;

public class Graph2DArray implements Graph {
	int[][] graphArray = null;
	int nNodes = 0;
	int nPaths = 0;

	@Override
	public void loadGraph() {
		// Load a graph from input.
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
		}
		
		sc.close();
	}

	@Override
	public void print() {
		// print out the internal graph
		System.out.println(nNodes+" "+nPaths);
		for (int i=0;i<nNodes;i++) {
			for (int j=0;j<nNodes;j++) {
				if (graphArray[i][j] > 0) {
					System.out.println(i+" "+j+" "+graphArray[i][j]);
				}
			}
		}
		
	}
	
	
}
