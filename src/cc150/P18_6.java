/**
 * 
 */
package cc150;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;
/**
 * @author dichenli
 * Describe an algorithm to find the smallest one million numbers 
 * in one billion numbers. Assume that the computer memory can hold 
 * all one billion numbers.
 */
public class P18_6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = {1, 5, 6, 3, 9, 7, 8, 4, 2};
		int[] a2 = {4, 4, 4, 4, 4, 4, 4, 4, 4};
		print(a);
		print(a2);
	}
	
	public static void print(int[] a) {
		Iterable<Integer> b = findFirstMillion(a);
		for(Integer i : b) {
			System.out.print(i + " ");
		}
		System.out.println();
		findMin(a);
		for(int i = 0; i < M; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	//solution1
	//use heap
	public static final int M = 5; //should be 1 million
	
	public static Iterable<Integer> findFirstMillion(int[] array) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(M, new IntegerComp());
		//a better way to do comparator is to use Collections.reverseOrder()
		int i;
		for(i =0; i < M; i++) {
			pq.add(array[i]);
		}
		for(i = M; i < array.length; i++) {
			if(array[i] < pq.peek()) { //the top of pq is the largest number in the pq, if a[i] < pq.peek(), a[i] belongs to the pq
				pq.add(array[i]);
				while(pq.size() > M) { //always maintain a size of M
					pq.poll();
				}
			}
		}
		return pq;
	}
	
	//self defined iterator so that the largest number comes to the top of pq
	public static class IntegerComp implements Comparator<Integer> {
		
		public int compare(Integer i1, Integer i2) {
			if(i1 > i2) {
				return -1;
			} else if (i1 < i2) {
				return 1;
			} else {
				return 0;
			}
		}
	}
	
	//solution2. If all elements are different, this method gives O(N) time 
	//guarantee and in place operation (0 extra space if system stack 
	//is not counted). If numbers may be different, this algorithm will need
	//to changed (3-way partition to put all values equal to pivot in the middle)
	public static int[] findMin(int[] array) {
		int index = rank(array, 0, array.length - 1, M);
		return Arrays.copyOfRange(array, 0, index + 1); //copyOfRange is exclusive end. index here is inclusive.
	}
	
	private static int random(int low, int high) {
		Random rand = new Random();
		return rand.nextInt(high - low + 1) + low;
	}
	
	private static int rank(int[] array, int left, int right, int size) {
		int pivot = random(left, right);
		int leftEnd = partition(array, left, right, pivot, size);
		int leftSize = leftEnd - left + 1;
		if(leftSize == size) {
			return leftEnd;
		} else if(leftSize < size) {
			return rank(array, leftEnd + 1, right, size - leftSize);
		} else {
			return rank(array, left, leftEnd, size);
		}
	}
	
	// three way partition, it will put all numbers equivalent to pivot to the middle of the array section
	//then it will try to find a position within the "== pivot" section that best match the target size. 
	//(may or may not be possible, but it will do its best.)
	private static int partition(int[] array, int left, int right, int pivot, int size) {
		int start = left;

		int mid;
		while(true) {
			while(left <= right && array[left] < pivot) {
				left++;
			}
			
			while(left <= right && array[right] > pivot) {
				right--;
			}

			mid = left;
			while(mid <= right && array[mid] >= pivot) {
				mid++;
			}
			if(mid <= right && array[mid] < pivot) {
				exch(array, left, mid);
				continue;
			}
			mid = right;
			while(mid >= left && array[mid] <= pivot) {
				mid--;
			}
			
			if(mid >= left && array[mid] > pivot) {
				exch(array, right, mid);
				continue;
			}
			
			if(left > right) {
				return right;
			}
			
			if(array[left] == pivot && array[right] == pivot) {
				if(right >= start + size - 1 && left <= start + size - 1) {
					return start + size - 1;
				} else if(right < start + size - 1) {
					return right;
				} else {
					return left;
				}
			}
			exch(array, left, right);
		}
	}
	
	private static void exch(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
