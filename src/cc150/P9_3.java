/**
 * 
 */
package cc150;

/**
 * @author dichenli
 * AmagicindexinanarrayA[l...n-l]isdefinedtobeanindexsuchthatA[i] = i. Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in array A.
 * FOLLOW UP 
 * What if the values are not distinct?
 */
public class P9_3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//               0, 1, 2, 3, 4, 5, 6, 7, 8, 9
		int[] array1 = {-1, 0, 1, 2, 3, 4, 5, 7, 8, 10};
		int[] array2 = {-1, 0, 1, 2, 3, 4, 5, 6, 7, 10};
		int[] array3 = {-1, 0, 1, 2, 7, 7, 7, 7, 7, 10};
		System.out.println(magicIndex(array1));
		System.out.println(magicIndex(array2));
		System.out.println(magicIndex2(array3));
	}
	
	public static Integer magicIndex(int[] array) {
		return magicIndex(array, 0, array.length - 1);
	}
	
	private static Integer magicIndex(int[] array, int lo, int hi) {
		if(lo > hi) {
			return null;
		} else if(lo == hi) {
			if(array[lo] == lo) {
				return lo;
			} else {
				return null;
			}
		}
		
		int mid = lo + (hi - lo) / 2;
		if(array[mid] == mid) {
			return mid;
		} else if(array[mid] > mid) {
			return magicIndex(array, lo, mid - 1);
		} else {
			return magicIndex(array, mid + 1, hi);
		}
	}

	//Follow up question
	public static Integer magicIndex2(int[] array) {
		return magicIndex2(array, 0, array.length - 1);
	}
	
	private static Integer magicIndex2(int[] array, int lo, int hi) {
		if(lo > hi) {
			return null;
		} else if(lo == hi) {
			if(array[lo] == lo) {
				return lo;
			} else {
				return null;
			}
		}
		
		int mid = lo + (hi - lo) / 2;
		int dMid = array[mid] - mid;
		if(dMid == 0) {
			return mid;
		}
		
		// search left
		Integer result = null;
		//see the book for why I do this
		int bound = dMid < 0? array[mid] : mid - 1;
		result = magicIndex2(array, lo, bound);
		if(result != null) {
			return result;
		}
		//search right
		bound = dMid > 0? array[mid] : mid + 1;
		return magicIndex2(array, bound, hi);
	}
}
