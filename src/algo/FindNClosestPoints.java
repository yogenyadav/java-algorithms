package algo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import datastructs.graph.Graph;
import datastructs.graph.Graph.GraphNode;

/*
 * There are some points (x,y) on a graph. This algorithm finds
 * N number of points closest to a given point (a,b) and also 
 * prints radius of circle containing N points.
 * 
 * Distance between points = SQRT((x1-x2)^2 - (y1-y2)^2)
 */
public class FindNClosestPoints {
	// priority queue is nothing but a min or max heap, in this case we want it to be a min heap
	// in min heap the smallest node is at the top
	// use a priority queue to store points with distance and let distance be the priority
	// run BFS from the starting point and explore all the reachable points in graph
	// at each point calculate the distance to point and store the point with its distance in min heap
	// when done, return N points from min heap
	
	public static List<GraphNode> findClosestPoints(Graph g, GraphNode start, int npoints){
		LinkedList<GraphNode> q = new LinkedList<GraphNode>();
		PriorityQueue<GraphNode> points = new PriorityQueue<GraphNode>();
		q.add(start);
		while(!q.isEmpty()){
			GraphNode n = q.removeFirst();
			if(n != null){
				for(GraphNode an : n.getAdjacent()){
					an.distance = n.distance + euclideanDistance(n, an);
					points.offer(an);
				}
			}
		}
		int count = 0;
		List<GraphNode> nclosest = new ArrayList<GraphNode>();
		while (count != npoints){
			nclosest.add(points.poll());
			count++;
		}
		return nclosest;
	}

	public static int euclideanDistance(GraphNode n, GraphNode an){
		int x = Math.abs(n.x - an.x);
		int y = Math.abs(n.y - an.y);
		
		int dist = (int)Math.sqrt(x^2 - y^2);
		return dist;
	}
	
	
	public static void main(String[] args) {

	}

}
