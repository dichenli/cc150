/**
 * 
 */
package cc150;
import java.util.*;
/**
 * @author dichenli
 *
 */
public class P17_14 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P17_14 a = new P17_14("thit");
		a.dictionary.add("i");
		a.dictionary.add("it");
		a.dictionary.add("hit");
		System.out.println(a.minInvalid());
	}

	public HashSet<String> dictionary;
	public String str;
//	public Hashtable<SubString, Integer> invalidLength;
	
	P17_14(String str) {
		this.str = str;
		dictionary = new HashSet<String>();
//		invalidLength = new Hashtable<SubString, Integer>();
	}
	
//	private class Partition {
//		int invalid;
//		int[] cut 
//	}
	
//	private class SubString {
//		int from;
//		int to;
//		SubString(int from, int to) {
//			this.from = from;
//			this.to = to;
//		}
//	}
	
	public int minInvalid() {
		if(str == null || str.length() == 0) {
			return 0;
		}
		
		return cut(0, 1);
	}
	
	private int cut(int lastCut, int front) {
		// base case. For example: "thit", lastCut 2 to 4 gives sub of "it". It is in the dictionary, return 2
		if(front == str.length()) {
			String sub = str.substring(lastCut, front);
			return invalidLength(sub);
		}
		
		int cut   = invalidLength(str.substring(lastCut, front)) + cut(front, front + 1);
		int noCut = cut(lastCut, front + 1);
		return Math.min(cut, noCut);
	}
	
	private int invalidLength(String substr) {
		if(dictionary.contains(substr)) {
			return 0;
		} else {
			return substr.length();
		}
	}
}
