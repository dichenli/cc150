/**
 * 
 */
package cc150;

import java.util.*;

/**
 * @author dichenli
 * Given a list of words, write a program to find the longest word made of other words in the list.
 */
public class p18_7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] words = {"awesome", "we", "so", "me", "a", "some"}; 
		System.out.println(longest(words));
	}

	public static String longest(String[] array) {
		//two sets: a word a non-word compound
		//a non-word compound: "awesome" is composed of a + we + some, 
		//so "wesome" and "awe" are compounds, but not words
		HashSet<String> words = new HashSet<String>();
		HashMap<String, Boolean> compounds = new HashMap<String, Boolean>();

		for(int i = 0; i < array.length; i++) {
			words.add(array[i]);
		}
		
		int maxLen = 0;
		String longestComp = null;
		for(int i = 0; i < array.length; i++) {
			String str = array[i];
			if(isCompound(str, words, compounds) && str.length() > maxLen) {
				longestComp = str;
				maxLen = str.length();
			}
		}
		return longestComp;
	}

	private static boolean isCompound(String str, HashSet<String> words, HashMap<String, Boolean> compounds) {
		if(compounds.containsKey(str)) { //already know str is compound
			if(compounds.get(str)) {
				return true;
			} else {
				return false;
			}
		} else if(str.length() == 1) {
			return false;
		}
		
		for(int i = 1; i < str.length(); i++) {
			//i is from 1 to strlen - 1, so strLeft and strRight is never empty string
			String strLeft = str.substring(0, i);//substring method is exclusive on right
			String strRight = str.substring(i); //only define start
			if(isWordOrCompound(strLeft, words, compounds) && isWordOrCompound(strRight, words, compounds)) {
				compounds.put(str, true);// the word is a compound word
				return true;
			}
		}
		
		//The word may be a primary word in dictionary, but not a compound
		//or, the "word" is not a word and not a compound (such as "awes")
		compounds.put(str, false);
		return false;
	}
	
	private static boolean isWordOrCompound(String str, HashSet<String> words, HashMap<String, Boolean> compounds) {
		if(words.contains(str)) {
			return true;
		} else if(isCompound(str, words, compounds)) {// result not hashed. Do recursive query
			return true;
		} 
		return false;
	}

}
