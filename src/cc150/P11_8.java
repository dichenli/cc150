/**
 * 
 */
package cc150;

/**
 * @author dichenli
 *
 */
public class P11_8 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P11_8 a = new P11_8();
		int[] list = {1, 7, 2, 0, 5, 3, 1, 4, 0};
		for(int i = 0; i < list.length; i++) {
			a.track(list[i]);
		}
		for(int i = 0; i < list.length; i++) {
			System.out.println(a.getRankOfNumber(list[i]));
		}
	}
	
	class Node {
		Node left;
		Node right;
		int value;
		int leftSize;
		Node(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
			this.leftSize = 0;
		}
	}
	
	Node root;
	
	P11_8() {
		root = null;
	}
	
	public void track(int x) {
		if(root == null) {
			root = new Node(x);
			return;
		}
		
		Node node = root;
		while(true) {
			if(x <= node.value) {
				node.leftSize++;
				if(node.left == null) {
					node.left = new Node(x);
					return;
				}
				node = node.left;
			} else {
				if(node.right == null) {
					node.right = new Node(x);
					return;
				}
				node = node.right;
			}
		}
		
	}
	
	public int getRankOfNumber(int x) {
		if(root == null) {
			return -1;
		}
		
		Node node = root;
		int rank = 0;
		while(node.value != x) {
			if(x < node.value) {
				node = node.left;
			} else { //x > node.value
				rank += node.leftSize; //count the node left tree size
				rank++; //also count the node itself
				node = node.right;
			}
		}
		rank += node.leftSize;
		
		return rank;
	}


}
