package algo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class LinkedInConnectionsHeirarchy {
	/*
	 * using BFS
	 */
	public static boolean isConnected(int a, int b){
		Queue<Integer> q = new LinkedList<Integer>();
		Set<Integer> visited = new HashSet<Integer>();
		q.offer(a);
		while(!q.isEmpty()){
			int n = q.poll();
			for(int adj : findFriends(n)){
				if(!visited.contains(adj))
					if(b == adj)
						return true;
					else{
						q.offer(adj);
						visited.add(adj);
					}
			}
		}
		return false;
	}
	/*
	 * using BFS
	 */
	public static Set<Integer> findAllConnectionsAtLevel(int a, int level){
		Queue<Integer> q = new LinkedList<Integer>();
		Set<Integer> visited = new HashSet<Integer>(); 

		q.offer(a);
		visited.add(a);

		// this keeps track of nodes that are added to queue for exploring at the current level
		// so that nodeCountInLevel can be calculated
		Set<Integer> nodesAddedAtLevel = new HashSet<Integer>();
		
		// these 2 variables are used to track how many total nodes to be explored at current
		// level and how many are explored. when all the nodes at current level are explored
		// levelcount is increased.
		int nodeCountInLevel = findFriends(a).size();
		int nodesExploredAtLevel = 0;

		// this is used to save nodes found at level being explored.
		int levelCount = 1;
		Map<Integer, Set<Integer>> levelConnections = new HashMap<Integer, Set<Integer>>(); 

		while(!q.isEmpty()){
			int n = q.poll();
			if(nodesExploredAtLevel == nodeCountInLevel){
				levelCount++;
				nodesExploredAtLevel = 0;
				nodeCountInLevel = getNodesToExploreAtLevel(nodesAddedAtLevel);
				nodesAddedAtLevel.clear();
			}
			for(int adj : findFriends(n)){
				nodesExploredAtLevel++;
				if(!visited.contains(adj)){
					nodesAddedAtLevel.add(adj);
					q.offer(adj);
					visited.add(adj);

					if(levelConnections.containsKey(levelCount))
						levelConnections.get(levelCount).add(adj);
					else
						levelConnections.put(levelCount, new HashSet<Integer>(Arrays.asList(new Integer[]{adj})));
				}
			}
		}
		return levelConnections.get(level);
	}
	/*
	 * Although BFS is known for finding the shortest path, but as explained in this video
	 * BFS can efficiently find shortest number of hops required from a to b but it cannot find 
	 * the path itself from a to b. Therefore, in below methods paths are found using DFS.
	 * https://www.youtube.com/watch?v=n-0JFFXuZ0c
	 * 
	 * Uses BFS and this method is to determine hops.
	 * 
	 */
	public static int findShortestNumberOfHops(int a, int b){
		Queue<Integer> q = new LinkedList<Integer>();
		Set<Integer> visited = new HashSet<Integer>();
		Map<Integer, Integer> hopsToNode = new HashMap<Integer, Integer>();
		q.offer(a);
		visited.add(a);
		hopsToNode.put(a, 0);

		while(!q.isEmpty()){
			int n = q.poll();
			int hopsRequiredToN = hopsToNode.get(n);
			for(int adj : findFriends(n)){
				if(!visited.contains(adj)){
					q.offer(adj);
					visited.add(adj);
					hopsToNode.put(adj, hopsRequiredToN+1);
				}
			}
		}
		return hopsToNode.get(b);
	}
	/*
	 * Using DFS
	 * - finds all the paths and its cost, saves in min heap
	 * - then returns path at the top of min heap
	 */
	public static Path findShortestPath(int a, int b){
		Set<Integer> visited = new HashSet<Integer>();
		Stack<Integer> path = new Stack<Integer>();
		PriorityQueue<Path> paths = new PriorityQueue<Path>();
		visited.add(a);
		path.push(a);
		findPaths(a, b, path, visited, paths);
		return paths.poll();
	}	
	/*
	 * using DFS
	 * - finds all paths and its cost and saves in min heap
	 */
	public static PriorityQueue<Path> findAllPathsWithCost(int a, int b){
		Set<Integer> visited = new HashSet<Integer>();
		Stack<Integer> path = new Stack<Integer>();
		PriorityQueue<Path> paths = new PriorityQueue<Path>();
		visited.add(a);
		path.push(a);
		findPaths(a, b, path, visited, paths);
		return paths;
	}
	
	/*
	 * the DFS implementation here is slightly different from classic DFS implementation because
	 * all the paths to target are found here. In classic DFS node is not removed from visited nodes.
	 * 
	 * Note: when target is found or when a path is completely explored and target is not found the
	 * node being visited is removed from visited nodes. This is done so that when the recursive
	 * function returns, other waiting recursive functions can explore other paths to target from 
	 * this node.
	 *   
	 * Also, this uses Stack to keep track of paths.  
	 */
	private static void findPaths(int node, int target, Stack<Integer> path, Set<Integer> visited, PriorityQueue<Path> paths){
		for(int adj : findFriends(node)){
			if(!visited.contains(adj)){
				path.push(adj);
				if(adj == target){
					paths.offer(new Path(path.size(), path.toArray(new Integer[1])));
					path.pop();
					path.pop();
					visited.remove(node);
					return;
				}
				//System.out.println("visiting: " + adj);
				visited.add(adj);
				findPaths(adj, target, path, visited, paths);
			}
		}
		visited.remove(node);
		path.pop();
	}	

	public static class Path implements Comparable<Path>{
		int cost;
		Integer[] path;
		
		public Path(int cost, Integer[] path) {
			this.cost = cost;
			this.path = path;
		}

		@Override
		public int compareTo(Path o) {
			if (this.cost < o.cost) return -1;
			else if (this.cost > o.cost) return 1;
			else return 0;
		}
		
		@Override
		public String toString(){
			StringBuffer sb = new StringBuffer();
			for(Integer p : path){
				sb.append(p.intValue()).append(">");
			}
			return sb.toString();
		}
	}
	private static int getNodesToExploreAtLevel(Set<Integer> nodesAddedAtLevel) {
		int count = 0;
		for(int i : nodesAddedAtLevel){
			count = count + findFriends(i).size();
		}
		return count;
	}
	/*
	 * this method simulates friends graph, findFriends method gives getAdjacents behavior
	 */
	private static Set<Integer> findFriends(int a){
		switch (a){
			case 1: return new HashSet<Integer>(Arrays.asList(new Integer[]{2,3,6}));
			case 2: return new HashSet<Integer>(Arrays.asList(new Integer[]{1,3,5,6}));
			case 3: return new HashSet<Integer>(Arrays.asList(new Integer[]{1,2,4}));
			case 4: return new HashSet<Integer>(Arrays.asList(new Integer[]{3,5,8}));
			case 5: return new HashSet<Integer>(Arrays.asList(new Integer[]{2,4,7}));
			case 6: return new HashSet<Integer>(Arrays.asList(new Integer[]{1,2,7}));
			case 7: return new HashSet<Integer>(Arrays.asList(new Integer[]{5,6,9}));
			case 8: return new HashSet<Integer>(Arrays.asList(new Integer[]{4,22}));
			case 9: return new HashSet<Integer>(Arrays.asList(new Integer[]{7,10}));
			case 10: return new HashSet<Integer>(Arrays.asList(new Integer[]{9,11,13}));
			case 11: return new HashSet<Integer>(Arrays.asList(new Integer[]{10,12}));
			case 12: return new HashSet<Integer>(Arrays.asList(new Integer[]{11,13,14}));
			case 13: return new HashSet<Integer>(Arrays.asList(new Integer[]{12,10}));
			case 14: return new HashSet<Integer>(Arrays.asList(new Integer[]{12}));
			case 15: return new HashSet<Integer>(Arrays.asList(new Integer[]{16}));
			case 16: return new HashSet<Integer>(Arrays.asList(new Integer[]{15}));
			case 17: return new HashSet<Integer>(Arrays.asList(new Integer[]{18}));
			case 18: return new HashSet<Integer>(Arrays.asList(new Integer[]{19}));
			case 19: return new HashSet<Integer>(Arrays.asList(new Integer[]{18,25}));
			case 20: return new HashSet<Integer>(Arrays.asList(new Integer[]{21,22}));
			case 21: return new HashSet<Integer>(Arrays.asList(new Integer[]{20,24}));
			case 22: return new HashSet<Integer>(Arrays.asList(new Integer[]{20,8}));
			case 23: return new HashSet<Integer>(Arrays.asList(new Integer[]{24}));
			case 24: return new HashSet<Integer>(Arrays.asList(new Integer[]{23,21}));
			case 25: return new HashSet<Integer>(Arrays.asList(new Integer[]{19}));
			default: return null;
		}
	}

	public static void main(String[] args) {
		System.out.format("%s and %s connected %s \n", 1, 14, 
				LinkedInConnectionsHeirarchy.isConnected(1,14));
		
		System.out.format("shartest path from %s to %s: %s \n", 8, 7, 
				LinkedInConnectionsHeirarchy.findShortestPath(8,7));
		
		PriorityQueue<Path> paths = LinkedInConnectionsHeirarchy.findAllPathsWithCost(1,24);
		for(Path path : paths){
			System.out.format("path from %s to %s: %s at cost: %s \n", 1, 24, path, path.cost);
		}
		
		System.out.format("at level %s the node %s has these connections: %s \n", 2, 3, 
				LinkedInConnectionsHeirarchy.findAllConnectionsAtLevel(3, 2));
		
		System.out.format("minimum number of hops required from %s to %s is %s \n", 1, 14, 
				LinkedInConnectionsHeirarchy.findShortestNumberOfHops(1,14));
	}
}
