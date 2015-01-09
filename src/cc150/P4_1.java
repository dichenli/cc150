/**
 * 
 */
package cc150;

/**
 * @author dichenli
 * Implement a function to check if a binary tree is balanced. 
 * For the purposes of this question, a balanced tree is 
 * defined to be a tree such that the heights of the two 
 * subtrees of any node never differ by more than one.
 */
public class P4_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree<Integer, String> tree = new BinarySearchTree<Integer, String>();
		tree.put(3, "3");
		tree.put(1, "1");
		tree.put(2, "2");
		System.out.println(tree.isBalanced());
		tree.put(4, "4");
		System.out.println(tree.isBalanced());
	}

}
