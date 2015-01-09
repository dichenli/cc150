/**
 * 
 */
package cc150;
import java.util.*;
/**
 * @author dichenli
 * Write a method to sort an array of strings so that all the anagrams are next to each
 * other.
 */
public class P11_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] words  = {"abc", "def", "bca", "ddd", "", "efd", "ddd"};
		System.out.println(Arrays.toString(sortAnagram(words)));
		String[] words2 = {"abc", "def", "bca", "ddd", "", "efd", "ddd"};
		System.out.println(Arrays.toString(sortAnagram2(words2)));
	}

	public static String[] sortAnagram(String[] words) {
		Hashtable<String, ArrayList<String>> anaHash = new Hashtable<String, ArrayList<String>>();
		for(int i = 0; i < words.length; i++) {
			String sorted = sortString(words[i]);
			if(anaHash.containsKey(sorted)) {
				anaHash.get(sorted).add(words[i]);;
			} else {
				ArrayList<String> l = new ArrayList<String>();
				l.add(words[i]);
				anaHash.put(sorted, l);
			}
		}
		
		int i = 0;
		for(ArrayList<String> l : anaHash.values()) {
			for(String s : l) {
				words[i++] = s;
			}
		}
		return words;
	}
	
	private static String sortString(String str) {
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}
	
	//solution 2, use classic sorting method, but define our own comparator
	//slow and stupid, but demonstrates the usage of comparator
	static class AnaComparator implements Comparator<String> {

		@Override
		public int compare(String s1, String s2) {
			return sortString(s1).compareTo(sortString(s2));
		}
		
		public String sortString(String str) {
			char[] chars = str.toCharArray();
			Arrays.sort(chars);
			return new String(chars);
		}
	}
	
	public static String[] sortAnagram2(String[] words) {
		Arrays.sort(words, new AnaComparator());
		return words;
	}
}
