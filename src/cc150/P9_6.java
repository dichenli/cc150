/**
 * 
 */
package cc150;
import java.util.*;
/**
 * @author dichenli
 * Implement an algorithm to print all valid (i.e., properly 
 * opened and closed) combinations of n-pairs of parentheses.
 */
public class P9_6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<String> list = validParentheses(4);
		for(String s : list) {
			System.out.println(s);
		}
	}
	
	public static ArrayList<String> validParentheses(int n) {
		if(n < 0) {
			return null;
		}
		Hashtable<String, Integer> insertPos = new Hashtable<String, Integer>();
		return validParentheses(n, insertPos);
	}
	
	//to remove duplicated result, simply for each recursion, new "()" must be inserted to
	//every position right after the last occurance of '(' in the original string.
	//for example, for (()), insert the third "()" to it, just insert to positions 2, 3 and 4,
	//but not 0, 1, because ()(()) and (()()) can be acquired from the insertion rule above
	//such position info is stored in the hashtable.
	private static ArrayList<String> validParentheses(int n, Hashtable<String, Integer> insertPos) {
		ArrayList<String> parens = new ArrayList<String>();
		if(n == 0) {
			parens.add("");
			insertPos.put("", 0);
			return parens;
		}
		
		ArrayList<String> prevParens = validParentheses(n - 1, insertPos);
		for(String s : prevParens) {
			for(int i = insertPos.get(s); i <= s.length(); i++) {
				String newStr = insertParenthesis(s, i);
				parens.add(newStr);
				insertPos.put(newStr, i + 1);
			}
		}
		return parens;
	}
	
	private static String insertParenthesis(String s, int i) {
		String prev = s.substring(0, i);
		String end = s.substring(i);
		return prev + "()" + end;
	}
}
