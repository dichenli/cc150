/**
 * 
 */
package cc150;
import java.util.*;
/**
 * @author dichenli
 * Write a method to compute all permutations of a string
 */
public class P9_5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list = permutations("aabc");
		for(String s : list) {
			System.out.println(s);
		}
	}

	public static ArrayList<String> permutations(String str) {
		if(str == null) {
			return null;
		}
		
		ArrayList<String> permu = new ArrayList<String>();
		if(str.length() == 0) {
			permu.add("");
			return permu;
		}
		
		char char0 = str.charAt(0);
		String subStr = str.substring(1);
		ArrayList<String> prevPermu = permutations(subStr);
		for(String s : prevPermu) {
			for(int i = 0; i <= s.length(); i++) {
				String newStr = insertChar(s, char0, i);
				permu.add(newStr);
			}
		}
		
		return permu;
	}
	
	//the key to this problem is the use of substring method.
	//str.substring(int start) returns the substring start from int (inclusive)
	//substring(int start, int end), end is exclusive
	//so substring(0, str.length()) will return the string itself
	private static String insertChar(String str, char c, int position) {
		String prev = str.substring(0, position);
		String after = str.substring(position);
		return prev + c + after;
	}
}
