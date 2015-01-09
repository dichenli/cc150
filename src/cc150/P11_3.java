/**
 * 
 */
package cc150;

/**
 * @author dichenli
 * Given a sorted array of n integers that has been rotated an 
 * unknown number of times, write code to find an element in 
 * the array. You may assume that the array was originally sorted 
 * in increasing order.
 */
public class P11_3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//             0, 1, 2, 3, 4, 5, 6, 7, 8
		int[] array = {3, 3, 4, 5, 0, 1, 2, 3, 3};
		for(int i = 0; i < 6; i++) {
			System.out.println("a[" + findElem(array, i) + "] = " + i);
		}
	}
	
	public static int findElem(int[] array, int value) {
		int end = array.length - 1;
		int init = array[0];
		//if unlucky, all elems are the same, it will take O(n) time here. 
		//Otherwise the whole method is O(logn) time
		while(end > 0 && array[end] == init) {
			end--;
		} 
		return findElem(array, value, 0, end);
	}
	
	private static int findElem(int[] array, int value, int lo, int hi) {
		if(lo == hi && value == array[lo]) {
			return lo;
		} else if(lo == hi && value != array[lo]) {
			return -1;
		}
		int aLo = array[lo];
		if(value == aLo) {
			return lo;
		} 
		
		int mid = lo + (hi - lo) / 2;
		int aMid = array[mid];
		if(value == aMid) {
			return mid;
		}
		if (value > aLo) {
			if(aMid >= aLo && value < aMid) {
				return findElem(array, value, lo, mid);
			} else if(aMid >= aLo && value > aMid) {
				return findElem(array, value, mid + 1, hi); //be very careful about the choice of range here
			} else if(aMid < aLo) {
				return findElem(array, value, lo, mid - 1);
			} else {
				System.out.println("bug?");
				return -1;
			}
		} 
		
		else { // if value < aLo
			if(aMid < aLo && aMid < value) {
				return findElem(array, value, mid, hi);
			} else if(aMid < aLo && aMid > value) {
				return findElem(array, value, lo, mid - 1);
			} else if(aMid >= aLo) {
				return findElem(array, value, mid + 1, hi); 
			} else {
				System.out.println("bug?");
				return -1;
			}
		}
	}

}
