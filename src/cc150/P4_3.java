/**
 * 
 */
package cc150;

/**
 * @author dichenli
 * Given a sorted (increasing order) array with unique integer elements,
 *  write an algo- rithm to create a binary search tree with minimal 
 *  height.
 */
public class P4_3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		BinarySearchTree<Integer, Integer> tree = BinarySearchTree.BSTFromSortedArray(array);
		tree.printTree();
	}
}
