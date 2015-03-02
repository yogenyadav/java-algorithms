package algo;

import java.util.LinkedList;

import datastructs.graph.Graph;
import datastructs.graph.Graph.GraphNode;

public class FindShortestPathBFS {

	public static boolean pathExists(Graph g, GraphNode st, GraphNode en){
		LinkedList<GraphNode> q = new LinkedList<GraphNode>();
		q.add(st);
		while(!q.isEmpty()){
			GraphNode n = q.removeFirst();
			if(n != null){
				for(GraphNode an : n.getAdjacent()){
					if(an.equals(en)){
						return true;
					}else{
						q.add(an);
					}
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {

	}

}
