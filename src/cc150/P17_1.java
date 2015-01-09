/**
 * 
 */
package cc150;

/**
 * @author dichenli
 * Writeafunctiontoswapanumberinplace(thatis,withouttemporary variables).
 */
public class P17_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		swap(1, 3);
		swap(20, -15);
		swap(1, 0);
		swap(~0, -99999999);
		swap2(1, 3);
		swap2(20, -15);
		swap2(1, 0);
		swap2(~0, -99999999);
		swap3(1, 3);
		swap3(20, -15);
		swap3(1, 0);
		swap3(~0, -99999999);
	}

	public static void swap(int a, int b) {
		System.out.println("Before: a = " + a + ", b = " + b);
		for(int n = 0; n < 32; n++) {
			if((((a >>> n) & 1) ^ ((b >>> n) & 1)) == 1) {
				a = a ^ (1 << n);
				b = b ^ (1 << n);
			}
		}
		System.out.println("After: a = " + a + ", b = " + b);
	}
	
	public static void swap2(int a, int b) {
		System.out.println("Before: a = " + a + ", b = " + b);
		a = a - b;
		b = a + b;
		a = b - a;
		System.out.println("After: a = " + a + ", b = " + b);
	}
	
	public static void swap3(int a, int b) {
		System.out.println("Before: a = " + a + ", b = " + b);
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println("After: a = " + a + ", b = " + b);
	}
}
