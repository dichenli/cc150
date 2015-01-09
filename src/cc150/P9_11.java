/**
 * 
 */
package cc150;
import java.util.*;
/**
 * @author dichenli
 * Given a boolean expression consisting of the symbols 0,1, &, |,
 * and A, and a desired boolean result value result, implement 
 * a function to count the number of ways of parenthesizing the 
 * expression such that it evaluates to result.
 */
public class P9_11 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(waysToParenthesize("1&1", true));
		System.out.println(waysToParenthesize("1&1&1", true));
		System.out.println(waysToParenthesize("1|0", true));
	}
	
	public static int waysToParenthesize(String expression, boolean result) {
		if(expression == null) { //many illegal arguments cases
			throw new IllegalArgumentException("Illegal input");
		}
		int len = expression.length();
		if(len <= 0 || len % 2 == 0) {
			throw new IllegalArgumentException("Illegal input");
		}
		
		Hashtable<String, Integer> waysHash = new Hashtable<String, Integer>();
		return waysToParenthesize(expression, result, waysHash);
	}
	
	private static int waysToParenthesize(String expression, boolean result, Hashtable<String, Integer> waysHash) {
		//DP method, expression + result is needed because the hashtable needs to hash the combination of string and result to a number of ways
		if (waysHash.containsKey(expression + result)) { 
			return waysHash.get(expression + result);
		}
		
		//base case, when the expression is a single 1 or 0
		int len = expression.length();
		if(len == 1) {
			boolean exp;
			if(expression.equals("1")) {
				exp = true;
			} else if(expression.equals("0")) {
				exp = false;
			} else {
				throw new IllegalArgumentException("Illegal input");
			}
			if(exp == result) {
				waysHash.put(expression + result, 1);
				return 1;
			} else {
				waysHash.put(expression + result, 0);
				return 0;
			}
		}
		
		//loop through each operator, because each operator could be the top level operator
		int ways = 0;
		for(int i = 1; i < len; i += 2) { 
			String sub1 = expression.substring(0, i);
			String sub2 = expression.substring(i + 1, len);
			char op = expression.charAt(i);
			
			if(op == '&' && result) {
				int ways1T = waysToParenthesize(sub1, true, waysHash);
				int ways2T = waysToParenthesize(sub2, true, waysHash);
				ways += ways1T * ways2T;
			} else if(op == '|' && !result) {
				int ways1F = waysToParenthesize(sub1, false, waysHash);
				int ways2F = waysToParenthesize(sub2, false, waysHash);
				ways += ways1F * ways2F;
			} else {
				int ways1T = waysToParenthesize(sub1, true, waysHash);
				int ways2T = waysToParenthesize(sub2, true, waysHash);
				int ways1F = waysToParenthesize(sub1, false, waysHash);
				int ways2F = waysToParenthesize(sub2, false, waysHash);
				if(op == '&' && !result) {
					ways += ways1F * ways2T + ways1T * ways2F + ways1F * ways2F;
				} else if(op == '|' && result) {
					ways += ways1F * ways2T + ways1T * ways2F + ways1T * ways2T;
				} else if(op == '^' && result) {
					ways += ways1F * ways2T + ways1T * ways2F;
				} else if(op == '^' && !result) {
					ways += ways1F * ways2F + ways1T * ways2T;
				} else {
					throw new IllegalArgumentException("Illegal input"); 
				}
			}
		} //end of for loop
		
		waysHash.put(expression + result, ways);
		return ways;
	}

}
