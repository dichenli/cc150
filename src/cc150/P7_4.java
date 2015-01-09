/**
 * 
 */
package cc150;

/**
 * @author dichenli
 * Write methods to implement the multiply, subtract, and divide operations for inte- gers. Use only the add operator.
 */
public class P7_4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(negate(11));
		System.out.println(negate(-11));
		System.out.println(negate(0));
		System.out.println(minus(11, 2));
		System.out.println(minus(11, 12));
		System.out.println(minus(11, 11));
		System.out.println(minus(-11, 2));
		System.out.println(minus(-11, -2));
		System.out.println(minus(0, 2));
		System.out.println(minus(0, 0));
		System.out.println(multiply(2, 2));
		System.out.println(multiply(0, 2));
		System.out.println(multiply(2, 0));
		System.out.println(multiply(2, -2));
		System.out.println(multiply(-2, 2));
		System.out.println(multiply(-2, -2));
		System.out.println(divide(2, 2));
		System.out.println(divide(2, 3));
		System.out.println(divide(-4, 3));
		System.out.println(divide(-6, -3));
//		System.out.println(divide(-2, 0));
//		System.out.println(divide(0, 0));
	}
	
	public static int negate(int num) {
		int a = num > 0? -1 : 1;
		int result = 0;
		while(num != 0) {
			num = num + a;
			result = result + a;
		}
		return result;
	}
	
	public static int minus(int a, int b) {
		return a + negate(b);
	}
	
	public static int multiply(int a, int b) {
		int sign = 1;
		if(b < 0) {
			sign = negate(sign);
			b = negate(b);
		}
		
		int result = 0;
		while(b > 0) {
			result = result + a;
			b = minus(b, 1);
		}
		if(sign < 0) {
			result = negate(result);
		}
		
		return result;
	}

	public static int divide(int a, int b) {
		if(b == 0) {
			throw new IllegalArgumentException();
		}
		
		int sign = 1;
		if(b < 0) {
			sign = negate(sign);
			b = negate(b);
		}
		if(a < 0) {
			sign = negate(sign);
			a = negate(a);
		}
		
		int result = -1;
		while(a >= 0) {
			a = minus(a, b);
			result = result + 1;
		}
		
		result = multiply(result, sign);
		return result;
	}
}
