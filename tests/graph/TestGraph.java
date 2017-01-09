package graph;

import graph.Graph.Node;

import org.junit.Test;

public class TestGraph {

	@Test
	public void testGraph() {
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
		Graph.DFS(a);
	}
}
