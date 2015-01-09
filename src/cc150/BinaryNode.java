/**
 * 
 */
package cc150;
import java.util.*;
/**
 * @author dichenli
 * 
 */
public class BinaryNode<T> {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private T value;
	private BinaryNode<T> left, right;
	
	public BinaryNode(T value) {
		this.value = value;
	}
	
	public BinaryNode(T value, BinaryNode<T> left, BinaryNode<T> right) {
		this(value);
		setLeft(left);
		setRight(right);
	}
	
	public BinaryNode<T> setLeft(BinaryNode<T> left) {
		this.left = left;
		return this;
	}
	
	public BinaryNode<T> setRight(BinaryNode<T> right) {
		this.right = right;
		return this;
	}

	public BinaryNode<T> setValue(T value ) {
		this.value = value;
		return this;
	}
	
	public BinaryNode<T> left() {
		return left;
	}
	
	public BinaryNode<T> right() {
		return right;
	}
	
	public T value() {
		return value;
	}
	
	@Override
	public String toString() {
		return value.toString();
	}
	
	//P4_5, solution 1, slow, time cost O(nlogn)
	public static boolean checkBST1(BinaryNode<Integer> root) {
		if(root == null) {
			return true;
		}
		
		Integer leftMax = findMax(root.left);
		Integer rightMin = findMin(root.right);
		if(root.value >= rightMin || root.value < leftMax) {
			return false;
		}
		
		return checkBST1(root.left) && checkBST1(root.right);
	}
	
	public static Integer findMax(BinaryNode<Integer> root) {
		if(root == null) {
			return Integer.MIN_VALUE;
		}

		Integer leftMax = findMax(root.left);
		Integer rightMax = findMax(root.right);
		
		return Math.max(Math.max(leftMax, root.value), rightMax);
	}
	
	public static Integer findMin(BinaryNode<Integer> root) {
		if(root == null) {
			return Integer.MAX_VALUE;
		}

		Integer leftMin = findMin(root.left);
		Integer rightMin = findMin(root.right);
		
		return Math.min(Math.min(leftMin, root.value), rightMin);
	}
	
