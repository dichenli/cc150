/**
 * 
 */
package cc150;

/**
 * @author dichenli
 * Write a function that adds two numbers. You should not use + or any arithmetic 
 * operators.
 */
public class P18_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(add(1, 4));
	}

	public static int add(int a, int b) {
		if(a == 0) {
			return b;
		} else if (b == 0) {
			return a;
		}
		
		//a ^ b: each bit sum if we don't consider carry
		//a & b: the carry out value from each bit, 
		//left shift 1, then add to a^b by recursive call
		return add(a ^ b, (a & b) << 1);
	}

}
