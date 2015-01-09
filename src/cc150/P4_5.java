/**
 * 
 */
package cc150;

/**
 * @author dichenli
 * Implement a function to check if a binary tree is a binary search tree.
 */
public class P4_5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryNode<Integer> node1 = new BinaryNode<Integer>(25);
		BinaryNode<Integer> node2 = new BinaryNode<Integer>(10, null, node1);
		BinaryNode<Integer> node3 = new BinaryNode<Integer>(30);
		BinaryNode<Integer> node4 = new BinaryNode<Integer>(20, node2, node3);
		
		System.out.println(BinaryNode.checkBST1(node4));
		System.out.println(BinaryNode.checkBST2(node4));
		System.out.println(BinaryNode.checkBST3(node4));
		
		node1.setValue(15);
		System.out.println(BinaryNode.checkBST1(node4));
		System.out.println(BinaryNode.checkBST2(node4));
		System.out.println(BinaryNode.checkBST3(node4));
	}

	
}
