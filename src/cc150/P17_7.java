/**
 * 
 */
package cc150;
import java.util.*;
/**
 * @author dichenli
 * Given any integer, print an English phrase that describes the integer (e.g., "One Thousand, Two Hundred Thirty Four").
 */
public class P17_7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(stringRepInt(1));
		System.out.println(stringRepInt(0));
		System.out.println(stringRepInt(-1));
		System.out.println(stringRepInt(1234560112));
		System.out.println(stringRepInt(1000));
		System.out.println(stringRepInt(10100012));
		System.out.println(stringRepInt(303001));
	}

	static final String[] thousands = {"", "thousand, ", "million, ", "billion, "};
	static Hashtable<Integer, String> numbers;

	private static void initializeValue() {
		numbers = new Hashtable<Integer, String>();
		numbers.put(0, "zero");
		numbers.put(1, "one");
		numbers.put(2, "two");
		numbers.put(3, "three");
		numbers.put(4, "four");
		numbers.put(5, "five");
		numbers.put(6, "six");
		numbers.put(7, "seven");
		numbers.put(8, "eight");
		numbers.put(9, "nine");
		numbers.put(10, "ten");
		numbers.put(11, "eleven");
		numbers.put(12, "twelve");
		numbers.put(13, "thirteen");
		numbers.put(14, "fourteen");
		numbers.put(15, "fifteen");
		numbers.put(16, "sixteen");
		numbers.put(17, "seventeen");
		numbers.put(18, "eighteen");
		numbers.put(19, "nineteen");
		numbers.put(20, "twenty");
		numbers.put(30, "thirty");
		numbers.put(40, "forty");
		numbers.put(50, "fifty");
		numbers.put(60, "sixty");
		numbers.put(70, "seventy");
		numbers.put(80, "eighty");
		numbers.put(90, "ninety");
	}

	public static String stringRepInt(int n) {
		if(n == 0) {
			return "zero";
		}

		initializeValue();
		StringBuilder str = new StringBuilder();
		if(n < 0) {
			n = -n;
			str.append("negative ");
		}

		char[] charlist = new Integer(n).toString().toCharArray();
		int len = charlist.length;
		int[] num = new int[charlist.length];
		for(int i = 0; i < charlist.length; i++) {
			num[i] = charlist[i] - '0';
		}// convert from 1234 to [1, 2, 3, 4]

		for(int i = 0; i < len; i++) {
			if(num[i] != 0) { 
				if((len - i - 1) % 3 == 2) { //hundreds
					str.append(numbers.get(num[i]));
					str.append(" hundred");
				} else if((len - i - 1) % 3 == 1) { //tens
					if(num[i] == 1) {
						int temp = num[i] * 10 + num[i + 1];
						str.append(numbers.get(temp)); //eleven to nineteen
						i++;
					} else {
						str.append(numbers.get(num[i] * 10));
					}
				} else { //1 to 9
					str.append(numbers.get(num[i])); 
				}
				str.append(" ");
			}

			if((len - i - 1) % 3 == 0) {
				int temp = num[i];
				if(i > 0) {
					temp += num[i - 1];
				}
				if(i > 1) {
					temp += num[i - 2];
				}
				if(temp != 0) { //handle exception. 1,000,100: one million, one hundred
					str.append(thousands[(len - i - 1) / 3]); 
				}
			}
		}
		int i;
		for(i = str.length() - 1; i >=0; i--) {
			if(str.charAt(i) != ' ' && str.charAt(i) != ',') {
				break;
			}
		}
		return str.substring(0, i + 1).toString().trim();
	}
}
