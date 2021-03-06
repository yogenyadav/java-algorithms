package datastructs.graph;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Graph {
	int V; //# vertices
	int E; //# edges
	Map<Integer, List<Integer>> adjacents;
//	List<Integer>[] adjacents = new List<Integer>[10];
	
	public Graph(int v) {
		super();
		V = v;
		E = 0;
		adjacents = new HashMap<Integer, List<Integer>>();
		for(int i = 0; i < V; i++){
			adjacents.put(i, new LinkedList<Integer>());
		}
	}
	
	public void addEdge(int v, int w){
		adjacents.get(v).add(w);
		adjacents.get(w).add(v);
		E++;
	}
	
	public static class GraphNode implements Comparator<GraphNode> {
		public int distance = 0;
		public boolean explored = false;
		public int x, y, z = 0;
		
		public List<GraphNode> getAdjacent() {
			return null;
		}

		@Override
		public int compare(GraphNode o1, GraphNode o2) {
			if (o1.distance < o2.distance) return -1;
			else if (o1.distance > o2.distance) return 1;
			else return 0;
		}
	}
}
