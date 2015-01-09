/**
 * 
 */
package cc150;
import java.util.*;
/**
 * @author dichenli
 * You are given two sorted arrays, A and B, where A has a large enough buffer at the 
 * end to hold B. Write a method to merge B into A in sorted order.
 */
public class P11_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[20];
		for(int i = 0; i < 10; i++) {
			a[i] = i;
		}
		int[] b = {1, 3, 5, 6, 8, 11};
		String result = Arrays.toString(merge(a, b, 9, 5));
		System.out.println(result);
	}

	//merge from end to start!!
	public static int[] merge(int[] a, int[] b, int lastA, int lastB) {
		int last = 1 + lastA + lastB;
		
		while(lastA >= 0 && lastB >= 0) {
			a[last--] = a[lastA] > b[lastB] ? a[lastA--] : b[lastB--];
		}

		//not need to copy A, they are already in place
//		while(lastA >= 0) {
//			a[last--] = a[lastA--];
//		}
		while(lastB >= 0) {
			a[last--] = a[lastB--];
		}
		
		return a;
	}
}
