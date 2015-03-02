import graph.Graph;
import graph.Graph.Node;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;


public class FindWordsInGrid {
	static List<String> wordsFound = new ArrayList<String>();
	static Set<String> words = new HashSet<String>();
	static Set<String> suffixes = new HashSet<String>();
	static char[][] grid = {{'a', 'b', 'c', 'd'},
							{'e', 'f', 'g', 'h'},
							{'i', 'j', 'k', 'l'},
							{'m', 'n', 'o', 'p'}
							};
//	neighbors
//	00 -> 01, 11, 10
//	22 -> 21, 23; 32, 12; 31, 33; 11, 13
//	r, c-1
//	r, c+1---
//	r+1, c
//	r-1, c
//	r+1, c-1
//	r+1, c+1
//	r-1, c-1
//	r-1, c+1
	public static class RowCol{
		int r;
		int c;
		public RowCol(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	public static List<RowCol> getAdjacents(int r, int c){
//		System.out.println("rows: " + grid.length);
//		System.out.println("cols: " + grid[0].length);
		List<RowCol> l = new ArrayList<RowCol>();
		if((c-1) >= 0){
			l.add(new RowCol(r, c-1));
			if((r+1) < grid.length)
				l.add(new RowCol(r+1, c-1));
			if((r-1) >= 0)
				l.add(new RowCol(r-1, c-1));
		}
		if((r+1) < grid.length){
			l.add(new RowCol(r+1, c));
			if((c+1) < grid[0].length)
				l.add(new RowCol(r+1, c+1));
		}
		if((r-1) >= 0){
			l.add(new RowCol(r-1, c));
			if((c+1) < grid[0].length)
				l.add(new RowCol(r-1, c+1));
		}
		if((c+1) < grid[0].length)
			l.add(new RowCol(r, c+1));
		return l;
	}
	static {		
		words.add("bef");
		words.add("dghi");
		words.add("aei");
		words.add("cbe");
		words.add("ceh");
		words.add("dabc");
		words.add("dg");
		words.add("eda");
		words.add("eghi");
		words.add("efi");
		words.add("fihg");
		words.add("feb");
		words.add("gda");
		words.add("gecb");
		words.add("heb");
		words.add("hgda");
		words.add("ifc");
		words.add("ihg");
		words.add("oplk");
		words.add("njghd");
		words.add("mjfe");
		
		suffixes.add("o");
		suffixes.add("op");
		suffixes.add("opl");
		suffixes.add("n");
		suffixes.add("nj");
		suffixes.add("njg");
		suffixes.add("njgh");
		suffixes.add("m");
		suffixes.add("mj");
		suffixes.add("mjf");
		suffixes.add("b");
		suffixes.add("be");
		suffixes.add("d");
		suffixes.add("dg");
		suffixes.add("dgh");
		suffixes.add("a");
		suffixes.add("ae");
		suffixes.add("c");
		suffixes.add("cb");
		suffixes.add("ce");
		suffixes.add("da");
		suffixes.add("dab");
		suffixes.add("e");
		suffixes.add("ed");
		suffixes.add("eg");
		suffixes.add("egh");
		suffixes.add("ef");
		suffixes.add("f");
		suffixes.add("fi");
		suffixes.add("fih");
		suffixes.add("fe");
		suffixes.add("g");
		suffixes.add("gd");
		suffixes.add("ge");
		suffixes.add("gec");
		suffixes.add("h");
		suffixes.add("he");
		suffixes.add("hg");
		suffixes.add("hgd");
		suffixes.add("i");
		suffixes.add("if");
		suffixes.add("ih");
	}
	public static void main(String[] args) {
//		char[][] m = {{'a', 'b', 'c', 'd'},
//			{'e', 'f', 'g', 'h'}};
//		System.out.println("rows: " + m.length);
//		System.out.println("cols: " + m[0].length);
		
		Node a = new Node("a"); //0
		Node b = new Node("b"); //1
		Node c = new Node("c"); //2
		Node d = new Node("d"); //3
		Node e = new Node("e"); //4
		Node f = new Node("f"); //5
		Node g = new Node("g"); //6
		Node h = new Node("h"); //7
		Node i = new Node("i"); //8
		
		Graph gg = new Graph();
		gg.addAdjacent(a, b);
		gg.addAdjacent(a, d);
		gg.addAdjacent(a, e);
		gg.addAdjacent(b, c);
		gg.addAdjacent(b, f);
		gg.addAdjacent(b, e);
		gg.addAdjacent(b, d);
		gg.addAdjacent(b, a);
		gg.addAdjacent(c, f);
		gg.addAdjacent(c, b);
		gg.addAdjacent(c, e);
		gg.addAdjacent(d, e);
		gg.addAdjacent(d, h);
		gg.addAdjacent(d, g);
		gg.addAdjacent(d, a);
		gg.addAdjacent(d, b);
		gg.addAdjacent(e, a);
		gg.addAdjacent(e, b);
		gg.addAdjacent(e, c);
		gg.addAdjacent(e, f);
		gg.addAdjacent(e, i);
		gg.addAdjacent(e, h);
		gg.addAdjacent(e, g);
		gg.addAdjacent(e, d);
		gg.addAdjacent(f, e);
		gg.addAdjacent(f, b);
		gg.addAdjacent(f, c);
		gg.addAdjacent(f, i);
		gg.addAdjacent(f, h);
		gg.addAdjacent(g, h);
		gg.addAdjacent(g, e);
		gg.addAdjacent(g, d);
		gg.addAdjacent(h, g);
		gg.addAdjacent(h, d);
		gg.addAdjacent(h, e);
		gg.addAdjacent(h, f);
		gg.addAdjacent(h, i);
		gg.addAdjacent(i, h);
		gg.addAdjacent(i, e);
		gg.addAdjacent(i, f);
		
		System.out.println(gg);

		long st = System.nanoTime();
		for(Node n : gg.getVertices()){
			DFS(gg, n, new StringBuilder());
		}
		System.out.println("time to find words: " + (System.nanoTime()-st));
		System.out.println(wordsFound);
		
		wordsFound = new ArrayList<String>();
		st = System.nanoTime();
		for(int r = 0; r < 4; r++){
			for(int j = 0; j < 4; j++){
				DFSOnArrayOfChars(r, j, new StringBuilder());
			}
		}
		System.out.println("time to find words: " + (System.nanoTime()-st));
		System.out.println(wordsFound);
	}
	/**
	 * DFS will solve this problem not BFS
	 * DFS using graph to find words
	 */
	public static void DFS(Graph g, Node n, StringBuilder wsf){
		if(words.contains(wsf + n.getData())){
			wordsFound.add(wsf + n.getData());
			wsf.append(n.getData());
		}else if(suffixes.contains(wsf + n.getData())){
			wsf.append(n.getData());
		}else{
			return;
		}
		for(Node w : n.getAdjacents()){
			if(words.contains(wsf + w.getData())){
				DFS(g, w, wsf);
			}else if(suffixes.contains(wsf + w.getData())){
				DFS(g, w, wsf);
			}
		}
		if(wsf.length() > 0)
			wsf.delete(wsf.length()-1, wsf.length());
	}
	/**
	 * DFS using multi dimensional array to find words
	 */
	public static void DFSOnArrayOfChars(int r, int c, StringBuilder wsf){
		if(words.contains(wsf + String.valueOf(grid[r][c]))){
			wordsFound.add(wsf + String.valueOf(grid[r][c]));
			wsf.append(String.valueOf(grid[r][c]));
		}else if(suffixes.contains(wsf + String.valueOf(grid[r][c]))){
			wsf.append(String.valueOf(grid[r][c]));
		}else{
			return;
		}
		for(RowCol w : getAdjacents(r, c)){
			if(words.contains(wsf + String.valueOf(grid[w.r][w.c]))){
				DFSOnArrayOfChars(w.r, w.c, wsf);
			}else if(suffixes.contains(wsf + String.valueOf(grid[w.r][w.c]))){
				DFSOnArrayOfChars(w.r, w.c, wsf);
			}
		}
		if(wsf.length() > 0)
			wsf.delete(wsf.length()-1, wsf.length());
	}
	public static void BFS(Graph g, Node start, Set<String> words, Set<String> suffixes, List<String> wordsFound){
		for(Node n : g.getVertices()){
			n.setVisited(false);
		}
		Queue<Node> q = new ArrayBlockingQueue<Node>(10);
		q.offer(start);
		while(!q.isEmpty()){
			Node n = q.poll();
			StringBuilder wfs = new StringBuilder();
			wfs.append(n.getData());
			for(Node w : n.getAdjacents()){
				//wfs.append(w.getData());
				if(words.contains(wfs.toString() + w.getData())){
					wfs.append(w.getData());
					wordsFound.add(wfs.toString());
					q.offer(w);
				}else if(suffixes.contains(wfs.toString() + w.getData())){
					wfs.append(w.getData());
					q.offer(w);
				}else{
//					wfs = new StringBuilder();
					//break;
				}
			}
		}
	}
}
