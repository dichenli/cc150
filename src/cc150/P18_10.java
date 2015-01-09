/**
 * 
 */
package cc150;
import java.util.*;
/**
 * @author dichenli
 * Given two words of equal length that are in a dictionary, 
 * write a method to trans- form one word into another word 
 * by changing only one letter at a time. The new word you get 
 * in each step must be in the dictionary.
 */
public class P18_10 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		P18_10 a = new P18_10();
		a.addWord("abc");
		a.addWord("abi");
		a.addWord("ahi");
		a.addWord("ghi");
		a.addWord("ghf");
		a.addWord("gef");
		a.addWord("def");
		a.addWord("abf");
		a.addWord("aec");
		Iterable<String> list = a.findPath("abc", "def");
		for(String s : list) {
			System.out.println(s);
		}
	}

	//from length to a set of all strings that has the same length
	HashMap<Integer, HashSet<String>> dictionary = new HashMap<Integer, HashSet<String>>();
	//from a string to a node
	HashMap<String, Node> words = null;
	
	class Node {
		String word = null;
		//words that are one char different. This is 
		//actually somehow useless in current implementation.
		//If the class is processed in a more DP way, this 
		//should come very handy, by preprocessing the
		//dictionary and find all similar pairs and store 
		//them in advance. In that case, the "unprocessed"
		//list in current implementation is not useful 
		//anymore. Instead, we should pass around a hashtable
		//which hash from node to visited, to record whether 
		//a node is visited.
		HashSet<String> similars = new HashSet<String>();
		Node from = null;
		
		Node(String s) {
			this.word = s;
		}
	}
	
	public void addWord(String s) {
		HashSet sameLenWords = null;
		if(dictionary.containsKey(s.length())) {
			sameLenWords = dictionary.get(s.length());
		} else {
			sameLenWords = new HashSet<String>();
		}
		sameLenWords.add(s);
		dictionary.put(s.length(), sameLenWords);
	}
	
	public Iterable<String> findPath(String from, String to) {
		if(from == null || to == null ||from.length() != to.length() 
				|| !dictionary.containsKey(from.length())) {
			return null;
		}
		
		HashSet<String> unprocessed = (HashSet<String>) dictionary.get(from.length()).clone();
		if(!unprocessed.contains(from) || !unprocessed.contains(to)) {
			return null;
		}
		words = new HashMap<String, Node>();
		
		Node dest = findPath(from, to, unprocessed);
		if(dest == null) {
			return null;
		}
		ArrayList<String> path = new ArrayList<String>();
		while(!dest.word.equals(from)) {
			path.add(dest.word);
			dest = dest.from;
		}
		path.add(from);
		Collections.reverse(path);
		return path;
	}
	
	private Node findPath(String from, String to, HashSet<String> unprocessed) {
		Node fromNode = getNode(from);
		Queue<Node> searchList = new LinkedList<Node>();
		searchList.add(fromNode);
		
		while(! searchList.isEmpty()) {
			Node current = searchList.poll();
			if(current.word.equals(to)) {
				return current;
			}
			visit(current, unprocessed, searchList);
		}
		return null;
	}
	
	private Node getNode(String s) {
		Node node = null;
		if(words.containsKey(s)) {
			node = words.get(s);
		} else {
			node = new Node(s);
			words.put(s, node);
		}
		
		return node;
	}
	
	private void visit(Node node, HashSet<String> unprocessed, Queue<Node> searchList) {
		for(String s : unprocessed) {
			if(isOneCharDifferent(node.word, s)) {
				node.similars.add(s);
				Node next = getNode(s);
				next.from = node;
				searchList.add(next);
			}
		}
		
		for(String s : node.similars) {
			unprocessed.remove(s);
		}
	}
	
	private boolean isOneCharDifferent(String s1, String s2) {
		int count = 0;
		for(int i = 0; i < s1.length(); i++) {
			if(s1.charAt(i) != s2.charAt(i)) {
				count++;
				if(count > 1) {
					return false;
				}
			}
		}
		
		if(count != 1) {
			return false;
		} 
		return true;
	}
	
}