	//P4_5, solution 2, take min and max values as arguments, much simplified the problem
	//This is actually a pre-order traverse. It is fast because if something goes wrong in this node, it won't future check its subtrees.
	public static boolean checkBST2(BinaryNode<Integer> root) {
		return checkBST2(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private static boolean checkBST2(BinaryNode<Integer> node, Integer min, Integer max) {
		if(node == null) {
			return true;
		}
		
		if(node.value <= min || node.value > max) {
			return false;
		}
		return checkBST2(node.left, min, node.value) && checkBST2(node.right, node.value, max);
	}
	
	//P4_5, solution 3. Using inorder traverse. If it is BST, ascending order is assumed.
	//An integer min is used to keep track of last value being compared. If min is larger than the current node value,
	//ascending order fails, so min is set to Integer.MAX_VALUE to assure it will continue to fail in future comparisons, 
	//otherwise it's updated to current node value
	public static boolean checkBST3(BinaryNode<Integer> root) {
		return checkBST3(root, Integer.MIN_VALUE) < Integer.MAX_VALUE;
	}
	
	private static Integer checkBST3(BinaryNode<Integer> node, Integer min) {
		if(node == null) {
			return min;
		}
		
		min = checkBST3(node.left, min);
		if(min > node.value) {
			return Integer.MAX_VALUE;
		} else {
			return checkBST3(node.right, node.value);
		}
	}
	
	//P4_7
	//if we knew parent nodes of each node, the problem could become simpler
	//efficient but complicated method
	public BinaryNode<T> firstCommon(BinaryNode<T> root, BinaryNode<T> node1, BinaryNode<T> node2) {
		//exceptions checking
		if (node1 == null) {
			return node2;
		} else if (node2 == null) {
			return node1;
		} else if(node1 == node2) {
			return node1;
		}
		//a method to check if node1 and node2 are in the root tree may be necessary, but not with the function below
		
		Result<T> result = searchFirstCommon(root, node1, node2);
		if(result.isAnc) {
			return result.node;
		} else {
			return null;
		}
	}
	
	//wrapper class to enable multiple return values
	private class Result<T> {
		BinaryNode<T> node;
		boolean isAnc; //if node1 is the common ancester of node1 & 2, it's true. if it's only a subtree with node1, it's false
		
		Result(BinaryNode<T> node, boolean isAncestor) {
			this.node = node;
			this.isAnc = isAncestor;
		}
	}
	
	private Result<T> searchFirstCommon(BinaryNode<T> root, BinaryNode<T> node1, BinaryNode<T> node2) {
		if(root == null) {
			return null;
		}
		
		Result<T> left = searchFirstCommon(root.left, node1, node2);
		Result<T> right = searchFirstCommon(root.right, node1, node2);
		
		if (left == null && right == null) {
			if(root == node1 || root == node2) {
				return new Result<T>(root, false);
			}
			return null;
			
		//one of them found something
		} else if (left == null || right == null) {
			Result<T> result = left !=null? left : right;
			if(result.node == node1 && root == node2) {
				//first common ancestor found
				return new Result<T>(root, true);
			} else if(result.node == node2 && root == node1) {
				//same thing
				return new Result<T>(root, true);
			} else {
				//inherit return value (ancestor or not) from its child
				return result;
			}
		}
		
		//both left and right found something. It's only possible when node1 and node2 resides on left and right respectively
		//so this is the first common ancestor
		return new Result<T>(root, true);
	}
	
	
	//P4_8
	//here I compare tree1 node to see whether it is identical to a tree2 node, 
	//then compare whether the subtree from two nodes are identical trees
	
	//A different approach is to do preorder traverse, then inorder traverse, 
	//each traverse returns a string representation.
	//if it is subtree, then tree2's strings are substrings of tree1's strings
	//if there is null node, the string should print out a "null" to represent it
	//the substring check is linear time (O(m + n)), the creation of two strings is linear time (O(m) and O(n))
	//so it's efficient in worst time case. But it's inefficient in space cost
	
	public static boolean isIdenticalTree(BinaryNode tree1, BinaryNode tree2) {
		if(tree1 == null && tree2 == null) {
			return true;
		} else if (tree1 == null || tree2 == null) {
			return false;
		} else if (!tree1.value.equals(tree2.value)) {
			return false;
		}
		
		return isIdenticalTree(tree1.left, tree2.left) && isIdenticalTree(tree1.right, tree2.right);
	}
	
	//here I use BFS to traverse the tree1 (huge tree), the extra space cost is O(N), so not good
	public static boolean isSubtree(BinaryNode tree1, BinaryNode tree2) {
		if(tree2 == null) {
			return true;
		} else if(tree1 == null) {
			return false;
		}
		
		LinkedList<BinaryNode> queue = new LinkedList<BinaryNode>();
		queue.add(tree1);
		
		while(!queue.isEmpty()) {
			BinaryNode node = queue.poll();
			if(node.value.equals(tree2.value)) {
				if(isIdenticalTree(node, tree2)) {
					return true;
				}
			}
			
			if(node.left != null) {
				queue.add(node.left);
			}
			if(node.right != null) {
				queue.add(node.right);
			}
		}
		return false;
	}

	//the second method uses recursive call, which make extra space (system stack) to be O(logN)
	//if we use stack to implement recursion, however, it will be O(N) extra space for balanced tree (depth of tree), because 
	//in recursion, only one subtree will be sent to stack at one time, but in self-defined stack, both subtrees will
	public static boolean isSubtree2(BinaryNode tree1, BinaryNode tree2) {
		if(tree2 == null) {
			return true;
		} else if(tree1 == null) {
			return false;
		}
		
		if(tree1.value == tree2.value) {
			if(isIdenticalTree(tree1, tree2)) {
				return true;
			}
		}
		
		if(isSubtree2(tree1.left, tree2) || isSubtree2(tree1.right, tree2)) {
			return true;
		} 
		return false;
	}
	
	//P4_9
	public static void printPaths(BinaryNode<Integer> node, int sum) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		printPathsHelper(node, sum, list);
	}
	
	private static void printPathsHelper(BinaryNode<Integer> node, int sum, ArrayList<Integer> list) {
		if(node == null) {
			return;
		}
		
		if(node.value == null) {
			list.add(0);
		} else {
			list.add(node.value);
		}
		
		int pathSum = 0;
		for(int i = list.size() - 1; i >= 0; i--) {
			pathSum += list.get(i);
			if(pathSum == sum) {
				printPath(list, i);
			}
		}
		
		printPathsHelper(node.left, sum, list);
		printPathsHelper(node.right, sum, list);
		
		list.remove(list.size() - 1);
	}
	
	private static void printPath(ArrayList<Integer> list, int start) {
		System.out.print(list.get(start));
		for(int i = start + 1; i < list.size(); i++) {
			System.out.print(" -> " + list.get(i));
		}
		System.out.println();
	}
	
}
