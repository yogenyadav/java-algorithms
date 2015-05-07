package algo;

import java.util.LinkedList;
import java.util.List;

import datastructs.graph.Graph;
import datastructs.graph.Graph.GraphNode;

public class FindShortestPathBFS {

	public static boolean pathExists(Graph g, GraphNode start, GraphNode end){
		LinkedList<GraphNode> q = new LinkedList<GraphNode>();
		q.add(start);
		while(!q.isEmpty()){
			GraphNode n = q.removeFirst();
			if(n != null){
				for(GraphNode an : n.getAdjacent()){
					if(an.equals(end)){
						return true;
					}else{
						q.add(an);
					}
				}
			}
		}
		return false;
	}
	
	public static List<GraphNode> findShortestPath(Graph g, GraphNode start, GraphNode end){
		LinkedList<GraphNode> q = new LinkedList<GraphNode>();
		LinkedList<GraphNode> path = new LinkedList<GraphNode>();
		q.add(start);
		while(!q.isEmpty()){
			GraphNode n = q.removeFirst();
			if(n != null){
				for(GraphNode an : n.getAdjacent()){
					path.add(an);
					if(an.equals(end)){
						return path;
					}else{
						q.add(an);
					}
				}
			}
		}
		return null;
	}

	public static void main(String[] args) {

	}

}
