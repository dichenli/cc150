/**
 * 
 */
package cc150;
import java.util.*;

/**
 * @author dichenli
 * Design an algorithm to find the kth number such that the only 
 * prime factors are 3, 5, and 7.
 */
public class P7_7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 1; i < 20; i++) {
			System.out.println(findKth357(i));
		}
	}
	
	private static ArrayList<Integer> list357 = null;
	private static int[] ptrs = {1, 2, 3};
	
	public static int findKth357(int k) {
		if(k <= 0) {
			throw new IllegalArgumentException("k must be positive");
		}
		
		if(list357 == null) {
			list357 = new ArrayList<Integer>();
			list357.add(1);
			list357.add(3);
			list357.add(5);
			list357.add(7);
		}
		
		while(list357.size() < k) {
			int[] getNums = new int[3];
			getNums[0] = 3 * list357.get(ptrs[0]);
			getNums[1] = 5 * list357.get(ptrs[1]);
			getNums[2] = 7 * list357.get(ptrs[2]);
			
			int min = getNums[0];
			for(int i = 1; i < 3; i++) {
				if(min > getNums[i]) {
					min = getNums[i];
				}
			} //find max of three
			
			for(int i = 0; i < 3; i++) {
				if(getNums[i] == min) {
					ptrs[i]++;
				}
			} //find all ptrs that point to the same product results, and increment all these pointers
			
			list357.add(min);
		}
		
		return list357.get(k - 1);
	}
	
}
