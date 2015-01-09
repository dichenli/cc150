/**
 * 
 */
package cc150;
import java.util.*;
/**
 * @author dichenli
 * Consider a simple node-like data structure called BiNode, which haspointers to two other nodes. The data structure BiNode could be used to represent both a binary tree (where nodel is the left node and node2 is the right node) or a doubly linked list (where nodel is the previous node and node2 is the next node). Implement a method to convert a binary search tree (implemented with BiNode) into a doubly linked list. Thevaluesshould be kept in order and the operation should be performed in place (that is,on the original data structure).
 */
public class P17_13 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BiNode node0 = new BiNode(0);
		BiNode node1 = new BiNode(1);
		BiNode node2 = new BiNode(2);
		BiNode node3 = new BiNode(3);
		BiNode node4 = new BiNode(4);
		BiNode node5 = new BiNode(5);
		BiNode node6 = new BiNode(6);
		node0.n2 = node1;
		node2.n1 = node0;
		node2.n2 = node3;
		node4.n1 = node2;
		node4.n2 = node6;
		node6.n1 = node5;
		node0 = BSTtoLL(node4);
		while(node0.n2 != null) {
			System.out.print(node0.key);
			node0 = node0.n2;
		}
		System.out.println(node0.key);
		
		while(node0 != null) {
			System.out.print(node0.key);
			node0 = node0.n1;
		}
		System.out.println();
	}

	public static class BiNode {
		int key;
		BiNode n1;
		BiNode n2;
		
		BiNode(int key) {
			this.key = key;
			n1 = null;
			n2 = null;
		}
	}
	
	public static BiNode BSTtoLL(BiNode root) {
		return getHead(root);
	}
	
	private static void convert(BiNode node) {
		node.n1 = getTail(node.n1);
		if(node.n1 != null) {
			node.n1.n2 = node;
		}
		node.n2 = getHead(node.n2);
		if(node.n2 != null) {
			node.n2.n1 = node;
		}
	}
	
	private static BiNode getHead(BiNode node) {
		if(node == null) {
			return null;
		}
		
		convert(node);
		
		while(node.n1 != null) {
			node = node.n1;
		}
		return node;
	}
	
	private static BiNode getTail(BiNode node) {
		if(node == null) {
			return null;
		}
		
		convert(node);
		
		while(node.n2 != null) {
			node = node.n2;
		}
		return node;
	}
}
