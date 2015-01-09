/**
 * 
 */
package cc150;

/**
 * @author dichenli
 *
 */
public class P17_8 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a1 = {1, 1, 1, 1, 1};
		int[] a2 = {1, -2, 1, 1, -2};
		int[] a3 = {-1, -2, 1, 1, 1, -1, -1, 3};
		System.out.println(maxSub(a1));
		System.out.println(maxSub(a2));
		System.out.println(maxSub(a3));
	}
	
	public static int maxSub(int[] array) {
		if(array.length <= 0) {
			return 0;
		}
		int[] maxSub = new int[array.length];
		maxSub[0] = array[0];
		int max = array[0];
		for(int i = 1; i < array.length; i++) {
			maxSub[i] = array[i];
			if(maxSub[i - 1] > 0) {
				maxSub[i] += maxSub[i - 1];	
			}
			if(maxSub[i] > max) {
				max = maxSub[i];
			}
		}
		return max;
	}

}
