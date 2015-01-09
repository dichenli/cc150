/**
 * 
 */
package cc150;

/**
 * @author dichenli
 *
 */
public class P5_6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Integer.toBinaryString(swapBits(0b0)));
		System.out.println(Integer.toBinaryString(swapBits(0b1001)));
	}

	public static int swapBits(int n) {
		return ((n & 0xaaaaaaaa) >>> 1) | ((n & 55555555) << 1);
	}
}
