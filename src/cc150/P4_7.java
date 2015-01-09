/**
 * 
 */
package cc150;

/**
 * @author dichenli
 * Design an algorithm and write code to find the first common
 * ancestor of two nodes inabinarytree.Avoid storing additional
 * nodes in a data structure. NOTE: This is not necessarily a 
 * binary search tree.
 */
public class P4_7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryNode<Integer> node1 = new BinaryNode<Integer>(1);
		BinaryNode<Integer> node2 = new BinaryNode<Integer>(2, null, node1);
		BinaryNode<Integer> node3 = new BinaryNode<Integer>(3);
		BinaryNode<Integer> node4 = new BinaryNode<Integer>(4, node2, node3);
		BinaryNode<Integer> node5 = new BinaryNode<Integer>(5);
		
		System.out.println(node4.firstCommon(node4, node1, node2));
		System.out.println(node4.firstCommon(node4, node1, node3));
		System.out.println(node4.firstCommon(node4, node1, node1));
		System.out.println(node4.firstCommon(node4, node1, node5));
	}

}
