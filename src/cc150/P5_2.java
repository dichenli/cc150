/**
 * 
 */
package cc150;

/**
 * @author dichenli
 * Given a real number between 0 and 7(e.g., 0.72) that is passed in 
 * as a double, print the binary representation. If the number cannot 
 * be represented accurately in binary with at most 32 characters, 
 * print "ERROR."
 */
public class P5_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double r = 0b0111011;
		r = r / 8; // r = 0b0111.011
		System.out.println(printBinary(r));
		System.out.println(printBinary(Math.PI));
	}

	public static String printBinary(double r) {
		int n = (int) r;
		r = r - n;
		StringBuffer str = new StringBuffer(Integer.toBinaryString(n) + ".");

		do{
			r = r * 2; 
			n = (int) r;
			r = r - n;
			str.append(n / 1);
		} while (r != 0 && str.length() <= 33);
		
		if(str.length() > 32) {
			return "ERROR";
		} else {
			return str.toString();
		}
	}
}
