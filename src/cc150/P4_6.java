/**
 * 
 */
package cc150;

/**
 * @author dichenli
 * Write an algorithm to find the 'next'node (i.e., in-order successor) 
 * of a given node in a binary search tree. You may assume that each 
 * node has a link to its parent.
 */
public class P4_6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		BinarySearchTree<Integer, Integer> tree = BinarySearchTree.BSTFromSortedArray(array);
		
		System.out.println(tree.next(3));
		System.out.println(tree.next(4));
		System.out.println(tree.next(5));
	}

}
