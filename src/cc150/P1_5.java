/**
 * 
 */
package cc150;

import cc150.P1_4.Solution1;

/**
 * @author dichenli
 * Implement a method to perform basic string compression
 * using the counts of repeated characters. 
 * For example, the string aabcccccaaa would become a2blc5a3. 
 * If the "compressed" string would not become smaller than the 
 * original string, your method should return the original string.
 */
public class P1_5 {

	/**
	 * 
	 * @param args
	 * 
	 */
	public static void main(String[] args) {
		Solution1 s1 = new P1_5().new Solution1();
		System.out.println(s1.compress("aaa"));
		System.out.println(s1.compress("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
		System.out.println(s1.compress("abcdefg"));
		System.out.println(s1.compress("aaaa1"));
		System.out.println(s1.compress(""));
	}
	
	class Solution1 {
		public String compress(String str) {
			int i, j;
			int len = str.length();
			StringBuffer strComp = new StringBuffer(len + 1);
			int lenComp = 0;
			
			for(i = 0; i < len; i += j) {
				char c = str.charAt(i);
				strComp.append(c);
				lenComp++;
				
				for(j = 1; i + j < len; j++) {
					if(str.charAt(i + j) != c) {
						break;
					}
				}
				
				strComp.append(j);
				lenComp++;
				if(lenComp >= len) {
					return str;
				}
			}
			
			return strComp.toString();
		}
	}
}
