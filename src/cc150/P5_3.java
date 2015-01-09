/**
 * 
 */
package cc150;

/**
 * @author dichenli
 * Given a positive integer, print the next smallest and the next 
 * largest number that have the same number of 1 bits in their 
 * binary representation.
 * next smallest: the smallest possible number that is larger than this one
 */
public class P5_3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printNumSame1Bits(0b0101010);
		printNumSame1Bits(0b0);
		printNumSame1Bits(~0);
		printNumSame1Bits(0b1111111111111111111111111111111);
		printNumSame1Bits(0b11011001111100);
	}
	
	public static void printNumSame1Bits(int n) {
		int m, k;
		try {
			m = nextSame1Bits(n);
			k = prevSame1Bits(n);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return;
		}

		System.out.println("Original: " + n + ", Binary is " + Integer.toBinaryString(n));
		if(m > 0) {
			System.out.println("Next Smallest: " + m + ", Binary is " + Integer.toBinaryString(m));
		} else {
			System.out.println("Next Smallest not found.");
		}
		if(k > 0) {
			System.out.println("Next Largest: " + k + ", Binary is " + Integer.toBinaryString(k));
		} else {
			System.out.println("Next Largest not found");
		}
	}
	
	public static int nextSame1Bits(int n) {
		if(n <= 0) {
			throw new IllegalArgumentException("input must be positive");
		}
		
		int i = 0; //position pointer
		int m;
		for(m = n; (m & 1) == 0; m = m >>> 1) {
			i++;
		}
		
		int count; //number of 1's before the first non-trailing zero
		for(count = 0; (m & 1) != 0; i++) {
			m = m >>> 1;
			count++;
		}
		
		m = n;
		m = m >>> i;
		m = m | 1;
		m = m << i;
		
		int bitSetter = 0;
		for(int j = 1; j < count; j++) {
			bitSetter = bitSetter << 1;
			bitSetter = bitSetter | 1;
		}
		m = m | bitSetter;
		
		if(m < 0) {
			return -1;
		}
		return m;
	}
	
	public static int prevSame1Bits(int n) {
		if(n <= 0) {
			throw new IllegalArgumentException("input must be positive");
		}
		
		int position = 0;
		int m = n;
		
		while((m & 1) != 0) {//shift right until we find the last position is 0
			m = m >> 1;
			position++;
			if (position > 32) {
				return -1; //not found
			}
		}
		while((m & 1) == 0) {//shift right until we find the last position is 0
			m = m >> 1;
			position++;
			if (position > 32) {
				return -1; //not found
			}
		}
		
		int bitSetter = 1 << position;
		m = n & (~bitSetter);
		
		bitSetter = 1 << (position - 1);
		m = m | bitSetter;
		
		return m;
	}

}
