/**
 * 
 */
package cc150;

/**
 * @author dichenli
 * Write a function to determine the number of bits 
 * required to convert integer A to integer B.
 */
public class P5_5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 0b11011;
		int b = 0b10001;
		System.out.println(differentBits(a, b));
		System.out.println(differentBits(0b11, b));
		System.out.println(differentBits(0, 0b0));
	}

	public static int differentBits(int a, int b) {
		int c = a ^ b;
		int count = 0;
		while(c != 0) {
			if((c & 1) == 1) {
				count++;
			}
			c = c >>> 1;
		}
		
		return count;
	}
}
