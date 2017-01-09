package graph;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Graph {
	private int edges;
	private Map<String, Node> vertices;
	
	public Graph(){
		edges = 0;
		vertices = new HashMap<String, Node>();
	}
	
	public void addAdjacent(Node from, Node to){
		if(!vertices.containsKey(from.getData()))
			vertices.put(from.getData(), from);
		if (vertices.get(from.getData()).addAdjacent(to)) {
			edges++;
		}
	}
	
	public Collection<Node> getVertices(){
		return Collections.unmodifiableCollection(vertices.values());
	}
	
	public int getEdges(){
		return edges;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("edges: ").append(edges).append("\n");
		for(Node v : vertices.values()){
			sb.append(v.toString());
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public static void BFS(Graph g, Node start){
		for(Node n : g.getVertices()){
			n.setVisited(false);
		}
		Queue<Node> q = new ArrayBlockingQueue<Node>(10);
		q.offer(start);
		while(!q.isEmpty()){
			Node n = q.poll();
			for(Node w : n.getAdjacents()){
				if(!w.isVisited()){
					System.out.println("visiting: " + w.getData());
					w.setVisited(true);
					q.offer(w);
				}
			}
		}
	}
	
	public static void DFS(Node start){
		if(!start.isVisited()){
			System.out.println("visiting: " + start.getData());
			start.setVisited(true);
		}
		for(Node n : start.getAdjacents()){
			if(!n.isVisited()){
				System.out.println("visiting: " + n.getData());
				n.setVisited(true);
				DFS(n);
			}
		}
	}	
	public static void IterativeDeepeningDFS(Graph g, Node start){
		
	}
	
	public static class Node{
		private boolean visited = false;
		private String data;
		private Set<Node> adjacents = new HashSet<Node>();
		
		public Node(String d){
			data = d;
		}
		public boolean isVisited(){
			return visited;
		}
		public void setVisited(boolean v){
			visited = v;
		}
		public String getData(){
			return data;
		}
		public boolean addAdjacent(Node n){
			if (!adjacents.contains(n)) {
				adjacents.add(n);
				return true;
			}
			return false;
		}
		public Set<Node> getAdjacents(){
			return Collections.unmodifiableSet(adjacents);
		}
		public boolean equals(Object obj) {
			   if (obj == null) { return false; }
			   if (obj == this) { return true; }
			   if (obj.getClass() != getClass()) {
			     return false;
			   }
			   Node rhs = (Node) obj;
			   return new EqualsBuilder()
			                 .appendSuper(super.equals(obj))
			                 .append(data, rhs.data)
			                 .isEquals();
			  }
		public int hashCode() {
			return new HashCodeBuilder()
			.append(data)
			.hashCode();
		}
		public String toString(){
			StringBuilder sb = new StringBuilder();
			sb.append(data).append("==>");
			for(Node adj : adjacents){
				sb.append(adj.getData()).append(",");
			}
			return sb.toString();
		}
	}
}
