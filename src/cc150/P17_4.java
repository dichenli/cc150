/**
 * 
 */
package cc150;

/**
 * @author dichenli
 * Write a method which finds the maximum of two numbers. You should not use if-else or any other comparison operator.
 */
public class P17_4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(max2(1, 2));
		System.out.println(max2(11, -22));
		System.out.println(max2(1, -1));
		System.out.println(max2(0, 0));
		System.out.println(max2(Integer.MAX_VALUE, -2)); //will fail
		
		System.out.println(max3(1, 2));
		System.out.println(max3(11, -22));
		System.out.println(max3(1, -1));
		System.out.println(max3(0, 0));
		System.out.println(max3(Integer.MAX_VALUE, -2));
	}
	
	public static double max(double a, double b) {
		return (Math.abs(a - b) + a + b) / 2;
	}

	//solution1, don't work well for the situation when number overflow
	public static int max2(int a, int b) {
		return (abs(a - b) + a + b) / 2;
	}
	
	//only works for integer
	public static int abs(int a) {
		int sign = (a >> 30) ^ 1; //get the highest bit, shift to get 11111111X | 1 or 00000000X | 1 (-1 or 1)
		return sign * a;
	}
	
	//solution 2, the same on book
	public static int max3(int a, int b) {
		int signa = sign(a);
		int signb = sign(b);
		int difSign = signa ^ signb; //1 if different sign, 0 if same sign
		int difSignResult = a * signa + b * signb;
		
		int k = sign(a - b);
		int sameSignResult = a * k + b * flip(k);
		
		return sameSignResult * flip(difSign) + difSignResult * difSign;
	}
	
	//return 1 if positive, 0 if negative
	public static int sign(int x) {
		return (~(x >> 31)) & 1; 
	}
	
	//1 -> 0; 0 -> 1
	public static int flip(int x) {
		return x ^ 1;
	}

}
