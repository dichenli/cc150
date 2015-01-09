/**
 * 
 */
package cc150;
import java.util.*;
/**
 * @author dichenli
 *
 */
public class P18_13 {

	/**
	 * @param args
	 */
	//group words by their length
	HashMap<Integer, HashSet<String>> sameLenWords = null;
	//for each group of words of same length, build a trie out of it
	HashMap<Integer, Trie> sameLenTrie = null;
	int maxLen = -1;

	P18_13(String[] words) {
		preProcess(words);
	}


	private class TrieNode {
		Character c;
		//		Boolean isWord = false;
		HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();

		TrieNode(Character c) {
			this.c = c;
		}

		boolean hasChild(Character c) {
			return children.containsKey(c);
		}

		TrieNode child(Character c) {
			return children.get(c);
		}

		void setChild(Character c) {
			children.put(c, new TrieNode(c));
		}
	}

	private class Trie {
		final TrieNode root = new TrieNode(null);

		//whether the trie contains a given prefix. For example, the query may
		//be ['a', 'w', 'e'], as the prefix of "awesome".
		private boolean hasPrefix(Iterable<Character> prefix) {
			TrieNode node = root;
			for(Character c : prefix) {
				if(!node.hasChild(c)) {
					return false;
				}
				node = node.child(c);
			}
			return true;
		}

		private void buildTrie(HashSet<String> words) {
			for(String s : words) {
				TrieNode node = root;
				for(int i = 0; i < s.length(); i++) {
					Character c = s.charAt(i);
					if(!node.hasChild(c)) {
						node.setChild(c);
					}
					node = node.child(c);
				}
				//				node.isWord = true;
			}
		}

	}

	//	class Rectangle {
	//		ArrayList<String> rows = new ArrayList<String>();
	//		ArrayList<String> cols = new ArrayList<String>();
	//		int rowCount = 0;
	//		int colCount = 0;
	//	}

	private void preProcess(String[] words) {
		if(words.length <= 0) {
			return;
		}

		sameLenWords = new HashMap<Integer, HashSet<String>>();
		for(int i = 0; i < words.length; i++) {
			int len = words[i].length();
			if(len > maxLen) {
				maxLen = len;
			}
			if(!sameLenWords.containsKey(len)) {
				sameLenWords.put(len, new HashSet<String>());
			}
			sameLenWords.get(len).add(words[i]);
		}

		sameLenTrie = new HashMap<Integer, Trie>();
		for(Integer i : sameLenWords.keySet()) {
			constructTrie(i, sameLenWords.get(i));
		}
	}

	private void constructTrie(int len, HashSet<String> words) {
		if(!sameLenTrie.containsKey(len)) {
			sameLenTrie.put(len, new Trie());
		}
		Trie trie = sameLenTrie.get(len);
		trie.buildTrie(words);
	}

	public Iterable<String> findLargest() {
		if(sameLenWords == null) {
			return null;
		}

		Iterable<String> result = null;
		//iterate through all possible products of width and height for rectangle, from high to low
		for(int i = maxLen * maxLen; i > 0; i--) {
			for(int j = 1; j <= (int) Math.sqrt(i); j++) {
				if(i % j == 0 && sameLenWords.containsKey(i / j) && sameLenTrie.containsKey(j)) {
					result = buildRectangle(i / j, j, sameLenWords.get(i / j), sameLenTrie.get(j));
					if(!(result == null)) {
						return result;
					}
				}
			}
		}
		return result;
	}

	//width: width of rectangle, also it is the length of each word in words1
	//height: height of rectangle, also height of each word in trie2
	private Iterable<String> buildRectangle(int width, int height, HashSet<String> words1, Trie trie2) {
		//rows and cols are data structures for the rectangle
		Stack<String> rows = new Stack<String>();
		Stack<Character>[] cols = (Stack<Character>[]) new Stack[width];
		for(int i = 0; i < width; i++) {
			cols[i] = new Stack<Character>();
		}
		boolean success = tryToFindRectangle(width, height, rows, cols, words1, trie2);
		if(success) {
			return rows;
		}
		return null;
	}

	//return whether the building of rectangle is successful
	private boolean tryToFindRectangle(int width, int height, 
			Stack<String> rows, Stack<Character>[] cols, HashSet<String> words1, Trie trie2) {
		for(String s : words1) {
			boolean flag = true; //whether this word pass all prefix-existence tests
			for(int i = 0; i < width; i++) {
				cols[i].push(s.charAt(i));
				//if this word doesn't fit the rectangle, pop it out from each column, 
				//then try the next word
				if(!trie2.hasPrefix(cols[i])) { 
					for(int j = i; j >= 0; j--) { //reverse what was pushed in
						cols[j].pop();
					}
					flag = false;
					break;
				}
			}
			
			if(flag) {
				//it successfully passed all the columns tests in this given level, so the word is added to the rows
				rows.push(s);
				if(rows.size() == height) {
					return true; //success! we found a valid word rectangle 
				}
				//recursive call next level
				boolean success = tryToFindRectangle(width, height, rows, cols, words1, trie2);
				if(success) {
					return success; //pass around the successful result
				}
			}
		}

		//building unsuccessful, return false with the rows and cols intact
		return false;
	}

	public static void printResult(String[] words) {
		P18_13 case1 = new P18_13(words);
		Iterable<String> result = case1.findLargest();
		if(result == null) {
			System.out.println("Square not found" + Arrays.toString(words) + System.lineSeparator());
			return;
		}
		for(String s : result) {
			System.out.println(s);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		String[] words1 = {"abc", "def", "ghi", "adg", "beh", "cfi", "h"};
		printResult(words1);
		String[] words2 = {"abc", "def", "ad", "be", "h"};
		printResult(words2);
		String[] words3 = {};
		printResult(words3);
	}
}
