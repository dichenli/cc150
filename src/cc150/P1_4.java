/**
 * 
 */
package cc150;

import cc150.P1_3.Solution_1;

/**
 * @author dichenli
 * Write a method to replace all spaces in a string with'%20'. 
 * You may assume that the string has sufficient space 
 * at the end of the string to hold the additional characters, 
 * and that you are given the "true" length of the string. 
 * (Note: if implementing in Java, please use a character 
 * array so that you can perform this opera- tion in place.)
 *	EXAMPLE
 *	Input: "Mr John Smith Output: "Mr%20Dohn%20Smith"
 */
public class P1_4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution1 s1 = new P1_4().new Solution1();
		System.out.println(s1.convert("Mr Dohn Smith0000000000".toCharArray(), "Mr Dohn Smith".length()));
		System.out.println(s1.convert("Mr0000000000".toCharArray(), "Mr".length()));
		System.out.println(s1.convert("Mr     0000000000".toCharArray(), "Mr     ".length()));
	}
	
	class Solution1 {
		public char[] convert(char[] str, int length) {
			
			int count = 0;
			for(int i = 0; i < length; i++) {
				if(str[i] == ' ') count++;
			}
			
			if(count == 0) {
				return str;
			}
			
			for(int i = length - 1; i >= 0; i--) {
				
				if(str[i] == ' ') {
					str[i + 2 * count - 2] = '%';
					str[i + 2 * count - 1] = '2';
					str[i + 2 * count]     = '0';
					count--;
					
					if(count == 0){
						break;
					}
					
				} else {
					str[i + 2 * count] = str[i];
				}
			}
			
			return str;
		}
	}

}
