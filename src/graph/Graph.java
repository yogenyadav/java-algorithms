package graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Graph {
	private int edges;
	private Map<String, Node> vertices;
	
	public Graph(){
		edges = 0;
		vertices = new HashMap<String, Node>();
	}
	public void addAdjacent(Node from, Node to){
		edges++;
		if(!vertices.containsKey(from.getData()))
			vertices.put(from.getData(), from);
		vertices.get(from.getData()).addAdjacent(to);
	}
	public List<Node> getAdjacents(Node n){
		return vertices.get(n.getData()).getAdjacents();
	}
	public Collection<Node> getVertices(){
		return vertices.values();
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
	public static void DFS(Graph g, Node start){
		if(!start.isVisited()){
			System.out.println("visiting: " + start.getData());
			start.setVisited(true);
		}
		for(Node n : start.getAdjacents()){
			if(!n.isVisited()){
				System.out.println("visiting: " + n.getData());
				n.setVisited(true);
				DFS(g, n);
			}
		}
	}	
	public static void IterativeDeepeningDFS(Graph g, Node start){
		
	}
	public static class Node{
		private boolean visited = false;
		private String data;
		private List<Node> adjacents = new ArrayList<Node>();
		
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
		public void addAdjacent(Node n){
			adjacents.add(n);
		}
		public List<Node> getAdjacents(){
			return adjacents;
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
	
	public static void main(String[] args) {
		Node a = new Node("A"); //0
		Node b = new Node("B"); //1
		Node c = new Node("C"); //2
		Node d = new Node("D"); //3
		Node e = new Node("E"); //4
		Graph g = new Graph();
		g.addAdjacent(a, b);
		g.addAdjacent(a, c);
		g.addAdjacent(b, a);
		g.addAdjacent(b, e);
		g.addAdjacent(c, a);
		g.addAdjacent(c, d);
		g.addAdjacent(d, c);
		g.addAdjacent(d, e);
		g.addAdjacent(e, b);
		g.addAdjacent(e, d);
		
		System.out.println(g);
		
		//Graph.BFS(g, a);
		for(Node n : g.getVertices()){
			n.setVisited(false);
		}
		Graph.DFS(g, a);
	}
}
