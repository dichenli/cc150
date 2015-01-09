/**
 * 
 */
package cc150;

import cc150.P1_7.Solution1;

/**
 * @author dichenli
 *
 */
public class P1_8 {

	/**
	 * P1.8 Assume you have a method isSubstring which checks if one word is a substring of another. 
	 * Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only 
	 * one call to isSubstring (e.g.,"waterbottle"is a rota- tion of"erbottlewat").
	 * @param args
	 */
	public static void main(String[] args) {
		Solution1 s1 = new P1_8().new Solution1();
		System.out.println(s1.isRotation("abcd", "bcda"));
		System.out.println(s1.isRotation("abcd", "abcd"));
		System.out.println(s1.isRotation("abcd", "bcd"));
		System.out.println(s1.isRotation("abcd", "bcad"));
		System.out.println(s1.isRotation("", ""));

	}

	//here I use contains because it functions the same as "isSubstring"
	class Solution1 {
		public boolean isRotation(String str1, String str2) {
			if(str1.length() != str2.length()) { 
				return false;
			}
			
			str1 = str1 + str1;
			return str1.contains(str2);
		}
	}
}
