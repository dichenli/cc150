/**
 * 
 */
package cc150;
import java.util.*;
/**
 * @author dichenli
 * Write a method to randomly generate a set of m integers from an array of size n. Each element must have equal probability of being chosen.
 */
public class P18_3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {0, 1, 2, 3, 4, 5};
		System.out.println(Arrays.toString(randomSet(a, 3)));
	}

	//this method assume either the array don't have repeating elements or the "set" treats the different elements with same value from array as different
	public static int[] randomSet(int[] array, int m) {
		Random rand = new Random();
		int n = array.length;
		if(n < m) {
			throw new IllegalArgumentException("m too large");
		}
		
		//almost the same method as P18_2
		for(int i = 0; i < m; i++) {
			int j = rand.nextInt(n - i) + i; //random number from i(inclusive) to n (exclusive)
			exch(array, i, j);
		}
		
		return Arrays.copyOfRange(array, 0, m);
	}
	
	private static int[] exch(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
		return array;
	}
}
