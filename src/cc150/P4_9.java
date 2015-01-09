/**
 * 
 */
package cc150;

/**
 * @author dichenli
 * You are given a binary tree in which each node contains a value. 
 * Design an algorithm to print all paths which sum to a given value.
 * The path does not need to start or end at the root or a leaf.
 */
public class P4_9 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryNode<Integer> node1 = new BinaryNode<Integer>(2);
		BinaryNode<Integer> node2 = new BinaryNode<Integer>(3, null, node1);
		BinaryNode<Integer> node3 = new BinaryNode<Integer>(9);
		BinaryNode<Integer> node4 = new BinaryNode<Integer>(-4, node2, node3);
		BinaryNode<Integer> node5 = new BinaryNode<Integer>(-2, node4, null);
		BinaryNode<Integer> node6 = new BinaryNode<Integer>(6, node5, null);
		
		BinaryNode.printPaths(node6, 5);
	}

}
