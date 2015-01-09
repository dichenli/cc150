/**
 * 
 */
package cc150;
import java.util.*;
/**
 * @author dichenli
 *
 */
public class P9_8 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(waysToNCents(3));
		System.out.println(waysToNCents(5));
		System.out.println(waysToNCents(10));
		System.out.println(waysToNCents(25));
		System.out.println(makeChange(3, 25));
		System.out.println(makeChange(5, 25));
		System.out.println(makeChange(10, 25));
		System.out.println(makeChange(25, 25));
	}
	
	//here I use DP method. The method in the book is recursion and it's better
	public static int waysToNCents(int n) {
		int[][] ways = new int[3][n + 1]; //ways[2] represents ways to make n coins by 1, 5, 10 and/or 25 cents
		Hashtable<Integer, Integer> coinValue = new Hashtable<Integer, Integer>();
		coinValue.put(0, 5); //hash from ways[][] rows to coin value
		coinValue.put(1, 10);
		coinValue.put(2, 25);
		
		for(int i = 0; i <= 2; i++) {
			for(int j = 0; j <= n; j++) {
				ways[i][j] = getWays(ways, i, j, coinValue);
			}
		}
		
		return ways[2][n];
	}
	
	//level means what coins are allowed: 
	//-1: only 1 cent. 
	//0: 1, 5 cents. 
	//1: 1, 5, 10 cents. 
	//2: 1, 5, 10 or 25 cents
	//return number of ways using the given level of coins to make n cents value
	public static int getWays(int[][] ways, int level, int n, Hashtable<Integer, Integer> coinValue) {
		if(n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else if (level < 0) { // when using only 1 cent coin, there is always only one way
			return 1;
		} 
		
		int coin = coinValue.get(level);// coin = 5, 10, or 25
		if (n < coin) {// for example, if n = 4, there is no way we can use 5 cents coin
			return getWays(ways, level - 1, n, coinValue);
		} else {
			int sum = ways[level][n - coin]; //use one coin of the level, plus anything else (there are ways[level][n - coin] ways to get the "anything else")
			sum += getWays(ways, level - 1, n, coinValue); //do not use the coin of the level at all
			return sum;
		}
	}
	
	//the book method
	public static int makeChange(int n, int denom) {
		int next_denom = 0;
		switch (denom) {
		case 25:
			next_denom = 10;
			break;
		case 10:
			next_denom = 5;
			break;
		case 5:
			next_denom = 1;
			break;
		case 1:
			return 1;
		}
		
		//here the book method is buggy
		if(n < denom) {
			return makeChange(n, next_denom);
		}
		
		int ways = 0;
		for(int i = 0; i * denom <= n; i++) {
			ways += makeChange(n - i * denom, next_denom);
		}
		return ways;
	}
}
