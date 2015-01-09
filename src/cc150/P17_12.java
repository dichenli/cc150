/**
 * 
 */
package cc150;
import java.util.*;
/**
 * @author dichenli
 * Design an algorithm to find all pairs of integers within an array which sum to a spec- ified value.
 */
public class P17_12 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	static class Pair {
		int num1, num2;
		Pair(int x, int y) {
			num1 = Math.max(x, y); 
			num2 = Math.min(x, y);
		}
	}
	
	public static Iterable<Pair> findPairs(int[] array, int sum) {
		Set<Pair> pairs = new HashSet<Pair>();
		Hashtable<Integer, Integer> numCount = new Hashtable<Integer, Integer>();
		
		for(int i = 0; i < array.length; i++) {
			int comp = sum - array[i];
			if(numCount.containsKey(comp)) {
				pairs.add(new Pair(comp, array[i]));
			}
			numCount.put(array[i], 1);
		}
		return pairs;
	}

}
