/**
 * 
 */
package cc150;
import java.util.*;
/**
 * @author dichenli
 * Given a binary tree, design an algorithm which creates 
 * a linked list of all the nodes at each depth (e.g., 
 * if you have a tree with depth D,you'll have D linked lists).
 */
public class P4_4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		BinarySearchTree<Integer, Integer> tree = BinarySearchTree.BSTFromSortedArray(array);
		ArrayList<LinkedList<Integer>> lists = tree.createLinkedLists();
		for(LinkedList<Integer> list : lists) {
			for(Integer i : list) {
				System.out.print(i + ", ");
			}
			System.out.println();
		}
	}
	
}
