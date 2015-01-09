/**
 * 
 */
package cc150;

import java.util.Arrays;

/**
 * @author dichenli
 * You have an array with all the numbers from 7 to N, where N 
 * is at most 32,000. The array may have duplicate entries and 
 * you do not know what N is. With only 4 kilo- bytes of memory 
 * available, how would you print all duplicate elements in the array?
 */
public class P10_4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 9};
		printDuplicate(numbers);
	}
	
	static class BitVector {
		final int size = 4000;
		byte[] vector;
		BitVector() {
			vector = new byte[size];
			Arrays.fill(vector, (byte) 0);//not necessary, it should be auto-filled when initialized
		}
		
		void put(int num, boolean status) {
			if(num < 0 || num >= size * 8) {
				throw new IndexOutOfBoundsException("0 <= n < 32000");
			}
			
			int byteNum = num / 8;
			int bit = num % 8;
			if(status) {
				vector[byteNum] |= (1 << bit);
			} else {
				vector[byteNum] &= ~(1 << bit);
			}
		}
		
		boolean get(int num) {
			if(num < 0 || num >= size * 8) {
				throw new IndexOutOfBoundsException("0 <= n < 32000");
			}
			
			int byteNum = num / 8;
			int bit = (vector[byteNum] >>> (num % 8)) & 1;
			if(bit == 1) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	public static void printDuplicate(int[] numbers) {
		BitVector bv = new BitVector();
		for(int i = 0; i <numbers.length; i++) {
			if(!bv.get(numbers[i])) {
				bv.put(numbers[i], true);
			} else {
				System.out.println(numbers[i]);
			}
		}
	}

}
