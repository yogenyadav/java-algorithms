package algo;

public class TreeNearestOrClosestNode {

	public static void main(String[] args) {

	}
// http://codercareer.blogspot.com/2013/03/no-45-closest-node-in-binary-search-tree_2.html?m=1
// given a tree of ints and a value v, find a node in tree closest to v
// algo:
// start from root
// find the absolute difference between v and root, also save the visited node (root in this case)
// if root > v then go left (because all value right of root are greater than root)
// find the absolute difference if smaller than before then save the left node
// again decide going left or right until leaf is reached

}
