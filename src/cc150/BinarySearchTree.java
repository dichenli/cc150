/**
 * 
 */
package cc150;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
/**
 * @author dichenli
 * Binary Search Tree data structure copied from Princeton Algorithm course
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value> implements Iterable<Key> {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree<Integer, String> tree = new BinarySearchTree<Integer, String>();
		tree.put(2, "2");
		tree.put(1, "1");
		tree.put(3, "3");
		tree.put(4, "4");
		System.out.println("tree.get(4): " + tree.get(4));
		Iterator<Integer> iter = tree.iterator();
		while(iter.hasNext()) {
			System.out.println("Iterator: " + iter.next());
		}
		tree.delete(3);
		iter = tree.iterator();
		System.out.println("After deletion: ");
		while(iter.hasNext()) {
			System.out.println("Iterator: " + iter.next());
		}
		System.out.println("Size of tree: " + tree.size());
		
	}
	
	public class Node {
		Key key;
		Value value;
		int size;
		Node left;
		Node right;
		Node parent = null;
		
		Node(Key key, Value value, int size) {
			this.key = key;
			this.value = value;
			this.size = size;
		}
		
		@Override
		public String toString() {
			return value.toString();
		}
		
		private void setParent(Node parent) {
			this.parent = parent;
		}
		
	}
	
	private Node root;
	
	public BinarySearchTree() {
		root = null;
	}
	
	public BinarySearchTree(Key key, Value value) {
		this();
		put(key, value);
	}
	
	public void put(Key key, Value value){
		root = put(root, key, value);
	}
	
	private Node put(Node node, Key key, Value value) {
		if(node == null) {
			return new Node(key, value, 1);
		} 
		
		int compare = key.compareTo(node.key);
		if(compare < 0) {
			node.left = put(node.left, key, value);
		} else if (compare > 0) {
			node.right = put(node.right, key, value);
		} else {
			node.value = value;
		}
		
		node.size = 1 + size(node.left) + size(node.right);
		return node;
	}
	
	private int size(Node node) {
		if(node == null) {
			return 0;
		}
		return node.size;
	}
	
	public int size() {
		return size(root);
	}
	
	public Node getNode(Key key) {
		return getNode(root, key);
	}
	
	private Node getNode(Node node, Key key) {
		if(node == null) {
			return null;
		}
		
		int compare = key.compareTo(node.key);
		if(compare < 0) {
			return getNode(node.left, key);
		} else if(compare > 0) {
			return getNode(node.right, key);
		} else {
			return node;
		}
	}
	
	public Value get(Key key) {
		return getNode(root, key).value;
	}

	//returns the minimum key node of the subtree
	private Node min(Node node) {
		if(node.left == null) {
			return node;
		}
		return min(node.left);
	}
	
	public Key min() {
		return min(root).key;
	}
	
	public void deleteMin() {
		deleteMin(root);
	}
	
	//returns the root of subtree after the minimum node is removed
	private Node deleteMin(Node node) {
		if(node.left == null) {
			return node.right;
		}
		node.left = deleteMin(node.left);
		node.size = 1 + size(node.left) + size(node.right);
		return node;
	}
	
	public void delete(Key key) {
		root = delete(root, key);
	}
	
	//Hibbard deletion
	private Node delete(Node node, Key key) {
		if(node == null) {
			return null;
		}
		
		int compare = key.compareTo(node.key);
		if(compare < 0) {
			node.left = delete(node.left, key);
		} else if (compare > 0) {
			node.right = delete(node.right, key);
		} else if(node.left == null) {
			return node.right;
		} else if(node.right == null) {
			return node.left;
		}
		else {
			Node temp = node;
			node = min(temp.right);
			node.right = deleteMin(temp.right);
			node.left = temp.left;
		}
		node.size = 1 + size(node.left) + size(node.right);
		return node;
	}
	
	@Override
	public Iterator<Key> iterator() {
		LinkedList<Key> queue = new LinkedList<Key>();
		inOrder(root, queue);
		return queue.iterator();
	}
	
	//in order iteration, return an ordered key list in a queue
	private void inOrder(Node node, LinkedList<Key> queue) {
		if(node == null) {
			return;
		}
		inOrder(node.left, queue);
		queue.add(node.key);
		inOrder(node.right, queue);
	}
	
	public void printTree() {
		printTree(root);
	}
	
	private void printTree(Node root) {
		if(root == null) {
			return;
		}
		
		if (root.left != null) {
			System.out.println(root + " left->" + root.left);
			printTree(root.left);
		}
		if (root.right != null) {
			System.out.println(root + " right->" + root.right);
			printTree(root.right);
		}
	}
	
	//set parents of every node
	public void setParents() {
		root.setParent(null);
		setParents(root);
	}
	
	private void setParents(Node node) {
		if(node.left != null) {
			node.left.setParent(node);
			setParents(node.left);
		}
		if(node.right != null) {
			node.right.setParent(node);
			setParents(node.right);
		}
	}
	
	//P4_1
	//whether a binary tree is Balanced (not necessarily a BST)
	public boolean isBalanced() {
		return depth(root) != -1;
	}
	
	private int depth(Node node) {
		if(node == null) {
			return 0;
		}
		int left = depth(node.left);
		int right = depth(node.right);
		if(left == -1 || right == -1) {
			return -1;
		} else if(Math.abs(left - right) <= 1) {
			return 1 + Math.max(left, right);
		} else {
			return -1;
		}
	}
	
	//P4_3
	public static BinarySearchTree<Integer, Integer> BSTFromSortedArray(Integer[] array) {
		BinarySearchTree<Integer, Integer> tree = new BinarySearchTree<Integer, Integer>();
		tree.root = null;
		int low = 0;
		int high = array.length - 1;
		tree.root = tree.BSTFromSortedArray(array, low, high);
		return tree;
	}
	
	private Node BSTFromSortedArray(Integer[] array, int low, int high) {
		if(low > high) {
			return null;
		} 
		
		int mid = low + (high - low) / 2;
		Node root = new Node((Key) array[mid], (Value) array[mid], high - low + 1);
		root.right = BSTFromSortedArray(array, mid + 1, high);
		root.left  = BSTFromSortedArray(array, low, mid - 1);
		return root;
	}
	
	//P4_4
	public ArrayList<LinkedList<Integer>> createLinkedLists() {
		ArrayList<LinkedList<Integer>> lists = new ArrayList<LinkedList<Integer>>();
		createLinkedLists(root, lists, 0);
		return lists;
	}
	
	private void createLinkedLists(Node node, ArrayList<LinkedList<Integer>> lists, int depth) {
		if(node == null) return;
		
		LinkedList<Integer> list = null;
		if(lists.size() <= depth) {
			list = new LinkedList<Integer>();
			lists.add(list);
		}
		
		list = lists.get(depth);
		list.add((Integer) node.value);
		createLinkedLists(node.left, lists, depth + 1);
		createLinkedLists(node.right, lists, depth + 1);
	}
	
	//P4_6
	public Integer next(Integer current) {
		return (Integer) nextNode(getNode((Key) current)).key;
	}
	
	public Node nextNode(Node current) {
		setParents(root);
		Node next = null;
		if(current.right != null) {
			next = current.right;
			while(next.left != null) {
				next = next.left;
			}
		} else {
			next = current;
			while (next.parent != null && next.parent.left != next) {
				next = next.parent;
			}
			next = next.parent;
		}
		return next;
	}
}
