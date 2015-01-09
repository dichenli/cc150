/**
 * 
 */
package cc150;

/**
 * @author dichenli
 *Given two strings, write a method to decide if one is a permutation of the other.
 */
public class P1_3 {

	/**
	 * Be careful, ask interviewer whether it's case sensitive, 
	 * whether whitespace is significant.
	 * Here I assume it's sensitive and whitespace is significant, 
	 * and repeating chars need to be counted,
	 * and all chars are ASCII
	 */
	public static void main(String[] args) {
		Solution_1 s1 = new P1_3().new Solution_1();
		System.out.println(s1.answer("aab", "aba"));
		System.out.println(s1.answer("aab", "abba"));
		System.out.println(s1.answer("", ""));
		System.out.println(s1.answer(")@", "@)†"));
		Solution_2 s2 = new P1_3().new Solution_2();
		System.out.println(s2.answer("aab", "aba"));
		System.out.println(s2.answer("aab", "abba"));
		System.out.println(s2.answer("", ""));
		System.out.println(s2.answer(")@", "@)†"));

	}

	public class Solution_1 {
		int R = 256;
		public boolean answer(String str1, String str2) {
			if(str1.length() != str2.length()) {
				return false;
			}

			int[] charCount = new int[R];
			for (int i = 0; i < R; i++) {
				charCount[i] = 0;
			}

			for (int i = 0; i < str1.length(); i++) {
				charCount[str1.charAt(i)]++;
				charCount[str2.charAt(i)]--;
			}

			for (int i = 0; i < R; i++) {
				if(charCount[i] != 0) {
					return false;
				}
			}

			return true;
		}
	}//end of solution1

	public class Solution_2 {

		public boolean answer(String str1, String str2) {
			if(str1.length() != str2.length()) {
				return false;
			}

			str1 = sort(str1);
			str2 = sort(str2);

			for(int i = 0; i < str1.length(); i++) {
				if(str1.charAt(i) != str2.charAt(i)) {
					return false;
				}
			}

			return true;
		}

		//sorting using java library methods instead of sorting by myself
		public String sort(String s) {
			char[] s_array = s.toCharArray();
			java.util.Arrays.sort(s_array);
			return new String(s_array);
		}

	}//end of solution2


}//end of file
