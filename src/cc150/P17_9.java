/**
 * 
 */
package cc150;
import java.util.*;
/**
 * @author dichenli
 * Design a method to find the frequency of occurrences of any 
 * given word in a book.
 */
public class P17_9 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private Hashtable<String, Integer> counts;
	private String[] words;
	
	P17_9() {
		this.words = null;
		this.counts = null;
	}
	
	private void hashBook(String[] words) { //not static, because different books may correspond to different objects
		counts = new Hashtable<String, Integer>();
		
		for(int i = 0; i < words.length; i++) {
			int wordCount = 1;
			String word = simpleWord(words[i]);
			if(counts.containsKey(word)) {
				wordCount += counts.get(word);
			}
			counts.put(word, wordCount);
		}
	}
	
	private static String simpleWord(String word) {
		return word.trim().toLowerCase(); //trim and to lower case, because "Word" and "word " are really the same thing
	}
	
	public int wordCount(String word, String[] words) {
		hashBook(words);
		return wordCount(word);
	}
	
	public int wordCount(String word) {
		if(counts == null) {
			return 0;
		}
		return counts.containsKey(word) ? counts.get(word) : 0;
	}
}
