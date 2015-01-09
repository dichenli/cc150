/**
 * 
 */
package cc150;
import java.util.*;
/**
 * @author dichenli
 * for P18_8
 */
public class SuffixTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
	
	String string;
	SuffixTreeNode root;
	
	private class SuffixTreeNode {
		Character c;
		HashSet<Integer> indices;
		//children is a hashmap from char to node. Clever way to implement such tree!
		HashMap<Character, SuffixTreeNode> children;
		
		SuffixTreeNode(Character c, int index) {
			this(c);
			addIndex(index);
		}
		
		SuffixTreeNode(Character c) {
			this.c = c;
			this.indices = new HashSet<Integer>();
			this.children = new HashMap<Character, SuffixTreeNode>();
		}
		
		boolean hasChild(Character c) {
			return children.containsKey(c);
		}
		
		SuffixTreeNode child(Character c) {
			if(!hasChild(c)) {
				return null;
			}
			return children.get(c);
		}
		
		void addIndex(int index) {
			indices.add(index);
		}
		
		SuffixTreeNode addChild(Character c, int index) {
			SuffixTreeNode child = null;
			if(!hasChild(c)) {
				child = new SuffixTreeNode(c, index);
				children.put(c, child);
			} else {
				child = child(c);
				child.addIndex(index);
			}
			return child;
		}
	}
	
	//needs O(N^2) time, bad.
	public SuffixTree(String str) {
		string = str;
		int len = string.length();
		root = new SuffixTreeNode(null);
		for(int i = 0; i < len; i++) {
			SuffixTreeNode node = root;
			for(int j = i; j < len; j++) {
				node = node.addChild(string.charAt(j), i);
			}
		}
	}

	//if the suffix tree string has a substring str
	public Iterable<Integer> search(String str) {
		if(str == null) {
			return new HashSet<Integer>();
		}
		
		SuffixTreeNode node = root;
		for(int i = 0; i < str.length(); i++) {
			Character c = str.charAt(i);
			node = node.child(c);
			if(node == null) {
				return new HashSet<Integer>();
			}
		}
		return node.indices;
	}
}
