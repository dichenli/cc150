/**
 * 
 */
package cc150;

/**
 * @author dichenli
 * You have two very large binary trees: T1, with millions of nodes, and T2, with
 * hundreds of nodes.Create an algorithm to decide if T2 is a subtree of Tl.
 * A tree T2 is a subtree of T1 if there exists a node n in T1 such 
 * that the subtree of n is identical to T2. That is, if you cut 
 * off the tree at node n, the two trees would be identical
 */
public class P4_8 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryNode<Integer> node1 = new BinaryNode<Integer>(1);
		BinaryNode<Integer> node2 = new BinaryNode<Integer>(2, null, node1);
		BinaryNode<Integer> node3 = new BinaryNode<Integer>(3);
		BinaryNode<Integer> node4 = new BinaryNode<Integer>(4, node2, node3);
		BinaryNode<Integer> nodeB1 = new BinaryNode<Integer>(1);
		BinaryNode<Integer> nodeB2 = new BinaryNode<Integer>(2, null, nodeB1);
		BinaryNode<Integer> nodeB3 = new BinaryNode<Integer>(3, null, nodeB2);
		System.out.println(BinaryNode.isSubtree(node4, nodeB2));
		System.out.println(BinaryNode.isSubtree2(node4, nodeB2));
		System.out.println(BinaryNode.isSubtree(node4, nodeB3));
		System.out.println(BinaryNode.isSubtree2(node4, nodeB3));
	}

}
