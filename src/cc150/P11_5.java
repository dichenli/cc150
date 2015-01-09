/**
 * 
 */
package cc150;

/**
 * @author dichenli
 * Given a sorted array of strings which is interspersed with empty 
 * strings, write a method to find the location of a given string.
 */
public class P11_5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] array = {"", "a", "", "b", "", "c", "", "c"};
		System.out.println(findElem(array, "a"));
		System.out.println(findElem(array, "b"));
		System.out.println(findElem(array, "c"));
	}

	public static int findElem(String[] array, String s) {
		if(s.equals("")) {
			for(int i = 0; i < array.length; i++) {
				if(array[i].equals(s)) {
					return i;
				}
			}
			return -1;
		}
		return findElem(array, s, 0, array.length - 1);
	}
	
	public static int findElem(String[] array, String s, int lo, int hi) {
		if(lo > hi) {
			return -1;
		} else if(lo == hi && s.equals(array[lo])) {
			return lo;
		}
		
		int mid = lo + (hi - lo) / 2;
		mid = findNearest(array, mid, lo, hi); //find the nearest place where the mid is not empty string
		if(mid == -1) { // the array section is all empty strings
			return -1;
		}
		
		if(s.equals(array[mid])) {
			return mid;
		} else if(s.compareTo(array[mid]) > 0) {
			return findElem(array, s, mid + 1, hi);
		} else {// if(s.compareTo(array[mid]) < 0)
			return findElem(array, s, lo, mid - 1);
		}
	}
	
	private static int findNearest(String[] array, int mid, int lo, int hi) {
		int newMid = mid;
		while(newMid >= lo && array[newMid].equals("")) {
			newMid--;
		}
		if(newMid >= lo) {
			return newMid;
		}
		
		newMid = mid;
		while(newMid <= hi && array[newMid].equals("")) {
			newMid++;
		}
		return newMid <= hi? newMid : -1;
	}
}
