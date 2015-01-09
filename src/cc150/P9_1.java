/**
 * 
 */
package cc150;

/**
 * @author dichenli
 * A child is running up a staircase with n steps, and can 
 * hop either 1step, 2 steps, or 3 steps at a time. Implement 
 * a method to count how many possible ways the child can run 
 * up the stairs.
 */
public class P9_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	//ways[0] = 1, ways[1] = 1, ways[2] = 2; 
	//ways[n] = ways[n - 1] + ways[n - 2] + ways[n - 3];
	public long waysUpStairs(int n) {
		int k = n > 2? n + 1 : 3;
		long[] ways = new long[k]; //use long because the number grows large very fast
		ways[0] = 1; //zero stairs, do nothing
		ways[1] = 1;
		ways[2] = 2;
		
		for(int i = 3; i < n; i++) {
			ways[i] = ways[n - 1] + ways[n - 2] + ways[n - 3];
		}
		
		return ways[n];
	}
}
