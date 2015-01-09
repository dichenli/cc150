/**
 * 
 */
package cc150;

/**
 * @author dichenli
 * You are given two 32-bit numbers,N andM, and two bit positions, 
 * i and j. Write a method to insert M into N such that M starts at 
 * bit j and ends at bit i. You can assume that the bits j 
 * through i have enough space to fit all of M.That is,if M = 10011,
 * you can assume that there are at least 5 bits between j and i. 
 * You would not, for example, have j = 3 and i = 2, because M could 
 * not fully fit between bit 3 and bit 2.
 */
public class P5_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 0b010;
		int n = 0b11111101;
		n = insertMtoN(m, n, 4, 2);
		System.out.println(Integer.toBinaryString(n));
	}
	
	public static int insertMtoN(int M, int N, int i, int j) {
		//if i = 4, j = 2
		int a = ~0; //1111 1111
		a = a >>> (32 - i + j - 1); //0000 0111
		M = M & a; // 0000 0mmm
		a = a << j; //0001 1100
		a = ~a; // 1110 0011
		N = a & N; // nnn0 00nn
		M = M << j; //000m mm00
		return M | N; //nnnm mmnn
	}

}
